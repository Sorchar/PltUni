.class public div_double_lhs
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

  invokestatic div_double_lhs/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	dconst_1.0
	iconst_2
	idiv
	invokestatic Runtime/printDouble(D)V
	iconst_0
	ireturn
.end method
