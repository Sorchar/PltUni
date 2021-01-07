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
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Value visit(EApp p, Environment arg) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Value visit(EAdd p, Environment arg) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Value visit(ESub p, Environment arg) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Value visit(ELt p, Environment arg) {
      // TODO Auto-generated method stub
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

  abstract class Entry {
    abstract Value value();
  }

  class Empty extends Environment {
    Value lookup(String x) {
      return null;
    }
  }

}
