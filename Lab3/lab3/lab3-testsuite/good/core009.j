.class public core009
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

  invokestatic core009/main()I
  pop
  return

.end method

.method public static foo()I
.limit locals 101
.limit stack 101
	ldc 10
	ireturn
.end method
.method public static main()I
.limit locals 101
.limit stack 101
	invokestatic core009/foo()I
	istore 0
	iload 0
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn
.end method
