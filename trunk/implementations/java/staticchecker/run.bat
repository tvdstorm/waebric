:: run.bat
::
:: Evalueert een Waebric AST en zet het resultaat in output-bestand evaluation.txt

@echo off
java -cp .;..; staticchecker/StaticSyntaxChecker D:\MSc\SoftwareConstruction\prakticum\aart\beaver\waebric\test\ref\home.txt > .\evaluation.txt
@echo on
