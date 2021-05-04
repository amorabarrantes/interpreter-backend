parser grammar myParser;

options {
 tokenVocab = myScanner;
}

program:(statement)* EOF                                                                    #programAST;
statement:          variableDecl PYCOMA                                                     #varDecSTAST
                    |classDeclaration PYCOMA                                                #classDecSTAST
                    |assignment PYCOMA                                                      #assignSTAST
                    |arrayAssignment PYCOMA                                                 #arrayAssignSTAST
                    |printStatement PYCOMA                                                  #printSTAST
                    |ifStatement                                                            #ifSTAST
                    |whileStatement                                                         #whileSTAST
                    |returnStatement PYCOMA                                                 #returnSTAST
                    |functionDecl                                                           #funcDecSTAST
                    |block                                                                  #blockSTAST;
block:BRACKETLEFT (statement)* BRACKETRIGHT                                                 #blockAST;
functionDecl:type IDENTIFIER PLEFT (formalParams)? PRIGHT block                             #functionDecAST;
formalParams:formalParam (COMMA formalParam)*                                               #formalParamsAST;
formalParam:type IDENTIFIER                                                                 #formalParamAST;
whileStatement:WHILE PLEFT expression PRIGHT block                                          #whileAST;
ifStatement:IF PLEFT expression PRIGHT block (ELSE block)?                                  #ifAST;
returnStatement:RETURN expression                                                           #returnAST;
printStatement:PRINT expression                                                             #printAST;
classDeclaration:CLASS IDENTIFIER BRACKETLEFT (classVariableDecl)* BRACKETRIGHT             #classDecAST;
classVariableDecl:simpleType IDENTIFIER (ASSIGN expression)? PYCOMA                         #classVarDecAST;
variableDecl:type IDENTIFIER (ASSIGN expression)?                                           #varDecAST;
type:   simpleType                                                                          #simpleTypeTPAST
        |arrayType                                                                          #arrayTypeTPAST
        |IDENTIFIER                                                                         #idTPAST;
simpleType: BOOLEAN                                                                         #booleanSimpleTAST
            |CHAR                                                                           #charSimpleTAST
            |INT                                                                            #intSimpleTAST
            |STRING                                                                         #stringSimpleTAST;
arrayType: simpleType SQUAREPLEFT SQUAREPRIGHT                                              #arrayTypeAST;
assignment: IDENTIFIER (DOT IDENTIFIER)? ASSIGN expression                                  #assignAST;
arrayAssignment: IDENTIFIER SQUAREPLEFT expression SQUAREPRIGHT ASSIGN expression           #arrayAssignAST;
expression: simpleExpression (relationalOp simpleExpression)*                               #expressionAST;
simpleExpression: term (additiveOp term)*                                                   #simpleExpressionAST;
term: factor (multiplicativeOP factor)*                                                     #termAST;
factor:         literal                                                                     #literalFAST //Comprobacion de asignacion listo
                |IDENTIFIER (DOT IDENTIFIER)?                                               #idFAST      //Comprobacion de asignacion listo
                |functionCall                                                               #functionCallFAST //Comprobacion de asignacion listo
                |arrayLookup                                                                #arrayLookUpFAST //Comprobacion de asignacion listo
                |arrayLength                                                                #arrayLengthFAST //Comprobacion de asignacion listo
                |subExpression                                                              #subExpressionFAST //Comprobacion de asignacion listo
                |arrayAllocationExpression                                                  #arrayAllocationExpressionFAST //Comprobacion de asignacion listo
                |allocationExpression                                                       #allocationExpressionFAST //Comprobacion de asignacion listo
                |unary                                                                      #unaryFAST; //Comprobacion de asignacion listo
relationalOp:ORSYMBOL                                                                       #orSymbolROAST
            |AMPERTON                                                                       #ampertonROAST
            |SMALLER                                                                        #smallerROAST
            |GREATHER                                                                       #greatherROAST
            |EQUALS                                                                         #equalsROAST
            |DIFFERENT                                                                      #differentROAST
            |SMALLEREQUAL                                                                   #smallerEqualROAST
            |GREATHEREQUAL                                                                  #greatherEqualROAST;
additiveOp:MAS                                                                              #masAdditOPAST
           |MINUS                                                                           #minusAdditOPAST
           |OR                                                                              #orAdditOPAST;
multiplicativeOP:MUL                                                                        #mulMultOPAST
                |DIV                                                                        #divMultOPAST
                |AND                                                                        #andMultOPAST;
unary: (MAS|MINUS|EXCLAMATION) (expression)*                                                #unaryAST;
literal:INTLITERAL                                                                          #intLiteralLAST
        |REALLITERAL                                                                        #realLiteralLAST
        |BOOLLITERAL                                                                        #boolLiteralLAST
        |STRINGLITERAL                                                                      #stringLiteralLAST;
allocationExpression: NEW IDENTIFIER PLEFT PRIGHT                                           #allocationExpressionAST;
arrayAllocationExpression: NEW simpleType SQUAREPLEFT expression SQUAREPRIGHT               #arrayAllocationExpressionAST;
subExpression:PLEFT expression PRIGHT                                                       #subExpressionAST;
functionCall:IDENTIFIER PLEFT (actualParams)? PRIGHT                                        #functionCallAST;
actualParams:expression (COMMA expression)*                                                 #actualParamsAST;
arrayLookup:IDENTIFIER SQUAREPLEFT expression SQUAREPRIGHT                                  #arrayLookupAST;
arrayLength:IDENTIFIER DOT LENGTH                                                           #arrayLengthAST;
