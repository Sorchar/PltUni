package cmm.Absyn; // Java Package generated by the BNF Converter.

public class LTrue  extends BoolLit {
  public LTrue() { }

  public <R,A> R accept(cmm.Absyn.BoolLit.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof cmm.Absyn.LTrue) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}
