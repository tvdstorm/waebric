#!/usr/bin/env bash
#
# test.sh
#
# Doorloopt alle .wae testbestanden in directory test/input
# en plaatst de gegenereerde AST's in directory test/output
#
# m.b.v. een diff-tool kunnen deze worden vergeleken met de output van de
# online evaluator en AST viewer op http://waebric.meta-environment.org/eval
#
# Tenslotte wordt de inhoud van test/output vergeleken met de inhoud van directory test/ref
#
for testfile in $(ls test/input/*.wae); do
  outputfile=test/output/${testfile##test/input/}
  outputfile=${outputfile%%.wae}.txt
  sh run.sh $testfile $outputfile
done;

diff test/output test/ref
exit 0
