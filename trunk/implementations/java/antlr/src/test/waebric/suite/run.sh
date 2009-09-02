TESTS=`cat tests.dat`

for t in $TESTS; do
    cd program
    echo "****************************** Running $t"
    java -jar ../../../../../dist/antlr-waebric.jar $t.wae ../output/$t.antlr.html > ../output/$t.log
    cd ..
done