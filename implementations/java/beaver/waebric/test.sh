# test.sh
#
# Doorloopt alle .wae testbestanden in directory test/input
# en plaatst de gegenereerde AST's in directory test/output
#
# m.b.v. een diff-tool kunnen deze worden vergeleken met de output van de
# online evaluator en AST viewer op http://waebric.meta-environment.org/eval
#
# Tip: copy-paste de output van de viewer naar een .txt file met dezelfde
# naam als het .wae testbestand en zet deze in directory test/ref
#
clear
cd test/input
for testfiles in $(ls *.wae)
do
  testfile=${testfiles%.*}
  sh ../../run.sh $testfile
done
exit 0

