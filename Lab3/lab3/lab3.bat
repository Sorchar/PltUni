@REM REM A simple batch program to run PLT lab3 on Windows systems.

@REM REM Adds the current dir to the class path so that lab3.class
@REM REM is found even when called from another directory.

@echo off
set dir=%~dp0
java -cp "%dir%;%CLASSPATH%" lab3 %*
