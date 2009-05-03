--
-- The Java Lexer
--
%Options fp=JavaLexer
%options single-productions
%options package=javaparser
%options template=LexerTemplateD.g
%options filter=JavaKWLexer.g
%options lalr=3

%Define
    --
    -- Definition of macro used in the included file LexerBasicMapB.g
    --
    $kw_lexer_class /.$JavaKWLexer./

%End

%Include
    LexerBasicMap.g
%End

%Export

    SlComment
    MlComment
    DocComment

    IDENTIFIER
--    PATHELEMENT
    IntegerLiteral
    LongLiteral
    FloatingPointLiteral
    DoubleLiteral
    CharacterLiteral
    StringLiteral
    PreText
    MidText
    PostText
--    PLUS_PLUS
--    MINUS_MINUS
--    EQUAL_EQUAL
--    LESS_EQUAL
--    GREATER_EQUAL
--    NOT_EQUAL
--    LEFT_SHIFT
--    RIGHT_SHIFT
--    UNSIGNED_RIGHT_SHIFT
--    PLUS_EQUAL
--    MINUS_EQUAL
--    MULTIPLY_EQUAL
--    DIVIDE_EQUAL
--    AND_EQUAL
--    OR_EQUAL
--    XOR_EQUAL
--    REMAINDER_EQUAL
--    LEFT_SHIFT_EQUAL
--    RIGHT_SHIFT_EQUAL
--    UNSIGNED_RIGHT_SHIFT_EQUAL
--    OR_OR
--    AND_AND
    PLUS
    MINUS
    NOT
    REMAINDER
    XOR
    AND
    MULTIPLY
    OR
    TWIDDLE
--    DIVIDE
--    DOLLAR
    GREATER
    LESS
    LPAREN
    RPAREN
    LBRACE
    RBRACE
    LBRACKET
    RBRACKET
    SEMICOLON
    SHARP
    QUESTION
    COLON
    SLASH
    COMMA
    DOT
    EQUAL

%End

%Terminals
    CtlCharNotWS

    LF   CR   HT   FF

    a    b    c    d    e    f    g    h    i    j    k    l    m
    n    o    p    q    r    s    t    u    v    w    x    y    z
    _

    A    B    C    D    E    F    G    H    I    J    K    L    M
    N    O    P    Q    R    S    T    U    V    W    X    Y    Z

    0    1    2    3    4    5    6    7    8    9

    AfterASCII   ::= '\u0080..\ufffe'
    Space        ::= ' '
    LF           ::= NewLine
    CR           ::= Return
    HT           ::= HorizontalTab
    FF           ::= FormFeed
    DoubleQuote  ::= '"'
    SingleQuote  ::= "'"
    Percent      ::= '%'
    VerticalBar  ::= '|'
    Exclamation  ::= '!'
    AtSign       ::= '@'
    BackQuote    ::= '`'
    Tilde        ::= '~'
    Sharp        ::= '#'
    DollarSign   ::= '$'
    Ampersand    ::= '&'
    Caret        ::= '^'
    Colon        ::= ':'
    SemiColon    ::= ';'
    BackSlash    ::= '\'
    LeftBrace    ::= '{'
    RightBrace   ::= '}'
    LeftBracket  ::= '['
    RightBracket ::= ']'
    QuestionMark ::= '?'
    Comma        ::= ','
    Dot          ::= '.'
    LessThan     ::= '<'
    GreaterThan  ::= '>'
    Plus         ::= '+'
    Minus        ::= '-'
    Slash        ::= '/'
    Star         ::= '*'
    LeftParen    ::= '('
    RightParen   ::= ')'
    Equal        ::= '='

%End

%Start
    Token
%End

%Rules

    ---------------------  Rules for Scanned Tokens --------------------------------
    -- The lexer creates an array list of tokens which is defined in the PrsStream class.
    -- A token has three attributes: a start offset, an end offset and a kind.
    -- 
    -- Only rules that produce complete tokens have actions to create token objects.
    -- When making a token, calls to the methods, $getToken(1) and $getRightSpan(), 
    -- provide the offsets (i.e. the span) of a rule's right hand side (rhs) and thus of the token.
    -- For a rule of the form A ::= A1 A2 ... An, the start offset of the rhs of A is given by
    -- $getToken(1) or by $getLeftSpan() and the end offset by $getRightSpan().
    --  
    -- Regarding rules for parsing in general, note that for a rhs symbol Ai, the 
    -- method $getToken(i) returns the location of the leftmost character derived from Ai.  
    -- The method $getLeftSpan(i) returns the same location unless Ai produces $empty in which case
    -- it returns the location of the last character derived before reducing Ai to $empty. 
    -- The method $getRightSpan(i) returns the location of the rightmost character derived from Ai 
    -- unless Ai produces $empty in which case it returns the location of the last character 
    -- derived before reducing Ai to $empty.
    --------------------------------------------------------------------------------
    Token ::= Identifier
        /.$BeginAction
                    checkForKeyWord();
          $EndAction
        ./
        
