.class public int_fun1
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

  invokestatic int_fun1/main()I
  pop
  return

.end method

.method public static have_an_int()
.limit locals 101
.limit stack 101
	iload 0
	iconst_2
	idiv
	ireturn
.end method
.method public static main()I
.limit locals 101
.limit stack 101
	iconst_1
	invokestatic int_fun1/have_an_int()
	invokestatic Runtime/printDouble(D)V
	iconst_0
	ireturn
.end method
