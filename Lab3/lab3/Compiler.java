import java.util.*;
import cmm.Absyn.*;
import cmm.PrettyPrinter;

public class Compiler {
  // The output of the compiler is a list of strings.
  LinkedList<String> output;

  // signature mapping function names to their JVM name and type
  HashMap<String, String> signature;

  // context mapping variable identifiers to their type and adresses
  List<Map<String, ContextEntry>> context;
  // next free adress for local variable
  int variableCounter = 0;

  // number of locals needed for current Function
  int limitLocals = 200;

  // maximum stack size needed for current Function
  int limitStack = 200;

  // current stack size
  int currentStack = 0;

  // global counter to get next label
  int nextLabel = 0;

  int labelCounter = 0;
  String functionName = "";

  // the return type of the currently compiled function
  cmm.Absyn.Type returnType;

  // type and adress
  public class ContextEntry {
    final Type type;
    final Integer address;

    ContextEntry(Type t, Integer a) {
      type = t;
      address = a;
    }

    public Integer getAddress() {
      return this.address;
    }

  }

  public class Fun {
    public String id;
    public TypeChecker.FunType funType; // fix funtype part i guess

    public Fun(String id, TypeChecker.FunType FunType) {
      this.id = id;
      this.funType = funType; // fix
    }
    // add to jvm?
  }

  private class FuncVisitor implements Def.Visitor<Void, Void> {
    public Void visit(DFun fun, Void arg) {

      addFunction(fun);
      return null;
    }
  }

  public static final Type BOOL = new Type_bool();
  public static final Type INT = new Type_int();
  public static final Type DOUBLE = new Type_double();
  public static final Type VOID = new Type_void();

  // Compile C-- AST to a .j source file (returned as String).
  // name should be just the class name without file extension.
  public String compile(String name, cmm.Absyn.Program p) {
    // Initialize output
    output = new LinkedList();
    functionName = name;

    // Output boilerplate
    output.add(".class public " + name);
    output.add(".super java/lang/Object");
    output.add("");
    output.add(".method public <init>()V");
    output.add("  .limit locals 1");
    output.add("");
    output.add("  aload_0");
    output.add("  invokespecial java/lang/Object/<init>()V");
    output.add("  return");
    output.add("");
    output.add(".end method");
    output.add("");
    output.add(".method public static main([Ljava/lang/String;)V");
    output.add("  .limit locals 1");
    output.add("  .limit stack  1");
    output.add("");
    output.add("  invokestatic " + name + "/main()I");
    output.add("  pop");
    output.add("  return");
    output.add("");
    output.add(".end method");
    output.add("");

    // TODO: compile AST, appending to output.
    signature = new HashMap<>();

    // add built-in functions
    PDefs pDefs = (PDefs) p;
    pDefs.listdef_.forEach(def -> def.accept(new FuncVisitor(), null));

    // runs Compiler
    p.accept(new ProgramVisitor(), null);

    // lacks built-in Functions

    // add user-defined functions to sign

    // Concatenate strings in output to .j file content.
    StringBuilder jtext = new StringBuilder();
    for (String s : output) {
      jtext.append(s + "\n");
    }
    return jtext.toString();
  }

  // compiles it
  public class ProgramVisitor implements Program.Visitor<Void, Void> {
    public Void visit(cmm.Absyn.PDefs p, Void arg) {
      for (Def def : p.listdef_)
        def.accept(new DefVisitor(), null);
      return null;
    }
  }

  // compiles function Defs

  public class DefVisitor implements Def.Visitor<Void, Void> {
    public Void visit(cmm.Absyn.DFun p, Void arg) {
      // reset state for new funcs
      context = new LinkedList();
      context.add(new HashMap());
      variableCounter = 0;
      limitLocals = 101;
      limitStack = 101;
      currentStack = 0;
      returnType = p.type_;

      // save output so far and reset Output
      LinkedList<String> savedOutput = output;
      output = new LinkedList();

      // compile function

      // add function parameters to Ctx
      for (Arg x : p.listarg_)
        x.accept(new ArgVisitor(), null);

      // compule func body
      for (Stm s : p.liststm_)
        s.accept(new StmVisitor(), null);

      // add new output to old Output
      LinkedList<String> newOutput = output;
      output = savedOutput;

      // fun / funtype missing?
      // Fun f = new Fun(p.id_, new FunType(p.type_, p.listarg_));
      // output.add("\n.method public static " + f.toJVM() + "\n"); // needs fun f to
      // work
      output.add(".method public static " + p.id_ + signature.get(p.id_));
      output.add(".limit locals " + limitLocals);
      output.add(".limit stack " + limitStack);

      for (String s : newOutput) {
        output.add("\t" + s);
      }
      output.add(".end method");

      return null;
    }
  }

  // compiling a function argument means adding it to the ctx

