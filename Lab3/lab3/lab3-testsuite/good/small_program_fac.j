.class public small_program_fac
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

  invokestatic small_program_fac/main()I
  pop
  return

.end method

.method public static fac(I)I
.limit locals 101
.limit stack 101
	iconst_1
	istore 1
	iload 1
	pop
	iload 0
	istore 2
	iload 2
	pop
	while1:
	iload 2
	iconst_0
	if_icmpgt true1
	iconst_0
	goto false1:
	true1:
	iconst_1
	false1:
	iconst_1
	if_icmpne done1
	iload 1
	iload 2
	imul
	istore 1
	iload 1
	pop
	iload 2
	iconst_1
	isub
	istore 2
	iload 2
	pop
	goto while1
	done1:
	iload 1
	ireturn

.end method

.method public static main()I
.limit locals 101
.limit stack 101
	iconst_5
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn

.end method

