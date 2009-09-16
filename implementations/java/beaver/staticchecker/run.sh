#!/usr/bin/env bash
#
# run.sh
#
# Evalueert een Waebric AST en zet het resultaat in output-bestand evaluation.txt

java -classpath .:.. staticchecker/StaticSyntaxChecker
echo
