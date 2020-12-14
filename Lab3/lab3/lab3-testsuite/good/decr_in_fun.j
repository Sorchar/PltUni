.class public decr_in_fun
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

  invokestatic decr_in_fun/main()I
  pop
  return

.end method

.method public static f(I)I
.limit locals 101
.limit stack 101
	iload 0
	iconst_1
	isub
	istore 0
	iload 0
	ireturn
nop
.end method
.method public static main()I
.limit locals 101
.limit stack 101
	iconst_0
	invokestatic decr_in_fun/f(I)I
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn
nop
.end method
