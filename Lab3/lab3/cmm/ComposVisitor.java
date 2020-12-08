package cmm;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  cmm.Absyn.Program.Visitor<cmm.Absyn.Program,A>,
  cmm.Absyn.Def.Visitor<cmm.Absyn.Def,A>,
  cmm.Absyn.Arg.Visitor<cmm.Absyn.Arg,A>,
  cmm.Absyn.Stm.Visitor<cmm.Absyn.Stm,A>,
  cmm.Absyn.Exp.Visitor<cmm.Absyn.Exp,A>,
  cmm.Absyn.IncDecOp.Visitor<cmm.Absyn.IncDecOp,A>,
  cmm.Absyn.MulOp.Visitor<cmm.Absyn.MulOp,A>,
  cmm.Absyn.AddOp.Visitor<cmm.Absyn.AddOp,A>,
  cmm.Absyn.CmpOp.Visitor<cmm.Absyn.CmpOp,A>,
  cmm.Absyn.BoolLit.Visitor<cmm.Absyn.BoolLit,A>,
  cmm.Absyn.Type.Visitor<cmm.Absyn.Type,A>
{
    /* Program */
    public cmm.Absyn.Program visit(cmm.Absyn.PDefs p, A arg)
    {
      cmm.Absyn.ListDef listdef_ = new cmm.Absyn.ListDef();
      for (cmm.Absyn.Def x : p.listdef_)
      {
        listdef_.add(x.accept(this,arg));
      }
      return new cmm.Absyn.PDefs(listdef_);
    }

    /* Def */
    public cmm.Absyn.Def visit(cmm.Absyn.DFun p, A arg)
    {
      cmm.Absyn.Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      cmm.Absyn.ListArg listarg_ = new cmm.Absyn.ListArg();
      for (cmm.Absyn.Arg x : p.listarg_)
      {
        listarg_.add(x.accept(this,arg));
      }
      cmm.Absyn.ListStm liststm_ = new cmm.Absyn.ListStm();
      for (cmm.Absyn.Stm x : p.liststm_)
      {
        liststm_.add(x.accept(this,arg));
      }
      return new cmm.Absyn.DFun(type_, id_, listarg_, liststm_);
    }

    /* Arg */
    public cmm.Absyn.Arg visit(cmm.Absyn.ADecl p, A arg)
    {
      cmm.Absyn.Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      return new cmm.Absyn.ADecl(type_, id_);
    }

    /* Stm */
    public cmm.Absyn.Stm visit(cmm.Absyn.SExp p, A arg)
    {
      cmm.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      return new cmm.Absyn.SExp(exp_);
    }
    public cmm.Absyn.Stm visit(cmm.Absyn.SDecls p, A arg)
    {
      cmm.Absyn.Type type_ = p.type_.accept(this, arg);
      cmm.Absyn.ListId listid_ = p.listid_;
      return new cmm.Absyn.SDecls(type_, listid_);
    }
    public cmm.Absyn.Stm visit(cmm.Absyn.SInit p, A arg)
    {
      cmm.Absyn.Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      cmm.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      return new cmm.Absyn.SInit(type_, id_, exp_);
    }
    public cmm.Absyn.Stm visit(cmm.Absyn.SReturn p, A arg)
    {
      cmm.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      return new cmm.Absyn.SReturn(exp_);
    }
    public cmm.Absyn.Stm visit(cmm.Absyn.SWhile p, A arg)
    {
      cmm.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      cmm.Absyn.Stm stm_ = p.stm_.accept(this, arg);
      return new cmm.Absyn.SWhile(exp_, stm_);
    }
    public cmm.Absyn.Stm visit(cmm.Absyn.SBlock p, A arg)
    {
      cmm.Absyn.ListStm liststm_ = new cmm.Absyn.ListStm();
      for (cmm.Absyn.Stm x : p.liststm_)
      {
        liststm_.add(x.accept(this,arg));
      }
      return new cmm.Absyn.SBlock(liststm_);
    }
    public cmm.Absyn.Stm visit(cmm.Absyn.SIfElse p, A arg)
    {
      cmm.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      cmm.Absyn.Stm stm_1 = p.stm_1.accept(this, arg);
      cmm.Absyn.Stm stm_2 = p.stm_2.accept(this, arg);
      return new cmm.Absyn.SIfElse(exp_, stm_1, stm_2);
    }

    /* Exp */
    public cmm.Absyn.Exp visit(cmm.Absyn.EBool p, A arg)
    {
      cmm.Absyn.BoolLit boollit_ = p.boollit_.accept(this, arg);
      return new cmm.Absyn.EBool(boollit_);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EInt p, A arg)
    {
      Integer integer_ = p.integer_;
      return new cmm.Absyn.EInt(integer_);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EDouble p, A arg)
    {
      Double double_ = p.double_;
      return new cmm.Absyn.EDouble(double_);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EId p, A arg)
    {
      String id_ = p.id_;
      return new cmm.Absyn.EId(id_);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EApp p, A arg)
    {
      String id_ = p.id_;
      cmm.Absyn.ListExp listexp_ = new cmm.Absyn.ListExp();
      for (cmm.Absyn.Exp x : p.listexp_)
      {
        listexp_.add(x.accept(this,arg));
      }
      return new cmm.Absyn.EApp(id_, listexp_);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EPost p, A arg)
    {
      String id_ = p.id_;
      cmm.Absyn.IncDecOp incdecop_ = p.incdecop_.accept(this, arg);
      return new cmm.Absyn.EPost(id_, incdecop_);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EPre p, A arg)
    {
      cmm.Absyn.IncDecOp incdecop_ = p.incdecop_.accept(this, arg);
      String id_ = p.id_;
      return new cmm.Absyn.EPre(incdecop_, id_);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EMul p, A arg)
    {
      cmm.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      cmm.Absyn.MulOp mulop_ = p.mulop_.accept(this, arg);
      cmm.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new cmm.Absyn.EMul(exp_1, mulop_, exp_2);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EAdd p, A arg)
    {
      cmm.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      cmm.Absyn.AddOp addop_ = p.addop_.accept(this, arg);
      cmm.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new cmm.Absyn.EAdd(exp_1, addop_, exp_2);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.ECmp p, A arg)
    {
      cmm.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      cmm.Absyn.CmpOp cmpop_ = p.cmpop_.accept(this, arg);
      cmm.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new cmm.Absyn.ECmp(exp_1, cmpop_, exp_2);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EAnd p, A arg)
    {
      cmm.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      cmm.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new cmm.Absyn.EAnd(exp_1, exp_2);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EOr p, A arg)
    {
      cmm.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      cmm.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new cmm.Absyn.EOr(exp_1, exp_2);
    }
    public cmm.Absyn.Exp visit(cmm.Absyn.EAss p, A arg)
    {
      String id_ = p.id_;
      cmm.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      return new cmm.Absyn.EAss(id_, exp_);
    }

    /* IncDecOp */
    public cmm.Absyn.IncDecOp visit(cmm.Absyn.OInc p, A arg)
    {
      return new cmm.Absyn.OInc();
    }
    public cmm.Absyn.IncDecOp visit(cmm.Absyn.ODec p, A arg)
    {
      return new cmm.Absyn.ODec();
    }

    /* MulOp */
    public cmm.Absyn.MulOp visit(cmm.Absyn.OTimes p, A arg)
    {
      return new cmm.Absyn.OTimes();
    }
    public cmm.Absyn.MulOp visit(cmm.Absyn.ODiv p, A arg)
    {
      return new cmm.Absyn.ODiv();
    }

    /* AddOp */
    public cmm.Absyn.AddOp visit(cmm.Absyn.OPlus p, A arg)
    {
      return new cmm.Absyn.OPlus();
    }
    public cmm.Absyn.AddOp visit(cmm.Absyn.OMinus p, A arg)
    {
      return new cmm.Absyn.OMinus();
    }

    /* CmpOp */
    public cmm.Absyn.CmpOp visit(cmm.Absyn.OLt p, A arg)
    {
      return new cmm.Absyn.OLt();
    }
    public cmm.Absyn.CmpOp visit(cmm.Absyn.OGt p, A arg)
    {
      return new cmm.Absyn.OGt();
    }
    public cmm.Absyn.CmpOp visit(cmm.Absyn.OLtEq p, A arg)
    {
      return new cmm.Absyn.OLtEq();
    }
    public cmm.Absyn.CmpOp visit(cmm.Absyn.OGtEq p, A arg)
    {
      return new cmm.Absyn.OGtEq();
    }
    public cmm.Absyn.CmpOp visit(cmm.Absyn.OEq p, A arg)
    {
      return new cmm.Absyn.OEq();
    }
    public cmm.Absyn.CmpOp visit(cmm.Absyn.ONEq p, A arg)
    {
      return new cmm.Absyn.ONEq();
    }

    /* BoolLit */
    public cmm.Absyn.BoolLit visit(cmm.Absyn.LTrue p, A arg)
    {
      return new cmm.Absyn.LTrue();
    }
    public cmm.Absyn.BoolLit visit(cmm.Absyn.LFalse p, A arg)
    {
      return new cmm.Absyn.LFalse();
    }

    /* Type */
    public cmm.Absyn.Type visit(cmm.Absyn.Type_bool p, A arg)
    {
      return new cmm.Absyn.Type_bool();
    }
    public cmm.Absyn.Type visit(cmm.Absyn.Type_int p, A arg)
    {
      return new cmm.Absyn.Type_int();
    }
    public cmm.Absyn.Type visit(cmm.Absyn.Type_double p, A arg)
    {
      return new cmm.Absyn.Type_double();
    }
    public cmm.Absyn.Type visit(cmm.Absyn.Type_void p, A arg)
    {
      return new cmm.Absyn.Type_void();
    }
}
