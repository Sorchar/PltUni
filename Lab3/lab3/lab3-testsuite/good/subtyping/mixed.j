.class public mixed
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

  invokestatic mixed/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	ldc2_w 1.5
	iconst_1
	iconst_2
	idiv
	i2d
	dadd
	invokestatic Runtime/printDouble(D)V
	iconst_0
	ireturn
nop
.end method
