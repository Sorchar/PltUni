import java.util.*;
import cmm.Absyn.*;
import cmm.PrettyPrinter;

public class Compiler
{
  // The output of the compiler is a list of strings.
  LinkedList<String> output;

  //signature mapping function names to their JVM name and type
  HashMap<String, Fun> signature;

  // context mapping variable identifiers to their type and adresses
  List<Map<String, ContextEntry>> context;
  // next free adress for local variable
  int nextLocal = 0;

  // number of locals needed for current Function
  int limitLocals = 0;

  // maximum stack size needed for current Function
  int limitStack = 0;

  // current stack size
  int currentStack = 0;

  // global counter to get next label
  int nextLabel = 0;

  // the return type of the currently compiled function
  cmm.Absyn.Type returnType;
  // type and adress
  public class ContextEntry {
    final Type type;
    final Integer address;
    ContextEntry(Type t, Integer a){type = t; address = a;}
  }

  public class Fun{
    public String id;
    public TypeChecker.FunType funType; // fix funtype part i guess
    public Fun(String id, TypeChecker.FunType FunType){
      this.id = id;
      this.funType = funType; // fix
    }
    // add to jvm?
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

    // Output boilerplate
    output.add(".class public " + name + "\n");
    output.add(".super java/lang/Object\n");
    output.add("\n");
    output.add(".method public <init>()V\n");
    output.add("  .limit locals 1\n");
    output.add("\n");
    output.add("  aload_0\n");
    output.add("  invokespecial java/lang/Object/<init>()V\n");
    output.add("  return\n");
    output.add("\n");
    output.add(".end method\n");
    output.add("\n");
    output.add(".method public static main([Ljava/lang/String;)V\n");
    output.add("  .limit locals 1\n");
    output.add("  .limit stack  1\n");
    output.add("\n");
    output.add("  invokestatic " + name + "/main()I\n");
    output.add("  pop\n");
    output.add("  return\n");
    output.add("\n");
    output.add(".end method\n");
    output.add("\n");

    // TODO: compile AST, appending to output.
    signature = new HashMap<>();

    // add built-in functions
    // runs Compiler
    p.accept(new ProgramVisitor(), null);

    // lacks built-in Functions

    // add user-defined functions to sign


    // Concatenate strings in output to .j file content.
    StringBuilder jtext = new StringBuilder();
    for (String s: output) {
      jtext.append(s);
    }
    return jtext.toString();
  }

  // compiles it
  public class ProgramVisitor implements Program.Visitor<Void, Void>{
    public Void visit(cmm.Absyn.PDefs p, Void arg){
      for(Def def: p.listdef_)
        def.accept(new DefVisitor(), null);
      return null;
    }
  }


  // compiles function Defs

  public class DefVisitor implements Def.Visitor<Void, Void>{
    public Void visit(cmm.Absyn.DFun p, Void arg){
      //reset state for new funcs
      context = new LinkedList();
      context.add(new TreeMap());
      nextLocal = 0;
      limitLocals = 0;
      limitStack = 0;
      currentStack = 0;
      returnType = p.type_;

      // save output so far and reset Output
      LinkedList<String> savedOutput = output;
      output = new LinkedList();

      // compile function

      // add function parameters to Ctx
      for(Arg x: p.listarg_)
        x.accept(new ArgVisitor(), null);

      // compule func body
    /*  for(Stm s: p.liststm_)
        s.accept(new StmVisitor(), null);*/

      // add new output to old Output
      LinkedList<String> newOutput = output;
      output = savedOutput;

      // fun / funtype missing?
      //Fun f = new Fun(p.id_, new FunType(p.type_, p.listarg_));
     // output.add("\n.method public static " + f.toJVM() + "\n"); // needs fun f to work
      output.add(".limit locals " + limitLocals + "\n");
      output.add(".limit stack " + limitStack + "\n\n");

      for ( String s: newOutput){
        output.add("\t" + s);
      }
      output.add("\n.end method\n");


      return null;
    }
  }

  // compiling a function argument means adding it to the ctx

  public class ArgVisitor implements Arg.Visitor<Void, Void>{
    public Void visit(cmm.Absyn.ADecl p, Void arg){
      newVar (p.id_, p.type_); // computes next free adress for ID and stores adress/type
      return null;
    }
  }

  // compile statements

  public class StmVisitor implements Stm.Visitor<Void, Void>{

    public Void visit(cmm.Absyn.SExp p, Void arg){
      if(true) throw new RuntimeException("not yet implemented compile statement" + cmm.PrettyPrinter.print(p));
      return null;
    }
    public Void visit(cmm.Absyn.SDecls p, Void arg){
      if(true) throw new RuntimeException("not yet implemented compile statement" + cmm.PrettyPrinter.print(p));
      return null;
    }
    public Void visit(cmm.Absyn.SInit p, Void arg){
      if(true) throw new RuntimeException("not yet implemented compile statement" + cmm.PrettyPrinter.print(p));
      return null;
    }
    public Void visit(cmm.Absyn.SReturn p, Void arg){
      // compare types
      if(true) throw new RuntimeException("not yet implemented compile statement" + cmm.PrettyPrinter.print(p));
      return null;
    }
    public Void visit(cmm.Absyn.SWhile p, Void arg){
      if(true) throw new RuntimeException("not yet implemented compile statement" + cmm.PrettyPrinter.print(p));
      return null;
    }
    public Void visit(cmm.Absyn.SBlock p, Void arg){
      if(true) throw new RuntimeException("not yet implemented compile statement" + cmm.PrettyPrinter.print(p));
      return null;
    }
    public Void visit(cmm.Absyn.SIfElse p, Void arg){
      if(true) throw new RuntimeException("not yet implemented compile statement" + cmm.PrettyPrinter.print(p));
      return null;
    }
  }

  public class ExpVisitor implements Exp.Visitor<Void, Void>{
    public Void visit(cmm.Absyn.EBool p, Void arg){
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EInt p, Void arg) {
      // he used a "emit" func here? dont remember what it did
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EDouble p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EId p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EApp p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EPost p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EPre p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EMul p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EAdd p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(ECmp p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EAnd p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EOr p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }

    @Override
    public Void visit(EAss p, Void arg) {
      if(true) throw new RuntimeException("Not yet implemented: compile expression" + cmm.PrettyPrinter.print(p));
      return null;
    }
  }

  int newVar(String x, Type t){
    int addr = nextLocal;
    context.get(0).put(x, new ContextEntry(t, addr));
  //  nextLocal += t.accept(new Size(), null); // lacks type visitor?
    if(nextLocal > limitLocals) limitLocals = nextLocal;
    return addr;
  }

  ContextEntry lookupVar(String x){
    for(Map<String,ContextEntry>b:context){
      ContextEntry ce = b.get(x);
      if(ce  != null) return ce;
    }
    throw new RuntimeException("Impossible: unbound variable " + x);
  }

  void newBlock(){
    context.add(0, new TreeMap());
  }

  void popblock(){
    context.remove(0);
  }

  // stack funcs
  // adjust stack visitor?
  //

}
