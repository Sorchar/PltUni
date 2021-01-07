@REM REM A simple batch program to run PLT lab4 on Windows systems.

@REM REM Adds the current dir to the class path so that lab4.class
@REM REM is found even when called from another directory.

@echo off
set dir=%~dp0
java -Xss80m -cp "%dir%;%CLASSPATH%" lab4 %*
