import cmm.Absyn.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;


public class Interpreter {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Func> signature = new HashMap<String, Func>();
        LinkedList<HashMap<String, Value>> context = new LinkedList<HashMap<String, Value>>();

        public final Type BOOL = new Type_bool();
        public final Type INT = new Type_int();
        public final Type DOUBLE = new Type_double();
        public final Type VOID = new Type_void();

        public void interpret(Program p) {
            p.accept(new ProgramVisitor(), null);
           }

    public class ProgramVisitor implements Program.Visitor<Void, Void>{

        @Override
        public Void visit(PDefs p, Void arg) {
            // TODO Auto-generated method stub
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
            return type == INT;
        }

        public boolean isDouble() {
            return type == DOUBLE;
        }

        public boolean isBool() {
            return type == BOOL;
        }
    }

    public class Func {
        ArrayList<String> argnames;
        DFun func;

        public Func() {
            this.argnames = new ArrayList<String>();
        }

        public Func(DFun func) {
            this.argnames = new ArrayList<String>();
            this.func = func;
        }

        public void addArg(String arg) {
            argnames.add(arg);
        }
    }
        // Statement //////////////////////////////////////////////////////////

    public class StmVisitor implements Stm.Visitor<Void, Void> { // is this supposed to be a value?

        @Override
        public Void visit(SExp p, Void arg) {
            p.exp_.accept(new ExpVisitor(), null);
            return null;
        }

        @Override
        public Void visit(SDecls p, Void arg) {
            return null;
        }

        @Override
        public Void visit(SInit p, Void arg) {
            return null;
        }

        @Override
        public Void visit(SReturn p, Void arg) {
            return null;
        }

        @Override
        public Void visit(SWhile p, Void arg) {
            return null;
        }

        @Override
        public Void visit(SBlock p, Void arg) {
            return null;
        }

        @Override
        public Void visit(SIfElse p, Void arg) {
            return null;
        }
    }
// ---------------
	/*public void assignVar(String x, Value v){ //values and not a func? 1;36:46
		for(HashMap<String, Value> m: context){
			if (m.containsKey(x)){
				m.put(x,v);
				return v;
			}
		}
		throw new RunTimeException("Unbound variable " +x);

	}*/
		//----------------------- Expression visitor
		public class ExpVisitor implements Exp.Visitor<Value, Void> {

				@Override
				public Value visit(EBool p, Void arg) {
						//return new Value(p.boolean_, BOOL);
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
						return null;
				}

				@Override
				public Value visit(EPost p, Void arg) {
						return null;
				}

				@Override
				public Value visit(EPre p, Void arg) {
						return null;
				}

				@Override
				public Value visit(EMul p, Void arg) {
						return null;
				}

				@Override
				public Value visit(EAdd p, Void arg) {
						return null;
				}

				@Override
				public Value visit(ECmp p, Void arg) {
						return null;
				}

				@Override
				public Value visit(EAnd p, Void arg) {
						return null;
				}

				@Override
				public Value visit(EOr p, Void arg) {
						return null;
				}

				@Override
				public Value visit(EAss p, Void arg) {
						return null;
				}

		}


		public Value lookupVar(String x) {
				for (HashMap<String, Value> m : context) {
						Value value = m.get(x);
						if (value != null) {
								return value;
						}
				}
				throw new TypeException("unbound variable " + x);
		}

}
