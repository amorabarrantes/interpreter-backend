package contextAnalysis;

import com.example.interpreterbackend.claseTablas;
import generated.myParser;
import generated.myParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ParserRuleContext;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class AnalisisContextual extends myParserBaseVisitor<Object> {

    claseTablas ct = claseTablas.getIsntance();

    public String varErrores = "";


    @Override
    public Object visitProgramAST(myParser.ProgramASTContext ctx) {
        try {
            for (myParser.StatementContext statement : ctx.statement())
                this.visit(statement);
            return null;
        } catch (RuntimeException e) {
            varErrores = e.getMessage();
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
        ct.tablaFunciones.openScope();
        ct.tablaVarDeclaration.openScope();
        ct.tablaClassDeclaration.openScope();

        for (myParser.StatementContext statement : ctx.statement()) {
            this.visit(statement);
        }

        ct.tablaFunciones.closeScope();
        ct.tablaVarDeclaration.closeScope();
        ct.tablaClassDeclaration.closeScope();
        return null;
    }

    @Override
    public Object visitFunctionDecAST(myParser.FunctionDecASTContext ctx) {

        String type = (String) this.visit(ctx.type());

        //AQUI SE VALIDA QUE NO SE PUEDAN INGRESAR 2 FUNCIONES CON EL MISMO IDENTIFICADOR.
        if (ct.tablaFunciones.retrieve(ctx.IDENTIFIER().getText()) == null) {
            ct.tablaFunciones.enter(new nodoFuncion(ctx.IDENTIFIER().getSymbol(), ct.tablaFunciones.nivel, ctx, new ArrayList<>(), type));
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => es una funcion ya existente");
        }

        if (ctx.formalParams() != null)
            this.visit(ctx.formalParams());

        this.visit(ctx.block());

        //ct.tablaFunciones.imprimirNodoFuncion();


        boolean flag = false;
        for (ParseTree child : ctx.children) {
            if (child instanceof myParser.BlockASTContext) {
                myParser.BlockASTContext blockChild = (myParser.BlockASTContext) child;
                for (ParserRuleContext statement : blockChild.statement()) {
                    if (statement instanceof myParser.ReturnSTASTContext) {
                        if(!statement.equals(blockChild.statement().get(blockChild.statement().size()-1))){
                            throw new RuntimeException("el return debe estar al final");
                        }
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (!flag) {
            ct.tablaFunciones.ll.remove(ct.tablaFunciones.retrieveNode(ctx.IDENTIFIER().getText()));
            throw new RuntimeException("No se puede declarar una funcion sin return.");
        }
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
        nodoFuncion nodo = ct.tablaFunciones.retrieveNode(nombreFuncion);

        nodo.parametros.add(new nodoVariable(ctx.IDENTIFIER().getSymbol(), ct.tablaVarDeclaration.nivel + 1, ctx, type));
        ct.tablaVarDeclaration.enter(new nodoVariable(ctx.IDENTIFIER().getSymbol(), ct.tablaVarDeclaration.nivel + 1, ctx, type));

        return null;
    }

    @Override
    public Object visitWhileAST(myParser.WhileASTContext ctx) {
        String type = (String) this.visit(ctx.expression());
        if(!type.equals("boolean")){
            throw new RuntimeException("La condicion del while requiere boolean, y se encontro => " + type + " <=");
        }
        this.visit(ctx.block());
        return null;
    }

    @Override
    public Object visitIfAST(myParser.IfASTContext ctx) {
        String type = (String) this.visit(ctx.expression());
        if(!type.equals("boolean")){
            throw new RuntimeException("La condicion del if requiere boolean, y se encontro => " + type + " <=");
        }
        this.visit(ctx.block(0));
        if (ctx.block(1) != null) {
            this.visit(ctx.block(1));
        }
        return null;
    }

    @Override
    public Object visitReturnAST(myParser.ReturnASTContext ctx) {
        String tipo = (String) this.visit(ctx.expression());

        if (ct.tablaFunciones.ll.size() != 0) {
            ParserRuleContext variable = ctx.getParent();

            while (variable != null) {
                if (variable.getClass().getSimpleName().equals("FunctionDecASTContext")) {
                    nodoFuncion funcion = ct.tablaFunciones.ll.get(ct.tablaFunciones.ll.size() - 1);

                    if (!funcion.type.equals(tipo)) {
                        throw new RuntimeException("La funcion => " + funcion.tok.getText() + " <= es de tipo => " + funcion.type + " <= pero retorna => " + tipo + " <=");
                    }
                }
                variable = variable.getParent();
            }
        } else {
            throw new RuntimeException("No se puede retornar fuera de una funcion.");
        }

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
        if (ct.tablaClassDeclaration.retrieve(ctx.IDENTIFIER().getText()) == null) {
            ct.tablaClassDeclaration.enter(new nodoClase(ctx.IDENTIFIER().getSymbol(), ct.tablaClassDeclaration.nivel, ctx, new ArrayList<>()));
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => es una clase ya existente");
        }

        for (myParser.ClassVariableDeclContext classVar : ctx.classVariableDecl())
            this.visit(classVar);

        //ct.tablaClassDeclaration.imprimirNodoClase();
        return null;
    }

    @Override
    public Object visitClassVarDecAST(myParser.ClassVarDecASTContext ctx) {
        String type = (String) this.visit(ctx.simpleType());
        nodoClase clasePadre = ct.tablaClassDeclaration.retrieveNode(((myParser.ClassDecASTContext) ctx.parent).IDENTIFIER().getText());

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


        if (ctx.expression() != null) {    //En este if hay que comprobar que la asignacion sea compatible con el tipo.
            String tipoAsignacion = (String) this.visit(ctx.expression());

            if (!tipoAsignacion.equals(type)) {
                throw new RuntimeException(ctx.IDENTIFIER().getText() + " espera => " + type + " pero recibi?? => " + tipoAsignacion);
            }
        }

        return type;
    }

    @Override
    public Object visitVarDecAST(myParser.VarDecASTContext ctx) {
        String type = (String) this.visit(ctx.type());

        nodoVariable retornoVariable = ct.tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER().getText());

        if (retornoVariable == null || retornoVariable.nivel != ct.tablaVarDeclaration.nivel) {
            if (ctx.expression() != null) {
                String tipoExpression = (String) this.visit(ctx.expression());
                if (!type.equals(tipoExpression)) {
                    throw new RuntimeException(ctx.IDENTIFIER().getText() + " espera => " + type + " pero recibi?? => " + tipoExpression);
                }
            }
            ct.tablaVarDeclaration.enter(new nodoVariable(ctx.IDENTIFIER().getSymbol(), ct.tablaVarDeclaration.nivel, ctx, type));
        } else
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => es una variable ya existente");

        //ct.tablaVarDeclaration.imprimirNodoVariable();
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

        if (ct.tablaClassDeclaration.retrieveNode(ctx.IDENTIFIER().getText()) != null) {
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
    public Object visitRealSimpleTAST(myParser.RealSimpleTASTContext ctx) {
        return "real";
    }

    @Override
    public Object visitArrayTypeAST(myParser.ArrayTypeASTContext ctx) {
        String type = (String) this.visit(ctx.simpleType());
        return type;
    }

    @Override
    public Object visitAssignAST(myParser.AssignASTContext ctx) {
        if (ctx.IDENTIFIER().size() == 1) {
            String tipoExpression = (String) this.visit(ctx.expression());
            nodoVariable busqueda = ct.tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER(0).getText());
            if (busqueda != null) {
                if (busqueda.type.equals(tipoExpression)) {
                    return tipoExpression;
                } else {
                    throw new RuntimeException(ctx.IDENTIFIER(0).getText() + " espera => " + busqueda.type + " pero recibi?? => " + tipoExpression);
                }
            } else {
                throw new RuntimeException(ctx.IDENTIFIER(0).getText() + " <= no esta declarado como variable.");
            }
        } else {
            nodoVariable variable = ct.tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER(0).getText());

            if (variable != null) {
                String tipoExpression = (String) this.visit(ctx.expression());
                nodoClase retrieveClase = ct.tablaClassDeclaration.retrieveNode(variable.type);

                if (retrieveClase != null) {
                    nodoVariable retrieveAtrituto = retrieveClase.buscarVariableClase(ctx.IDENTIFIER(1).getText());
                    if (retrieveAtrituto != null) {
                        if (retrieveAtrituto.type.equals(tipoExpression)) {
                            return tipoExpression;
                        } else {
                            throw new RuntimeException(ctx.IDENTIFIER(1).getText() + " espera => " + retrieveAtrituto.type + " pero recibi?? => " + tipoExpression);
                        }
                    } else {
                        throw new RuntimeException("La clase => " + ctx.IDENTIFIER(0).getText() + " <= no contiene al atributo => " + ctx.IDENTIFIER(1).getText() + " <=");
                    }
                } else {
                    throw new RuntimeException(ctx.IDENTIFIER(0).getText() + " <= no esta declarado como clase.");
                }
            } else {
                throw new RuntimeException("La variable => " + ctx.IDENTIFIER(0).getText() + " <= no esta declarada");
            }
        }
    }

    @Override
    public Object visitArrayAssignAST(myParser.ArrayAssignASTContext ctx) {
        String tipoExpression1 = (String) this.visit(ctx.expression(0));
        if (tipoExpression1.equals("int")) {
            String tipoExpression2 = (String) this.visit(ctx.expression(1));
            nodoVariable busqueda = ct.tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER().getText());
            if (busqueda != null) {
                if (busqueda.type.equals(tipoExpression2)) {
                    return tipoExpression2;
                } else {
                    throw new RuntimeException(ctx.IDENTIFIER().getText() + " espera => " + busqueda.type + " pero recibi?? => " + tipoExpression2);
                }
            } else {
                throw new RuntimeException(ctx.IDENTIFIER().getText() + " <= no esta declarado como variable.");
            }
        } else {
            throw new RuntimeException("El subIndice de un arreglo, debe ser int, pero recibio => " + tipoExpression1);
        }
    }

    @Override
    public Object visitExpressionAST(myParser.ExpressionASTContext ctx) {


        String tipoSimpleExpression = (String) this.visit(ctx.simpleExpression(0));

        ArrayList<String> intRelationals = new ArrayList<>() {
            {
                add("smaller");
                add("greather");
                add("equals");
                add("different");
                add("smallerequal");
                add("greatherequal");
            }
        };

        ArrayList<String> allRelationals = new ArrayList<>() {
            {
                add("equals");
                add("different");
            }
        };

        ArrayList<String> booleanRelationals = new ArrayList<>() {
            {
                add("orsymbol");
                add("amperton");
                add("equals");
                add("different");
            }
        };

        if (ctx.simpleExpression().size() == 1) {
            return tipoSimpleExpression;
        } else {
            for (int i = 1; i < ctx.simpleExpression().size(); i++) {
                String tipoRelationOP = (String) this.visit(ctx.relationalOp(i - 1));
                String tipoSimpleExpressionAuxiliar = (String) this.visit(ctx.simpleExpression(i));

                if (tipoSimpleExpression.equals("boolean") && booleanRelationals.contains(tipoRelationOP) && tipoSimpleExpressionAuxiliar.equals("boolean")) {
                    tipoSimpleExpression = tipoSimpleExpressionAuxiliar;

                } else if ((tipoSimpleExpression.equals("int") || tipoSimpleExpression.equals("real")) && intRelationals.contains(tipoRelationOP) && (tipoSimpleExpressionAuxiliar.equals("int")) || tipoSimpleExpressionAuxiliar.equals("real")) {
                    tipoSimpleExpression = tipoSimpleExpressionAuxiliar;

                } else if (tipoSimpleExpression.equals(tipoSimpleExpressionAuxiliar) && allRelationals.contains(tipoRelationOP)) {
                    tipoSimpleExpression = tipoSimpleExpressionAuxiliar;
                } else {
                    throw new RuntimeException("=> " + tipoSimpleExpression + " <= no se puede relacionar con => " + tipoSimpleExpressionAuxiliar +
                            " <= cuando hay un => " + ctx.relationalOp(i - 1).getText() + " <= en medio");
                }
            }
            return "boolean";
        }
    }

    @Override
    public Object visitSimpleExpressionAST(myParser.SimpleExpressionASTContext ctx) {
        String tipoTermino = (String) this.visit(ctx.term(0));
        //Retorna 0 cuando es concatenacion de booleanos mediante or.
        //Retorna 1 cuando es una resta de enteros.
        //Retorna 2 cuando es una concatenacion mediante + retornando string
        //Retorna 3 cuando es una suma de enteros.
        int bandera = 0;

        boolean concatenacion = false;


        if (ctx.term().size() == 1) {
            return tipoTermino;
        } else {

            String additiveAux = (String) this.visit(ctx.additiveOp(0));
            String termAux = (String) this.visit(ctx.term(1));
            if ((tipoTermino.equals("string") && additiveAux.equals("mas")) ||
                    (additiveAux.equals("mas") && termAux.equals("string"))) {
                concatenacion = true;
                bandera = 2;
            }

            for (int i = 1; i < ctx.term().size(); i++) {
                String tipoAdditive = (String) this.visit(ctx.additiveOp(i - 1));
                String tipoTerminoAuxiliar = (String) this.visit(ctx.term(i));

                //Este if entra solo cuando se concatenan booleanos con un or.
                if (tipoTermino.equals("boolean") && tipoAdditive.equals("or") && tipoTerminoAuxiliar.equals("boolean")) {
                    tipoTermino = tipoTerminoAuxiliar;

                    //A este else if entra solo si se va a hacer una concatenacion de strings.
                } else if ((tipoTermino.equals("int") || tipoTermino.equals("real")) && tipoAdditive.equals("minus") && (tipoTerminoAuxiliar.equals("int") || tipoTerminoAuxiliar.equals("real"))) {
                    tipoTermino = tipoTerminoAuxiliar;
                    bandera = 1;

                } else if ((tipoTermino.equals("int") || tipoTermino.equals("real")) && tipoAdditive.equals("mas") && (tipoTerminoAuxiliar.equals("int") || tipoTerminoAuxiliar.equals("real"))) {
                    if (concatenacion)
                        bandera = 2;
                    else
                        bandera = 3;

                    tipoTermino = tipoTerminoAuxiliar;
                } else if (concatenacion) {
                    tipoTermino = tipoTerminoAuxiliar;
                } else {
                    throw new RuntimeException("=> " + tipoTermino + " <= no se puede relacionar con => " + tipoTerminoAuxiliar +
                            " <= cuando hay un => " + ctx.additiveOp(i - 1).getText() + " <= en medio");
                }
            }

            ArrayList<String> arreglo = new ArrayList<>();

            for (int i = 0; i < ctx.term().size(); i++) {
                String tipoTermAux = (String) this.visit(ctx.term(i));
                arreglo.add(tipoTermAux);
            }
            if (arreglo.contains("string")) {
                return "string";
            } else if (arreglo.contains("boolean")) {
                return "boolean";
            } else if (arreglo.contains("real")) {
                return "real";
            } else {
                return "int";
            }

        }
    }

    @Override
    public Object visitTermAST(myParser.TermASTContext ctx) {
        String tipoFactor = (String) this.visit(ctx.factor(0));
        if(ctx.factor().size() == 1){
            return tipoFactor;
        } else {
            for (int i = 1; i < ctx.factor().size(); i++) {
                String tipoMultiplicative = (String) this.visit(ctx.multiplicativeOP(i - 1));
                String tipoFactorAuxiliar = (String) this.visit(ctx.factor(i));

                if ((tipoFactor.equals("int") || tipoFactor.equals("real")) && (tipoMultiplicative.equals("mul") || tipoMultiplicative.equals("div")) && (tipoFactorAuxiliar.equals("int") || tipoFactorAuxiliar.equals("real"))) {
                    tipoFactor = tipoFactorAuxiliar;

                } else if (tipoFactor.equals("boolean") && tipoMultiplicative.equals("and") && tipoFactorAuxiliar.equals("boolean")) {
                    tipoFactor = tipoFactorAuxiliar;
                } else {
                    throw new RuntimeException("=> " + tipoFactor + " <= no se puede relacionar con => " + tipoFactorAuxiliar +
                            " <= cuando hay un => " + ctx.multiplicativeOP(i - 1).getText() + " <= en medio");
                }
            }
        }

        ArrayList<String> arreglo = new ArrayList<>();

        for (int i = 0; i < ctx.factor().size(); i++) {
            String tipoFactorAux = (String) this.visit(ctx.factor(i));
            arreglo.add(tipoFactorAux);
        }

        if (arreglo.contains("string")) {
            return "string";
        } else if (arreglo.contains("boolean")) {
            return "boolean";
        } else if (arreglo.contains("real")) {
            return "real";
        } else if (arreglo.contains("char")) {
            return "char";
        } else  {
            return "int";
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
            nodoVariable nodo = ct.tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER().get(0).getText());
            if (nodo != null) {
                return nodo.type;
            } else {
                throw new RuntimeException(ctx.IDENTIFIER().get(0).getText() + " no es una variable existente");
            }
        } else { //Asignacion de una variable de tipo clase.
            nodoVariable variable = ct.tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER().get(0).getText());

            if (variable != null) {
                nodoClase clase = ct.tablaClassDeclaration.retrieveNode(variable.type);
                nodoVariable variableClase = clase.buscarVariableClase(ctx.IDENTIFIER().get(1).getText());

                if (variableClase != null) {
                    return variableClase.type;
                } else {
                    throw new RuntimeException("La clase => " + ctx.IDENTIFIER().get(0).getText() + " <= no tiene el atributo => " + ctx.IDENTIFIER().get(1).getText() + " <=");
                }
            } else {
                throw new RuntimeException("La variable => " + ctx.IDENTIFIER().get(0).getText() + " <= no existe");
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
        return "orsymbol";
    }

    @Override
    public Object visitAmpertonROAST(myParser.AmpertonROASTContext ctx) {
        return "amperton";
    }

    @Override
    public Object visitSmallerROAST(myParser.SmallerROASTContext ctx) {
        return "smaller";
    }

    @Override
    public Object visitGreatherROAST(myParser.GreatherROASTContext ctx) {
        return "greather";
    }

    @Override
    public Object visitEqualsROAST(myParser.EqualsROASTContext ctx) {
        return "equals";
    }

    @Override
    public Object visitDifferentROAST(myParser.DifferentROASTContext ctx) {
        return "different";
    }

    @Override
    public Object visitSmallerEqualROAST(myParser.SmallerEqualROASTContext ctx) {
        return "smallerequal";
    }

    @Override
    public Object visitGreatherEqualROAST(myParser.GreatherEqualROASTContext ctx) {
        return "greatherequal";
    }

    @Override
    public Object visitMasAdditOPAST(myParser.MasAdditOPASTContext ctx) {
        return "mas";
    }

    @Override
    public Object visitMinusAdditOPAST(myParser.MinusAdditOPASTContext ctx) {
        return "minus";
    }

    @Override
    public Object visitOrAdditOPAST(myParser.OrAdditOPASTContext ctx) {
        return "or";
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
                if (!tipoExpression.equals("int")) {
                    throw new RuntimeException(tipoExpression + " <= fue encontrado y se requiere un entero");
                }
            }
            return "int";
        } else {
            for (myParser.ExpressionContext expression : ctx.expression()) {
                String tipoExpression = (String) this.visit(expression);
                if (!tipoExpression.equals("boolean")) {
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
        return "real";
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
    public Object visitCharLiteralLAST(myParser.CharLiteralLASTContext ctx) {
        return "char";
    }

    @Override
    public Object visitAllocationExpressionAST(myParser.AllocationExpressionASTContext ctx) {
        if (ct.tablaClassDeclaration.retrieveNode(ctx.IDENTIFIER().getText()) != null) {
            return ctx.IDENTIFIER().getText();
        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " <= no es una clase declarada");
        }
    }

    @Override
    public Object visitArrayAllocationExpressionAST(myParser.ArrayAllocationExpressionASTContext ctx) {
        //En caso de dar problemas, hay que agregar un [] al final de este string.

        String tipoSimpleAsignacion = (String) this.visit(ctx.simpleType());
        String tipoExpression = (String) this.visit(ctx.expression());
        if (!tipoExpression.equals("int")) {
            throw new RuntimeException("La dimension del arreglo debe ser un int pero se obtuvo => " + tipoExpression + " <=");
        }
        return tipoSimpleAsignacion;
    }

    @Override
    public Object visitSubExpressionAST(myParser.SubExpressionASTContext ctx) {
        String tipo = (String) this.visit(ctx.expression());
        return tipo;
    }

    @Override
    public Object visitFunctionCallAST(myParser.FunctionCallASTContext ctx) {
        nodoFuncion funcion = ct.tablaFunciones.retrieveNode(ctx.IDENTIFIER().getText());
        if (funcion != null) {

            if (ctx.actualParams() != null) {
                this.visit(ctx.actualParams());
            }else if(funcion.parametros.size() != 0){
                throw new RuntimeException("La funcion tiene: " + funcion.parametros.size() + " parametros, pero recibi??: 0 argumentos.");
            }
            return funcion.type;

        } else {
            throw new RuntimeException(ctx.IDENTIFIER().getText() + " => no existe esta funcion");
        }
    }

    @Override
    public Object visitActualParamsAST(myParser.ActualParamsASTContext ctx) {
        nodoFuncion funcion = ct.tablaFunciones.retrieveNode(((myParser.FunctionCallASTContext) ctx.parent).IDENTIFIER().getText());

        if (funcion.parametros.size() == ctx.expression().size()) {
            for (int i = 0; i < ctx.expression().size(); i++) {
                String tipoParametroFuncion = funcion.parametros.get(i).type;
                String tipoExpressionArgumento = (String) this.visit(ctx.expression().get(i));

                if (!tipoParametroFuncion.equals(tipoExpressionArgumento)) {
                    throw new RuntimeException("La funcion => " + funcion.tok.getText() + " <= espera => " + tipoParametroFuncion + " <= y obtuvo => " + tipoExpressionArgumento + " <=");
                }
            }
        } else {
            throw new RuntimeException("La funcion tiene: " + funcion.parametros.size() + " parametros, pero recibi??: " + ctx.expression().size() + " argumentos.");
        }
        return null;
    }

    @Override
    public Object visitArrayLookupAST(myParser.ArrayLookupASTContext ctx) {
        nodoVariable tipoAsignacion = ct.tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER().getText());
        if (tipoAsignacion != null) {
            this.visit(ctx.expression());
            return tipoAsignacion.type;
        } else {
            throw new RuntimeException("=> " + ctx.IDENTIFIER().getText() + " <= no es una variable definida.");
        }
    }

    @Override
    public Object visitArrayLengthAST(myParser.ArrayLengthASTContext ctx) {
        nodoVariable variable = ct.tablaVarDeclaration.retrieveNode(ctx.IDENTIFIER().getText());
        if (variable != null) {
            return "int";
        } else {
            throw new RuntimeException("=> " + ctx.IDENTIFIER().getText() + " <= no es una variable declarada");
        }
    }


}