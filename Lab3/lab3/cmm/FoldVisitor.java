package cmm;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* Program */
    public R visit(cmm.Absyn.PDefs p, A arg) {
      R r = leaf(arg);
      for (cmm.Absyn.Def x : p.listdef_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Def */
    public R visit(cmm.Absyn.DFun p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      for (cmm.Absyn.Arg x : p.listarg_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      for (cmm.Absyn.Stm x : p.liststm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Arg */
    public R visit(cmm.Absyn.ADecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }

/* Stm */
    public R visit(cmm.Absyn.SExp p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.SDecls p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.SInit p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.SReturn p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.SWhile p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      r = combine(p.stm_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.SBlock p, A arg) {
      R r = leaf(arg);
      for (cmm.Absyn.Stm x : p.liststm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(cmm.Absyn.SIfElse p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      r = combine(p.stm_1.accept(this, arg), r, arg);
      r = combine(p.stm_2.accept(this, arg), r, arg);
      return r;
    }

/* Exp */
    public R visit(cmm.Absyn.EBool p, A arg) {
      R r = leaf(arg);
      r = combine(p.boollit_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.EInt p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.EDouble p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.EId p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.EApp p, A arg) {
      R r = leaf(arg);
      for (cmm.Absyn.Exp x : p.listexp_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(cmm.Absyn.EPost p, A arg) {
      R r = leaf(arg);
      r = combine(p.incdecop_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.EPre p, A arg) {
      R r = leaf(arg);
      r = combine(p.incdecop_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.EMul p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.mulop_.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.EAdd p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.addop_.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.ECmp p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.cmpop_.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.EAnd p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.EOr p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(cmm.Absyn.EAss p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }

/* IncDecOp */
    public R visit(cmm.Absyn.OInc p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.ODec p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* MulOp */
    public R visit(cmm.Absyn.OTimes p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.ODiv p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* AddOp */
    public R visit(cmm.Absyn.OPlus p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.OMinus p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* CmpOp */
    public R visit(cmm.Absyn.OLt p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.OGt p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.OLtEq p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.OGtEq p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.OEq p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.ONEq p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* BoolLit */
    public R visit(cmm.Absyn.LTrue p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.LFalse p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Type */
    public R visit(cmm.Absyn.Type_bool p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.Type_int p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.Type_double p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(cmm.Absyn.Type_void p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