  public class ArgVisitor implements Arg.Visitor<Void, Void> {
    public Void visit(cmm.Absyn.ADecl p, Void arg) {
      addVar(p.id_, p.type_); // computes next free adress for ID and stores adress/type
      return null;
    }
  }

  // compile statements

  public class StmVisitor implements Stm.Visitor<Void, Void> {

    public Void visit(cmm.Absyn.SExp p, Void arg) {
      p.exp_.accept(new ExpVisitor(), arg);
      if (output.getLast().charAt(output.getLast().length() - 1) != 'V') {
        output.add("pop");
      }
      return null;
    }

    public Void visit(cmm.Absyn.SDecls p, Void arg) {
      p.listid_.forEach(id -> addVar(id, p.type_));
      return null;
    }

    public Void visit(cmm.Absyn.SInit p, Void arg) {
      addVar(p.id_, p.type_);
      p.exp_.accept(new ExpVisitor(), arg);
      output.add("istore " + getVariable(p.id_).getAddress());
      return null;
    }

    public Void visit(cmm.Absyn.SReturn p, Void arg) {
      p.exp_.accept(new ExpVisitor(), null);
      output.add("ireturn");
      return null;
    }

    public Void visit(cmm.Absyn.SWhile p, Void arg) {
      String trueLabel = getUniqueLabel();
      String falseLabel = getUniqueLabel();

      output.add(trueLabel + ":");
      p.exp_.accept(new ExpVisitor(), arg);
      output.add("iconst_1");
      output.add("if_icmpne " + falseLabel);
      pushBlock();
      p.stm_.accept(new StmVisitor(), arg);
      popBlock();
      output.add("goto " + trueLabel);
      output.add(falseLabel + ":");
      return null;
    }

    public Void visit(cmm.Absyn.SBlock p, Void arg) {
      pushBlock();
      p.liststm_.forEach(stm -> stm.accept(new StmVisitor(), arg));
      popBlock();
      return null;
    }

    public Void visit(cmm.Absyn.SIfElse p, Void arg) {
      String trueLabel = getUniqueLabel();
      String falseLabel = getUniqueLabel();
      p.exp_.accept(new ExpVisitor(), arg);

      output.add("iconst_1");
      output.add("if_icmpeq " + trueLabel);
      pushBlock();
      p.stm_2.accept(new StmVisitor(), arg);
      popBlock();
      output.add("goto " + falseLabel);
      output.add(trueLabel + ":");
      pushBlock();
      p.stm_1.accept(new StmVisitor(), arg);
      popBlock();
      output.add(falseLabel + ":");
      return null;
    }
  }

  public class ExpVisitor implements Exp.Visitor<Void, Void> {
    public Void visit(cmm.Absyn.EBool p, Void arg) {
      var ebool = p.boollit_;
      if (ebool instanceof LTrue)
        output.add("iconst_1");
      else
        output.add("iconst_0");
      return null;
    }

    @Override
    public Void visit(EInt p, Void arg) {
      if (p.integer_ >= 0){
        if (p.integer_ <= 5) {
          output.add("iconst_" + p.integer_.toString());
         } else {
          output.add("ldc " + p.integer_.toString());
         }
      }else{
        output.add("iconst_m" + p.integer_.toString());
      }
      return null;
    }

    @Override
    public Void visit(EDouble p, Void arg) {
      if (p.double_ >= 0)
        output.add("dconst_" + p.double_.toString()); // slides dont mention negative doubles, assume same as int?
      else
        output.add("dconst_m" + p.double_.toString());
      return null;
    }

    @Override
    public Void visit(EId p, Void arg) {
      var variableLocation = getVariable(p.id_).getAddress();
      output.add("iload " + variableLocation);
      return null;
    }

    @Override
    public Void visit(EApp p, Void arg) {

      pushBlock();
      if (p.id_.equals("readInt")) {
        output.add("invokestatic Runtime/readInt()I");
      } else if (p.id_.equals("printInt")) {
        for (Exp exp : p.listexp_) {
          exp.accept(new ExpVisitor(), arg);
        }
        output.add("invokestatic Runtime/printInt(I)V");
      } else if (p.id_.equals("readDouble")) {
        output.add("invokestatic Runtime/readDouble()D");
      } else if (p.id_.equals("printDouble")) {
        for (Exp exp : p.listexp_) {
          exp.accept(new ExpVisitor(), arg);
        }
        output.add("invokestatic Runtime/printDouble(D)V");
      } else {
        for (Exp exp : p.listexp_) {
          exp.accept(new ExpVisitor(), arg);
        }
        output.add("invokestatic " + functionName + "/" + p.id_ + signature.get(p.id_));
      }
      popBlock();
      return null;

    }

