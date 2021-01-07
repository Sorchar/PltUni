package fun;

/** BNFC-Generated Abstract Visitor */

public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
    /* Program */
    public R visit(fun.Absyn.Prog p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fun.Absyn.Program p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Main */
    public R visit(fun.Absyn.DMain p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fun.Absyn.Main p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Def */
    public R visit(fun.Absyn.DDef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fun.Absyn.Def p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Exp */
    public R visit(fun.Absyn.EVar p, A arg) { return visitDefault(p, arg); }
    public R visit(fun.Absyn.EInt p, A arg) { return visitDefault(p, arg); }
    public R visit(fun.Absyn.EApp p, A arg) { return visitDefault(p, arg); }
    public R visit(fun.Absyn.EAdd p, A arg) { return visitDefault(p, arg); }
    public R visit(fun.Absyn.ESub p, A arg) { return visitDefault(p, arg); }
    public R visit(fun.Absyn.ELt p, A arg) { return visitDefault(p, arg); }
    public R visit(fun.Absyn.EIf p, A arg) { return visitDefault(p, arg); }
    public R visit(fun.Absyn.EAbs p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fun.Absyn.Exp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
