parser grammar myParser;

options {
 tokenVocab = myScanner;
}

program:(statement)* EOF;
statement:          variableDecl PYCOMA
                    |classDeclaration PYCOMA
                    |assignment PYCOMA
                    |arrayAssignment PYCOMA
                    |printStatement PYCOMA
                    |ifStatement
                    |whileStatement
                    |returnStatement PYCOMA
                    |functionDecl
                    |block;

block:BRACKETLEFT (statement)* BRACKETRIGHT;
functionDecl:type IDENTIFIER PLEFT (formalParams)? PRIGHT block;
formalParams:formalParam (COMMA formalParam)*;
formalParam:type IDENTIFIER;
whileStatement:WHILE PLEFT expression PRIGHT block;
ifStatement:IF PLEFT expression PRIGHT block (ELSE block)?;
returnStatement:RETURN expression;
printStatement:PRINT expression;
classDeclaration:CLASS IDENTIFIER BRACKETLEFT (classVariableDecl)* BRACKETRIGHT;
classVariableDecl:simpleType IDENTIFIER (ASSIGN expression)?;
variableDecl:type IDENTIFIER (ASSIGN expression)?;
type:simpleType|arrayType|IDENTIFIER;
simpleType: BOOLEAN|CHAR|INT|STRING;
arrayType: simpleType SQUAREPLEFT SQUAREPRIGHT;
assignment: IDENTIFIER (DOT IDENTIFIER)? ASSIGN expression;
arrayAssignment: IDENTIFIER SQUAREPLEFT expression SQUAREPRIGHT ASSIGN expression;
expression: simpleExpression (relationalOp simpleExpression)*;
simpleExpression: term (additiveOp term)*;
term: factor (multiplicativeOP factor)*;
factor:         literal
                |IDENTIFIER (DOT IDENTIFIER)?
                |functionCall
                |arrayLookup
                |arrayLength
                |subExpression
                |arrayAllocationExpression
                |allocationExpression
                |unary;

relationalOp:ORSYMBOL|AMPERTON|SMALLER|GREATHER|EQUALS|DIFFERENT|SMALLEREQUAL|GREATHEREQUAL;
additiveOp:MAS|MINUS|OR;
multiplicativeOP:MUL|DIV|AND;

unary: (MAS|MINUS|EXCLAMATION) (expression)*;

literal:INTLITERAL|REALLITERAL|BOOLLITERAL|STRINGLITERAL;


allocationExpression: NEW IDENTIFIER PLEFT PRIGHT;
arrayAllocationExpression: NEW simpleType SQUAREPLEFT expression SQUAREPRIGHT;
subExpression:PLEFT expression PRIGHT;
functionCall:IDENTIFIER PLEFT (actualParams)? PRIGHT;
actualParams:expression (COMMA expression)*;
arrayLookup:IDENTIFIER SQUAREPLEFT expression SQUAREPRIGHT;
arrayLength:IDENTIFIER DOT LENGTH;


