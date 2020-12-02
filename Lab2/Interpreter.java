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
                def.accept(new FunctionVisitor(), arg);
            }
   

            pushBlock();
            findFunction("main").func.accept(new DefVisitor(), arg);
            popBlock();
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
            return type.equals(INT);
        }

        public boolean isDouble() {
            if (type == null) {
                return false;
            }
            return type.equals(DOUBLE);
        }

        public boolean isBool() {
            if (type == null) {
                return false;
            }
            return type.equals(BOOL);
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

        public class FunctionVisitor implements Def.Visitor<Void, Void> {

            @Override
            public Void visit(DFun p, Void arg) {
                    Func function = new Func(p);
                    p.listarg_.forEach(argument -> {
                        ADecl a = (ADecl)argument;
                        function.addArg(a.id_);
                    });
                    addFunction(p.id_, function);
                return null;
            }

        }

    // Statement //////////////////////////////////////////////////////////

    public class StmVisitor implements Stm.Visitor<Value, Void> { // is this supposed to be a value?

        @Override
        public Value visit(SExp p, Void arg) {
            p.exp_.accept(new ExpVisitor(), arg);
            return null;
        }

        @Override
        public Value visit(SDecls p, Void arg) {
            p.listid_.forEach(id -> addVar(id, new Value(null, p.type_)));
            return null;
        }

        @Override
        public Value visit(SInit p, Void arg) {
            var c = p.exp_.accept(new ExpVisitor(), arg).value;
            addVar(p.id_, new Value(c, p.type_));
            return null;
        }

        @Override
        public Value visit(SReturn p, Void arg) {
            return (p.exp_.accept(new ExpVisitor(), arg));
        }

        @Override
        public Value visit(SWhile p, Void arg) {
            Value condition = p.exp_.accept(new ExpVisitor(), arg);
            while ((boolean) (condition.value)) {
                pushBlock();
                Value value = p.stm_.accept(new StmVisitor(), arg);
                popBlock();
                if (value != null) {
                    return value;
                }
                condition = p.exp_.accept(new ExpVisitor(), arg);
                // p.stm_.accept(new StmVisitor(), arg);
            }
            return null;
        }

        @Override
        public Value visit(SBlock p, Void arg) {
            pushBlock();
            p.liststm_.forEach(s -> s.accept(new StmVisitor(), arg));
            popBlock();
            return null;
        }

        @Override
        public Value visit(SIfElse p, Void arg) {
            pushBlock();
            Value value = null;
            boolean condition = (boolean) p.exp_.accept(new ExpVisitor(), arg).value;
            if (condition) {
                value = p.stm_1.accept(this, arg);
            } else {
                value = p.stm_2.accept(this, arg);
            }
            popBlock();
            return value;
        }
    }

    // ----------------------- Expression visitor
    public class ExpVisitor implements Exp.Visitor<Value, Void> {

        @Override
        public Value visit(EBool p, Void arg) {
            var lit = p.boollit_;
            if (lit instanceof LTrue) {
                return new Value(true, BOOL);
            } else {
                return new Value(false, BOOL);
            }

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
            for (int i = 0; i < p.listexp_.size(); ++i) {
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
            } else {
                val = function.func.accept(new DefVisitor(), arg);
            }
            popBlock();
            return val;
        }

        @Override
        public Value visit(EPost p, Void arg) {
            Value value1 = lookupVar(p.id_);
            Value value2 = null;
            IncDecOp operator = p.incdecop_;
            if (operator instanceof OInc) {
                if (value1.isInt()) {
                    value2 = new Value((int) (value1.value) + 1, INT);
                } else if (value1.isDouble()) {
                    value2 = new Value((double) (value1.value) + 1, DOUBLE);
                }
            } else if (operator instanceof ODec) {
                if (value1.isInt()) {
                    value2 = new Value((int) (value1.value) - 1, INT);
                } else if (value1.isDouble()) {
                    value2 = new Value((double) (value1.value) - 1, DOUBLE);
                }
            }
            updateVar(p.id_, value2);
            return value1;
        }

        @Override
        public Value visit(EPre p, Void arg) {
            Value value1 = lookupVar(p.id_);
            Value value2 = null;
            IncDecOp operator = p.incdecop_;
            if (operator instanceof OInc) {
                if (value1.isInt()) {
                    value2 = new Value((int) (value1.value) + 1, INT);
                } else if (value1.isDouble()) {
                    value2 = new Value((double) (value1.value) + 1, DOUBLE);
                }
            } else if (operator instanceof ODec) {
                if (value1.isInt()) {
                    value2 = new Value((int) (value1.value) - 1, INT);
                } else if (value1.isDouble()) {
                    value2 = new Value((double) (value1.value) - 1, DOUBLE);
                }
            }
            updateVar(p.id_, value2);
            return value2;
        }

        @Override
        public Value visit(EMul p, Void arg) {
            // work in progress
            Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
            Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
            Value value3 = null;
            var superType = getSuperType(value1, value2);
            value1 = castToSuperType(value1, superType);
            value2 = castToSuperType(value2, superType);

            var operator = p.mulop_;
            if (operator instanceof OTimes) {
                if (value1.isDouble() && value2.isDouble()) {
                    value3 = new Value((double) ((Object) value1.value) * (double) ((Object) value2.value), DOUBLE);
                } else if (value1.isInt() && value2.isInt()) {
                    value3 = new Value((int) ((Object) value1.value) * (int) ((Object) value2.value), INT);
                }
            } else if (operator instanceof ODiv) {
                if (value2.isDouble() && value2.value.equals(0)) {
                    throw new RuntimeException("Can not divide by 0");
                } else if (value2.isInt() && value2.value.equals(0)) {
                    throw new RuntimeException("Can not divide by 0");
                }
                if (value1.isDouble() && value2.isDouble()) {
                    value3 = new Value((double) ((Object) value1.value) / (double) ((Object) value2.value), DOUBLE);
                } else if (value1.isInt() && value2.isInt()) {
                    value3 = new Value((int) ((Object) value1.value) / (int) ((Object) value2.value), INT);
                }
            }
            return value3;
        }

        @Override
        public Value visit(EAdd p, Void arg) {
            Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
            Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
            Value value3 = null;
            var operator = p.addop_;
            if (operator instanceof OPlus) {
                if (value1.isInt() && value2.isInt()) {
                    value3 = new Value((int) (value1.value) + (int) (value2.value), INT);
                } else if (value1.isDouble() && value2.isDouble()) {
                    value3 = new Value((double) (value1.value) + (double) (value2.value), DOUBLE);
                }
            } else if (operator instanceof OMinus) {
                if (value1.isInt() && value2.isInt()) {
                    value3 = new Value((int) (value1.value) - (int) (value2.value), INT);
                } else if (value1.isDouble() && value2.isDouble()) {
                    value3 = new Value((double) (value1.value) - (double) (value2.value), DOUBLE);
                }
            }
            return value3;
        }

        @Override
        public Value visit(ECmp p, Void arg) {
            Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
            Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
            CmpOp operator = p.cmpop_;
            if (operator instanceof OLt) {
                if (value1.isInt() && (int) value1.value < (int) value2.value) {
                    return new Value(true, BOOL);
                } else if (value1.isDouble() && (double) value1.value < (double) value2.value) {
                    return new Value(true, BOOL);
                } else {
                    return new Value(false, BOOL);
                }
            } else if (operator instanceof OGt) {
                if (value1.isInt() && (int) value1.value > (int) value2.value) {
                    return new Value(true, BOOL);
                } else if (value1.isDouble() && (double) value1.value > (double) value2.value) {
                    return new Value(true, BOOL);
                } else {
                    return new Value(false, BOOL);
                }

            } else if (operator instanceof OLtEq) {
                if (value1.isInt() && (int) value1.value <= (int) value2.value) {
                    return new Value(true, BOOL);
                } else if (value1.isDouble() && (double) value1.value <= (double) value2.value) {
                    return new Value(true, BOOL);
                } else {
                    return new Value(false, BOOL);
                }

            } else if (operator instanceof OGtEq) {
                if (value1.isInt() && (int) value1.value >= (int) value2.value) {
                    return new Value(true, BOOL);
                } else if (value1.isDouble() && (double) value1.value >= (double) value2.value) {
                    return new Value(true, BOOL);
                } else {
                    return new Value(false, BOOL);
                }

            } else if (operator instanceof OEq) {
                if (value1.isInt() && (int) value1.value == (int) value2.value) {
                    return new Value(true, BOOL);
                } else if (value1.isDouble() && (double) value1.value == (double) value2.value) {
                    return new Value(true, BOOL);
                } else if (value1.isBool() && (boolean) value1.value == (boolean) value2.value) {
                    return new Value(true, BOOL);
                } else {
                    return new Value(false, BOOL);
                }

            } else if (operator instanceof ONEq) {
                if (value1.isInt() && (int) value1.value != (int) value2.value) {
                    return new Value(true, BOOL);
                } else if (value1.isDouble() && (double) value1.value != (double) value2.value) {
                    return new Value(true, BOOL);
                } else if (value1.isBool() && (boolean) value1.value != (boolean) value2.value) {
                    return new Value(true, BOOL);
                } else {
                    return new Value(false, BOOL);
                }
            }
            throw new RuntimeException("Illegal operator " + operator);
        }

        @Override
        public Value visit(EAnd p, Void arg) {
            Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
            if (!(boolean) (value1.value))
                return new Value(false, BOOL);
            Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
            if (!(boolean) (value2.value))
                return new Value(false, BOOL);
            return new Value(true, BOOL);
        }

        @Override
        public Value visit(EOr p, Void arg) {
            Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
            if ((boolean) (value1.value))
                return new Value(true, BOOL);
            Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
            if ((boolean) (value2.value))
                return new Value(true, BOOL);
            return new Value(false, BOOL);
        }

        @Override
        public Value visit(EAss p, Void arg) {
            Value value = p.exp_.accept(new ExpVisitor(), arg);
            updateVar(p.id_, value);
            return value;
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
        throw new RuntimeException("Unbound variable found in the interpreter " + x);
    }
    // Operators //////////////////////////////////////////////////////////

    public class OperatorVisito implements CmpOp.Visitor<Type, Void> {

        @Override
        public Type visit(OLt p, Void arg) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Type visit(OGt p, Void arg) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Type visit(OLtEq p, Void arg) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Type visit(OGtEq p, Void arg) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Type visit(OEq p, Void arg) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Type visit(ONEq p, Void arg) {
            // TODO Auto-generated method stub
            return null;
        }

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

    public void updateVar(String id, Value value) {
        for (HashMap<String, Value> m : context) {
            if (m.containsKey(id)) {
                m.put(id, value);
                break;
            }
        }
    }

    public Type getSuperType(Value v1, Value v2) {
        return v1.type.equals(DOUBLE) ? v1.type : v2.type;
    }

    public Value castToSuperType(Value value, Type type) {
        if (type.equals(DOUBLE)) {
            if (value.isInt()) {
                value.type = type;
                value.value = ((double) ((int) value.value));
            } else if (value.isDouble()) {
                if (value.value instanceof Integer) {
                    value.value = ((double) ((int) value.value));
                }
            }
        }
        return value;
    }
}
