
from waegenerator import WaeGenerator

import difflib, sys
testdata = file('tests/wae/suite/tests.dat')

output = 'tests/wae/suite/output'

testdata = testdata.readlines()
testdata = [test.split()[0] for test in testdata]

tests_ok = 0
failed = []

for test in testdata:
    source = open('tests/wae/suite/program/%s.wae' % test)
    try:
        waebric = WaeGenerator(source, output)
    except Exception:
        pass

    raw = open('%s/%s.raw.html'% (output, test ))
    differ = difflib.unified_diff

    try:
        new = open('%s/%s.htm' % (output, test))
    except Exception, err:
        print err
        #no generated file found probably exception.

    diff = differ(raw.readlines(), new.readlines(),
                        fromfile = "%s.raw.html" % test,
                        tofile = "%s.htm" % test)

    #diff is a generator.
    diff = [d for d in diff]
    if diff:
        print test, "FAIL",
        sys.stdout.writelines(diff)
        failed.append(test)
    else:
        print test, "OK"
        tests_ok += 1

print "FAILED ", ", ".join(failed)
print "%d Tests Succeeded of %d" % (tests_ok, len(testdata))