.class public int_fun0
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

  invokestatic int_fun0/main()I
  pop
  return

.end method

.method public static have_an_int()
.limit locals 101
.limit stack 101
	iconst_1
	ireturn

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_2
	idiv
	invokestatic Runtime/printDouble(D)V
	iconst_0
	ireturn

.end method

