"""
Parser Module.

convention:

For each parser function the parsed token should be ready and waiting.
ending with an next call to
"""

import logging
import tokenize
import re
from decorator import decorator

from token import *

DEBUG = True
SHOWTOKENS = True
SHOWPARSER = True

if DEBUG:
    LOG_FILENAME = 'parser logging.out'
    logging.basicConfig(filename=LOG_FILENAME,level=logging.DEBUG,)


keywords = {'IF':'if', 'ELSE':'else',
            'EACH':'each', 'LET':'let', 'IN':'in', 'COMMENT':'comment',
            'ECHO':'echo', 'CDATA':'cdata', 'YIELD':'yield',

            'MODULE':'module', 'IMPORT':'import', 'DEF':'def', 'END':'end',
            'SITE':'site',

            'LIST':'list', 'RECORD':'record', 'STRING':'string',
            }


## debug tools.

def strToken(type, token, (srow, scol), (erow, ecol), line):
    return "%d,%d-%d,%d:\t%s\t%s" % \
        (srow, scol, erow, ecol, tok_name[type], repr(token))

def logToken(*token):
    logging.debug(strToken(*token))


def _trace(f, *args, **kw):
    logging.debug("calling %s with args %s, %s" % \
            (f.__name__, args, kw ))
    result = f(*args, **kw)
    logging.debug("exit %s" % f.__name__)
    return result

def trace(f):
    return decorator(_trace, f)


class UnexpectedToken(Exception):

    def __init__(self, token, expected=""):
        self.token = token
        self.expected = expected
        logging.debug("raised exception on:")
        logToken(*token)
        tokenize.printtoken(*token)
        logging.debug("expected: %s" % expected)

    def __str__(self):
        return "%s expected: %s" % (tokenize.tokentostring(*self.token),
            self.expected)


class Parser(object):

    def __init__(self, Parser=None):
        self.tokens = []
        self.peekedTokens = []
        self.currentToken = []

        if Parser:
            self.tokens = Parser.tokens
            self.peekedTokens = Parser.peekedTokens
            self.currentToken = Parser.currentToken

            if DEBUG and SHOWPARSER:
                logging.debug(type(self))

    def matchLexeme(self, lexeme):
        """ return boolean if current token matches lexeme """
        if self.currentToken[1]:
            return self.currentToken[1] == lexeme
        return False

    def matchTokensort(self, tokensort):
        """ return boolen if current token matches tokensort """
        return self.currentToken[0] == tokensort

    def check(self, expected="", tokensort=None, lexeme=None):
        """ check if current token is tokensort of lexeme """
        if lexeme:
           if not self.currentToken[1] == lexeme:
                raise UnexpectedToken(self.currentToken, expected=expected)
        if tokensort:
            if not self.currentToken[0] == tokensort:
                raise UnexpectedToken(self.currentToken, expected=expected)

    def peek(self, x=1, tokensort="", lexeme=""):
        """lookahead x tokens in advance, returns true
           if tokensort and or lexeme matches peekedtoken.
        """
        d = x - len(self.peekedTokens)
        if d > -1:
            try:
                for i in range(d+1):
                    self.peekedTokens.append(self.tokens.next())
            except StopIteration:
                return False

        peekToken = self.peekedTokens[x-1]
        if tokensort:
            if not peekToken[0] == tokensort:
                return False
        if lexeme:
            if not peekToken[1] == lexeme:
                return False
        return True

    def hasnext(self):
        return self.peek()

    def next(self, expected="", tokensort="", lexeme=""):
        """
        Get the next token, if tokensort or lexeme is defined
        checks if next token matches tokensort of lexeme.
        """
        if self.peekedTokens:
            self.currentToken = self.peekedTokens.pop(0)
        else:
            try:
                self.currentToken = self.tokens.next()
            except StopIteration:
                logging.debug(" no next token available ")
                raise StopIteration

        if tokensort or lexeme:
            expected = "'%s%s%s'" % (expected, tokensort, lexeme)
            self.check(expected, tokensort, lexeme)

        if DEBUG and SHOWTOKENS:
            logToken(*self.currentToken)

        return self.currentToken

    def __repr__(self):
        return "%s at '%s'" % ( str(type(self)), self.currentToken[1])

class WaebricParser(Parser):
    """ start the parsing!"""
    def parse(self):
        logging.debug("--------------------")
        logging.debug('start parsing tokens')
        logging.debug("--------------------")
        module = ModuleParser(self)
        module.next()
        module.parseModule()


