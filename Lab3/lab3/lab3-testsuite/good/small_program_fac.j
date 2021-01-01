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
	L0:
	iload 2
	iconst_0
	if_icmpgt L2
	iconst_0
	goto L3
	L2:
	iconst_1
	L3:
	iconst_0
	if_icmpeq L1
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
	goto L0
	L1:
	iload 1
	ireturn
nop
.end method
.method public static main()I
.limit locals 101
.limit stack 101
	iconst_5
	invokestatic small_program_fac/fac(I)I
	invokestatic Runtime/printInt(I)V
	iconst_0
	ireturn
nop
.end method
