
ENDMARKER = 0
NAME = 1
NUMBER = 2 
STRING = 3 
NEWLINE = 4 
LPAR = 5 
RPAR = 6 
LSQB = 7 
RSQB = 8 
COLON = 9
COMMA = 10 
#SEMI 
#PLUS 
#MINUS
#STAR 
#SLASH
#VBAR 
#AMPER 
#LESS 
#GREATER 
#EQUAL 
#DOT 
#PERCENT 
#BACKQUOTE 
#LBRACE 
#RBRACE 
#EQEQUAL
#NOTEQUAL
#LESSEQUAL
#GREATEREQUAL 
#TILDE 
#CIRCUMFLEX 
#LEFTSHIFT 
#RIGHTSHIFT
#DOUBLESTAR 
#PLUSEQUAL 
#MINEQUAL 
#STAREQUAL 
#SLASHEQUAL
#PERCENTEQUAL
#AMPEREQUAL
#VBAREQUAL

OP = 40
ERRORTOKEN = 50
N_TOKENS = 12 

tok_name = {}
for _name, _value in globals().items():
    if type(_value) is type(0):
        tok_name[_value] = _name


def ISTERMINAL(x):
    return x < NT_OFFSET

def ISNONTERMINAL(x):
    return x >= NT_OFFSET

def ISEOF(x):
    return x == ENDMARKER

