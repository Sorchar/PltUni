.class public arith_ass_int_mult_double
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

  invokestatic arith_ass_int_mult_double/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_2
	dconst_3.14
	imul
	istore 0
	iload 0
	pop
	iconst_0
	ireturn
.end method
