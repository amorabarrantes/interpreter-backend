lexer grammar myScanner;

//símbolos
PYCOMA          : ';' ;
ASSIGN          : '=';
PLEFT           : '(';
PRIGHT          : ')';
VIR             : '~';
COLON           : ':';
PLUS            : '+';
MINUS           : '-';
MUL             : '*';
DIV             : '/';
fragment GREATHER        : '>';
fragment SMALLER         : '<';
fragment GREATHEREQUAL   : '>=';
fragment SMALLEREQUAL    : '<=';
QMARK           : '"';
DOT             : '.';
UNDERSCORE      : '_';
fragment EQUALS : '==';
fragment DIFFERENT : '!=';
SQUAREPLEFT     : '[';
SQUAREPRIGHT    : ']';
COMMA           : ',';
EXCLAMATION     : '!';
BRACKETLEFT     : '{';
BRACKETRIGHT    : '}';
CAT             : '#';
DOLLAR          : '$';
PERCENT         : '%';
AMPERTON        : '&';
QUESTIONMARK    : '?';
AT              : '@';
EXPONENTIAL     : '^';
SIMPLEQMARK     : '`';
ORSYMBOL        : '|';
//BACKSLASH       : '\\';
//SIMPLEQMARK2    :'\'';

//palabras reservadas
AND     : 'and';
OR      : 'or';
BOOLEAN : 'boolean';
LENGTH  : 'length';
NEW     : 'new';
CHAR    : 'char';
INT     : 'int';
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

//operadores
RELATIONALOP:SMALLER|GREATHER|EQUALS|DIFFERENT|SMALLEREQUAL|GREATHEREQUAL;
ADDITIVEOP:PLUS|MINUS|OR;
MULTIPLICATIVEOP:MUL|DIV|AND;

//LITERAL
LITERAL:INTLITERAL|REALLITERAL|BOOLLITERAL|STRINGLITERAL;
INTLITERAL: DIGIT DIGIT*;
REALLITERAL: DIGIT DIGIT* DOT DIGIT*| DOT DIGIT DIGIT*;
BOOLLITERAL: TRUE|FALSE;
STRINGLITERAL:QMARK (PRINTABLE)* QMARK;


//PRINTABLE
fragment PRINTABLE: DIGIT|LETTER|WS|EXCLAMATION|EQUALS|QMARK|CAT|DOLLAR|PERCENT|AMPERTON|PLEFT|PRIGHT|MUL|PLUS|DIFFERENT|COMMA|MINUS|DOT|DIV
                    |COLON|PYCOMA|SMALLER|SMALLEREQUAL|ASSIGN|GREATHER|AND|OR|GREATHEREQUAL|QUESTIONMARK|AT|SQUAREPLEFT|SQUAREPRIGHT|EXPONENTIAL|UNDERSCORE|SIMPLEQMARK
                    |BRACKETLEFT|ORSYMBOL|BRACKETRIGHT|VIR;

//IDENTIFIER
IDENTIFIER:(UNDERSCORE|LETTER)(UNDERSCORE|LETTER|DIGIT)*;

WS:[ \r\t\n]+ -> skip;

//FRAGMENTS
fragment LETTER: 'a'..'z'|'A'..'Z';
fragment DIGIT: '0'..'9';
fragment NUMBER: (DIGIT|DIGIT)*;

NUM: DIGIT DIGIT*;

