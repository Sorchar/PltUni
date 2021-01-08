JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
PARSER=${JAVA} ${JAVA_FLAGS} java_cup.Main
PARSER_FLAGS=-nopositions -expect 100
LEXER=jflex
LEXER_FLAGS=
all : test

test : absyn fun/Yylex.class fun/PrettyPrinter.class fun/Test.class fun/VisitSkel.class fun/ComposVisitor.class fun/AbstractVisitor.class fun/FoldVisitor.class fun/AllVisitor.class fun/parser.class fun/sym.class fun/Test.class

.PHONY : absyn

%.class : %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn : fun/Absyn/Program.java fun/Absyn/Prog.java fun/Absyn/Main.java fun/Absyn/DMain.java fun/Absyn/Def.java fun/Absyn/DDef.java fun/Absyn/ListDef.java fun/Absyn/ListIdent.java fun/Absyn/Exp.java fun/Absyn/EVar.java fun/Absyn/EInt.java fun/Absyn/EApp.java fun/Absyn/EAdd.java fun/Absyn/ESub.java fun/Absyn/ELt.java fun/Absyn/EIf.java fun/Absyn/EAbs.java
	${JAVAC} ${JAVAC_FLAGS} $^

fun/Yylex.java : fun/Yylex
	${LEXER} ${LEXER_FLAGS} fun/Yylex

fun/parser.java fun/sym.java : fun/_cup.cup
	${PARSER} ${PARSER_FLAGS} fun/_cup.cup
	mv parser.java sym.java fun/

fun/Yylex.class : fun/Yylex.java fun/parser.java fun/sym.java

fun/sym.class : fun/sym.java

fun/parser.class : fun/parser.java fun/sym.java

fun/PrettyPrinter.class : fun/PrettyPrinter.java

clean :
	rm -f fun/Absyn/*.class fun/*.class

distclean : vclean

vclean :
	 rm -f fun/Absyn/Program.java fun/Absyn/Prog.java fun/Absyn/Main.java fun/Absyn/DMain.java fun/Absyn/Def.java fun/Absyn/DDef.java fun/Absyn/ListDef.java fun/Absyn/ListIdent.java fun/Absyn/Exp.java fun/Absyn/EVar.java fun/Absyn/EInt.java fun/Absyn/EApp.java fun/Absyn/EAdd.java fun/Absyn/ESub.java fun/Absyn/ELt.java fun/Absyn/EIf.java fun/Absyn/EAbs.java fun/Absyn/Program.class fun/Absyn/Prog.class fun/Absyn/Main.class fun/Absyn/DMain.class fun/Absyn/Def.class fun/Absyn/DDef.class fun/Absyn/ListDef.class fun/Absyn/ListIdent.class fun/Absyn/Exp.class fun/Absyn/EVar.class fun/Absyn/EInt.class fun/Absyn/EApp.class fun/Absyn/EAdd.class fun/Absyn/ESub.class fun/Absyn/ELt.class fun/Absyn/EIf.class fun/Absyn/EAbs.class
	 rm -f fun/Absyn/*.class
	 rmdir fun/Absyn/
	 rm -f fun/Yylex fun/_cup.cup fun/Yylex.java fun/VisitSkel.java fun/ComposVisitor.java fun/AbstractVisitor.java fun/FoldVisitor.java fun/AllVisitor.java fun/PrettyPrinter.java fun/Skeleton.java fun/Test.java fun/parser.java fun/sym.java fun/*.class
	 rm -f Makefile
	 rmdir -p fun/
