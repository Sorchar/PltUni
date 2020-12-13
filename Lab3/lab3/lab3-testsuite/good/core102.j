.class public core102
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

  invokestatic core102/main()I
  pop
  return

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	while1:
	iconst_2
	iconst_5
	iconst_6
	imul
	iconst_5
	idiv
	iadd
	iconst_67
	isub
	iconst_5
	if_icmpgt true1
	iconst_0
	goto false1:
	true1:
	iconst_1
	false1:
	iconst_1
	if_icmpne done1
	goto while1
	done1:
	iconst_0
	ireturn

.end method

