TESTS=`cat tests.dat`

for t in $TESTS; do
    cd program
    echo "****************************** Running $t"
    java -jar ../../../../../dist/java-waebric.jar $t.wae ../output/$t.java.html > ../output/$t.log
    cd ..
done
