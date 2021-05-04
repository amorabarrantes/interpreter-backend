package contextAnalysis;

import generated.myParser;
import generated.myParserBaseVisitor;

import java.util.ArrayList;
import java.util.LinkedList;


public class AnalisisContextual extends myParserBaseVisitor<Object> {

    private final identificationTable<nodoVariable> tablaVarDeclaration = new identificationTable<>(new LinkedList<>(), 0);
    private final identificationTable<nodoClase> tablaClassDeclaration = new identificationTable<>(new LinkedList<>(), 0);
    private final identificationTable<nodoFuncion> tablaFunciones = new identificationTable<>(new LinkedList<>(), 0);


    @Override
    public Object visitProgramAST(myParser.ProgramASTContext ctx) {
        try {
            for (myParser.StatementContext statement : ctx.statement())
                this.visit(statement);
            return null;
        } catch (RuntimeException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Object visitVarDecSTAST(myParser.VarDecSTASTContext ctx) {
        this.visit(ctx.variableDecl());
        return null;
    }

    @Override
    public Object visitClassDecSTAST(myParser.ClassDecSTASTContext ctx) {
        this.visit(ctx.classDeclaration());
        return null;
    }

    @Override
    public Object visitAssignSTAST(myParser.AssignSTASTContext ctx) {
        this.visit(ctx.assignment());
        return null;
    }

    @Override
    public Object visitArrayAssignSTAST(myParser.ArrayAssignSTASTContext ctx) {
        this.visit(ctx.arrayAssignment());
        return null;
    }

    @Override
    public Object visitPrintSTAST(myParser.PrintSTASTContext ctx) {
        this.visit(ctx.printStatement());
        return null;
    }

    @Override
    public Object visitIfSTAST(myParser.IfSTASTContext ctx) {
        this.visit(ctx.ifStatement());
        return null;
    }

    @Override
    public Object visitWhileSTAST(myParser.WhileSTASTContext ctx) {
        this.visit(ctx.whileStatement());
        return null;
    }

    @Override
    public Object visitReturnSTAST(myParser.ReturnSTASTContext ctx) {
        this.visit(ctx.returnStatement());
        return null;
    }

    @Override
    public Object visitFuncDecSTAST(myParser.FuncDecSTASTContext ctx) {
        this.visit(ctx.functionDecl());
        return null;
    }

    @Override
    public Object visitBlockSTAST(myParser.BlockSTASTContext ctx) {
        this.visit(ctx.block());
        return null;
    }

    @Override
    public Object visitBlockAST(myParser.BlockASTContext ctx) {
        for (myParser.StatementContext statement : ctx.statement())
            this.visit(statement);
        return null;
    }

    @Override
    public Object visitFunctionDecAST(myParser.FunctionDecASTContext ctx) {

        String type = (String) this.visit(ctx.type());

        //AQUI SE VALIDA QUE NO SE PUEDAN INGRESAR 2 FUNCIONES CON EL MISMO IDENTIFICADOR.
        if (tablaFunciones.retrieve(ctx.IDENTIFIER().getText()) == null) {
            tablaFunciones.enter(new nodoFuncion(ctx.IDENTIFIER().getSymbol(), tablaFunciones.nivel, ctx, new ArrayList<nodoVariable>(), type));
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => es una funcion ya existente");
        }

        if (ctx.formalParams() != null)
            this.visit(ctx.formalParams());
        this.visit(ctx.block());

        tablaFunciones.imprimirNodoFuncion();

        return null;
    }

    @Override
    public Object visitFormalParamsAST(myParser.FormalParamsASTContext ctx) {

        for (myParser.FormalParamContext param : ctx.formalParam()) {
            this.visit(param);
        }
        return null;
    }

    @Override
    public Object visitFormalParamAST(myParser.FormalParamASTContext ctx) {

        String type = (String) this.visit(ctx.type());

        String nombreFuncion = ((myParser.FunctionDecASTContext) (ctx.parent.parent)).IDENTIFIER().getText();
        nodoFuncion nodo = tablaFunciones.retrieveNode(nombreFuncion);
        nodo.parametros.add(new nodoVariable(ctx.IDENTIFIER().getSymbol(), 0, ctx, type));

        return null;
    }

    @Override
    public Object visitWhileAST(myParser.WhileASTContext ctx) {
        this.visit(ctx.expression());
        this.visit(ctx.block());
        return null;
    }

    @Override
    public Object visitIfAST(myParser.IfASTContext ctx) {
        this.visit(ctx.expression());
        this.visit(ctx.block(0));
        if (ctx.block(1) != null) {
            this.visit(ctx.block(1));
        }
        return null;
    }

    @Override
    public Object visitReturnAST(myParser.ReturnASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitPrintAST(myParser.PrintASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitClassDecAST(myParser.ClassDecASTContext ctx) {

        //AQUI SE VALIDA QUE NO SE PUEDAN INGRESAR 2 CLASES CON EL MISMO IDENTIFICADOR.
        if (tablaClassDeclaration.retrieve(ctx.IDENTIFIER().getText()) == null) {
            tablaClassDeclaration.enter(new nodoClase(ctx.IDENTIFIER().getSymbol(), tablaClassDeclaration.nivel, ctx, new ArrayList<nodoVariable>()));
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => es una clase ya existente");
        }

        for (myParser.ClassVariableDeclContext classVar : ctx.classVariableDecl())
            this.visit(classVar);

        tablaClassDeclaration.imprimirNodoClase();
        return null;
    }

    @Override
    public Object visitClassVarDecAST(myParser.ClassVarDecASTContext ctx) {
        String type = (String) this.visit(ctx.simpleType());
        nodoClase clasePadre = tablaClassDeclaration.retrieveNode(((myParser.ClassDecASTContext) ctx.parent).IDENTIFIER().getText());

        nodoVariable nodoNuevo = new nodoVariable(ctx.IDENTIFIER().getSymbol(), 0, ctx, type);

        boolean existe = false;

        for (nodoVariable obj : clasePadre.atributos) {
            if (obj.declCtx.getText().equals(nodoNuevo.declCtx.getText())) {
                existe = true;
            }
        }

        if (!existe) {
            clasePadre.atributos.add(nodoNuevo);
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => es un atributo ya existente");
        }


        if (ctx.expression() != null)    //En este if hay que comprobar que la asignacion sea compatible con el tipo.
            this.visit(ctx.expression());

        return type;
    }

    @Override
    public Object visitVarDecAST(myParser.VarDecASTContext ctx) {
        String type = (String) this.visit(ctx.type());
        if (tablaVarDeclaration.retrieve(ctx.IDENTIFIER().getText()) == null) {
            if (ctx.expression() != null) {
                String tipoExpression = (String) this.visit(ctx.expression());
                if (!type.equals(tipoExpression)) {
                    throw new RuntimeException(ctx.IDENTIFIER().getText() + " espera => " + type + " pero recibió => " + tipoExpression);
                }
            }
            tablaVarDeclaration.enter(new nodoVariable(ctx.IDENTIFIER().getSymbol(), tablaVarDeclaration.nivel, ctx, type));
        } else
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => es una variable ya existente");


        tablaVarDeclaration.imprimirNodoVariable();
        return null;
    }


    @Override
    public Object visitSimpleTypeTPAST(myParser.SimpleTypeTPASTContext ctx) {
        String varType = (String) this.visit(ctx.simpleType());
        return varType;
    }

    @Override
    public Object visitArrayTypeTPAST(myParser.ArrayTypeTPASTContext ctx) {
        String arrayType = (String) this.visit(ctx.arrayType());
        return arrayType;
    }

    @Override
    public Object visitIdTPAST(myParser.IdTPASTContext ctx) {
        String idType = ctx.IDENTIFIER().getText();

        if (tablaClassDeclaration.retrieveNode(ctx.IDENTIFIER().getText()) != null) {
            return idType;
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => como tipo de dato no existe");
        }
    }

    @Override
    public Object visitBooleanSimpleTAST(myParser.BooleanSimpleTASTContext ctx) {
        return "boolean";
    }

    @Override
    public Object visitCharSimpleTAST(myParser.CharSimpleTASTContext ctx) {
        return "char";
    }

    @Override
    public Object visitIntSimpleTAST(myParser.IntSimpleTASTContext ctx) {
        return "int";
    }

    @Override
    public Object visitStringSimpleTAST(myParser.StringSimpleTASTContext ctx) {
        return "string";
    }

    @Override
    public Object visitArrayTypeAST(myParser.ArrayTypeASTContext ctx) {
        String type = (String) this.visit(ctx.simpleType());
        return type;
    }

    @Override
    public Object visitAssignAST(myParser.AssignASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitArrayAssignAST(myParser.ArrayAssignASTContext ctx) {
        this.visit(ctx.expression(0));
        this.visit(ctx.expression(1));
        return null;
    }

    @Override
    public Object visitExpressionAST(myParser.ExpressionASTContext ctx) {

        String tipoSimpleExpression = (String) this.visit(ctx.simpleExpression(0));

        for (int i = 1; i < ctx.simpleExpression().size(); i++) {
            this.visit(ctx.relationalOp(i - 1));
            this.visit(ctx.simpleExpression(i));
        }
        return tipoSimpleExpression;
    }

    @Override
    public Object visitSimpleExpressionAST(myParser.SimpleExpressionASTContext ctx) {
        String tipoTermino = (String) this.visit(ctx.term(0));

        if (ctx.term().size() == 1) {
            return tipoTermino;
        } else {
            for (int i = 1; i < ctx.additiveOp().size(); i++) {
                String tipoAdditive = (String) this.visit(ctx.additiveOp(i - 1));
                String tipoTerminoAuxiliar = (String) this.visit(ctx.term(i));

                if ((tipoTermino.equals("int") && (tipoAdditive.equals("mul") || tipoAdditive.equals("div")) && tipoTerminoAuxiliar.equals("int"))
                        || tipoTermino.equals("boolean") && tipoAdditive.equals("and") && tipoTerminoAuxiliar.equals("boolean")) {
                    tipoTermino = tipoTerminoAuxiliar;
                } else {
                    throw new RuntimeException("=> " + tipoTermino + " <= no se puede relacionar con => " + tipoTerminoAuxiliar +
                            " <= cuando hay un => " + ctx.additiveOp(i - 1).getText() + " <= en medio");
                }
            }
            return tipoTermino;
        }


    }

    @Override
    public Object visitTermAST(myParser.TermASTContext ctx) {
        String tipoFactor = (String) this.visit(ctx.factor(0));
        if (ctx.factor().size() == 1) {
            return tipoFactor;
        } else {
            for (int i = 1; i < ctx.factor().size(); i++) {
                String tipoMultiplicative = (String) this.visit(ctx.multiplicativeOP(i - 1));
                String tipoFactorAuxiliar = (String) this.visit(ctx.factor(i));

                if ((tipoFactor.equals("int") && (tipoMultiplicative.equals("mul") || tipoMultiplicative.equals("div")) && tipoFactorAuxiliar.equals("int"))
                        || tipoFactor.equals("boolean") && tipoMultiplicative.equals("and") && tipoFactorAuxiliar.equals("boolean")) {
                    tipoFactor = tipoFactorAuxiliar;
                } else {
                    throw new RuntimeException("=> " + tipoFactor + " <= no se puede relacionar con => " + tipoFactorAuxiliar +
                            " <= cuando hay un => " + ctx.multiplicativeOP(i - 1).getText() + " <= en medio");
                }
            }
            return tipoFactor;
        }
    }

    @Override
    public Object visitLiteralFAST(myParser.LiteralFASTContext ctx) {
        String tipoLiteral = (String) this.visit(ctx.literal());
        return tipoLiteral;
    }

    @Override
    public Object visitIdFAST(myParser.IdFASTContext ctx) {
        //Asignacion de una variable ya declarada.
        if (ctx.IDENTIFIER().size() == 1) {
            nodoVariable nodo = tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER().get(0).getText());
            if (nodo != null) {
                return nodo.type;
            } else {
                throw new RuntimeException(ctx.IDENTIFIER().get(0).getText() + " no es una variable existente");
            }
        } else { //Asignacion de una variable de clase
            nodoClase clase = tablaClassDeclaration.retrieveNode(ctx.IDENTIFIER().get(0).getText());
            if (clase != null) {
                nodoVariable variableClase = clase.buscarVariableClase(ctx.IDENTIFIER().get(1).getText());
                if (variableClase != null) {
                    return variableClase.type;
                } else {
                    throw new RuntimeException("La clase => " + ctx.IDENTIFIER().get(0).getText() + " <= no tiene el atributo => " + ctx.IDENTIFIER().get(1).getText() + " <=");
                }
            } else {
                throw new RuntimeException("La clase => " + ctx.IDENTIFIER().get(0).getText() + " <= no existe");
            }
        }
    }

    @Override
    public Object visitFunctionCallFAST(myParser.FunctionCallFASTContext ctx) {
        String tipoFuncion = (String) this.visit(ctx.functionCall());
        return tipoFuncion;
    }

    @Override
    public Object visitArrayLookUpFAST(myParser.ArrayLookUpFASTContext ctx) {
        String tipoArreglo = (String) this.visit(ctx.arrayLookup());
        return tipoArreglo;
    }

    @Override
    public Object visitArrayLengthFAST(myParser.ArrayLengthFASTContext ctx) {
        String tipoArrayLength = (String) this.visit(ctx.arrayLength());
        return tipoArrayLength;
    }

    @Override
    public Object visitSubExpressionFAST(myParser.SubExpressionFASTContext ctx) {
        String tipoSubExpression = (String) this.visit(ctx.subExpression());
        return tipoSubExpression;
    }

    @Override
    public Object visitArrayAllocationExpressionFAST(myParser.ArrayAllocationExpressionFASTContext ctx) {
        String tipoArrayAllocation = (String) this.visit(ctx.arrayAllocationExpression());
        return tipoArrayAllocation;
    }

    @Override
    public Object visitAllocationExpressionFAST(myParser.AllocationExpressionFASTContext ctx) {
        String tipoAllocationExpression = (String) this.visit(ctx.allocationExpression());
        return tipoAllocationExpression;
    }

    @Override
    public Object visitUnaryFAST(myParser.UnaryFASTContext ctx) {
        String tipoUnary = (String) this.visit(ctx.unary());
        return tipoUnary;
    }

    @Override
    public Object visitOrSymbolROAST(myParser.OrSymbolROASTContext ctx) {
        return null;
    }

    @Override
    public Object visitAmpertonROAST(myParser.AmpertonROASTContext ctx) {
        return null;
    }

    @Override
    public Object visitSmallerROAST(myParser.SmallerROASTContext ctx) {
        return null;
    }

    @Override
    public Object visitGreatherROAST(myParser.GreatherROASTContext ctx) {
        return null;
    }

    @Override
    public Object visitEqualsROAST(myParser.EqualsROASTContext ctx) {
        return null;
    }

    @Override
    public Object visitDifferentROAST(myParser.DifferentROASTContext ctx) {
        return null;
    }

    @Override
    public Object visitSmallerEqualROAST(myParser.SmallerEqualROASTContext ctx) {
        return null;
    }

    @Override
    public Object visitGreatherEqualROAST(myParser.GreatherEqualROASTContext ctx) {
        return null;
    }

    @Override
    public Object visitMasAdditOPAST(myParser.MasAdditOPASTContext ctx) {
        return null;
    }

    @Override
    public Object visitMinusAdditOPAST(myParser.MinusAdditOPASTContext ctx) {
        return null;
    }

    @Override
    public Object visitOrAdditOPAST(myParser.OrAdditOPASTContext ctx) {
        return null;
    }

    @Override
    public Object visitMulMultOPAST(myParser.MulMultOPASTContext ctx) {
        return "mul";
    }

    @Override
    public Object visitDivMultOPAST(myParser.DivMultOPASTContext ctx) {
        return "div";
    }

    @Override
    public Object visitAndMultOPAST(myParser.AndMultOPASTContext ctx) {
        return "and";
    }

    @Override
    public Object visitUnaryAST(myParser.UnaryASTContext ctx) {

        if (ctx.MAS() != null || ctx.MINUS() != null) {
            for (myParser.ExpressionContext expression : ctx.expression()) {
                String tipoExpression = (String) this.visit(expression);
                if (tipoExpression != "int") {
                    throw new RuntimeException(tipoExpression + " <= fue encontrado y se requiere un entero");
                }
            }
            return "int";
        } else {
            for (myParser.ExpressionContext expression : ctx.expression()) {
                String tipoExpression = (String) this.visit(expression);
                if (tipoExpression != "boolean") {
                    throw new RuntimeException(tipoExpression + " <= fue encontrado y se requiere un boolean");
                }
            }
            return "boolean";
        }
    }

    @Override
    public Object visitIntLiteralLAST(myParser.IntLiteralLASTContext ctx) {
        return "int";
    }

    @Override
    public Object visitRealLiteralLAST(myParser.RealLiteralLASTContext ctx) {
        return "int";
    }

    @Override
    public Object visitBoolLiteralLAST(myParser.BoolLiteralLASTContext ctx) {
        return "boolean";
    }

    @Override
    public Object visitStringLiteralLAST(myParser.StringLiteralLASTContext ctx) {
        return "string";
    }

    @Override
    public Object visitAllocationExpressionAST(myParser.AllocationExpressionASTContext ctx) {
        if (tablaClassDeclaration.retrieveNode(ctx.IDENTIFIER().getText()) != null) {
            return ctx.IDENTIFIER().getText();
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " <= no es una clase declarada");
        }
    }

    @Override
    public Object visitArrayAllocationExpressionAST(myParser.ArrayAllocationExpressionASTContext ctx) {
        //En caso de dar problemas, hay que agregar un [] al final de este string.
        String tipoSimpleAsignacion = (String) this.visit(ctx.simpleType());

        this.visit(ctx.expression());
        return tipoSimpleAsignacion;
    }

    @Override
    public Object visitSubExpressionAST(myParser.SubExpressionASTContext ctx) {
        String tipo = (String) this.visit(ctx.expression());
        return tipo;
    }

    @Override
    public Object visitFunctionCallAST(myParser.FunctionCallASTContext ctx) {
        nodoFuncion funcion = tablaFunciones.retrieveNode(ctx.IDENTIFIER().getText());
        if (funcion != null) {

            if (ctx.actualParams() != null) {
                this.visit(ctx.actualParams());
            }
            return funcion.type;

        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => no existe esta funcion");
        }
    }

    @Override
    public Object visitActualParamsAST(myParser.ActualParamsASTContext ctx) {
        nodoFuncion funcion = tablaFunciones.retrieveNode(((myParser.FunctionCallASTContext) ctx.parent).IDENTIFIER().getText());

        if (funcion.parametros.size() == ctx.expression().size()) {
            for (int i = 0; i < ctx.expression().size(); i++) {
                String tipoParametroFuncion = funcion.parametros.get(i).type;
                String tipoExpressionArgumento = (String) this.visit(ctx.expression().get(i));

                if (!tipoParametroFuncion.equals(tipoExpressionArgumento)) {
                    throw new RuntimeException("La funcion => " + funcion.tok.getText() + " <= espera => " + tipoParametroFuncion + " <= y obtuvo => " + tipoExpressionArgumento + " <=");
                }
            }
        } else {
            throw new RuntimeException("La funcion tiene: " + funcion.parametros.size() + " parametros, pero recibió: " + ctx.expression().size() + " argumentos.");
        }
        return null;
    }

    @Override
    public Object visitArrayLookupAST(myParser.ArrayLookupASTContext ctx) {
        nodoVariable tipoAsignacion = tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER().getText());
        if (tipoAsignacion != null) {
            this.visit(ctx.expression());
            return tipoAsignacion.type;
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " <= no es una variable definida.");
        }
    }

    @Override
    public Object visitArrayLengthAST(myParser.ArrayLengthASTContext ctx) {
        nodoVariable variable = tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER().getText());
        if (variable != null) {
            return "int";
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " <= no es una variable declarada");
        }
    }
}