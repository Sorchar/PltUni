-- testdriver generated by progs-test-lab1

import System.IO (stderr, hPutStrLn)
import System.Environment (getArgs)

import Grammar.Par (myLexer, pProgram)
import Grammar.ErrM

parse s = case pProgram (myLexer s) of
  Bad err  -> hPutStrLn stderr "ERROR" >> hPutStrLn stderr err
  Ok  tree -> hPutStrLn stderr "OK"

main = do
  [file] <- getArgs
  readFile file >>= parse
