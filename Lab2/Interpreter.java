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

    public class StmVisitor implements Stm.Visitor<Value, Void> { // is this supposed to be a value?

        @Override
        public Value visit(SExp p, Void arg) { // could this be a void?
            p.exp_.accept(new ExpVisitor(), arg);
            return null;
        }

        @Override
        public Value visit(SDecls p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(SInit p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(SReturn p, Void arg) {
            return (p.exp_.accept(new ExpVisitor(),arg));
        }

        @Override
        public Value visit(SWhile p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(SBlock p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Value visit(SIfElse p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }
    }
		//----------------------- Expression visitor
		public class ExpVisitor implements Exp.Visitor<Value, Void> {

				@Override
				public Value visit(EBool p, Void arg) {
						//return new Value(p.boolean_, BOOL)
					//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
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
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
						return null;
				}

				@Override
				public Value visit(EPost p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

						return null;
				}

				@Override
				public Value visit(EPre p, Void arg) {

					//if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
						return null;
				}

				@Override
				public Value visit(EMul p, Void arg) {
					//if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

						return null;
				}

				@Override
				public Value visit(EAdd p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

						return null;
				}

				@Override
				public Value visit(ECmp p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

						return null;
				}

				@Override
				public Value visit(EAnd p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

						return null;
				}

				@Override
				public Value visit(EOr p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

						return null;
				}

				@Override
				public Value visit(EAss p, Void arg) {
				//	if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));

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
