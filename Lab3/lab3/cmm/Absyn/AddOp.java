package cmm.Absyn; // Java Package generated by the BNF Converter.

public abstract class AddOp implements java.io.Serializable {
  public abstract <R,A> R accept(AddOp.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(cmm.Absyn.OPlus p, A arg);
    public R visit(cmm.Absyn.OMinus p, A arg);

  }

}