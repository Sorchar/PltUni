.class public good11
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

  invokestatic good11/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_0
	istore 0
	iconst_0
	istore 1
	while1:
	invokestatic Runtime/readInt()I
	istore 2
	iload 2
	iconst_0
	if_icmpne true1
	iconst_0
	goto false1:
	true1:
	iconst_1
	false1:
	iconst_1
	if_icmpne done1
	iload 0
	iload 2
	iadd
	istore 0
	iload 0
	pop
	iload 1
	iload 1
	iconst_1
	iadd
	istore 1
	pop
	goto while1
	done1:
	iload 0
	iload 1
	idiv
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn

.end method

