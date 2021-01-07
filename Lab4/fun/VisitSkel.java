package fun;

/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/

/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use.
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgramVisitor<R,A> implements fun.Absyn.Program.Visitor<R,A>
  {
    public R visit(fun.Absyn.Prog p, A arg)
    { /* Code for Prog goes here */
      for (fun.Absyn.Def x: p.listdef_) {
        x.accept(new DefVisitor<R,A>(), arg);
      }
      p.main_.accept(new MainVisitor<R,A>(), arg);
      return null;
    }
  }
  public class MainVisitor<R,A> implements fun.Absyn.Main.Visitor<R,A>
  {
    public R visit(fun.Absyn.DMain p, A arg)
    { /* Code for DMain goes here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
  }
  public class DefVisitor<R,A> implements fun.Absyn.Def.Visitor<R,A>
  {
    public R visit(fun.Absyn.DDef p, A arg)
    { /* Code for DDef goes here */
      //p.ident_;
      for (String x: p.listident_) {
        //x;
      }
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ExpVisitor<R,A> implements fun.Absyn.Exp.Visitor<R,A>
  {
    public R visit(fun.Absyn.EVar p, A arg)
    { /* Code for EVar goes here */
      //p.ident_;
      return null;
    }
    public R visit(fun.Absyn.EInt p, A arg)
    { /* Code for EInt goes here */
      //p.integer_;
      return null;
    }
    public R visit(fun.Absyn.EApp p, A arg)
    { /* Code for EApp goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(fun.Absyn.EAdd p, A arg)
    { /* Code for EAdd goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(fun.Absyn.ESub p, A arg)
    { /* Code for ESub goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(fun.Absyn.ELt p, A arg)
    { /* Code for ELt goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(fun.Absyn.EIf p, A arg)
    { /* Code for EIf goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      p.exp_3.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(fun.Absyn.EAbs p, A arg)
    { /* Code for EAbs goes here */
      //p.ident_;
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
  }
}
