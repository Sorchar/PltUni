.class public ass_double_int
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

  invokestatic ass_double_int/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_1
	i2d
	dstore 0
	dload 0
	iconst_2
	i2d
	ddiv
	dstore 0
	dload 0
	pop2
	dload 0
	invokestatic Runtime/printDouble(D)V
	iconst_0
	ireturn
nop
.end method
