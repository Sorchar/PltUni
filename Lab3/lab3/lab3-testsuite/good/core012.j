.class public core012
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

  invokestatic core012/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	ldc 56
	istore 0
	ldc 23
	istore 1
	iload 0
	iload 1
	iadd
	invokestatic Runtime/printInt(I)V
	iload 0
	iload 1
	isub
	invokestatic Runtime/printInt(I)V
	iload 0
	iload 1
	imul
	invokestatic Runtime/printInt(I)V
	ldc 45
	iconst_2
	idiv
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn
.end method