class ModuleParser(Parser):
    """ Parse module statement defined in module """

    def parseModule(self):
        """parse module statements """
        self.check('Module ModuleID', lexeme=keywords['MODULE'] )

        #create a new ast module.
        #parse the module identifier.
        self.next()
        moduleId = self.parseModuleId()

        # while there are more tokens
        # parse for Site , Function and Import statements
        while(self.next()):
            if self.matchLexeme(keywords['IMPORT']):
                imports = ImportParser(self.tokens)
            elif self.matchLexeme(keywords['DEF']):
                function = FunctionParser(self)
                function.parseFunction()
            elif self.matchLexeme(keywords['SITE']):
                site = SiteParser(self)
                site.parseSite()
            elif self.matchTokensort(ENDMARKER):
                return
            else:
               raise UnexpectedToken(self.currentToken,
            expected="import, def, site, newline" )

    def parseModuleId(self):
        """Parse the module identifier """
        # AST new module id.
        moduleID = []
        self.check("Module Identifier", tokensort=NAME)
        moduleID.append(self.currentToken)

        while(self.peek(lexeme='.')):
            self.next() #skip .
            self.next("Module Identifier", tokensort=NAME)
            moduleID.append(self.currentToken)


class SiteParser(Parser):
    """ Parse Site function defined in module."""

    def parseSite(self):
        # AST, mappings.
        self.check("Site Defenition", lexeme=keywords['SITE'])
        # check mapping

        while self.next():
            if self.matchLexeme(keywords['END']):
                return
            self.parseMapping()

        raise UnexpectedToken(self.currentToken, expected="missing site ending END")

    def parseMapping(self):
        """ parse content in between site and end."""
        # AST new mapping
        self.parsePath()
        self.next( lexeme=":" )
        self.next( tokensort=NAME )
        p = MarkupParser(self)
        p.parseMarkup()
        p.next( lexeme=';')
        #setmarkup on mapping

    def parsePath(self):
        path = ""
        if self.peek(lexeme="/") or self.peek(x=2,lexeme="/"):
            path = self.parseDirectory()
        path = path + self.parseFileName()
        logging.debug(path)
        #AST path stuff.

    def parseDirectory(self):
        directory = ""
        if self.isPathElement():
            directory += self.currentToken[1]

        while self.next():
            if self.matchLexeme("/"):
                if directory:
                    directory += "/"
                self.next()

            if self.peek(lexeme="."):
                return directory #return , we're in a filename

            if self.isPathElement():
                directory += self.currentToken[1]
            else:
                raise UnexpectedToken(self.currentToken, expected="path element")
        raise UnexpectedToken(self.currentToken, expected="directory path")

    def parseFileName(self):
        self.check(tokensort=NAME, expected="File Name")
        name = self.currentToken[1]
        self.next(lexeme = ".")
        self.next(tokensort=NAME, expected="File extension") # extension
        name = "%s.%s" % (name, self.currentToken[1])
        return name

    def isPathElement(self):
        regex = re.compile(r"(.* .*)|(.*\t.*)|(.*\n.*)|(.*\r.*)|(.*/.*)|(.*\\..*)|(.*\\\\.*)")
        if regex.match(self.currentToken[1]):
            return False
        return True


class FunctionParser(Parser):

    def parseFunction(self):
        self.check(expected="function defenition, def", lexeme=keywords['DEF'])
        self.next(tokensort=NAME)
        ## parse identifier

        ## parse formals

        ## parser statements.
        while(self.next()):
            if self.matchLexeme(keywords['END']):
                return
            statement = StatementParser(self)
            statement.parseStatement()

        raise UnexpectedToken(self.currentToken,
                expected="""END, Missing function ending END""")


class ExpressionParser(Parser):
    """
    Symbol expression,
    Text,
    Natural number,
    Variable,
    List,
    Record,
    """

    @trace
    def parseExpression(self):
        expression = None
        if self.matchLexeme("'"):
            self.next("symbol name", tokensort=NAME)
            expression = self.currentToken[1]
            #symbol.
        elif self.matchTokensort(STRING):
            expression = self.currentToken[1]
            #data string
        elif self.matchTokensort(NUMBER):
            expression = self.currentToken[1]
            #number stuff
        elif self.matchLexeme("["):
            expression = self.parseList()
        elif self.matchLexeme("{"):
            expression = self.parseRecord()

        elif self.peek(lexeme=".") and self.peek(x=2, tokensort=NAME):
            while self.peek(lexeme=".") and self.peek(x=2, tokensort=NAME):
                self.next(lexeme=".") #skip.
                self.next(expected="NAME", tokensort=NAME)
                #ast. stuff.
        elif self.peek(lexeme="+") and expression:
            #parse a + expression left and right.
            #ast set left = currently parsed expression
            self.next() # skip +
            expression = expression + '+' + self.currentToken[1]
            self.parseExpression()
            #ast set right.
        logging.debug(expression)
        if not expression:
            raise UnexpectedToken(self.currentToken,
                expected="Expression: symbol, string, number, list, record, name.data")
        self.next()
        return expression

    @trace
    def parseList(self):
        self.check("List opening '[' ", lexeme="[")
        self.next()
        #ast stuff.
        result = "["
        while self.hasnext():
            if self.matchLexeme(']'):
                #end list return.
                return result + " ]"
            result = result + self.currentToken[1]
            self.parseExpression()
            #ast add expression.
            if not self.matchLexeme(']'):
                self.check(expected="comma ", lexeme=",")
                self.next()
                result = result + ','

    @trace
    def parseRecord(self):
        self.check("Record opening '{'", lexeme="{")
        result = "{"
        while self.next():
            if self.matchLexeme('}'):
                return result + "}"
            self.matchTokensort(NAME)
            self.next(lexeme=":")
            #record add expression
            self.parseExpression()
            result = result + self.currentToken[1]
            if not self.peek(lexeme='}'):
                result = result + ','
                self.next("comma ", lexeme=",")


