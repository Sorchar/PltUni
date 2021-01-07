package fun;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  fun.Absyn.Program.Visitor<fun.Absyn.Program,A>,
  fun.Absyn.Main.Visitor<fun.Absyn.Main,A>,
  fun.Absyn.Def.Visitor<fun.Absyn.Def,A>,
  fun.Absyn.Exp.Visitor<fun.Absyn.Exp,A>
{
    /* Program */
    public fun.Absyn.Program visit(fun.Absyn.Prog p, A arg)
    {
      fun.Absyn.ListDef listdef_ = new fun.Absyn.ListDef();
      for (fun.Absyn.Def x : p.listdef_)
      {
        listdef_.add(x.accept(this,arg));
      }
      fun.Absyn.Main main_ = p.main_.accept(this, arg);
      return new fun.Absyn.Prog(listdef_, main_);
    }

    /* Main */
    public fun.Absyn.Main visit(fun.Absyn.DMain p, A arg)
    {
      fun.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      return new fun.Absyn.DMain(exp_);
    }

    /* Def */
    public fun.Absyn.Def visit(fun.Absyn.DDef p, A arg)
    {
      String ident_ = p.ident_;
      fun.Absyn.ListIdent listident_ = p.listident_;
      fun.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      return new fun.Absyn.DDef(ident_, listident_, exp_);
    }

    /* Exp */
    public fun.Absyn.Exp visit(fun.Absyn.EVar p, A arg)
    {
      String ident_ = p.ident_;
      return new fun.Absyn.EVar(ident_);
    }
    public fun.Absyn.Exp visit(fun.Absyn.EInt p, A arg)
    {
      Integer integer_ = p.integer_;
      return new fun.Absyn.EInt(integer_);
    }
    public fun.Absyn.Exp visit(fun.Absyn.EApp p, A arg)
    {
      fun.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      fun.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new fun.Absyn.EApp(exp_1, exp_2);
    }
    public fun.Absyn.Exp visit(fun.Absyn.EAdd p, A arg)
    {
      fun.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      fun.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new fun.Absyn.EAdd(exp_1, exp_2);
    }
    public fun.Absyn.Exp visit(fun.Absyn.ESub p, A arg)
    {
      fun.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      fun.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new fun.Absyn.ESub(exp_1, exp_2);
    }
    public fun.Absyn.Exp visit(fun.Absyn.ELt p, A arg)
    {
      fun.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      fun.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new fun.Absyn.ELt(exp_1, exp_2);
    }
    public fun.Absyn.Exp visit(fun.Absyn.EIf p, A arg)
    {
      fun.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      fun.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      fun.Absyn.Exp exp_3 = p.exp_3.accept(this, arg);
      return new fun.Absyn.EIf(exp_1, exp_2, exp_3);
    }
    public fun.Absyn.Exp visit(fun.Absyn.EAbs p, A arg)
    {
      String ident_ = p.ident_;
      fun.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      return new fun.Absyn.EAbs(ident_, exp_);
    }
}
