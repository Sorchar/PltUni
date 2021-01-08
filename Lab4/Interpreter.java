import java.util.*;

import fun.Absyn.*;

public class Interpreter {

  final Strategy strategy;
  final Map < String, Exp > signature = new HashMap<>();

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
      // System.out.println(p.listident_);
      // System.out.println(p.exp_);
      // System.out.println(p.ident_);
      // System.out.println("-------");
      var exp = p.exp_;
      Collections.reverse(p.listident_);
      for (var argument : p.listident_){
        exp = new EAbs(argument, exp);
      }
      signature.put(p.ident_, exp);
      
      return null;
    }

  }

  class ExpVisitor implements Exp.Visitor<Value, Environment> {

    @Override
    public Value visit(EVar p, Environment arg) {
      Value value = arg.lookup(p.ident_);
      if (value != null){
        return value;
      }else {
        Exp exp = signature.get(p.ident_);
        if (exp != null) {
          return exp.accept(new ExpVisitor(), arg);
        }
      }
      throw new RuntimeException("Variable not found: " + p.ident_);
    }

    @Override
    public Value visit(EInt p, Environment arg) {
      return new IntValue(p.integer_);
    }

    @Override
    public Value visit(EApp p, Environment arg) {
      Entry entry = new ValueEntry(new IntValue(0));
      if (strategy == Strategy.CallByValue){
        entry = new ValueEntry(p.exp_2.accept(new ExpVisitor(), arg));
      }
      return p.exp_1.accept(new ExpVisitor(), arg).apply(entry);

    }

    @Override
    public Value visit(EAdd p, Environment arg) {
      Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
      Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
      return new IntValue(value1.intValue() + value2.intValue());
    }

    @Override
    public Value visit(ESub p, Environment arg) {
      Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
      Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
      return new IntValue(value1.intValue() - value2.intValue());
    }

    @Override
    public Value visit(ELt p, Environment arg) {
      Value value1 = p.exp_1.accept(new ExpVisitor(), arg);
      Value value2 = p.exp_2.accept(new ExpVisitor(), arg);
      if (value1.intValue() < value2.intValue()) {
        return new IntValue(1);
      } else {
        return new IntValue(0);
      }
    }

    @Override
    public Value visit(EIf p, Environment arg) {
      var exp = p.exp_1.accept(new ExpVisitor(), arg);
      if (exp.intValue() == 1) {
        return p.exp_2.accept(new ExpVisitor(), arg);
      } else {
        return p.exp_3.accept(new ExpVisitor(), arg);
      }
    }

    @Override
    public Value visit(EAbs p, Environment arg) {
      return new FuncValue(p.ident_, p.exp_, arg);
    }

  }

  abstract class Environment {
    abstract Value lookup(String x);
  }

  abstract class Value {
    abstract public int intValue();

    abstract public Value apply(Entry e);
  }

  class IntValue extends Value {

    final int value;

    public IntValue(int i) {
      value = i;
    }

    public int intValue() {
      return value;
    }

    public Value apply(Entry e) {
      throw new RuntimeException("value is not a function");
    }
  }

  // lambda function
  class FuncValue extends Value {

    final String x;
    final Exp body;
    final Environment enviroment;

    FuncValue(String x, Exp body, Environment env) {
      this.x = x;
      this.body = body;
      this.enviroment = env;
    }

    @Override
    public int intValue() {
      throw new RuntimeException("funcValue is not int");
    }

    @Override
    public Value apply(Entry e) {
      return body.accept(new ExpVisitor(), new Extend(x, e, enviroment));
    }
  }

  abstract class Entry {
    abstract Value value();
  }

  class ValueEntry extends Entry {
    final Value value;

    ValueEntry(Value value) {
      this.value = value;
    }

    @Override
    Value value() {
      return value;
    }
  }

  class Empty extends Environment {
    Value lookup(String x) {
      return null;
    }
  }

  class Extend extends Environment {
    final Environment enviroment;
    final String y;
    final Entry entry;

    Extend(String y, Entry entry, Environment env) {
      this.enviroment = env;
      this.y = y;
      this.entry = entry;
    }

    Value lookup(String x) {
      if (x.equals(y)) {
        return entry.value();
      } else {
        return enviroment.lookup(x);
      }
    }
  }

}