class PredicateParser(Parser):
    pass


class StatementParser(Parser):

    def parseStatement(self):
        if self.matchLexeme(keywords['LET']):
            self.parseLetStatement()
            return
        if self.matchLexeme(keywords['IF']):
            return
        elif self.matchLexeme(keywords['EACH']):
            return
        elif self.matchLexeme(keywords['ECHO']):
            return
        elif self.matchLexeme(keywords['CDATA']):
            return
        elif self.matchLexeme('}'): #? should be removed.
            return
        elif self.matchLexeme('{'): #? starts a new staments block
            return
        elif self.matchLexeme(keywords['COMMENT']):
            return
        elif self.matchLexeme(keywords['YIELD']):
            return
        elif self.matchTokensort(NAME):
            self.parseMarkupStatements()
            return

        raise UnexpectedToken(self.currentToken,
            expected="""statement, "if", "each", "let", "{", "comment",
                "echo", "cdata", "yield" or Markup""" )

    def parseLetStatement(self):
        logging.debug("parse LET .. IN .. END block")
        if self.matchLexeme(keywords['LET']):
            while self.next():
                #TODO parse assignment markup.
                if self.matchLexeme(keywords['IN']):
                    while self.next():
                        if self.matchLexeme(keywords['END']):
                            logging.debug("end LET block")
                            return
                        self.parseStatement()
                    raise UnexpectedToken(self.currentToken,
                        expected="missing END of LET .. IN .. END block")
            raise UnexpectedToken(self.currentToken,
                expected = """LET .. IN .. END, missing IN """)

    def parseMarkupStatements(self):
        """
        p;      markup
        p p;    markup variable
        p p();  markup - markup
        p p p();
        p "embedding < >";
        """
        markup = MarkupParser(self)

        while self.next():
            markup.parseMarkup()
            if self.peek(lexeme=';'):
                self.next() # skip ;
                return
        raise UnexpectedToken(self.currentToken,
                expected =  "Statement ;")

    def isMarkup(self):
        """
        NEEDED??
        current token is markup if:
        next = name
        next = ()
        next = atributes
        """
        pass


class EmbeddingParser(Parser):
    @trace
    def parseEmbedding(self):
        self.check('embedding " < > " ', tokensort=PRESTRING)

        while not self.peek(tokensort=POSTSTRING):
            self.next()
            if self.matchTokensort(EMBSTRING):
                #AST.
                pass
            elif self.matchTokensort(PRESTRING):
                #AST
                pass
            else:
                raise UnexpectedToken(self.currentToken,
                    expected = "Embedded string Error")
        self.next("tail of embedded string", tokensort=POSTSTRING)
        #AST
        self.next()

class MarkupParser(Parser):
    """
    p     markup
    p p   markup variable
    p p() markup - markup
    p p p()
    """

    @trace
    def parseMarkup(self):
        """Differentiate between p and p()"""
        self.parseDesignator()
        if self.peek(lexeme="("):
            self.parseArguments()
    @trace
    def parseDesignator(self):
        """ p attributes* markup """
        self.check(tokensort=NAME)
        #AST create designator.
        self.peek()
        #peek first character for possible attribute
        if self.peekedTokens:
                if self.peekedTokens[0][1][0] in "#$@:%.":
                    self.parseAttributes()

    @trace
    def parseAttributes(self):
        """ # . $ : @ % @ """
        attributes = []
        self.peek()
        while self.peekedTokens[0][1] in "#$@:%.":
            self.next()
            if self.matchLexeme('#'):
                self.next(tokensort=NAME)
                attributes.append(('#', self.currentToken))
            elif self.matchLexeme('.'):
                self.next(tokensort=NAME)
            elif self.matchLexeme('$'):
                self.next(tokensort=NAME)
            elif self.matchLexeme('@'):
                self.next(tokensort=NUMBER)
                #TODO %
            elif self.matchLexeme(':'):
                self.next(tokensort=NAME)
            else:
                raise UnexpectedToken(self.currentToken,
                    expected=" Attribute, # . : @ % ")


    def parseArguments(self):
        """ ( Arguments,* ) """
        self.next( lexeme='(')
        while self.next():
            if self.matchLexeme(')'):
                return
            elif self.matchTokensort(NAME):
                #AST, name argument.
                self.parseArgument()
                self.next(lexeme=',')

    def parseArgument(self):
        """ name = expression || expression"""
        # check if there is an =.
        # check if there
        # recursive call back to expression parser
        pass

def parse(source):
    tokens = tokenize.generate_tokens(source)
    parser = WaebricParser()
    parser.tokens = tokens
    parser.parse()

if __name__ == '__main__':                     # testing
    import sys
    if len(sys.argv) > 1: parse(open(sys.argv[1]).readline)
    else : parse(sys.stdin.readline)


