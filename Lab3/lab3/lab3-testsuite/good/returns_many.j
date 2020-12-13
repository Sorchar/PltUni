.class public returns_many
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

  invokestatic returns_many/main()I
  pop
  return

.end method

.method public static r()I
.limit locals 101
.limit stack 101
	iconst_12
	ireturn
	iconst_2
	ireturn
	iconst_3
	ireturn

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn
	iconst_2
	ireturn

.end method

