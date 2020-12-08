package cmm;

/** BNFC-Generated Abstract Visitor */

public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
    /* Program */
    public R visit(cmm.Absyn.PDefs p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.Program p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Def */
    public R visit(cmm.Absyn.DFun p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.Def p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Arg */
    public R visit(cmm.Absyn.ADecl p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.Arg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Stm */
    public R visit(cmm.Absyn.SExp p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.SDecls p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.SInit p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.SReturn p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.SWhile p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.SBlock p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.SIfElse p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.Stm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Exp */
    public R visit(cmm.Absyn.EBool p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EInt p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EDouble p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EId p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EApp p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EPost p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EPre p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EMul p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EAdd p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.ECmp p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EAnd p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EOr p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.EAss p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.Exp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* IncDecOp */
    public R visit(cmm.Absyn.OInc p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.ODec p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.IncDecOp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* MulOp */
    public R visit(cmm.Absyn.OTimes p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.ODiv p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.MulOp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* AddOp */
    public R visit(cmm.Absyn.OPlus p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.OMinus p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.AddOp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* CmpOp */
    public R visit(cmm.Absyn.OLt p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.OGt p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.OLtEq p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.OGtEq p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.OEq p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.ONEq p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.CmpOp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* BoolLit */
    public R visit(cmm.Absyn.LTrue p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.LFalse p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.BoolLit p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Type */
    public R visit(cmm.Absyn.Type_bool p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.Type_int p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.Type_double p, A arg) { return visitDefault(p, arg); }
    public R visit(cmm.Absyn.Type_void p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(cmm.Absyn.Type p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
