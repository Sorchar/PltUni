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
	dconst_22.5
	istore 0
	dconst_23.5
	istore 1
	iload 0
	iconst_1
	isub
	istore 0
	iload 0
	pop
	iload 0
	invokestatic Runtime/printDouble(D)V
	iload 1
	iconst_1
	isub
	istore 1
	iload 1
	invokestatic Runtime/printDouble(D)V
	iconst_0
	ireturn
nop
.end method
