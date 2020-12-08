package cmm;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  private static final int INDENT_WIDTH = 2;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + INDENT_WIDTH;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       int t;
       _n_ = _n_ - INDENT_WIDTH;
       for(t=0; t<INDENT_WIDTH; t++) {
         backup();
       }
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else if (s.trim().equals(""))
    {
       backup();
       buf_.append(s);
    }
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(cmm.Absyn.Program foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.Program foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.Def foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.Def foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.ListDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.ListDef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.Arg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.Arg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.ListArg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.ListArg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.Stm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.Stm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.ListStm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.ListStm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.Exp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.Exp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.ListExp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.ListExp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.IncDecOp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.IncDecOp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.MulOp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.MulOp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.AddOp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.AddOp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.CmpOp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.CmpOp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.BoolLit foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.BoolLit foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.Type foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.Type foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(cmm.Absyn.ListId foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(cmm.Absyn.ListId foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(cmm.Absyn.Program foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.PDefs)
    {
       cmm.Absyn.PDefs _pdefs = (cmm.Absyn.PDefs) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_pdefs.listdef_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.Def foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.DFun)
    {
       cmm.Absyn.DFun _dfun = (cmm.Absyn.DFun) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_dfun.type_, 0);
       pp(_dfun.id_, 0);
       render("(");
       pp(_dfun.listarg_, 0);
       render(")");
       render("{");
       pp(_dfun.liststm_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.ListDef foo, int _i_)
  {
     for (java.util.Iterator<cmm.Absyn.Def> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(cmm.Absyn.Arg foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.ADecl)
    {
       cmm.Absyn.ADecl _adecl = (cmm.Absyn.ADecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_adecl.type_, 0);
       pp(_adecl.id_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.ListArg foo, int _i_)
  {
     for (java.util.Iterator<cmm.Absyn.Arg> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(cmm.Absyn.Stm foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.SExp)
    {
       cmm.Absyn.SExp _sexp = (cmm.Absyn.SExp) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sexp.exp_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.SDecls)
    {
       cmm.Absyn.SDecls _sdecls = (cmm.Absyn.SDecls) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sdecls.type_, 0);
       pp(_sdecls.listid_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.SInit)
    {
       cmm.Absyn.SInit _sinit = (cmm.Absyn.SInit) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sinit.type_, 0);
       pp(_sinit.id_, 0);
       render("=");
       pp(_sinit.exp_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.SReturn)
    {
       cmm.Absyn.SReturn _sreturn = (cmm.Absyn.SReturn) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("return");
       pp(_sreturn.exp_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.SWhile)
    {
       cmm.Absyn.SWhile _swhile = (cmm.Absyn.SWhile) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("while");
       render("(");
       pp(_swhile.exp_, 0);
       render(")");
       pp(_swhile.stm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.SBlock)
    {
       cmm.Absyn.SBlock _sblock = (cmm.Absyn.SBlock) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{");
       pp(_sblock.liststm_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.SIfElse)
    {
       cmm.Absyn.SIfElse _sifelse = (cmm.Absyn.SIfElse) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("if");
       render("(");
       pp(_sifelse.exp_, 0);
       render(")");
       pp(_sifelse.stm_1, 0);
       render("else");
       pp(_sifelse.stm_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.ListStm foo, int _i_)
  {
     for (java.util.Iterator<cmm.Absyn.Stm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(cmm.Absyn.Exp foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.EBool)
    {
       cmm.Absyn.EBool _ebool = (cmm.Absyn.EBool) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_ebool.boollit_, 0);
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EInt)
    {
       cmm.Absyn.EInt _eint = (cmm.Absyn.EInt) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_eint.integer_, 0);
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EDouble)
    {
       cmm.Absyn.EDouble _edouble = (cmm.Absyn.EDouble) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_edouble.double_, 0);
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EId)
    {
       cmm.Absyn.EId _eid = (cmm.Absyn.EId) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_eid.id_, 0);
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EApp)
    {
       cmm.Absyn.EApp _eapp = (cmm.Absyn.EApp) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_eapp.id_, 0);
       render("(");
       pp(_eapp.listexp_, 0);
       render(")");
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EPost)
    {
       cmm.Absyn.EPost _epost = (cmm.Absyn.EPost) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_epost.id_, 0);
       pp(_epost.incdecop_, 0);
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EPre)
    {
       cmm.Absyn.EPre _epre = (cmm.Absyn.EPre) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_epre.incdecop_, 0);
       pp(_epre.id_, 0);
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EMul)
    {
       cmm.Absyn.EMul _emul = (cmm.Absyn.EMul) foo;
       if (_i_ > 5) render(_L_PAREN);
       pp(_emul.exp_1, 5);
       pp(_emul.mulop_, 0);
       pp(_emul.exp_2, 6);
       if (_i_ > 5) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EAdd)
    {
       cmm.Absyn.EAdd _eadd = (cmm.Absyn.EAdd) foo;
       if (_i_ > 4) render(_L_PAREN);
       pp(_eadd.exp_1, 4);
       pp(_eadd.addop_, 0);
       pp(_eadd.exp_2, 5);
       if (_i_ > 4) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.ECmp)
    {
       cmm.Absyn.ECmp _ecmp = (cmm.Absyn.ECmp) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_ecmp.exp_1, 4);
       pp(_ecmp.cmpop_, 0);
       pp(_ecmp.exp_2, 4);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EAnd)
    {
       cmm.Absyn.EAnd _eand = (cmm.Absyn.EAnd) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_eand.exp_1, 2);
       render("&&");
       pp(_eand.exp_2, 3);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EOr)
    {
       cmm.Absyn.EOr _eor = (cmm.Absyn.EOr) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_eor.exp_1, 1);
       render("||");
       pp(_eor.exp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.EAss)
    {
       cmm.Absyn.EAss _eass = (cmm.Absyn.EAss) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_eass.id_, 0);
       render("=");
       pp(_eass.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.ListExp foo, int _i_)
  {
     for (java.util.Iterator<cmm.Absyn.Exp> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(cmm.Absyn.IncDecOp foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.OInc)
    {
       cmm.Absyn.OInc _oinc = (cmm.Absyn.OInc) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("++");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.ODec)
    {
       cmm.Absyn.ODec _odec = (cmm.Absyn.ODec) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("--");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.MulOp foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.OTimes)
    {
       cmm.Absyn.OTimes _otimes = (cmm.Absyn.OTimes) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("*");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.ODiv)
    {
       cmm.Absyn.ODiv _odiv = (cmm.Absyn.ODiv) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("/");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.AddOp foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.OPlus)
    {
       cmm.Absyn.OPlus _oplus = (cmm.Absyn.OPlus) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("+");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.OMinus)
    {
       cmm.Absyn.OMinus _ominus = (cmm.Absyn.OMinus) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("-");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.CmpOp foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.OLt)
    {
       cmm.Absyn.OLt _olt = (cmm.Absyn.OLt) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("<");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.OGt)
    {
       cmm.Absyn.OGt _ogt = (cmm.Absyn.OGt) foo;
       if (_i_ > 0) render(_L_PAREN);
       render(">");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.OLtEq)
    {
       cmm.Absyn.OLtEq _olteq = (cmm.Absyn.OLtEq) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("<=");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.OGtEq)
    {
       cmm.Absyn.OGtEq _ogteq = (cmm.Absyn.OGtEq) foo;
       if (_i_ > 0) render(_L_PAREN);
       render(">=");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.OEq)
    {
       cmm.Absyn.OEq _oeq = (cmm.Absyn.OEq) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("==");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.ONEq)
    {
       cmm.Absyn.ONEq _oneq = (cmm.Absyn.ONEq) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("!=");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.BoolLit foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.LTrue)
    {
       cmm.Absyn.LTrue _ltrue = (cmm.Absyn.LTrue) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("true");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.LFalse)
    {
       cmm.Absyn.LFalse _lfalse = (cmm.Absyn.LFalse) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("false");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.Type foo, int _i_)
  {
    if (foo instanceof cmm.Absyn.Type_bool)
    {
       cmm.Absyn.Type_bool _type_bool = (cmm.Absyn.Type_bool) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("bool");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.Type_int)
    {
       cmm.Absyn.Type_int _type_int = (cmm.Absyn.Type_int) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("int");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.Type_double)
    {
       cmm.Absyn.Type_double _type_double = (cmm.Absyn.Type_double) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("double");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof cmm.Absyn.Type_void)
    {
       cmm.Absyn.Type_void _type_void = (cmm.Absyn.Type_void) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("void");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(cmm.Absyn.ListId foo, int _i_)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }


  private static void sh(cmm.Absyn.Program foo)
  {
    if (foo instanceof cmm.Absyn.PDefs)
    {
       cmm.Absyn.PDefs _pdefs = (cmm.Absyn.PDefs) foo;
       render("(");
       render("PDefs");
       render("[");
       sh(_pdefs.listdef_);
       render("]");
       render(")");
    }
  }

  private static void sh(cmm.Absyn.Def foo)
  {
    if (foo instanceof cmm.Absyn.DFun)
    {
       cmm.Absyn.DFun _dfun = (cmm.Absyn.DFun) foo;
       render("(");
       render("DFun");
       sh(_dfun.type_);
       sh(_dfun.id_);
       render("[");
       sh(_dfun.listarg_);
       render("]");
       render("[");
       sh(_dfun.liststm_);
       render("]");
       render(")");
    }
  }

  private static void sh(cmm.Absyn.ListDef foo)
  {
     for (java.util.Iterator<cmm.Absyn.Def> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(cmm.Absyn.Arg foo)
  {
    if (foo instanceof cmm.Absyn.ADecl)
    {
       cmm.Absyn.ADecl _adecl = (cmm.Absyn.ADecl) foo;
       render("(");
       render("ADecl");
       sh(_adecl.type_);
       sh(_adecl.id_);
       render(")");
    }
  }

  private static void sh(cmm.Absyn.ListArg foo)
  {
     for (java.util.Iterator<cmm.Absyn.Arg> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(cmm.Absyn.Stm foo)
  {
    if (foo instanceof cmm.Absyn.SExp)
    {
       cmm.Absyn.SExp _sexp = (cmm.Absyn.SExp) foo;
       render("(");
       render("SExp");
       sh(_sexp.exp_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.SDecls)
    {
       cmm.Absyn.SDecls _sdecls = (cmm.Absyn.SDecls) foo;
       render("(");
       render("SDecls");
       sh(_sdecls.type_);
       render("[");
       sh(_sdecls.listid_);
       render("]");
       render(")");
    }
    if (foo instanceof cmm.Absyn.SInit)
    {
       cmm.Absyn.SInit _sinit = (cmm.Absyn.SInit) foo;
       render("(");
       render("SInit");
       sh(_sinit.type_);
       sh(_sinit.id_);
       sh(_sinit.exp_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.SReturn)
    {
       cmm.Absyn.SReturn _sreturn = (cmm.Absyn.SReturn) foo;
       render("(");
       render("SReturn");
       sh(_sreturn.exp_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.SWhile)
    {
       cmm.Absyn.SWhile _swhile = (cmm.Absyn.SWhile) foo;
       render("(");
       render("SWhile");
       sh(_swhile.exp_);
       sh(_swhile.stm_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.SBlock)
    {
       cmm.Absyn.SBlock _sblock = (cmm.Absyn.SBlock) foo;
       render("(");
       render("SBlock");
       render("[");
       sh(_sblock.liststm_);
       render("]");
       render(")");
    }
    if (foo instanceof cmm.Absyn.SIfElse)
    {
       cmm.Absyn.SIfElse _sifelse = (cmm.Absyn.SIfElse) foo;
       render("(");
       render("SIfElse");
       sh(_sifelse.exp_);
       sh(_sifelse.stm_1);
       sh(_sifelse.stm_2);
       render(")");
    }
  }

  private static void sh(cmm.Absyn.ListStm foo)
  {
     for (java.util.Iterator<cmm.Absyn.Stm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(cmm.Absyn.Exp foo)
  {
    if (foo instanceof cmm.Absyn.EBool)
    {
       cmm.Absyn.EBool _ebool = (cmm.Absyn.EBool) foo;
       render("(");
       render("EBool");
       sh(_ebool.boollit_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EInt)
    {
       cmm.Absyn.EInt _eint = (cmm.Absyn.EInt) foo;
       render("(");
       render("EInt");
       sh(_eint.integer_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EDouble)
    {
       cmm.Absyn.EDouble _edouble = (cmm.Absyn.EDouble) foo;
       render("(");
       render("EDouble");
       sh(_edouble.double_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EId)
    {
       cmm.Absyn.EId _eid = (cmm.Absyn.EId) foo;
       render("(");
       render("EId");
       sh(_eid.id_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EApp)
    {
       cmm.Absyn.EApp _eapp = (cmm.Absyn.EApp) foo;
       render("(");
       render("EApp");
       sh(_eapp.id_);
       render("[");
       sh(_eapp.listexp_);
       render("]");
       render(")");
    }
    if (foo instanceof cmm.Absyn.EPost)
    {
       cmm.Absyn.EPost _epost = (cmm.Absyn.EPost) foo;
       render("(");
       render("EPost");
       sh(_epost.id_);
       sh(_epost.incdecop_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EPre)
    {
       cmm.Absyn.EPre _epre = (cmm.Absyn.EPre) foo;
       render("(");
       render("EPre");
       sh(_epre.incdecop_);
       sh(_epre.id_);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EMul)
    {
       cmm.Absyn.EMul _emul = (cmm.Absyn.EMul) foo;
       render("(");
       render("EMul");
       sh(_emul.exp_1);
       sh(_emul.mulop_);
       sh(_emul.exp_2);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EAdd)
    {
       cmm.Absyn.EAdd _eadd = (cmm.Absyn.EAdd) foo;
       render("(");
       render("EAdd");
       sh(_eadd.exp_1);
       sh(_eadd.addop_);
       sh(_eadd.exp_2);
       render(")");
    }
    if (foo instanceof cmm.Absyn.ECmp)
    {
       cmm.Absyn.ECmp _ecmp = (cmm.Absyn.ECmp) foo;
       render("(");
       render("ECmp");
       sh(_ecmp.exp_1);
       sh(_ecmp.cmpop_);
       sh(_ecmp.exp_2);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EAnd)
    {
       cmm.Absyn.EAnd _eand = (cmm.Absyn.EAnd) foo;
       render("(");
       render("EAnd");
       sh(_eand.exp_1);
       sh(_eand.exp_2);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EOr)
    {
       cmm.Absyn.EOr _eor = (cmm.Absyn.EOr) foo;
       render("(");
       render("EOr");
       sh(_eor.exp_1);
       sh(_eor.exp_2);
       render(")");
    }
    if (foo instanceof cmm.Absyn.EAss)
    {
       cmm.Absyn.EAss _eass = (cmm.Absyn.EAss) foo;
       render("(");
       render("EAss");
       sh(_eass.id_);
       sh(_eass.exp_);
       render(")");
    }
  }

  private static void sh(cmm.Absyn.ListExp foo)
  {
     for (java.util.Iterator<cmm.Absyn.Exp> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(cmm.Absyn.IncDecOp foo)
  {
    if (foo instanceof cmm.Absyn.OInc)
    {
       cmm.Absyn.OInc _oinc = (cmm.Absyn.OInc) foo;
       render("OInc");
    }
    if (foo instanceof cmm.Absyn.ODec)
    {
       cmm.Absyn.ODec _odec = (cmm.Absyn.ODec) foo;
       render("ODec");
    }
  }

  private static void sh(cmm.Absyn.MulOp foo)
  {
    if (foo instanceof cmm.Absyn.OTimes)
    {
       cmm.Absyn.OTimes _otimes = (cmm.Absyn.OTimes) foo;
       render("OTimes");
    }
    if (foo instanceof cmm.Absyn.ODiv)
    {
       cmm.Absyn.ODiv _odiv = (cmm.Absyn.ODiv) foo;
       render("ODiv");
    }
  }

  private static void sh(cmm.Absyn.AddOp foo)
  {
    if (foo instanceof cmm.Absyn.OPlus)
    {
       cmm.Absyn.OPlus _oplus = (cmm.Absyn.OPlus) foo;
       render("OPlus");
    }
    if (foo instanceof cmm.Absyn.OMinus)
    {
       cmm.Absyn.OMinus _ominus = (cmm.Absyn.OMinus) foo;
       render("OMinus");
    }
  }

  private static void sh(cmm.Absyn.CmpOp foo)
  {
    if (foo instanceof cmm.Absyn.OLt)
    {
       cmm.Absyn.OLt _olt = (cmm.Absyn.OLt) foo;
       render("OLt");
    }
    if (foo instanceof cmm.Absyn.OGt)
    {
       cmm.Absyn.OGt _ogt = (cmm.Absyn.OGt) foo;
       render("OGt");
    }
    if (foo instanceof cmm.Absyn.OLtEq)
    {
       cmm.Absyn.OLtEq _olteq = (cmm.Absyn.OLtEq) foo;
       render("OLtEq");
    }
    if (foo instanceof cmm.Absyn.OGtEq)
    {
       cmm.Absyn.OGtEq _ogteq = (cmm.Absyn.OGtEq) foo;
       render("OGtEq");
    }
    if (foo instanceof cmm.Absyn.OEq)
    {
       cmm.Absyn.OEq _oeq = (cmm.Absyn.OEq) foo;
       render("OEq");
    }
    if (foo instanceof cmm.Absyn.ONEq)
    {
       cmm.Absyn.ONEq _oneq = (cmm.Absyn.ONEq) foo;
       render("ONEq");
    }
  }

  private static void sh(cmm.Absyn.BoolLit foo)
  {
    if (foo instanceof cmm.Absyn.LTrue)
    {
       cmm.Absyn.LTrue _ltrue = (cmm.Absyn.LTrue) foo;
       render("LTrue");
    }
    if (foo instanceof cmm.Absyn.LFalse)
    {
       cmm.Absyn.LFalse _lfalse = (cmm.Absyn.LFalse) foo;
       render("LFalse");
    }
  }

  private static void sh(cmm.Absyn.Type foo)
  {
    if (foo instanceof cmm.Absyn.Type_bool)
    {
       cmm.Absyn.Type_bool _type_bool = (cmm.Absyn.Type_bool) foo;
       render("Type_bool");
    }
    if (foo instanceof cmm.Absyn.Type_int)
    {
       cmm.Absyn.Type_int _type_int = (cmm.Absyn.Type_int) foo;
       render("Type_int");
    }
    if (foo instanceof cmm.Absyn.Type_double)
    {
       cmm.Absyn.Type_double _type_double = (cmm.Absyn.Type_double) foo;
       render("Type_double");
    }
    if (foo instanceof cmm.Absyn.Type_void)
    {
       cmm.Absyn.Type_void _type_void = (cmm.Absyn.Type_void) foo;
       render("Type_void");
    }
  }

  private static void sh(cmm.Absyn.ListId foo)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(String.format(java.util.Locale.ROOT, "%.15g ", d)); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(String.format(java.util.Locale.ROOT, "%.15g", d)); }
  private static void sh(Character c) { render("'" + c.toString() + "'"); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(' ');
      n--;
    }
  }
  private static void backup()
  {
    int prev = buf_.length() - 1;
    if (buf_.charAt(prev) == ' ')
      buf_.setLength(prev);
  }
  private static void trim()
  {
    // Trim initial spaces
    int end = 0;
    int len = buf_.length();
    while (end < len && buf_.charAt(end) == ' ')
      end++;
    buf_.delete(0, end);
    // Trim trailing spaces
    end = buf_.length();
    while (end > 0 && buf_.charAt(end-1) == ' ')
      end--;
    buf_.setLength(end);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