    @Override
    public Void visit(EPost p, Void arg) {
      Integer variableLocation = getVariable(p.id_).getAddress();
      String operation = "";
      if (p.incdecop_ instanceof ODec) {
        operation = "isub";
      } else if (p.incdecop_ instanceof OInc) {
        operation = "iadd";
      }
      output.add("iload " + variableLocation);
      output.add("iload " + variableLocation);
      output.add("iconst_1");
      output.add(operation);
      output.add("istore " + variableLocation);
      return null;
    }
// x++ ++x
    @Override
    public Void visit(EPre p, Void arg) {
      Integer variableLocation = getVariable(p.id_).getAddress();
      String operation = "";
      if (p.incdecop_ instanceof ODec) {
        operation = "isub";
      } else if (p.incdecop_ instanceof OInc) {
        operation = "iadd";
      }

      output.add("iload " + variableLocation);
      output.add("iconst_1");
      output.add(operation);
      output.add("istore " + variableLocation);
      output.add("iload " + variableLocation);
      return null;
    }

    @Override
    public Void visit(EMul p, Void arg) {
      p.exp_1.accept(new ExpVisitor(), arg);
      p.exp_2.accept(new ExpVisitor(), arg);
      var operator = p.mulop_;
      if (operator instanceof OTimes)
        output.add("imul");
      else if (operator instanceof ODiv)
        output.add("idiv");
      // somethings missing, working progress
      return null;
    }

    @Override
    public Void visit(EAdd p, Void arg) {
      p.exp_1.accept(new ExpVisitor(), arg);
      p.exp_2.accept(new ExpVisitor(), arg);
      var operator = p.addop_;
      if (operator instanceof OPlus)
        output.add("iadd");
      else if (operator instanceof OMinus)
        output.add("isub"); // im assuming its sub, didnt find on slides
      // not perfect will work more on it tomorrow

      return null;
    }

    @Override
    public Void visit(ECmp p, Void arg) {
      String trueLabel = getUniqueLabel();
      String falseLabel = getUniqueLabel();
      var op = p.cmpop_;
      p.exp_1.accept(new ExpVisitor(), arg);
      p.exp_2.accept(new ExpVisitor(), arg);

      if (op instanceof OLt) {
        output.add("if_icmplt " + trueLabel);
      } else if (op instanceof OGt) {
        output.add("if_icmpgt " + trueLabel);
      } else if (op instanceof OLtEq) {
        output.add("if_icmple " + trueLabel);
      } else if (op instanceof OGtEq) {
        output.add("if_icmpge " + trueLabel);
      } else if (op instanceof OEq) {
        output.add("if_icmpeq " + trueLabel);
      } else if (op instanceof ONEq) {
        output.add("if_icmpne " + trueLabel);
      }
      output.add("iconst_0");
      output.add("goto " + falseLabel);
      output.add(trueLabel + ":");
      output.add("iconst_1");
      output.add(falseLabel + ":");
      return null;
    }

    @Override
    public Void visit(EAnd p, Void arg) {
      if (true)
        throw new RuntimeException(
            "Not yet implemented: compile statement" + p.getClass() + " - " + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EOr p, Void arg) {
      if (true)
        throw new RuntimeException(
            "Not yet implemented: compile statement" + p.getClass() + " - " + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EAss p, Void arg) {
      Integer variableLocation = getVariable(p.id_).getAddress();
      p.exp_.accept(new ExpVisitor(), arg);
      output.add("istore " + variableLocation);
      output.add("iload " + variableLocation);
      return null;
    }
  }

  int addVar(String x, Type t) {
    int counter = variableCounter;
    context.get(0).put(x, new ContextEntry(t, counter));
    variableCounter++;
    if (variableCounter > limitLocals) {
      limitLocals = variableCounter;
    }
    return counter;
  }

  ContextEntry getVariable(String x) {
    for (Map<String, ContextEntry> b : context) {
      ContextEntry ce = b.get(x);
      if (ce != null)
        return ce;
    }
    throw new RuntimeException("Impossible: unbound variable " + x);
  }

  void pushBlock() {
    context.add(0, new HashMap());
  }

  void popBlock() {
    context.remove(0);
  }

  public void addFunction(DFun function) {

    String type = "(";
    for (Arg arg : function.listarg_) {
      ADecl agrument = (ADecl) arg;
      if (agrument.type_ instanceof Type_int) {
        type = type + "I";
      } else if (agrument.type_ instanceof Type_bool) {
        type = type + "Z";
      } else if (agrument.type_ instanceof Type_void) {
        type = type + "V";
      }

    }
    type = type + ")";

    if (function.type_ instanceof Type_int) {
      type = type + "I";
    } else if (function.type_ instanceof Type_bool) {
      type = type + "Z";
    } else if (function.type_ instanceof Type_void) {
      type = type + "V";
    }
    signature.put(function.id_, type);

  }

  public String getUniqueLabel(){
    String label = "L" + labelCounter;
    labelCounter++;
    return label;
  }

  // TODO add id func?
  // stack funcs
  // adjust stack visitor?
  //
}
