
import unittest
from parser.tokenize import tokenize
from parser.token import *

class Testtokenizer(unittest.TestCase):
    "test tokenize functions"

    result = ""

    def setUP(self):
        self.result = "" 


    def tokeneater(self, type, token, (srow, scol), (erow, ecol), line):
        line = "%2d,%-2d %2d,%-2d: %15s  %15s\n" % \
                        (srow, scol, erow, ecol, tok_name[type], repr(token))
        self.result = self.result + line

    def test_comment(self):
        source = open('tests/commenttest.wae').readline
        tokenize(source, self.tokeneater)
        expected = r""" 1,0   1,1 :              NL             '\n'
 2,0   2,6 :            NAME         'module'
 2,7   2,11:            NAME           'test'
 2,11  2,12:         NEWLINE             '\n'
 3,0   3,1 :              NL             '\n'
 4,0   4,17:         COMMENT  '/* commentline */'
 4,17  4,18:         NEWLINE             '\n'
 5,0   5,17:         COMMENT  '// commentslashes'
 5,17  5,18:         NEWLINE             '\n'
 6,0   8,2 :         COMMENT  '/* comment\n   comment\n*/'
 8,2   8,3 :         NEWLINE             '\n'
 9,0   9,1 :              NL             '\n'
10,0  14,2 :         COMMENT  '/* comment    \n// commentblaaaaaaaaaa\n\n   comment\n*/'
14,2  14,3 :         NEWLINE             '\n'
15,0  15,0 :       ENDMARKER               ''
"""
        self.assertEqual(self.result, expected)


if __name__ == '__main__':
        unittest.main()

