:: run.sh
::
:: Genereert een Waebric AST op basis van input-bestand <filenaam>.wae
:: en zet deze in output-bestand <filenaam>.txt

@echo off
java -cp .;..;..\bin waebric/Main .\test\input\%1.wae > .\test\output\%1.txt
@echo on
