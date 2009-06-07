# run.sh
#
# Genereert een Waebric AST op basis van input-bestand <filenaam>.wae
# en zet deze in output-bestand <filenaam>.txt
#
java -classpath ../lib/beaver.jar:.:.. waebric/Main test/input/$1.wae > test/output/$1.txt


