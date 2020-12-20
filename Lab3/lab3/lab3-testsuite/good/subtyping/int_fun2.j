.class public int_fun2
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

  invokestatic int_fun2/main()I
  pop
  return

.end method

.method public static have_an_int(DD)D
.limit locals 101
.limit stack 101
	dload 0
	dload 2
	ddiv
	dreturn
nop
.end method
.method public static main()I
.limit locals 101
.limit stack 101
	iconst_1
	i2d
	iconst_2
	i2d
	invokestatic int_fun2/have_an_int(DD)D
	invokestatic Runtime/printDouble(D)V
	iconst_0
	ireturn
nop
.end method
