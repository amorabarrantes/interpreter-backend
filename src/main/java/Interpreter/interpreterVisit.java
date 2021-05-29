package Interpreter;

import com.example.interpreterbackend.claseTablas;
import contextAnalysis.nodoClase;
import contextAnalysis.nodoFuncion;
import contextAnalysis.nodoVariable;
import generated.myParser;
import generated.myParserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.Objects;

public class interpreterVisit extends myParserBaseVisitor<Object> {

    claseTablas ct = claseTablas.getIsntance();
    public String varErrores;


    @Override
    public Object visitProgramAST(myParser.ProgramASTContext ctx) {
        try {
            for (myParser.StatementContext statement : ctx.statement())
                this.visit(statement);
            return null;
        } catch (RuntimeException e) {
            varErrores = e.getMessage();
            System.out.println(varErrores);
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

        boolean flag = false;
        for (ParseTree child : ctx.children) {
            if (child instanceof myParser.BlockASTContext) {
                myParser.BlockASTContext blockChild = (myParser.BlockASTContext) child;
                for (ParserRuleContext statement : blockChild.statement()) {
                    if (statement instanceof myParser.ReturnSTASTContext) {
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

        nodoValorClase clase = new nodoValorClase(ctx.IDENTIFIER().getText(), ct.tablaNodoValorClase.nivel, new ArrayList<>());
        ct.tablaNodoValorClase.enter(clase);

        if (ctx.classVariableDecl().size() > 0) {
            for (myParser.ClassVariableDeclContext classVar : ctx.classVariableDecl()) {
                String clave = classVar.getChild(1).getText();
                Object valor = this.visit(classVar);
                String type = classVar.getChild(0).getText();

                clase.atributos.add(new nodoValorVariable(clave, ct.tablaNodoValorVariable.nivel, type, valor));
            }
        }

        ct.tablaNodoValorClase.imprimirNodoValorClase();
        return null;
    }

    @Override
    public Object visitClassVarDecAST(myParser.ClassVarDecASTContext ctx) {
        if (ctx.expression() != null) {
            return this.visit(ctx.expression());
        } else {
            String type = ctx.simpleType().getText();
            switch (type) {
                case "int":
                    return 0;
                case "boolean":
                    return false;
                case "string":
                default:
                    return "";
            }
        }
    }

    @Override
    public Object visitVarDecAST(myParser.VarDecASTContext ctx) {
        String type = (String) this.visit(ctx.type());

        if (ctx.expression() != null) {
            Object valorExpression = this.visit(ctx.expression());


            switch (type) {
                case "int":
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, Integer.parseInt((String) valorExpression)));
                    break;
                case "string":
                    String subString = ((String) valorExpression).replace("\"", "");
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, subString));
                    break;
                case "boolean":
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, Boolean.parseBoolean((String) valorExpression)));
                    break;
                case "char":
                    String subChar = ((String) valorExpression).replace("'", "");
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, subChar.charAt(0)));
                    break;

