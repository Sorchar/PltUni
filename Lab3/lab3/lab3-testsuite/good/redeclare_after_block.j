.class public redeclare_after_block
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

  invokestatic redeclare_after_block/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_1
	istore 0
	iconst_0
	istore 1
	iconst_1
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn
nop
.end method
