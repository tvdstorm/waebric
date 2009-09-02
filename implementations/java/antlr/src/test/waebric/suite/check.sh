TESTS=`cat tests.dat`

for t in $TESTS; do
    cmp output/$t.raw.html output/$t.antlr.html > output/$t.diff
	if [ $? -gt 0 ]; then 
		echo "$t fails."
	fi
done