                case "int[]":
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, new int[Integer.parseInt((String) valorExpression)]));
                    break;
                case "boolean[]":
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, new boolean[Integer.parseInt((String) valorExpression)]));
                    break;
                case "string[]":
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, new String[Integer.parseInt((String) valorExpression)]));
                    break;
                case "char[]":
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, new char[Integer.parseInt((String) valorExpression)]));
                    break;
                default:
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, (nodoValorClase) valorExpression));
                    break;
            }
        } else {
            ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, null));
        }
        ct.tablaNodoValorVariable.imprimirNodoValorVariables();
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
        return ctx.IDENTIFIER().getText();
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
        return type + "[]";
    }

    @Override
    public Object visitAssignAST(myParser.AssignASTContext ctx) {
        if (ctx.IDENTIFIER().size() == 1) {
            String valorExpression = (String) this.visit(ctx.expression());
            nodoValorVariable variable = ct.tablaNodoValorVariable.retrieveNode(ctx.IDENTIFIER(0).getText());

            String type = variable.type;
            switch (type) {
                case "int":
                    variable.valor = Integer.parseInt(valorExpression);
                    break;
                case "string":
                    variable.valor = valorExpression.replace("\"", "");
                    break;
                case "boolean":
                    variable.valor = Boolean.parseBoolean(valorExpression);
                    break;
                case "char":
                    variable.valor = valorExpression.replace("'", "");
                    break;
            }
            return null;

        } else {

            nodoValorVariable variable = ct.tablaNodoValorVariable.retrieveNode(ctx.IDENTIFIER(0).getText());
            nodoValorVariable atributo = ((nodoValorClase)variable.valor).buscarVariableClase(ctx.IDENTIFIER(1).getText());
            String valorExpression = (String) this.visit(ctx.expression());


            switch (atributo.type) {
                case "int":
                    atributo.valor = Integer.parseInt(valorExpression);
                    break;
                case "string":
                    atributo.valor = valorExpression.replace("\"", "");
                    break;
                case "boolean":
                    atributo.valor = Boolean.parseBoolean(valorExpression);
                    break;
                case "char":
                    atributo.valor = valorExpression.replace("'", "");
                    break;
            }
            return null;
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
                    throw new RuntimeException(ctx.IDENTIFIER().getText() + " espera => " + busqueda.type + " pero recibió => " + tipoExpression2);
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
        Object tipoSimpleExpression = this.visit(ctx.simpleExpression(0));

        if (ctx.simpleExpression().size() == 1) {
            return tipoSimpleExpression;
        } else {
            for (int i = 1; i < ctx.simpleExpression().size(); i++) {
                String tipoRelationOP = (String) this.visit(ctx.relationalOp(i - 1));
                String tipoSimpleExpressionAuxiliar = (String) this.visit(ctx.simpleExpression(i));
            }
            return null;
        }
    }

    @Override
    public Object visitSimpleExpressionAST(myParser.SimpleExpressionASTContext ctx) {
        Object tipoTermino = this.visit(ctx.term(0));

        if (ctx.term().size() == 1) {
            return tipoTermino;
        } else {

            String additiveAux = (String) this.visit(ctx.additiveOp(0));
            String termAux = (String) this.visit(ctx.term(1));

            for (int i = 1; i < ctx.term().size(); i++) {
                String tipoAdditive = (String) this.visit(ctx.additiveOp(i - 1));
                String tipoTerminoAuxiliar = (String) this.visit(ctx.term(i));
            }
            return null;
        }

    }

    @Override
    public Object visitTermAST(myParser.TermASTContext ctx) {
        Object tipoFactor = this.visit(ctx.factor(0));

        if (ctx.factor().size() != 1) {
            for (int i = 1; i < ctx.factor().size(); i++) {
                String tipoMultiplicative = (String) this.visit(ctx.multiplicativeOP(i - 1));
                String tipoFactorAuxiliar = (String) this.visit(ctx.factor(i));
            }
        }
        return tipoFactor;
    }

    @Override
    public Object visitLiteralFAST(myParser.LiteralFASTContext ctx) {
        Object tipoLiteral = this.visit(ctx.literal());
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
        Object tipoArrayAllocation = this.visit(ctx.arrayAllocationExpression());
        return tipoArrayAllocation;
    }

    @Override
    public Object visitAllocationExpressionFAST(myParser.AllocationExpressionFASTContext ctx) {
        Object tipoAllocationExpression = this.visit(ctx.allocationExpression());
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
        return ctx.INTLITERAL().getText();

    }

    @Override
    public Object visitRealLiteralLAST(myParser.RealLiteralLASTContext ctx) {
        return ctx.REALLITERAL().getText();
    }

    @Override
    public Object visitBoolLiteralLAST(myParser.BoolLiteralLASTContext ctx) {
        return ctx.BOOLLITERAL().getText();
    }

    @Override
    public Object visitStringLiteralLAST(myParser.StringLiteralLASTContext ctx) {
        return ctx.STRINGLITERAL().getText();
    }

    @Override
    public Object visitCharLiteralLAST(myParser.CharLiteralLASTContext ctx) {
        return ctx.CHARLITERAL().getText();
    }

    @Override
    public Object visitAllocationExpressionAST(myParser.AllocationExpressionASTContext ctx){
        nodoValorClase clase = ct.tablaNodoValorClase.retrieveNode(ctx.IDENTIFIER().getText());

        ArrayList<nodoValorVariable> arrayAux = new ArrayList<>();
        for (nodoValorVariable obj: clase.atributos) {
            arrayAux.add(new nodoValorVariable(obj.identifier, obj.nivel, obj.type, obj.valor));
        }

        nodoValorClase instancia = new nodoValorClase(clase.identifier, clase.nivel, arrayAux);
        return instancia;
    }

    @Override
    public Object visitArrayAllocationExpressionAST(myParser.ArrayAllocationExpressionASTContext ctx) {
        Object valorExpression = this.visit(ctx.expression());
        return valorExpression;
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
            throw new RuntimeException("La funcion tiene: " + funcion.parametros.size() + " parametros, pero recibió: " + ctx.expression().size() + " argumentos.");
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
