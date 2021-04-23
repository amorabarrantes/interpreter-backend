package com.example.interpreterbackend;

import generated.*;


public class PrettyPrint<Object> extends myParserBaseVisitor <Object>{
    int numTabs = 0;
    @Override
    public Object visitProgramAST(myParser.ProgramASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        for (myParser.StatementContext statement: ctx.statement())
            this.visit(statement);

        numTabs--;
        return null;
    }

    @Override
    public Object visitVarDecSTAST(myParser.VarDecSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.variableDecl());
        numTabs--;
        return null;
    }

    @Override
    public Object visitClassDecSTAST(myParser.ClassDecSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.classDeclaration());
        numTabs--;
        return null;
    }

    @Override
    public Object visitAssignSTAST(myParser.AssignSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.assignment());
        numTabs--;
        return null;
    }

    @Override
    public Object visitArrayAssignSTAST(myParser.ArrayAssignSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.arrayAssignment());
        numTabs--;
        return null;
    }

    @Override
    public Object visitPrintSTAST(myParser.PrintSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.printStatement());
        numTabs--;
        return null;
    }

    @Override
    public Object visitIfSTAST(myParser.IfSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.ifStatement());
        numTabs--;
        return null;
    }

    @Override
    public Object visitWhileSTAST(myParser.WhileSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.whileStatement());
        numTabs--;
        return null;
    }

    @Override
    public Object visitReturnSTAST(myParser.ReturnSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.returnStatement());
        numTabs--;
        return null;
    }

    @Override
    public Object visitFuncDecSTAST(myParser.FuncDecSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.functionDecl());
        numTabs--;
        return null;
    }

    @Override
    public Object visitBlockSTAST(myParser.BlockSTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.block());
        numTabs--;
        return null;
    }

    @Override
    public Object visitBlockAST(myParser.BlockASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        for (myParser.StatementContext statement: ctx.statement())
            this.visit(statement);

        numTabs--;
        return null;
    }

    @Override
    public Object visitFunctionDecAST(myParser.FunctionDecASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.type());
        if(ctx.formalParams() != null) 
            this.visit(ctx.formalParams());

        this.visit(ctx.block());
        numTabs--;
        return null;
    }

    @Override
    public Object visitFormalParamsAST(myParser.FormalParamsASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        for (myParser.FormalParamContext param: ctx.formalParam())
            this.visit(param);

        numTabs--;
        return null;
    }

    @Override
    public Object visitFormalParamAST(myParser.FormalParamASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.type());
        numTabs--;
        return null;
    }

    @Override
    public Object visitWhileAST(myParser.WhileASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.expression());
        this.visit(ctx.block());
        numTabs--;
        return null;
    }

    @Override
    public Object visitIfAST(myParser.IfASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.expression());
        this.visit(ctx.block(0));

        if(ctx.block(1) != null) {
            System.out.println("si tiene else");
            this.visit(ctx.block(1));
        }

        numTabs--;
        return null;
    }

    @Override
    public Object visitReturnAST(myParser.ReturnASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.expression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitPrintAST(myParser.PrintASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.expression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitClassDecAST(myParser.ClassDecASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        for(myParser.ClassVariableDeclContext classVar: ctx.classVariableDecl())
            this.visit(classVar);

        numTabs--;
        return null;
    }

    @Override
    public Object visitClassVarDecAST(myParser.ClassVarDecASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.simpleType());
        this.visit(ctx.expression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitVarDecAST(myParser.VarDecASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.type());
        if(ctx.expression() != null)
            this.visit(ctx.expression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitSimpleTypeTPAST(myParser.SimpleTypeTPASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.simpleType());
        numTabs--;
        return null;
    }

    @Override
    public Object visitArrayTypeTPAST(myParser.ArrayTypeTPASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.arrayType());
        numTabs--;
        return null;
    }

    @Override
    public Object visitIdTPAST(myParser.IdTPASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitBooleanSimpleTAST(myParser.BooleanSimpleTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitCharSimpleTAST(myParser.CharSimpleTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitIntSimpleTAST(myParser.IntSimpleTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitStringSimpleTAST(myParser.StringSimpleTASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitArrayTypeAST(myParser.ArrayTypeASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        this.visit(ctx.simpleType());

        return null;
    }

    @Override
    public Object visitAssignAST(myParser.AssignASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.expression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitArrayAssignAST(myParser.ArrayAssignASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.expression(0));
        this.visit(ctx.expression(1));
        numTabs--;
        return null;
    }

    @Override
    public Object visitExpressionAST(myParser.ExpressionASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.simpleExpression(0));

        for (int i = 1; i < ctx.simpleExpression().size(); i++) {
            this.visit(ctx.relationalOp(i-1));
            this.visit(ctx.simpleExpression(i));
        }
        numTabs--;
        return null;
    }

    @Override
    public Object visitSimpleExpressionAST(myParser.SimpleExpressionASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.term(0));

        for (int i = 1; i < ctx.additiveOp().size(); i++) {
            this.visit(ctx.additiveOp(i-1));
            this.visit(ctx.term(i));
        }
        numTabs--;
        return null;
    }

    @Override
    public Object visitTermAST(myParser.TermASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.factor(0));

        for (int i = 1; i < ctx.factor().size(); i++) {
            this.visit(ctx.multiplicativeOP(i-1));
            this.visit(ctx.factor(i));
        }
        numTabs--;
        return null;
    }

    @Override
    public Object visitLiteralFAST(myParser.LiteralFASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.literal());
        numTabs--;
        return null;
    }

    @Override
    public Object visitIdFAST(myParser.IdFASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitFunctionCallFAST(myParser.FunctionCallFASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.functionCall());
        numTabs--;
        return null;
    }

    @Override
    public Object visitArrayLookUpFAST(myParser.ArrayLookUpFASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.arrayLookup());
        numTabs--;
        return null;
    }

    @Override
    public Object visitArrayLengthFAST(myParser.ArrayLengthFASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.arrayLength());
        numTabs--;
        return null;
    }

    @Override
    public Object visitSubExpressionFAST(myParser.SubExpressionFASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.subExpression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitArrayAllocationExpressionFAST(myParser.ArrayAllocationExpressionFASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.arrayAllocationExpression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitAllocationExpressionFAST(myParser.AllocationExpressionFASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.allocationExpression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitUnaryFAST(myParser.UnaryFASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.unary());
        numTabs--;
        return null;
    }

    @Override
    public Object visitOrSymbolROAST(myParser.OrSymbolROASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitAmpertonROAST(myParser.AmpertonROASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitSmallerROAST(myParser.SmallerROASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitGreatherROAST(myParser.GreatherROASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitEqualsROAST(myParser.EqualsROASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitDifferentROAST(myParser.DifferentROASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitSmallerEqualROAST(myParser.SmallerEqualROASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitGreatherEqualROAST(myParser.GreatherEqualROASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitMasAdditOPAST(myParser.MasAdditOPASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitMinusAdditOPAST(myParser.MinusAdditOPASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitOrAdditOPAST(myParser.OrAdditOPASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitMulMultOPAST(myParser.MulMultOPASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitDivMultOPAST(myParser.DivMultOPASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitAndMultOPAST(myParser.AndMultOPASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitUnaryAST(myParser.UnaryASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitIntLiteralLAST(myParser.IntLiteralLASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitRealLiteralLAST(myParser.RealLiteralLASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitBoolLiteralLAST(myParser.BoolLiteralLASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitStringLiteralLAST(myParser.StringLiteralLASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitAllocationExpressionAST(myParser.AllocationExpressionASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }

    @Override
    public Object visitArrayAllocationExpressionAST(myParser.ArrayAllocationExpressionASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.simpleType());
        this.visit(ctx.expression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitSubExpressionAST(myParser.SubExpressionASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.expression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitFunctionCallAST(myParser.FunctionCallASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        if(ctx.actualParams() != null)
            this.visit(ctx.actualParams());
        numTabs--;
        return null;
    }

    @Override
    public Object visitActualParamsAST(myParser.ActualParamsASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        for (myParser.ExpressionContext expression: ctx.expression())
            this.visit(expression);
        numTabs--;
        return null;
    }

    @Override
    public Object visitArrayLookupAST(myParser.ArrayLookupASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        numTabs++;
        this.visit(ctx.expression());
        numTabs--;
        return null;
    }

    @Override
    public Object visitArrayLengthAST(myParser.ArrayLengthASTContext ctx) {
        System.out.println("\t".repeat(numTabs) + ctx.getClass().getSimpleName().replace("Context",""));
        return null;
    }
}
