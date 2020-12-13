.class public void_return
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

  invokestatic void_return/main()I
  pop
  return

.end method

.method public static ret()V
.limit locals 101
.limit stack 101
	iconst_0
	invokestatic Runtime/printInt(I)V
	ireturn

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_0
	ireturn

.end method