--    Token ::= PathElement
--        /.$BeginAction
--                    checkForKeyWord();
--          $EndAction
--        ./    
                            
    Token ::= '"' SLBody '"'
        /.$BeginAction
                    makeToken($_StringLiteral);
          $EndAction
        ./
    --TODO: check with Tijs
    Token ::= '!' TextBody '<'
        /.$BeginAction
                    makeToken($_PreText);
          $EndAction
        ./
    Token ::= '>' TextBody '"'
        /.$BeginAction
                    makeToken($_PostText);
          $EndAction
        ./
    Token ::= '>' TextBody '<'
        /.$BeginAction
                    makeToken($_MidText);
          $EndAction
        ./

    Token ::= "'" NotSQ "'"
        /.$BeginAction
                    makeToken($_CharacterLiteral);
          $EndAction
        ./
    Token ::= IntegerLiteral
        /.$BeginAction
                    makeToken($_IntegerLiteral);
          $EndAction
        ./
    Token ::= FloatingPointLiteral
        /.$BeginAction
                    makeToken($_FloatingPointLiteral);
          $EndAction
        ./
    Token ::= DoubleLiteral
        /.$BeginAction
                    makeToken($_DoubleLiteral);
          $EndAction
        ./
    Token ::= '/' '*' Inside Stars '/'
        /.$BeginAction
                    if (getKind($getLeftSpan(3)) == Char_Star)
                         makeComment($_DocComment);
                    else makeComment($_MlComment);
          $EndAction
        ./
    Token ::= SLC
        /.$BeginAction
                    makeComment($_SlComment);
          $EndAction
        ./
    Token ::= WS -- White Space is scanned but not added to output vector
        /.$BeginAction
                    skipToken();
          $EndAction
        ./
    Token ::= '+'
        /.$BeginAction
                    makeToken($_PLUS);
          $EndAction
        ./
    Token ::= '-'
        /.$BeginAction
                    makeToken($_MINUS);
          $EndAction
        ./

    Token ::= '*'
        /.$BeginAction
                    makeToken($_MULTIPLY);
          $EndAction
        ./

--    Token ::= '/'
--        /.$BeginAction
--                    makeToken($_DIVIDE);
--          $EndAction
--        ./

    Token ::= '('
        /.$BeginAction
                    makeToken($_LPAREN);
          $EndAction
        ./

    Token ::= ')'
        /.$BeginAction
                    makeToken($_RPAREN);
          $EndAction
        ./

    Token ::= '='
        /.$BeginAction
                    makeToken($_EQUAL);
          $EndAction
        ./

    Token ::= ','
        /.$BeginAction
                    makeToken($_COMMA);
          $EndAction
        ./

    Token ::= ':'
        /.$BeginAction
                    makeToken($_COLON);
          $EndAction
        ./

    Token ::= ';'
        /.$BeginAction
                    makeToken($_SEMICOLON);
          $EndAction
        ./

    Token ::= '^'
        /.$BeginAction
                    makeToken($_XOR);
          $EndAction
        ./
        
    Token ::= '#'
        /.$BeginAction
                    makeToken($_SHARP);
          $EndAction
        ./

