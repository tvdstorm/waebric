--
-- The Java KeyWord Lexer
--
%Options fp=JavaKWLexer
%options package=javaparser
%options template=KeyWordTemplateD.g

$Include
    KWLexerLowerCaseMap.g
$End

$Export

    module
    def
    end
    site
    if
    each
    else
    let
    in
    comment
    echo
    cdata
    yield
    
$End

$Terminals
    a    b    c    d    e    f    g    h    i    j    k    l    m
    n    o    p    q    r    s    t    u    v    w    x    y    z
$End

$Start
    KeyWord
$End

$Rules

-- The Goal for the parser is a single Keyword

    KeyWord ::= m o d u l e
        /.$BeginAction
            $setResult($_module);
          $EndAction
        ./
    
              | d e f
        /.$BeginAction
            $setResult($_def);
          $EndAction
        ./

              | e n d
        /.$BeginAction
            $setResult($_end);
          $EndAction
        ./

              | s i t e
        /.$BeginAction
            $setResult($_site);
          $EndAction
        ./

              | i f
        /.$BeginAction
            $setResult($_if);
          $EndAction
        ./

              | e a c h
        /.$BeginAction
            $setResult($_each);
          $EndAction
        ./
    
              | e l s e
        /.$BeginAction
            $setResult($_else);
          $EndAction
        ./


              | l e t
        /.$BeginAction
            $setResult($_let);
          $EndAction
        ./

              | i n
        /.$BeginAction
            $setResult($_in);
          $EndAction
        ./

              | c o m m e n t
        /.$BeginAction
            $setResult($_comment);
          $EndAction
        ./

              | e c h o
        /.$BeginAction
            $setResult($_echo);
          $EndAction
        ./

              | c d a t a
        /.$BeginAction
            $setResult($_cdata);
          $EndAction
        ./

              | y i e l d
        /.$BeginAction
            $setResult($_yield);
          $EndAction
        ./

$End
