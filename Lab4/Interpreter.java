import java.util.*;

import fun.Absyn.*;

public class Interpreter {

  final Strategy strategy;

  public Interpreter(Strategy strategy) {
    this.strategy = strategy;
  }

  public void interpret(Program p) {
    System.out.println(p.accept(new ProgramVisitor(), null).intValue());
  }

  public class ProgramVisitor implements Program.Visitor<Value, Void> {

    @Override
    public Value visit(Prog p, Void arg) {
      p.listdef_.forEach(def -> def.accept(new DefVisitor(), arg));
      return p.main_.accept(new MainVisitor(), null);
    }
  }

  public class MainVisitor implements Main.Visitor<Value, Void> {

    @Override
    public Interpreter.Value visit(DMain p, Void arg) {
      return p.exp_.accept(new ExpVisitor(), new Empty());
    }
  }

  public class DefVisitor implements Def.Visitor<Void, Void> {

    @Override
    public Void visit(DDef p, Void arg) {
      // TODO Auto-generated method stub
      return null;
    }

  }

  class ExpVisitor implements Exp.Visitor<Value, Environment> {

    @Override
    public Value visit(EVar p, Environment arg) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Value visit(EInt p, Environment arg) {
      return new intValue(p.integer_);
    }

    @Override
    public Value visit(EApp p, Environment arg) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Value visit(EAdd p, Environment arg) {
      Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
      Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
      return new intValue(value1.intValue() + value2.intValue());
    }

    @Override
    public Value visit(ESub p, Environment arg) {
      Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
      Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
      return new intValue(value1.intValue() - value2.intValue());    }

    @Override
    public Value visit(ELt p, Environment arg) {
      //Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
      //Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
      //return new intValue(value1.intValue() < value2.intValue()); //TODO fix
      return null;
    }

    @Override
    public Value visit(EIf p, Environment arg) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Value visit(EAbs p, Environment arg) {
      // TODO Auto-generated method stub
      // TODO this is the one that requires funcValue
      return null;
    }

  }

  abstract class Environment {
    abstract Value lookup(String x);
  }

  abstract class Value {
    abstract public int intValue();

    abstract public Value apply(Entry e);
  }

  class intValue extends Value {

    final int value;
    public intValue (int i) { value = i; }

    public int intValue() {
      return value;
    }
    public Value apply(Entry e){
      throw new RuntimeException ("value is not a function");
    }
  }

  class funcValue extends Value{

    final String x;
    final Exp body;
    final Environment gamma;

    funcValue(String x, Exp body, Environment gamma){
      this.x = x;
      this.body = body;
      this.gamma = gamma;
    }

    @Override
    public int intValue() {
      throw new RuntimeException("funcValue is not int");
    }

    @Override
    public Value apply(Entry e) {
      //TODO
      return null;
    }
  }

  abstract class Entry {
    abstract Value value();
  }

  class ValueEntry extends Entry{
// TODO fix
    @Override
    Value value() {
      return null;
    }
  }

  class Empty extends Environment {
    Value lookup(String x) {
      return null;
    }
  }

}
