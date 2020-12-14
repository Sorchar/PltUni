.class public cmp_while_double_int_plus_int
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

  invokestatic cmp_while_double_int_plus_int/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	L0:
	dconst_5.324
	iconst_1
	ldc 43
	iadd
	if_icmpge L2
	iconst_0
	goto L3
	L2:
	iconst_1
	L3:
	iconst_1
	if_icmpne L1
	goto L0
	L1:
	iconst_0
	ireturn
nop
.end method
