.class public identifiers_case_sensitive
.super java/lang/Object

.method public <init>()V
  .limit locals 1

  aload_0
  invokespecial java/lang/Object/<init>()V
  return

.end method

.method public static main([Ljava/lang/String;)V
  .limit locals 1
  .limit stack  1

  invokestatic identifiers_case_sensitive/main()I
  pop
  return

.end method

.method public static printint(I)V
.limit locals 101
.limit stack 101
	ldc 100
	iload 0
	iadd
	invokestatic Runtime/printInt(I)V
return
nop
.end method
.method public static printdouble(D)V
.limit locals 101
.limit stack 101
	ldc2_w 99.0
	dload 0
	dadd
	invokestatic Runtime/printDouble(D)V
return
nop
.end method
.method public static readint()I
.limit locals 101
.limit stack 101
	iconst_0
	ireturn
nop
.end method
.method public static readdouble()D
.limit locals 101
.limit stack 101
	ldc2_w 1.0
	dreturn
nop
.end method
.method public static main()I
.limit locals 101
.limit stack 101
	invokestatic identifiers_case_sensitive/readint()I
	istore 0
	invokestatic identifiers_case_sensitive/readdouble()D
	dstore 1
	iload 0
	invokestatic identifiers_case_sensitive/printint(I)V
	dload 1
	invokestatic identifiers_case_sensitive/printdouble(D)V
	iconst_0
	ireturn
nop
.end method
