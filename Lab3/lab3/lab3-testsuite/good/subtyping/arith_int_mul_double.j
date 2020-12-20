.class public arith_int_mul_double
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

  invokestatic arith_int_mul_double/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_1
	i2d
	ldc2_w 1.1
	dmul
	dstore 0
	dload 0
	pop2
	iconst_0
	ireturn
nop
.end method
