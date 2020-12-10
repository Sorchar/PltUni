package cmm.Absyn; // Java Package generated by the BNF Converter.

public class EAss  extends Exp {
  public final String id_;
  public final Exp exp_;
  public EAss(String p1, Exp p2) { id_ = p1; exp_ = p2; }

  public <R,A> R accept(cmm.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof cmm.Absyn.EAss) {
      cmm.Absyn.EAss x = (cmm.Absyn.EAss)o;
      return this.id_.equals(x.id_) && this.exp_.equals(x.exp_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.id_.hashCode())+this.exp_.hashCode();
  }


}