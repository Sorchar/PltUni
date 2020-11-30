import cmm.Absyn.*;
import cmm.PrettyPrinter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
import javax.management.RuntimeErrorException;

public class Interpreter {

    Scanner scanner = new Scanner(System.in);
    HashMap<String, Func> signature = new HashMap<String, Func>();
    ArrayList<HashMap<String, Value>> context = new ArrayList<HashMap<String, Value>>();

    public final Type BOOL = new Type_bool();
    public final Type INT = new Type_int();
    public final Type DOUBLE = new Type_double();
    public final Type VOID = new Type_void();

    public void interpret(Program p) {
        p.accept(new ProgramVisitor(), null);
    }

    public class ProgramVisitor implements Program.Visitor<Void, Void> {

        @Override
        public Void visit(PDefs p, Void arg) {
            Func function = new Func();
            function.addArg("x");
            addFunction("printInt", function);
            function = new Func();
            function.addArg("x");
            addFunction("printDouble", function);
            function = new Func();
            addFunction("readInt", function);
            function = new Func();
            addFunction("readDouble", function);

            for (Def def : p.listdef_) {
                // def.accept(new FunctionVisitor(), arg);
            }

            for (Def def : p.listdef_) {
                def.accept(new DefVisitor(), arg);
            }

            return null;
        }
    }

    public class Value {

        Object value;
        Type type;

        public Value(Object val, Type type) {
            this.value = val;
            this.type = type;
        }

        public boolean isInt() {
            if (type == null) {
                return false;
            }
            return type == INT;
        }

        public boolean isDouble() {
            if (type == null) {
                return false;
            }
            return type == DOUBLE;
        }

        public boolean isBool() {
            if (type == null) {
                return false;
            }
            return type == BOOL;
        }
    }

    // Function //////////////////////////////////////////////////////////

    public class Func {
        ArrayList<String> argumentNames;
        DFun func;

        public Func() {
            this.argumentNames = new ArrayList<String>();
        }

        public Func(DFun func) {
            this.argumentNames = new ArrayList<String>();
            this.func = func;
        }

        public void addArg(String arg) {
            argumentNames.add(arg);
        }
    }

    public class DefVisitor implements Def.Visitor<Value, Void> {

        @Override
        public Value visit(DFun p, Void arg) {
            Value val = null;
            for (Stm stm : p.liststm_) {
                val = stm.accept(new StmVisitor(), arg);
                if (val != null) {
                    return val;
                }
            }

            return val;
        }

    }

    // Statement //////////////////////////////////////////////////////////

    public class StmVisitor implements Stm.Visitor<Value, Void> { // is this supposed to be a value?

        @Override
        public Value visit(SExp p, Void arg) { // could this be a void?
            p.exp_.accept(new ExpVisitor(), arg);
            return null;
        }

        @Override
        public Value visit(SDecls p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(SInit p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(SReturn p, Void arg) {
            return (p.exp_.accept(new ExpVisitor(), arg));
        }

        @Override
        public Value visit(SWhile p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(SBlock p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(SIfElse p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }
    }

    // ----------------------- Expression visitor
    public class ExpVisitor implements Exp.Visitor<Value, Void> {

        @Override
        public Value visit(EBool p, Void arg) {
            // return new Value(p.boolean_, BOOL)
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(EInt p, Void arg) {
            return new Value(p.integer_, INT);
        }

        @Override
        public Value visit(EDouble p, Void arg) {
            return new Value(p.double_, DOUBLE);
        }

        @Override
        public Value visit(EId p, Void arg) {
            return lookupVar(p.id_);
        }

        @Override
        public Value visit(EApp p, Void arg) {
            pushBlock();
            Func function = findFunction(p.id_);
            Value val = new Value(null, null);
            ArrayList<Value> argumentValues = new ArrayList<>();
            p.listexp_.forEach(exp -> argumentValues.add(exp.accept(new ExpVisitor(), arg)));

            for (int i = 0; i < p.listexp_.size(); i++) {
                addVar(function.argumentNames.get(i), argumentValues.get(i));
            }

            if (p.id_.equals("printInt")) {
                System.out.println(lookupVar(function.argumentNames.get(0)).value);
            } else if (p.id_.equals("printDouble")) {
                System.out.println(lookupVar(function.argumentNames.get(0)).value);
            } else if (p.id_.equals("readInt")) {
                val = new Value(scanner.nextInt(), INT);
            } else if (p.id_.equals("readDouble")) {
                val = new Value(scanner.nextDouble(), DOUBLE);
            } else
                val = function.func.accept(new DefVisitor(), arg);

            popBlock();
            return null;
        }

        @Override
        public Value visit(EPost p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

            return null;
        }

        @Override
        public Value visit(EPre p, Void arg) {

            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(EMul p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

            return null;
        }

        @Override
        public Value visit(EAdd p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

            return null;
        }

        @Override
        public Value visit(ECmp p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

            return null;
        }

        @Override
        public Value visit(EAnd p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

            return null;
        }

        @Override
        public Value visit(EOr p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

            return null;
        }

        @Override
        public Value visit(EAss p, Void arg) {
            if (true)
                throw new RuntimeException(
                        "Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

            return null;
        }

    }

    public Value lookupVar(String x) {
        for (HashMap<String, Value> m : context) {
            Value value = m.get(x);
            if (value != null && value.value == null) {
                throw new RuntimeException("Variable " + x + " is null");
            }
            if (value != null) {
                return value;
            }
        }
        throw new TypeException("Unbound variable " + x);
    }

    // Context handlers //////////////////////////////////////////////////////////

    public void pushBlock() {
        context.add(0, new HashMap<String, Value>());
    }

    public void popBlock() {
        context.remove(0);
    }

    public Func findFunction(String id) {
        return signature.get(id);
    }

    public void addFunction(String id, Func func) {
        signature.put(id, func);
    }

    public void addVar(String id, Value val) {
        context.get(0).put(id, val);
    }

}
