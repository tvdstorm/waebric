#!/usr/bin/env bash
#
# run.sh
#
# Genereert een Waebric AST op basis van input-bestand <filenaam>.wae
# en zet deze in output-bestand <filenaam>.txt

java -classpath ../../../lib/beaver.jar:.:.. waebric/Main $1.wae > ../output/$1.txt
cat ../output/$1.txt
echo
