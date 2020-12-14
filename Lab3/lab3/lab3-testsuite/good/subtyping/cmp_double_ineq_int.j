.class public cmp_double_ineq_int
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

  invokestatic cmp_double_ineq_int/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	dconst_1.1
	iconst_1
	if_icmpne L0
	iconst_0
	goto L1
	L0:
	iconst_1
	L1:
	pop
	iconst_0
	ireturn
.end method
