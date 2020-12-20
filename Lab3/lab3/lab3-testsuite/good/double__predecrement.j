.class public double__predecrement
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

  invokestatic double__predecrement/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	ldc2_w 22.5
	dstore 0
	ldc2_w 23.5
	dstore 2
	dload 0
	dconst_1
	dsub
	dstore 0
	dload 0
	pop2
	dload 0
	invokestatic Runtime/printDouble(D)V
	dload 2
	dconst_1
	dsub
	dstore 2
	dload 2
	invokestatic Runtime/printDouble(D)V
	iconst_0
	ireturn
nop
.end method
