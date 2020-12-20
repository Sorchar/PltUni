.class public div_double_rhs
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

  invokestatic div_double_rhs/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_1
	i2d
	ldc2_w 2.0
	ddiv
	invokestatic Runtime/printDouble(D)V
	iconst_0
	ireturn
nop
.end method