--    Token ::= '$'
--        /.$BeginAction
--                    makeToken($_DOLLAR);
--          $EndAction
--        ./            

    Token ::= '%'
        /.$BeginAction
                    makeToken($_REMAINDER);
          $EndAction
        ./
        
    Token ::= '/'
        /.$BeginAction
                    makeToken($_SLASH);
          $EndAction
        ./        

    Token ::= '~'
        /.$BeginAction
                    makeToken($_TWIDDLE);
          $EndAction
        ./

    Token ::= '|'
        /.$BeginAction
                    makeToken($_OR);
          $EndAction
        ./

    Token ::= '&'
        /.$BeginAction
                    makeToken($_AND);
          $EndAction
        ./

    Token ::= '<'
        /.$BeginAction
                    makeToken($_LESS);
          $EndAction
        ./

    Token ::= '>'
        /.$BeginAction
                    makeToken($_GREATER);
          $EndAction
        ./

    Token ::= '.'
        /.$BeginAction
                    makeToken($_DOT);
          $EndAction
        ./
        

    Token ::= '!'
        /.$BeginAction
                    makeToken($_NOT);
          $EndAction
        ./

    Token ::= '['
        /.$BeginAction
                    makeToken($_LBRACKET);
          $EndAction
        ./

    Token ::= ']'
        /.$BeginAction
                    makeToken($_RBRACKET);
          $EndAction
        ./

    Token ::= '{'
        /.$BeginAction
                    makeToken($_LBRACE);
          $EndAction
        ./

    Token ::= '}'
        /.$BeginAction
                    makeToken($_RBRACE);
          $EndAction
        ./

    Token ::= '?'
        /.$BeginAction
                    makeToken($_QUESTION);
          $EndAction
        ./

    IntegerLiteral -> Integer
                    | Integer LetterLl
                    | '0' LetterXx HexDigits
                    | '0' LetterXx HexDigits LetterLl

    DoubleLiteral -> Decimal
                   | Decimal LetterForD
                   | Decimal Exponent
                   | Decimal Exponent LetterForD
                   | Integer Exponent
                   | Integer Exponent LetterForD
                   | Integer LetterForD

    FloatingPointLiteral -> Decimal LetterForF
                          | Decimal Exponent LetterForF
                          | Integer Exponent LetterForF
                          | Integer LetterForF

    Inside ::= Inside Stars NotSlashOrStar
             | Inside '/'
             | Inside NotSlashOrStar
             | $empty

    Stars -> '*'
           | Stars '*'

    SLC ::= '/' '/'
          | SLC NotEol

    SLBody ::= $empty
             | SLBody NotDQ

    TextBody ::= $empty
             | TextBody TextChar

    Integer -> Digit
             | Integer Digit

    HexDigits -> HexDigit
               | HexDigits HexDigit

    Decimal ::= '.' Integer
              | Integer '.'
              | Integer '.' Integer

    Exponent ::= LetterEe Integer
               | LetterEe '-' Integer
               | LetterEe '+' Integer

    WSChar -> Space
            | LF
            | CR
            | HT
            | FF

    Letter -> LowerCaseLetter
            | UpperCaseLetter
            | _
            | '$'
            | '\u0080..\ufffe'

    LowerCaseLetter -> a | b | c | d | e | f | g | h | i | j | k | l | m |
                       n | o | p | q | r | s | t | u | v | w | x | y | z

    UpperCaseLetter -> A | B | C | D | E | F | G | H | I | J | K | L | M |
                       N | O | P | Q | R | S | T | U | V | W | X | Y | Z

    Digit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    OctalDigit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7

    a..f -> a | b | c | d | e | f | A | B | C | D | E | F

    HexDigit -> Digit
              | a..f

    OctalDigits3 -> OctalDigit
                  | OctalDigit OctalDigit
                  | OctalDigit OctalDigit OctalDigit

    LetterForD -> 'D'
                | 'd'

    LetterForF -> 'F'
                | 'f'

    LetterLl -> 'L'
              | 'l'

    LetterEe -> 'E'
              | 'e'

    LetterXx -> 'X'
              | 'x'


    WS -> WSChar
        | WS WSChar
        
    --PathElement -> Letter | Digit
    --           | Identifier Letter
    --           | Identifier Digit
    
    --PathElement -> Digit | Identifier | Digit Identifier

    Identifier -> Letter
                | Identifier Letter
                | Identifier Digit
    

    SpecialNotStar -> '+' | '-' | '/' | '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                      '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                      '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

    SpecialNotSlash -> '+' | '-' | -- exclude the star as well
                       '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                       '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                       '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

    SpecialNotDQ -> '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | "'" | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

    SpecialNotSQ -> '+' | '-' | '*' | '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | '/' | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

    NotSlashOrStar -> Letter
                    | Digit
                    | SpecialNotSlash
                    | WSChar

    NotEol -> Letter
            | Digit
            | Space
            | '*'
            | SpecialNotStar
            | HT
            | FF
            | CtlCharNotWS

    NotDQ -> Letter
           | Digit
           | SpecialNotDQ
           | Space
           | HT
           | FF
           | EscapeSequence
           | '\' u HexDigit HexDigit HexDigit HexDigit
           | '\' OctalDigit

    TextChar -> Letter
           | Digit
           | SpecialNotDQ
           | Space
           | HT
           | FF
           | EscapeSequence
           | LF
           | CR
           | '\' u HexDigit HexDigit HexDigit HexDigit
           | '\' OctalDigit

    NotSQ -> Letter
           | Digit
           | SpecialNotSQ
           | Space
           | HT
           | FF
           | EscapeSequence
           | '\' u HexDigit HexDigit HexDigit HexDigit
           | '\' OctalDigits3

    EscapeSequence ::= '\' b
                     | '\' t
                     | '\' n
                     | '\' f
                     | '\' r
                     | '\' '"'
                     | '\' "'"
                     | '\' '\'
%End
