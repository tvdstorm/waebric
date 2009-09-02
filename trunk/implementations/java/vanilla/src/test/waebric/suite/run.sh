TESTS=`cat tests.dat`

for t in $TESTS; do
    echo "****************************** Running $t"
    java -jar ../../../../dist/java-waebric.jar program/$t.wae output/$t.java.html > output/$t.log
done