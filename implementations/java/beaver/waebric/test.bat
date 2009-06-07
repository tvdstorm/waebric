:: test.bat
::
:: Doorloopt alle .wae testbestanden in directory test\input
:: en plaatst de gegenereerde AST's in directory test\output
::
:: m.b.v. een diff-tool kunnen deze worden vergeleken met de output van de
:: online evaluator en AST viewer op http://waebric.meta-environment.org/eval
::
:: Tip: copy-paste de output van de viewer naar een .txt file met dezelfde
:: naam als het .wae testbestand en zet deze in directory test\ref

@ECHO OFF
setlocal
set list=.\test\input\*.wae
for /f "delims=" %%i in ('dir /b "%list%"') do run %%~ni
@ECHO ON
