.class public ass_in_while
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

  invokestatic ass_in_while/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_5
	istore 0
	L0:
	iload 0
	iconst_5
	if_icmpeq L2
	iconst_0
	goto L3
	L2:
	iconst_1
	L3:
	iconst_1
	if_icmpne L1
	ldc 7
	istore 0
	iload 0
	pop
	goto L0
	L1:
	iload 0
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn
nop
.end method
