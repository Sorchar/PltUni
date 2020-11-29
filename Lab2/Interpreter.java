import cmm.Absyn.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;


public class Interpreter {

	public final static Value VNULL = new VNull();
	
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

    public class StmVisitor implements Stm.Visitor<Void, Void> {

        @Override
        public Void visit(SExp p, Void arg) {
            p.exp_.accept(new ExpVisitor(), null);
            return null;
        }

        @Override
        public Void visit(SDecls p, Void arg) {
            if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Void visit(SInit p, Void arg) {
           newVar(p.id_, VNULL);
           Value v = p.exp_.accept(new ExpVisitor(), null));
           assignVar(p.id_, v);
            return null;
        }

        @Override
        public Void visit(SReturn p, Void arg) {
            var type = p.exp_.accept(new ExpVisitor(), arg);
            typeEquals(returnType, type);
            return null;
        }

        @Override
        public Void visit(SWhile p, Void arg) {
            if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Void visit(SBlock p, Void arg) {
            if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }

        @Override
        public Void visit(SIfElse p, Void arg) {
            if(true) throw new RuntimeException("Not yet implemented " + p.getClass().toString() + " -> " + PrettyPrinter.print(p));
            return null;
        }
    }

	public void assignVar(String x, Value v){ //values and not a func? 1;36:46
		for(HashMap<String, Value> m: context){
			if (m.containsKey(x)){
				m.put(x,v);
				return v;
			}
		}
		throw new RunTimeException("Unbound variable " +x);
		
	}
		

}
