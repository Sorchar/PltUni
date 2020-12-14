.class public ass_many
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

  invokestatic ass_many/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	ldc 6
	istore 2
	iload 2
	istore 1
	iload 1
	pop
	iload 2
	iload 1
	iadd
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn
.end method
