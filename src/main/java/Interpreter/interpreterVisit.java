package Interpreter;

import com.example.interpreterbackend.claseTablas;
import generated.myParser;
import generated.myParserBaseVisitor;

import java.util.ArrayList;

public class interpreterVisit extends myParserBaseVisitor<Object> {

    claseTablas ct = claseTablas.getIsntance();
    public String varErroresInterprete;
    public String printMessage = "";

    public ArrayList<String> listaImpresion = new ArrayList<>();


    @Override
    public Object visitProgramAST(myParser.ProgramASTContext ctx) {
        try {
            for (myParser.StatementContext statement : ctx.statement())
                this.visit(statement);
            return null;
        } catch (RuntimeException e) {
            varErroresInterprete = e.getMessage();
            System.out.println(varErroresInterprete);
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

        Object valor = this.visit(ctx.block());
        return valor;
    }

    @Override
    public Object visitBlockAST(myParser.BlockASTContext ctx) {

        ct.tablaNodoValorVariable.openScope();
        ct.tablaNodoValorClase.openScope();
        ct.tablaNodoValorFuncion.openScope();

        for (myParser.StatementContext statement : ctx.statement()) {
            if(ctx.statement().indexOf(statement) == (ctx.statement().size() -1) && statement.getClass().toString().contains("eturn")){
                myParser.ReturnSTASTContext retornoS = (myParser.ReturnSTASTContext) statement;
                myParser.ReturnASTContext retorno = (myParser.ReturnASTContext) retornoS.returnStatement();
                Object valorExpresion = this.visit(retorno);

                return valorExpresion;


            }else{
                this.visit(statement);
            }

        }


        ct.tablaNodoValorFuncion.closeScope();
        ct.tablaNodoValorClase.closeScope();
        ct.tablaNodoValorVariable.closeScope();

        return null;
    }

    @Override
    public Object visitFunctionDecAST(myParser.FunctionDecASTContext ctx) {
        String tipoDatoFuncion = (String) this.visit(ctx.type());

        //if (ctx.formalParams() != null)
        //    this.visit(ctx.formalParams());

        //this.visit(ctx.block());

        ct.tablaNodoValorFuncion.enter(new nodoValorFuncion(ctx.IDENTIFIER().getText(), ct.tablaNodoValorFuncion.nivel, tipoDatoFuncion, ctx));

        //ct.tablaNodoValorFuncion.imprimirNodoValorFuncion();
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
        nodoValorFuncion nodo = ct.tablaNodoValorFuncion.retrieveNode(nombreFuncion);

        nodoValorVariable parametroFuncion = new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel + 1, type, null); //Se crea la variable del parametro
        ct.tablaNodoValorVariable.enter(parametroFuncion); //Se inserta la variable en la tabla de variables del interpreter.
        nodo.listaParametros.add(parametroFuncion); //Se inserta esta variable en la lista de parametros de la funcion
        return null;
    }

    @Override
    public Object visitWhileAST(myParser.WhileASTContext ctx) {
        Boolean condicionBoolean = (Boolean) this.visit(ctx.expression());
        while (condicionBoolean) {
            this.visit(ctx.block());
            condicionBoolean = (Boolean) this.visit(ctx.expression());
        }
        return null;
    }

    @Override
    public Object visitIfAST(myParser.IfASTContext ctx) {
        Boolean valorExpression = (Boolean) this.visit(ctx.expression());

        if (valorExpression) {
            this.visit(ctx.block(0));
        } else {
            if (ctx.block(1) != null) {
                this.visit(ctx.block(1));
            }
        }
        return null;
    }

    @Override
    public Object visitReturnAST(myParser.ReturnASTContext ctx) {
        Object retorno = this.visit(ctx.expression());
        return retorno;
    }

