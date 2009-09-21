
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

    def test_embedding(self):
        source = open('tests/embeddingtest.wae').readline
        tokenize(source, self.tokeneater)
        expected = r""" 1,0   1,6 :            NAME         'module'
 1,7   1,20:            NAME  'embeddingtest'
 1,20  1,21:         NEWLINE             '\n'
 2,0   2,1 :              NL             '\n'
 3,0   3,4 :            NAME           'site'
 3,4   3,5 :         NEWLINE             '\n'
 4,2   4,6 :            NAME           'site'
 4,6   4,7 :      ERRORTOKEN              '/'
 4,7   4,16:            NAME      'embedtest'
 4,16  4,17:              OP              '.'
 4,17  4,21:            NAME           'html'
 4,21  4,22:              OP              ':'
 4,23  4,32:            NAME      'embedtext'
 4,32  4,33:              OP              '('
 4,33  4,34:              OP              ')'
 4,34  4,35:         NEWLINE             '\n'
 5,0   5,3 :            NAME            'end'
 5,3   5,4 :         NEWLINE             '\n'
 6,0   6,1 :              NL             '\n'
 7,0   7,3 :            NAME            'def'
 7,4   7,13:            NAME      'embedtext'
 7,13  7,14:         NEWLINE             '\n'
 8,4   8,5 :            NAME              'p'
 8,6   8,16:       PRESTRING     '" pretext '
 8,16  8,29:       EMBSTRING  '< "midtext" >'
 8,28  8,40:      POSTSTRING    ' posttext "'
 8,40  8,41:              OP              ';'
 8,41  8,42:         NEWLINE             '\n'
 9,4   9,5 :            NAME              'p'
 9,6   9,7 :       PRESTRING               ''
 9,7   9,20:       EMBSTRING  "<em 'UTRECHT>"
 9,19  9,44:       PRESTRING  ' - De Vlaamse schrijver '
 9,44  9,70:       EMBSTRING  '<em "Joost Vandecasteele">'
 9,70 10,73:      POSTSTRING  ' heeft afgelopen\n          zaterdag literatuurprijs De Brandende Pen gewonnen. Zijn tekst"'
10,73 10,74:              OP              ';'
10,74 10,75:         NEWLINE             '\n'
11,0  11,3 :            NAME            'end'
11,3  11,4 :         NEWLINE             '\n'
12,0  12,0 :       ENDMARKER               ''
"""
        self.assertEqual(self.result, expected)


if __name__ == '__main__':
        unittest.main()

