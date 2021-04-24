package contextAnalysis;

import generated.myParser;
import generated.myParserBaseVisitor;
import org.antlr.runtime.CommonToken;

import java.util.LinkedList;


public class AnalisisContextual extends myParserBaseVisitor <Object>{
    private identificationTable tabla = new identificationTable(new LinkedList<>(),0);


    @Override
    public Object visitProgramAST(myParser.ProgramASTContext ctx) {
        try {
            for (myParser.StatementContext statement: ctx.statement())
                this.visit(statement);
            return null;
        }catch (RuntimeException e){
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
        for (myParser.StatementContext statement: ctx.statement())
            this.visit(statement);
        return null;
    }

    @Override
    public Object visitFunctionDecAST(myParser.FunctionDecASTContext ctx) {
        this.visit(ctx.type());
        if(ctx.formalParams() != null) 
            this.visit(ctx.formalParams());
        this.visit(ctx.block());
        return null;
    }

    @Override
    public Object visitFormalParamsAST(myParser.FormalParamsASTContext ctx) {
        for (myParser.FormalParamContext param: ctx.formalParam())
            this.visit(param);
        return null;
    }

    @Override
    public Object visitFormalParamAST(myParser.FormalParamASTContext ctx) {
        this.visit(ctx.type());
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
        if(ctx.block(1) != null) {
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
        for(myParser.ClassVariableDeclContext classVar: ctx.classVariableDecl())
            this.visit(classVar);
        return null;
    }

    @Override
    public Object visitClassVarDecAST(myParser.ClassVarDecASTContext ctx) {
        String type = (String) this.visit(ctx.simpleType());

        if(ctx.expression() != null)    //En este if hay que comprobar que la asignacion sea compatible con el tipo.
            this.visit(ctx.expression());

        return type;
    }

    @Override
    public Object visitVarDecAST(myParser.VarDecASTContext ctx) {
        String type = (String) this.visit(ctx.type());
        if (tabla.retrieve(ctx.IDENTIFIER().getText()) == null){
            tabla.enter(ctx.IDENTIFIER().getSymbol(),type, tabla.nivel, ctx);
        }else
            throw new RuntimeException(ctx.IDENTIFIER().getText() +": es una variable ya existente");
        if(ctx.expression() != null)
            this.visit(ctx.expression());
        tabla.imprimir();
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
        if (tabla.retrieve(ctx.IDENTIFIER().getText()) != null)
            return  idType;
        else
            throw new RuntimeException(ctx.IDENTIFIER().getText()+": como tipo de dato no existe");
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
        this.visit(ctx.simpleExpression(0));
        for (int i = 1; i < ctx.simpleExpression().size(); i++) {
            this.visit(ctx.relationalOp(i-1));
            this.visit(ctx.simpleExpression(i));
        }
        return null;
    }

    @Override
    public Object visitSimpleExpressionAST(myParser.SimpleExpressionASTContext ctx) {
        this.visit(ctx.term(0));
        for (int i = 1; i < ctx.additiveOp().size(); i++) {
            this.visit(ctx.additiveOp(i-1));
            this.visit(ctx.term(i));
        }
        return null;
    }

    @Override
    public Object visitTermAST(myParser.TermASTContext ctx) {
        this.visit(ctx.factor(0));

        for (int i = 1; i < ctx.factor().size(); i++) {
            this.visit(ctx.multiplicativeOP(i-1));
            this.visit(ctx.factor(i));
        }
        return null;
    }

    @Override
    public Object visitLiteralFAST(myParser.LiteralFASTContext ctx) {
        this.visit(ctx.literal());
        return null;
    }

    @Override
    public Object visitIdFAST(myParser.IdFASTContext ctx) {
        return null;
    }

    @Override
    public Object visitFunctionCallFAST(myParser.FunctionCallFASTContext ctx) {
        this.visit(ctx.functionCall());
        return null;
    }

    @Override
    public Object visitArrayLookUpFAST(myParser.ArrayLookUpFASTContext ctx) {
        this.visit(ctx.arrayLookup());
        return null;
    }

    @Override
    public Object visitArrayLengthFAST(myParser.ArrayLengthFASTContext ctx) {
        this.visit(ctx.arrayLength());
        return null;
    }

    @Override
    public Object visitSubExpressionFAST(myParser.SubExpressionFASTContext ctx) {
        this.visit(ctx.subExpression());
        return null;
    }

    @Override
    public Object visitArrayAllocationExpressionFAST(myParser.ArrayAllocationExpressionFASTContext ctx) {
        this.visit(ctx.arrayAllocationExpression());
        return null;
    }

    @Override
    public Object visitAllocationExpressionFAST(myParser.AllocationExpressionFASTContext ctx) {
        this.visit(ctx.allocationExpression());
        return null;
    }

    @Override
    public Object visitUnaryFAST(myParser.UnaryFASTContext ctx) {
        this.visit(ctx.unary());
        return null;
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
        return null;
    }

    @Override
    public Object visitDivMultOPAST(myParser.DivMultOPASTContext ctx) {
        return null;
    }

    @Override
    public Object visitAndMultOPAST(myParser.AndMultOPASTContext ctx) {
        return null;
    }

    @Override
    public Object visitUnaryAST(myParser.UnaryASTContext ctx) {
        for (myParser.ExpressionContext expression: ctx.expression()){
            this.visit(expression);
        }
        return null;
    }

    @Override
    public Object visitIntLiteralLAST(myParser.IntLiteralLASTContext ctx) {
        return null;
    }

    @Override
    public Object visitRealLiteralLAST(myParser.RealLiteralLASTContext ctx) {
        return null;
    }

    @Override
    public Object visitBoolLiteralLAST(myParser.BoolLiteralLASTContext ctx) {
        return null;
    }

    @Override
    public Object visitStringLiteralLAST(myParser.StringLiteralLASTContext ctx) {
        return null;
    }

    @Override
    public Object visitAllocationExpressionAST(myParser.AllocationExpressionASTContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayAllocationExpressionAST(myParser.ArrayAllocationExpressionASTContext ctx) {
        this.visit(ctx.simpleType());
        this.visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitSubExpressionAST(myParser.SubExpressionASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitFunctionCallAST(myParser.FunctionCallASTContext ctx) {
        if(ctx.actualParams() != null)
            this.visit(ctx.actualParams());
        return null;
    }

    @Override
    public Object visitActualParamsAST(myParser.ActualParamsASTContext ctx) {
        for (myParser.ExpressionContext expression: ctx.expression())
            this.visit(expression);
        return null;
    }

    @Override
    public Object visitArrayLookupAST(myParser.ArrayLookupASTContext ctx) {
        this.visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitArrayLengthAST(myParser.ArrayLengthASTContext ctx) {
        return null;
    }
}