    @Override
    public Object visitPrintAST(myParser.PrintASTContext ctx) {
        listaImpresion.add(this.visit(ctx.expression()).toString());
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

        //ct.tablaNodoValorClase.imprimirNodoValorClase();
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
                case "real":
                    return 0.0;
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

                    String auxInt = valorExpression.toString();
                    String[] auxInt2 = auxInt.split("\\.");
                    String auxInt3 = auxInt2[0];
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, Integer.parseInt(auxInt3)));
                    break;
                case "real":
                    String floatAux = valorExpression.toString();
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, Double.parseDouble(floatAux)));
                    break;
                case "string":
                    String subString = ((String) valorExpression).replace("\"", "");
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, subString));
                    break;
                case "boolean":
                    String auxBoolean = valorExpression.toString();
                    ct.tablaNodoValorVariable.enter(new nodoValorVariable(ctx.IDENTIFIER().getText(), ct.tablaNodoValorVariable.nivel, type, Boolean.parseBoolean(auxBoolean)));
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
        //ct.tablaNodoValorVariable.imprimirNodoValorVariables();

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
    public Object visitRealSimpleTAST(myParser.RealSimpleTASTContext ctx) {
        return "real";
    }

    @Override
    public Object visitArrayTypeAST(myParser.ArrayTypeASTContext ctx) {
        String type = (String) this.visit(ctx.simpleType());
        return type + "[]";
    }

    @Override
    public Object visitAssignAST(myParser.AssignASTContext ctx) {
        if (ctx.IDENTIFIER().size() == 1) {
            Object valorExpression = this.visit(ctx.expression());
            nodoValorVariable variable = ct.tablaNodoValorVariable.retrieveNode(ctx.IDENTIFIER(0).getText());

            String type = variable.type;
            switch (type) {
                case "int":
                    String auxInt = valorExpression.toString();
                    String[] auxInt2 = auxInt.split("\\.");
                    String auxInt3 = auxInt2[0];
                    variable.valor = Integer.parseInt(auxInt3);
                    break;
                case "real":
                    variable.valor = Double.parseDouble(valorExpression.toString());
                    break;
                case "string":
                    variable.valor = valorExpression.toString().replace("\"", "");
                    break;
                case "boolean":
                    variable.valor = Boolean.parseBoolean(valorExpression.toString());
                    break;
                case "char":
                    variable.valor = valorExpression.toString().replace("'", "");
                    break;
            }
            //ct.tablaNodoValorVariable.imprimirNodoValorVariables();
            return null;

        } else {

            nodoValorVariable variable = ct.tablaNodoValorVariable.retrieveNode(ctx.IDENTIFIER(0).getText());
            nodoValorVariable atributo = ((nodoValorClase) variable.valor).buscarVariableClase(ctx.IDENTIFIER(1).getText());
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
        int indice = Integer.parseInt((String) this.visit(ctx.expression(0)));

        String valorAsignacion = this.visit(ctx.expression(1)).toString();

        nodoValorVariable varArray = ct.tablaNodoValorVariable.retrieveNode(ctx.IDENTIFIER().getText());
        String type = varArray.type;


        switch (type) {
            case "int[]":
                int[] var = ((int[]) varArray.valor);
                if (indice >= var.length || indice < 0) {
                    throw new RuntimeException("El indice => " + indice + " <= esta fuera de las dimensiones del array => " + varArray.identifier + " <=");
                } else {
                    ((int[]) varArray.valor)[indice] = Integer.parseInt(valorAsignacion);
                    break;
                }
            case "boolean[]":
                int[] var2 = ((int[]) varArray.valor);
                if (indice >= var2.length || indice < 0) {
                    throw new RuntimeException("El indice => " + indice + " <= esta fuera de las dimensiones del array => " + varArray.identifier + " <=");
                } else {
                    ((boolean[]) varArray.valor)[indice] = Boolean.parseBoolean(valorAsignacion);
                    break;
                }
            case "string[]":
                int[] var3 = ((int[]) varArray.valor);

                if (indice >= var3.length || indice < 0) {
                    throw new RuntimeException("El indice => " + indice + " <= esta fuera de las dimensiones del array => " + varArray.identifier + " <=");
                } else {
                    ((String[]) varArray.valor)[indice] = valorAsignacion;
                    break;
                }
            case "char[]":
                int[] var4 = ((int[]) varArray.valor);
                if (indice >= var4.length || indice < 0) {
                    throw new RuntimeException("El indice => " + indice + " <= esta fuera de las dimensiones del array => " + varArray.identifier + " <=");
                } else {
                    ((char[]) varArray.valor)[indice] = valorAsignacion.charAt(0);
                    break;
                }
        }
        //ct.tablaNodoValorVariable.imprimirNodoValorVariables();
        return null;

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

                switch (tipoRelationOP) {
                    case "equals":
                        boolean tipoSimpleExpressionAux = tipoSimpleExpression.toString().equals(tipoSimpleExpressionAuxiliar.toString());
                        tipoSimpleExpression = tipoSimpleExpressionAux;
                        break;
                    case "different":
                        boolean tipoSimpleExpressionAux2 = !(tipoSimpleExpression.toString().equals(tipoSimpleExpressionAuxiliar.toString()));
                        tipoSimpleExpression = tipoSimpleExpressionAux2;
                        break;
                    case "smaller":
                        boolean tipoSimpleExpressionAux3 = Double.parseDouble(tipoSimpleExpression.toString()) < Double.parseDouble(tipoSimpleExpressionAuxiliar.toString());
                        tipoSimpleExpression = tipoSimpleExpressionAux3;
                        break;
                    case "greather":
                        boolean tipoSimpleExpressionAux4 = Double.parseDouble(tipoSimpleExpression.toString()) > Double.parseDouble(tipoSimpleExpressionAuxiliar.toString());
                        tipoSimpleExpression = tipoSimpleExpressionAux4;
                        break;
                    case "smallerequal":
                        boolean tipoSimpleExpressionAux5 = Double.parseDouble(tipoSimpleExpression.toString()) <= Double.parseDouble(tipoSimpleExpressionAuxiliar.toString());
                        tipoSimpleExpression = tipoSimpleExpressionAux5;
                        break;
                    case "greatherequal":
                        boolean tipoSimpleExpressionAux6 = Double.parseDouble(tipoSimpleExpression.toString()) >= Double.parseDouble(tipoSimpleExpressionAuxiliar.toString());
                        tipoSimpleExpression = tipoSimpleExpressionAux6;
                        break;
                    case "orsymbol":
                        boolean tipoSimpleExpressionAux7 = Boolean.parseBoolean(tipoSimpleExpression.toString()) || Boolean.parseBoolean(tipoSimpleExpressionAuxiliar.toString());
                        tipoSimpleExpression = tipoSimpleExpressionAux7;
                        break;
                    case "amperton":
                        boolean tipoSimpleExpressionAux8 = Boolean.parseBoolean(tipoSimpleExpression.toString()) && Boolean.parseBoolean(tipoSimpleExpressionAuxiliar.toString());
                        tipoSimpleExpression = tipoSimpleExpressionAux8;
                        break;
                }

            }
            return tipoSimpleExpression;
        }
    }

    @Override
    public Object visitSimpleExpressionAST(myParser.SimpleExpressionASTContext ctx) {
        Object tipoTermino = this.visit(ctx.term(0));


        if (ctx.term().size() == 1) {
            return tipoTermino;
        } else {
            for (int i = 1; i < ctx.term().size(); i++) {
                String tipoAdditive = (String) this.visit(ctx.additiveOp(i - 1));
                Object tipoTerminoAuxiliar = this.visit(ctx.term(i));

                switch (tipoAdditive) {
                    case "mas":
                        Double tipoTerminoAux = Double.parseDouble(tipoTermino.toString()) + Double.parseDouble(tipoTerminoAuxiliar.toString());
                        tipoTermino = tipoTerminoAux;
                        break;
                    case "minus":
                        Double tipoTerminoAux2 = Double.parseDouble(tipoTermino.toString()) - Double.parseDouble(tipoTerminoAuxiliar.toString());
                        tipoTermino = tipoTerminoAux2;
                        break;
                    case "or":
                        if (Boolean.parseBoolean(tipoTermino.toString()) || Boolean.parseBoolean(tipoTerminoAuxiliar.toString())) {
                            tipoTermino = "true";
                        } else {
                            tipoTermino = "false";
                        }
                        break;
                }
            }
            return tipoTermino;
        }

    }

    @Override
    public Object visitTermAST(myParser.TermASTContext ctx) {

        Object tipoFactor = this.visit(ctx.factor(0));

        if (ctx.factor().size() != 1) {
            for (int i = 1; i < ctx.factor().size(); i++) {
                String tipoMultiplicative = this.visit(ctx.multiplicativeOP(i - 1)).toString();
                String tipoFactorAuxiliar = this.visit(ctx.factor(i)).toString();

                switch (tipoMultiplicative) {
                    case "mul":
                        Double tipoFactorAux = Double.parseDouble(tipoFactor.toString()) * Double.parseDouble(tipoFactorAuxiliar);
                        tipoFactor = tipoFactorAux;
                        break;
                    case "div":
                        Double tipoFactorAux2 = Double.parseDouble(tipoFactor.toString()) / Double.parseDouble(tipoFactorAuxiliar);
                        tipoFactor = tipoFactorAux2;
                        break;
                    case "and":
                        if (Boolean.parseBoolean(tipoFactor.toString()) && Boolean.parseBoolean(tipoFactorAuxiliar)) {
                            tipoFactor = "true";
                        } else {
                            tipoFactor = "false";
                        }
                        break;
                }
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
            return ct.tablaNodoValorVariable.retrieveNode(ctx.IDENTIFIER(0).getText()).valor;
        } else {//Asignacion de una variable de tipo clase.
            nodoValorClase clase = (nodoValorClase) ct.tablaNodoValorVariable.retrieveNode(ctx.IDENTIFIER(0).getText()).valor;
            nodoValorVariable atributo = clase.buscarVariableClase(ctx.IDENTIFIER(1).getText());
            return atributo.valor;
        }
    }

    @Override
    public Object visitFunctionCallFAST(myParser.FunctionCallFASTContext ctx) {
        Object valor = this.visit(ctx.functionCall());
        return valor;
    }

    @Override
    public Object visitArrayLookUpFAST(myParser.ArrayLookUpFASTContext ctx) {
        Object tipoArreglo = this.visit(ctx.arrayLookup());
        return tipoArreglo;
    }

    @Override
    public Object visitArrayLengthFAST(myParser.ArrayLengthFASTContext ctx) {
        Object valorArrayLength = this.visit(ctx.arrayLength());
        return valorArrayLength;
    }

    @Override
    public Object visitSubExpressionFAST(myParser.SubExpressionFASTContext ctx) {
        Object tipoSubExpression = this.visit(ctx.subExpression());
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
        Object tipoUnary = this.visit(ctx.unary());
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
        if (ctx.MAS() != null) {
            String valorExpression = (String) this.visit(ctx.expression(0));
            return valorExpression;
        } else if (ctx.MINUS() != null) {
            int valorExpressionAux = Integer.parseInt(this.visit(ctx.expression(0)).toString());
            String valorExpression = Integer.toString(valorExpressionAux * -1);
            return valorExpression;
        } else {
            Boolean valorExpressionAux = Boolean.parseBoolean(this.visit(ctx.expression(0)).toString());
            String valorExpression = Boolean.toString(!valorExpressionAux);
            return valorExpression;
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
    public Object visitAllocationExpressionAST(myParser.AllocationExpressionASTContext ctx) {
        nodoValorClase clase = ct.tablaNodoValorClase.retrieveNode(ctx.IDENTIFIER().getText());

        ArrayList<nodoValorVariable> arrayAux = new ArrayList<>();
        for (nodoValorVariable obj : clase.atributos) {
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
        Object valor = this.visit(ctx.expression());
        return valor;
    }

    @Override
    public Object visitFunctionCallAST(myParser.FunctionCallASTContext ctx) {

        nodoValorFuncion funcion = ct.tablaNodoValorFuncion.retrieveNode(ctx.IDENTIFIER().getText());

        if (ctx.actualParams() != null) {

            this.visit(funcion.declCtx.formalParams()); //Se visitan los parametros de la funcion para guardarlos como variables

            this.visit(ctx.actualParams()); //Se visitan los argumentos para asignarselos a los parametros de la funcion


        }

        System.out.println("si");
        Object retorno = this.visit(funcion.declCtx.block()); //Se ejecuta el bloque de la funcion
        System.out.println("no");


        return retorno;
    }

    @Override
    public Object visitActualParamsAST(myParser.ActualParamsASTContext ctx) {

        nodoValorFuncion funcion = ct.tablaNodoValorFuncion.retrieveNode(((myParser.FunctionCallASTContext) ctx.parent).IDENTIFIER().getText());
        for (int i = 0; i < ctx.expression().size(); i++) {
            Object valorArgumentoSubI = this.visit(ctx.expression().get(i));
            nodoValorVariable parametro = funcion.listaParametros.get(i);
            String type = parametro.type;
            switch (type) {
                case "int":

                    String auxInt = valorArgumentoSubI.toString();
                    if(auxInt.contains(".")){
                        String[] auxInt2 = auxInt.split("\\.");
                        String auxInt3 = auxInt2[0];
                        parametro.valor = Integer.parseInt(auxInt3);
                    }else{
                        parametro.valor = Integer.parseInt(valorArgumentoSubI.toString());
                    }
                    break;
                case "real":
                    parametro.valor = Double.parseDouble(valorArgumentoSubI.toString());
                    break;
                case "string":
                    String subString = ((String) valorArgumentoSubI).replace("\"", "");
                    parametro.valor = subString;
                    break;
                case "boolean":
                    parametro.valor = Boolean.parseBoolean(valorArgumentoSubI.toString());
                    break;
                case "char":
                    String subChar = ((String) valorArgumentoSubI).replace("'", "");
                    parametro.valor = subChar.charAt(0);
                    break;
                case "int[]":
                    int[] listaInt = (int[])valorArgumentoSubI;
                    parametro.valor = listaInt;
                    break;
                case "boolean[]":
                    boolean[] listaBoolean = (boolean[])valorArgumentoSubI;
                    parametro.valor = listaBoolean;
                    break;
                case "string[]":
                    String[] listaString = (String[])valorArgumentoSubI;
                    parametro.valor = listaString;
                    break;
                case "char[]":
                    char[] listaChar = (char[])valorArgumentoSubI;
                    parametro.valor = listaChar;
                    break;
                default:
                    break;
            }

        }
        //ct.tablaNodoValorFuncion.imprimirNodoValorFuncion();

        return null;
    }

    @Override
    public Object visitArrayLookupAST(myParser.ArrayLookupASTContext ctx) {
        nodoValorVariable varArray = ct.tablaNodoValorVariable.retrieveNode(ctx.IDENTIFIER().getText());
        int indice = Integer.parseInt((String) this.visit(ctx.expression()));
        String type = varArray.type;


        int[] var = ((int[]) varArray.valor);
        if (indice >= var.length || indice < 0) {
            throw new RuntimeException("El indice => " + indice + " <= esta fuera de las dimensiones del array => " + varArray.identifier + " <=");
        }

        switch (type) {
            case "int[]":
                return ((int[]) varArray.valor)[indice];
            case "boolean[]":
                return ((boolean[]) varArray.valor)[indice];
            case "string[]":
                return ((String[]) varArray.valor)[indice];
            default:
                return ((char[]) varArray.valor)[indice];

        }
    }

    @Override
    public Object visitArrayLengthAST(myParser.ArrayLengthASTContext ctx) {
        nodoValorVariable varArray = ct.tablaNodoValorVariable.retrieveNode(ctx.IDENTIFIER().getText());
        String type = varArray.type;

        switch (type) {
            case "int[]":
                return ((int[]) varArray.valor).length;
            case "boolean[]":
                return ((boolean[]) varArray.valor).length;
            case "string[]":
                return ((String[]) varArray.valor).length;
            default:
                return ((char[]) varArray.valor).length;

        }
    }
}
