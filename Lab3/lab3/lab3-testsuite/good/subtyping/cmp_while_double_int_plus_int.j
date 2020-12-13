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
	while1:
	dconst_5.324
	iconst_1
	iconst_43
	iadd
	iconst_1
	if_icmpne done1
	goto while1
	done1:
	iconst_0
	ireturn

.end method

