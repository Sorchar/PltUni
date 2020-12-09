package cmm;

/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/

/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use.
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgramVisitor<R,A> implements cmm.Absyn.Program.Visitor<R,A>
  {
    public R visit(cmm.Absyn.PDefs p, A arg)
    { /* Code for PDefs goes here */
      for (cmm.Absyn.Def x: p.listdef_) {
        x.accept(new DefVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class DefVisitor<R,A> implements cmm.Absyn.Def.Visitor<R,A>
  {
    public R visit(cmm.Absyn.DFun p, A arg)
    { /* Code for DFun goes here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      for (cmm.Absyn.Arg x: p.listarg_) {
        x.accept(new ArgVisitor<R,A>(), arg);
      }
      for (cmm.Absyn.Stm x: p.liststm_) {
        x.accept(new StmVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class ArgVisitor<R,A> implements cmm.Absyn.Arg.Visitor<R,A>
  {
    public R visit(cmm.Absyn.ADecl p, A arg)
    { /* Code for ADecl goes here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      return null;
    }
  }
  public class StmVisitor<R,A> implements cmm.Absyn.Stm.Visitor<R,A>
  {
    public R visit(cmm.Absyn.SExp p, A arg)
    { /* Code for SExp goes here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.SDecls p, A arg)
    { /* Code for SDecls goes here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      for (String x: p.listid_) {
        //x;
      }
      return null;
    }
    public R visit(cmm.Absyn.SInit p, A arg)
    { /* Code for SInit goes here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.SReturn p, A arg)
    { /* Code for SReturn goes here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.SWhile p, A arg)
    { /* Code for SWhile goes here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      p.stm_.accept(new StmVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.SBlock p, A arg)
    { /* Code for SBlock goes here */
      for (cmm.Absyn.Stm x: p.liststm_) {
        x.accept(new StmVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(cmm.Absyn.SIfElse p, A arg)
    { /* Code for SIfElse goes here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      p.stm_1.accept(new StmVisitor<R,A>(), arg);
      p.stm_2.accept(new StmVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ExpVisitor<R,A> implements cmm.Absyn.Exp.Visitor<R,A>
  {
    public R visit(cmm.Absyn.EBool p, A arg)
    { /* Code for EBool goes here */
      p.boollit_.accept(new BoolLitVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.EInt p, A arg)
    { /* Code for EInt goes here */
      //p.integer_;
      return null;
    }
    public R visit(cmm.Absyn.EDouble p, A arg)
    { /* Code for EDouble goes here */
      //p.double_;
      return null;
    }
    public R visit(cmm.Absyn.EId p, A arg)
    { /* Code for EId goes here */
      //p.id_;
      return null;
    }
    public R visit(cmm.Absyn.EApp p, A arg)
    { /* Code for EApp goes here */
      //p.id_;
      for (cmm.Absyn.Exp x: p.listexp_) {
        x.accept(new ExpVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(cmm.Absyn.EPost p, A arg)
    { /* Code for EPost goes here */
      //p.id_;
      p.incdecop_.accept(new IncDecOpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.EPre p, A arg)
    { /* Code for EPre goes here */
      p.incdecop_.accept(new IncDecOpVisitor<R,A>(), arg);
      //p.id_;
      return null;
    }
    public R visit(cmm.Absyn.EMul p, A arg)
    { /* Code for EMul goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.mulop_.accept(new MulOpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.EAdd p, A arg)
    { /* Code for EAdd goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.addop_.accept(new AddOpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.ECmp p, A arg)
    { /* Code for ECmp goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.cmpop_.accept(new CmpOpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.EAnd p, A arg)
    { /* Code for EAnd goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.EOr p, A arg)
    { /* Code for EOr goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(cmm.Absyn.EAss p, A arg)
    { /* Code for EAss goes here */
      //p.id_;
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
  }
  public class IncDecOpVisitor<R,A> implements cmm.Absyn.IncDecOp.Visitor<R,A>
  {
    public R visit(cmm.Absyn.OInc p, A arg)
    { /* Code for OInc goes here */
      return null;
    }
    public R visit(cmm.Absyn.ODec p, A arg)
    { /* Code for ODec goes here */
      return null;
    }
  }
  public class MulOpVisitor<R,A> implements cmm.Absyn.MulOp.Visitor<R,A>
  {
    public R visit(cmm.Absyn.OTimes p, A arg)
    { /* Code for OTimes goes here */
      return null;
    }
    public R visit(cmm.Absyn.ODiv p, A arg)
    { /* Code for ODiv goes here */
      return null;
    }
  }
  public class AddOpVisitor<R,A> implements cmm.Absyn.AddOp.Visitor<R,A>
  {
    public R visit(cmm.Absyn.OPlus p, A arg)
    { /* Code for OPlus goes here */
      return null;
    }
    public R visit(cmm.Absyn.OMinus p, A arg)
    { /* Code for OMinus goes here */
      return null;
    }
  }
  public class CmpOpVisitor<R,A> implements cmm.Absyn.CmpOp.Visitor<R,A>
  {
    public R visit(cmm.Absyn.OLt p, A arg)
    { /* Code for OLt goes here */
      return null;
    }
    public R visit(cmm.Absyn.OGt p, A arg)
    { /* Code for OGt goes here */
      return null;
    }
    public R visit(cmm.Absyn.OLtEq p, A arg)
    { /* Code for OLtEq goes here */
      return null;
    }
    public R visit(cmm.Absyn.OGtEq p, A arg)
    { /* Code for OGtEq goes here */
      return null;
    }
    public R visit(cmm.Absyn.OEq p, A arg)
    { /* Code for OEq goes here */
      return null;
    }
    public R visit(cmm.Absyn.ONEq p, A arg)
    { /* Code for ONEq goes here */
      return null;
    }
  }
  public class BoolLitVisitor<R,A> implements cmm.Absyn.BoolLit.Visitor<R,A>
  {
    public R visit(cmm.Absyn.LTrue p, A arg)
    { /* Code for LTrue goes here */
      return null;
    }
    public R visit(cmm.Absyn.LFalse p, A arg)
    { /* Code for LFalse goes here */
      return null;
    }
  }
  public class TypeVisitor<R,A> implements cmm.Absyn.Type.Visitor<R,A>
  {
    public R visit(cmm.Absyn.Type_bool p, A arg)
    { /* Code for Type_bool goes here */
      return null;
    }
    public R visit(cmm.Absyn.Type_int p, A arg)
    { /* Code for Type_int goes here */
      return null;
    }
    public R visit(cmm.Absyn.Type_double p, A arg)
    { /* Code for Type_double goes here */
      return null;
    }
    public R visit(cmm.Absyn.Type_void p, A arg)
    { /* Code for Type_void goes here */
      return null;
    }
  }
}
