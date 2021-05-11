lexer grammar myScanner;

//símbolos
PYCOMA          : ';' ;
ASSIGN          : '=';
PLEFT           : '(';
PRIGHT          : ')';
VIR             : '~';
COLON           : ':';
MAS             : '+';
MINUS           : '-';
MUL             : '*';
DIV             : '/';
GREATHER        : '>';
SMALLER         : '<';
GREATHEREQUAL   : '>=';
SMALLEREQUAL    : '<=';
QMARK           : '"';
DOT             : '.';
UNDERSCORE      : '_';
EQUALS :        '==';
DIFFERENT :     '!=';
SQUAREPLEFT     : '[';
SQUAREPRIGHT    : ']';
COMMA           : ',';
EXCLAMATION     : '!';
BRACKETLEFT     : '{';
BRACKETRIGHT    : '}';
CAT             : '#';
DOLLAR          : '$';
PERCENT         : '%';
AMPERTON        : '&&';
QUESTIONMARK    : '?';
AT              : '@';
EXPONENTIAL     : '^';
SIMPLEQMARK     : '\'';
ORSYMBOL        : '||';

//palabras reservadas
AND     : 'and';
OR      : 'or';
BOOLEAN : 'boolean';
LENGTH  : 'length';
NEW     : 'new';
CHAR    : 'char';
INT     : 'int';
REAL    : 'real';
STRING  : 'string';
fragment TRUE: 'true';
fragment FALSE   : 'false';
CLASS   : 'class';
PRINT   : 'print';
RETURN  : 'return';
IF      : 'if';
WHILE   : 'while';
LET     : 'let';
THEN    : 'then';
ELSE    : 'else';
IN      : 'in';
DO      : 'do';
BEGIN   : 'begin';
END     : 'end';
CONST   : 'const';
VAR     : 'var';

//LITERAL
INTLITERAL: DIGIT DIGIT*;
REALLITERAL: DIGIT DIGIT* DOT DIGIT* | DOT DIGIT DIGIT*;
BOOLLITERAL: TRUE|FALSE;
STRINGLITERAL:QMARK (PRINTABLE)* QMARK;
CHARLITERAL: SIMPLEQMARK PRINTABLE SIMPLEQMARK;

//PRINTABLE
fragment PRINTABLE: '\\' ["\\] | ~["\\\r\n];


//IDENTIFIER
IDENTIFIER:(UNDERSCORE|LETTER)(UNDERSCORE|LETTER|DIGIT)*;

WS:[ \r\t\n]+ -> skip;

COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;

//FRAGMENTS
fragment LETTER: 'a'..'z'|'A'..'Z';
fragment DIGIT: '0'..'9';
fragment NUMBER: (DIGIT|DIGIT)*;

NUM: DIGIT DIGIT*;

