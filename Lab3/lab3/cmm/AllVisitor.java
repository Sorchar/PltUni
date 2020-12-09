package cmm;

/** BNFC-Generated All Visitor */

public interface AllVisitor<R,A> extends
  cmm.Absyn.Program.Visitor<R,A>,
  cmm.Absyn.Def.Visitor<R,A>,
  cmm.Absyn.Arg.Visitor<R,A>,
  cmm.Absyn.Stm.Visitor<R,A>,
  cmm.Absyn.Exp.Visitor<R,A>,
  cmm.Absyn.IncDecOp.Visitor<R,A>,
  cmm.Absyn.MulOp.Visitor<R,A>,
  cmm.Absyn.AddOp.Visitor<R,A>,
  cmm.Absyn.CmpOp.Visitor<R,A>,
  cmm.Absyn.BoolLit.Visitor<R,A>,
  cmm.Absyn.Type.Visitor<R,A>
{}
