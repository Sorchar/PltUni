package cmm.Absyn; // Java Package generated by the BNF Converter.

public class SExp  extends Stm {
  public final Exp exp_;
  public SExp(Exp p1) { exp_ = p1; }

  public <R,A> R accept(cmm.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof cmm.Absyn.SExp) {
      cmm.Absyn.SExp x = (cmm.Absyn.SExp)o;
      return this.exp_.equals(x.exp_);
    }
    return false;
  }

  public int hashCode() {
    return this.exp_.hashCode();
  }


}
