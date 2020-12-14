.class public good05
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

  invokestatic good05/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_1
	istore 0
	iload 0
	pop
	iload 0
	istore 1
	iload 1
	pop
	invokestatic Runtime/readInt()I
	istore 2
	iload 2
	pop
	iload 0
	invokestatic Runtime/printInt(I)V
	L0:
	iload 1
	iload 2
	if_icmplt L2
	iconst_0
	goto L3
	L2:
	iconst_1
	L3:
	iconst_1
	if_icmpne L1
	iload 1
	invokestatic Runtime/printInt(I)V
	iload 0
	iload 1
	iadd
	istore 1
	iload 1
	pop
	iload 1
	iload 0
	isub
	istore 0
	iload 0
	pop
	goto L0
	L1:
	iconst_0
	ireturn
nop
.end method
