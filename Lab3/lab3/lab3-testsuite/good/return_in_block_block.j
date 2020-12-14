.class public return_in_block_block
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

  invokestatic return_in_block_block/main()I
  pop
  return

.end method

.method public static niam()I
.limit locals 101
.limit stack 101
	ldc 99
	ireturn
	iconst_2
	invokestatic Runtime/printInt(I)V
	iconst_1
	invokestatic Runtime/printInt(I)V
nop
.end method
.method public static main()I
.limit locals 101
.limit stack 101
	invokestatic return_in_block_block/niam()I
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn
	iconst_3
	invokestatic Runtime/printInt(I)V
	iconst_4
	invokestatic Runtime/printInt(I)V
nop
.end method
