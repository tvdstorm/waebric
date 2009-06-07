java -classpath ../lib/beaver.jar:.:.. waebric/Main $1.wae > test/output/$1.txt
cat test/output/$1.txt
echo