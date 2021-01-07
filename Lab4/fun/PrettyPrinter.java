package fun;

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
  public static String print(fun.Absyn.Program foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fun.Absyn.Program foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fun.Absyn.Main foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fun.Absyn.Main foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fun.Absyn.Def foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fun.Absyn.Def foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fun.Absyn.ListDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fun.Absyn.ListDef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fun.Absyn.ListIdent foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fun.Absyn.ListIdent foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fun.Absyn.Exp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fun.Absyn.Exp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(fun.Absyn.Program foo, int _i_)
  {
    if (foo instanceof fun.Absyn.Prog)
    {
       fun.Absyn.Prog _prog = (fun.Absyn.Prog) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_prog.listdef_, 0);
       pp(_prog.main_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fun.Absyn.Main foo, int _i_)
  {
    if (foo instanceof fun.Absyn.DMain)
    {
       fun.Absyn.DMain _dmain = (fun.Absyn.DMain) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("main");
       render("=");
       render("print");
       pp(_dmain.exp_, 3);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fun.Absyn.Def foo, int _i_)
  {
    if (foo instanceof fun.Absyn.DDef)
    {
       fun.Absyn.DDef _ddef = (fun.Absyn.DDef) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_ddef.ident_, 0);
       pp(_ddef.listident_, 0);
       render("=");
       pp(_ddef.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fun.Absyn.ListDef foo, int _i_)
  {
     for (java.util.Iterator<fun.Absyn.Def> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(";");
       } else {
         render(";");
       }
     }  }

  private static void pp(fun.Absyn.ListIdent foo, int _i_)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(fun.Absyn.Exp foo, int _i_)
  {
    if (foo instanceof fun.Absyn.EVar)
    {
       fun.Absyn.EVar _evar = (fun.Absyn.EVar) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_evar.ident_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof fun.Absyn.EInt)
    {
       fun.Absyn.EInt _eint = (fun.Absyn.EInt) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_eint.integer_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof fun.Absyn.EApp)
    {
       fun.Absyn.EApp _eapp = (fun.Absyn.EApp) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_eapp.exp_1, 2);
       pp(_eapp.exp_2, 3);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof fun.Absyn.EAdd)
    {
       fun.Absyn.EAdd _eadd = (fun.Absyn.EAdd) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_eadd.exp_1, 1);
       render("+");
       pp(_eadd.exp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fun.Absyn.ESub)
    {
       fun.Absyn.ESub _esub = (fun.Absyn.ESub) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_esub.exp_1, 1);
       render("-");
       pp(_esub.exp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fun.Absyn.ELt)
    {
       fun.Absyn.ELt _elt = (fun.Absyn.ELt) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_elt.exp_1, 1);
       render("<");
       pp(_elt.exp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fun.Absyn.EIf)
    {
       fun.Absyn.EIf _eif = (fun.Absyn.EIf) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("if");
       pp(_eif.exp_1, 0);
       render("then");
       pp(_eif.exp_2, 0);
       render("else");
       pp(_eif.exp_3, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fun.Absyn.EAbs)
    {
       fun.Absyn.EAbs _eabs = (fun.Absyn.EAbs) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("\\");
       pp(_eabs.ident_, 0);
       render("->");
       pp(_eabs.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(fun.Absyn.Program foo)
  {
    if (foo instanceof fun.Absyn.Prog)
    {
       fun.Absyn.Prog _prog = (fun.Absyn.Prog) foo;
       render("(");
       render("Prog");
       render("[");
       sh(_prog.listdef_);
       render("]");
       sh(_prog.main_);
       render(")");
    }
  }

  private static void sh(fun.Absyn.Main foo)
  {
    if (foo instanceof fun.Absyn.DMain)
    {
       fun.Absyn.DMain _dmain = (fun.Absyn.DMain) foo;
       render("(");
       render("DMain");
       sh(_dmain.exp_);
       render(")");
    }
  }

  private static void sh(fun.Absyn.Def foo)
  {
    if (foo instanceof fun.Absyn.DDef)
    {
       fun.Absyn.DDef _ddef = (fun.Absyn.DDef) foo;
       render("(");
       render("DDef");
       sh(_ddef.ident_);
       render("[");
       sh(_ddef.listident_);
       render("]");
       sh(_ddef.exp_);
       render(")");
    }
  }

  private static void sh(fun.Absyn.ListDef foo)
  {
     for (java.util.Iterator<fun.Absyn.Def> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(fun.Absyn.ListIdent foo)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(fun.Absyn.Exp foo)
  {
    if (foo instanceof fun.Absyn.EVar)
    {
       fun.Absyn.EVar _evar = (fun.Absyn.EVar) foo;
       render("(");
       render("EVar");
       sh(_evar.ident_);
       render(")");
    }
    if (foo instanceof fun.Absyn.EInt)
    {
       fun.Absyn.EInt _eint = (fun.Absyn.EInt) foo;
       render("(");
       render("EInt");
       sh(_eint.integer_);
       render(")");
    }
    if (foo instanceof fun.Absyn.EApp)
    {
       fun.Absyn.EApp _eapp = (fun.Absyn.EApp) foo;
       render("(");
       render("EApp");
       sh(_eapp.exp_1);
       sh(_eapp.exp_2);
       render(")");
    }
    if (foo instanceof fun.Absyn.EAdd)
    {
       fun.Absyn.EAdd _eadd = (fun.Absyn.EAdd) foo;
       render("(");
       render("EAdd");
       sh(_eadd.exp_1);
       sh(_eadd.exp_2);
       render(")");
    }
    if (foo instanceof fun.Absyn.ESub)
    {
       fun.Absyn.ESub _esub = (fun.Absyn.ESub) foo;
       render("(");
       render("ESub");
       sh(_esub.exp_1);
       sh(_esub.exp_2);
       render(")");
    }
    if (foo instanceof fun.Absyn.ELt)
    {
       fun.Absyn.ELt _elt = (fun.Absyn.ELt) foo;
       render("(");
       render("ELt");
       sh(_elt.exp_1);
       sh(_elt.exp_2);
       render(")");
    }
    if (foo instanceof fun.Absyn.EIf)
    {
       fun.Absyn.EIf _eif = (fun.Absyn.EIf) foo;
       render("(");
       render("EIf");
       sh(_eif.exp_1);
       sh(_eif.exp_2);
       sh(_eif.exp_3);
       render(")");
    }
    if (foo instanceof fun.Absyn.EAbs)
    {
       fun.Absyn.EAbs _eabs = (fun.Absyn.EAbs) foo;
       render("(");
       render("EAbs");
       sh(_eabs.ident_);
       sh(_eabs.exp_);
       render(")");
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

