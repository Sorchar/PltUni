.class public cmp_while_int_eq_double
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

  invokestatic cmp_while_int_eq_double/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	while1:
	iconst_3
	dconst_3.1
	iconst_1
	if_icmpne done1
	goto while1
	done1:
	iconst_0
	ireturn

.end method
