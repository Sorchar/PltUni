.class public core006
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

  invokestatic core006/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_45
	istore 0
	iload 0
	pop
	iconst_36
	iconst_67
	iadd
	istore 1
	iload 1
	pop
	iload 0
	invokestatic Runtime/printInt(I)V
	iload 1
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn

.end method

