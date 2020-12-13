.class public good03
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

  invokestatic good03/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	invokestatic Runtime/readInt()I
	istore 0
	iconst_1
	istore 1
	iconst_1
	istore 2
	while1:
	iload 2
	iload 0
	iconst_1
	iadd
	if_icmplt true1
	iconst_0
	goto false1
	true1:
	iconst_1
	false1:
	iconst_1
	if_icmpne done1
	iload 2
	iload 1
	imul
	istore 1
	iload 1
	pop
	iload 2
	iconst_1
	iadd
	istore 2
	iload 2
	pop
	goto while1
	done1:
	iload 1
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn

.end method

