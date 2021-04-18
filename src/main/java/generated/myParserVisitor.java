// Generated from C:/Users/andre/Desktop/TEC/Compiladores/Proyecto 1/interpreter-backend/src/main/java\myParser.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link myParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface myParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code programAST}
	 * labeled alternative in {@link myParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramAST(myParser.ProgramASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDecSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecSTAST(myParser.VarDecSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDecSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecSTAST(myParser.ClassDecSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSTAST(myParser.AssignSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssignSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignSTAST(myParser.ArrayAssignSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintSTAST(myParser.PrintSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSTAST(myParser.IfSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileSTAST(myParser.WhileSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnSTAST(myParser.ReturnSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDecSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecSTAST(myParser.FuncDecSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockSTAST}
	 * labeled alternative in {@link myParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSTAST(myParser.BlockSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockAST}
	 * labeled alternative in {@link myParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockAST(myParser.BlockASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionDecAST}
	 * labeled alternative in {@link myParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecAST(myParser.FunctionDecASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalParamsAST}
	 * labeled alternative in {@link myParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParamsAST(myParser.FormalParamsASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalParamAST}
	 * labeled alternative in {@link myParser#formalParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParamAST(myParser.FormalParamASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileAST}
	 * labeled alternative in {@link myParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileAST(myParser.WhileASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifAST}
	 * labeled alternative in {@link myParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfAST(myParser.IfASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnAST}
	 * labeled alternative in {@link myParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnAST(myParser.ReturnASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printAST}
	 * labeled alternative in {@link myParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintAST(myParser.PrintASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDecAST}
	 * labeled alternative in {@link myParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecAST(myParser.ClassDecASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classVarDecAST}
	 * labeled alternative in {@link myParser#classVariableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassVarDecAST(myParser.ClassVarDecASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDecAST}
	 * labeled alternative in {@link myParser#variableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecAST(myParser.VarDecASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleTypeTPAST}
	 * labeled alternative in {@link myParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeTPAST(myParser.SimpleTypeTPASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypeTPAST}
	 * labeled alternative in {@link myParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeTPAST(myParser.ArrayTypeTPASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idTPAST}
	 * labeled alternative in {@link myParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTPAST(myParser.IdTPASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanSimpleTAST}
	 * labeled alternative in {@link myParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanSimpleTAST(myParser.BooleanSimpleTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charSimpleTAST}
	 * labeled alternative in {@link myParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharSimpleTAST(myParser.CharSimpleTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intSimpleTAST}
	 * labeled alternative in {@link myParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntSimpleTAST(myParser.IntSimpleTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringSimpleTAST}
	 * labeled alternative in {@link myParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringSimpleTAST(myParser.StringSimpleTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypeAST}
	 * labeled alternative in {@link myParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeAST(myParser.ArrayTypeASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignAST}
	 * labeled alternative in {@link myParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignAST(myParser.AssignASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssignAST}
	 * labeled alternative in {@link myParser#arrayAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignAST(myParser.ArrayAssignASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAST}
	 * labeled alternative in {@link myParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAST(myParser.ExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleExpressionAST}
	 * labeled alternative in {@link myParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpressionAST(myParser.SimpleExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termAST}
	 * labeled alternative in {@link myParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermAST(myParser.TermASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalFAST}
	 * labeled alternative in {@link myParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralFAST(myParser.LiteralFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idFAST}
	 * labeled alternative in {@link myParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdFAST(myParser.IdFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallFAST}
	 * labeled alternative in {@link myParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallFAST(myParser.FunctionCallFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLookUpFAST}
	 * labeled alternative in {@link myParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLookUpFAST(myParser.ArrayLookUpFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLengthFAST}
	 * labeled alternative in {@link myParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLengthFAST(myParser.ArrayLengthFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpressionFAST}
	 * labeled alternative in {@link myParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpressionFAST(myParser.SubExpressionFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAllocationExpressionFAST}
	 * labeled alternative in {@link myParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAllocationExpressionFAST(myParser.ArrayAllocationExpressionFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocationExpressionFAST}
	 * labeled alternative in {@link myParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocationExpressionFAST(myParser.AllocationExpressionFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryFAST}
	 * labeled alternative in {@link myParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryFAST(myParser.UnaryFASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orSymbolROAST}
	 * labeled alternative in {@link myParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrSymbolROAST(myParser.OrSymbolROASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ampertonROAST}
	 * labeled alternative in {@link myParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmpertonROAST(myParser.AmpertonROASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code smallerROAST}
	 * labeled alternative in {@link myParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerROAST(myParser.SmallerROASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greatherROAST}
	 * labeled alternative in {@link myParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreatherROAST(myParser.GreatherROASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalsROAST}
	 * labeled alternative in {@link myParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsROAST(myParser.EqualsROASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code differentROAST}
	 * labeled alternative in {@link myParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifferentROAST(myParser.DifferentROASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code smallerEqualROAST}
	 * labeled alternative in {@link myParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerEqualROAST(myParser.SmallerEqualROASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greatherEqualROAST}
	 * labeled alternative in {@link myParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreatherEqualROAST(myParser.GreatherEqualROASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masAdditOPAST}
	 * labeled alternative in {@link myParser#additiveOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasAdditOPAST(myParser.MasAdditOPASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusAdditOPAST}
	 * labeled alternative in {@link myParser#additiveOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusAdditOPAST(myParser.MinusAdditOPASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orAdditOPAST}
	 * labeled alternative in {@link myParser#additiveOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrAdditOPAST(myParser.OrAdditOPASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulMultOPAST}
	 * labeled alternative in {@link myParser#multiplicativeOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulMultOPAST(myParser.MulMultOPASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divMultOPAST}
	 * labeled alternative in {@link myParser#multiplicativeOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivMultOPAST(myParser.DivMultOPASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andMultOPAST}
	 * labeled alternative in {@link myParser#multiplicativeOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndMultOPAST(myParser.AndMultOPASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryAST}
	 * labeled alternative in {@link myParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryAST(myParser.UnaryASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiteralLAST}
	 * labeled alternative in {@link myParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteralLAST(myParser.IntLiteralLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realLiteralLAST}
	 * labeled alternative in {@link myParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealLiteralLAST(myParser.RealLiteralLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLiteralLAST}
	 * labeled alternative in {@link myParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteralLAST(myParser.BoolLiteralLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteralLAST}
	 * labeled alternative in {@link myParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteralLAST(myParser.StringLiteralLASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocationExpressionAST}
	 * labeled alternative in {@link myParser#allocationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocationExpressionAST(myParser.AllocationExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAllocationExpressionAST}
	 * labeled alternative in {@link myParser#arrayAllocationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAllocationExpressionAST(myParser.ArrayAllocationExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpressionAST}
	 * labeled alternative in {@link myParser#subExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpressionAST(myParser.SubExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallAST}
	 * labeled alternative in {@link myParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallAST(myParser.FunctionCallASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code actualParamsAST}
	 * labeled alternative in {@link myParser#actualParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParamsAST(myParser.ActualParamsASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLookupAST}
	 * labeled alternative in {@link myParser#arrayLookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLookupAST(myParser.ArrayLookupASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLengthAST}
	 * labeled alternative in {@link myParser#arrayLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLengthAST(myParser.ArrayLengthASTContext ctx);
}