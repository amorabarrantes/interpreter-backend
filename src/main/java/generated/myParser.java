// Generated from C:/Users/andre/Desktop/TEC/Compiladores/Proyecto 1/interpreter-backend/src/main/java\myParser.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class myParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PYCOMA=1, ASSIGN=2, PLEFT=3, PRIGHT=4, VIR=5, COLON=6, MAS=7, MINUS=8, 
		MUL=9, DIV=10, GREATHER=11, SMALLER=12, GREATHEREQUAL=13, SMALLEREQUAL=14, 
		QMARK=15, DOT=16, UNDERSCORE=17, EQUALS=18, DIFFERENT=19, SQUAREPLEFT=20, 
		SQUAREPRIGHT=21, COMMA=22, EXCLAMATION=23, BRACKETLEFT=24, BRACKETRIGHT=25, 
		CAT=26, DOLLAR=27, PERCENT=28, AMPERTON=29, QUESTIONMARK=30, AT=31, EXPONENTIAL=32, 
		SIMPLEQMARK=33, ORSYMBOL=34, AND=35, OR=36, BOOLEAN=37, LENGTH=38, NEW=39, 
		CHAR=40, INT=41, STRING=42, CLASS=43, PRINT=44, RETURN=45, IF=46, WHILE=47, 
		LET=48, THEN=49, ELSE=50, IN=51, DO=52, BEGIN=53, END=54, CONST=55, VAR=56, 
		INTLITERAL=57, REALLITERAL=58, BOOLLITERAL=59, STRINGLITERAL=60, IDENTIFIER=61, 
		WS=62, NUM=63;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_functionDecl = 3, 
		RULE_formalParams = 4, RULE_formalParam = 5, RULE_whileStatement = 6, 
		RULE_ifStatement = 7, RULE_returnStatement = 8, RULE_printStatement = 9, 
		RULE_classDeclaration = 10, RULE_classVariableDecl = 11, RULE_variableDecl = 12, 
		RULE_type = 13, RULE_simpleType = 14, RULE_arrayType = 15, RULE_assignment = 16, 
		RULE_arrayAssignment = 17, RULE_expression = 18, RULE_simpleExpression = 19, 
		RULE_term = 20, RULE_factor = 21, RULE_relationalOp = 22, RULE_additiveOp = 23, 
		RULE_multiplicativeOP = 24, RULE_unary = 25, RULE_literal = 26, RULE_allocationExpression = 27, 
		RULE_arrayAllocationExpression = 28, RULE_subExpression = 29, RULE_functionCall = 30, 
		RULE_actualParams = 31, RULE_arrayLookup = 32, RULE_arrayLength = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "block", "functionDecl", "formalParams", "formalParam", 
			"whileStatement", "ifStatement", "returnStatement", "printStatement", 
			"classDeclaration", "classVariableDecl", "variableDecl", "type", "simpleType", 
			"arrayType", "assignment", "arrayAssignment", "expression", "simpleExpression", 
			"term", "factor", "relationalOp", "additiveOp", "multiplicativeOP", "unary", 
			"literal", "allocationExpression", "arrayAllocationExpression", "subExpression", 
			"functionCall", "actualParams", "arrayLookup", "arrayLength"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'('", "')'", "'~'", "':'", "'+'", "'-'", "'*'", 
			"'/'", "'>'", "'<'", "'>='", "'<='", "'\"'", "'.'", "'_'", "'=='", "'!='", 
			"'['", "']'", "','", "'!'", "'{'", "'}'", "'#'", "'$'", "'%'", "'&'", 
			"'?'", "'@'", "'^'", "'`'", "'|'", "'and'", "'or'", "'boolean'", "'length'", 
			"'new'", "'char'", "'int'", "'string'", "'class'", "'print'", "'return'", 
			"'if'", "'while'", "'let'", "'then'", "'else'", "'in'", "'do'", "'begin'", 
			"'end'", "'const'", "'var'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PYCOMA", "ASSIGN", "PLEFT", "PRIGHT", "VIR", "COLON", "MAS", "MINUS", 
			"MUL", "DIV", "GREATHER", "SMALLER", "GREATHEREQUAL", "SMALLEREQUAL", 
			"QMARK", "DOT", "UNDERSCORE", "EQUALS", "DIFFERENT", "SQUAREPLEFT", "SQUAREPRIGHT", 
			"COMMA", "EXCLAMATION", "BRACKETLEFT", "BRACKETRIGHT", "CAT", "DOLLAR", 
			"PERCENT", "AMPERTON", "QUESTIONMARK", "AT", "EXPONENTIAL", "SIMPLEQMARK", 
			"ORSYMBOL", "AND", "OR", "BOOLEAN", "LENGTH", "NEW", "CHAR", "INT", "STRING", 
			"CLASS", "PRINT", "RETURN", "IF", "WHILE", "LET", "THEN", "ELSE", "IN", 
			"DO", "BEGIN", "END", "CONST", "VAR", "INTLITERAL", "REALLITERAL", "BOOLLITERAL", 
			"STRINGLITERAL", "IDENTIFIER", "WS", "NUM"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "myParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public myParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(myParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BRACKETLEFT) | (1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING) | (1L << CLASS) | (1L << PRINT) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(68);
				statement();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public TerminalNode PYCOMA() { return getToken(myParser.PYCOMA, 0); }
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ArrayAssignmentContext arrayAssignment() {
			return getRuleContext(ArrayAssignmentContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				variableDecl();
				setState(77);
				match(PYCOMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				classDeclaration();
				setState(80);
				match(PYCOMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				assignment();
				setState(83);
				match(PYCOMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				arrayAssignment();
				setState(86);
				match(PYCOMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				printStatement();
				setState(89);
				match(PYCOMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				ifStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(92);
				whileStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				returnStatement();
				setState(94);
				match(PYCOMA);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(96);
				functionDecl();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(97);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode BRACKETLEFT() { return getToken(myParser.BRACKETLEFT, 0); }
		public TerminalNode BRACKETRIGHT() { return getToken(myParser.BRACKETRIGHT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(BRACKETLEFT);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BRACKETLEFT) | (1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING) | (1L << CLASS) | (1L << PRINT) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(101);
				statement();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(BRACKETRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TerminalNode PLEFT() { return getToken(myParser.PLEFT, 0); }
		public TerminalNode PRIGHT() { return getToken(myParser.PRIGHT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			type();
			setState(110);
			match(IDENTIFIER);
			setState(111);
			match(PLEFT);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(112);
				formalParams();
				}
			}

			setState(115);
			match(PRIGHT);
			setState(116);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParamsContext extends ParserRuleContext {
		public List<FormalParamContext> formalParam() {
			return getRuleContexts(FormalParamContext.class);
		}
		public FormalParamContext formalParam(int i) {
			return getRuleContext(FormalParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(myParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(myParser.COMMA, i);
		}
		public FormalParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParams; }
	}

	public final FormalParamsContext formalParams() throws RecognitionException {
		FormalParamsContext _localctx = new FormalParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formalParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			formalParam();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(119);
				match(COMMA);
				setState(120);
				formalParam();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public FormalParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParam; }
	}

	public final FormalParamContext formalParam() throws RecognitionException {
		FormalParamContext _localctx = new FormalParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formalParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			type();
			setState(127);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(myParser.WHILE, 0); }
		public TerminalNode PLEFT() { return getToken(myParser.PLEFT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PRIGHT() { return getToken(myParser.PRIGHT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(WHILE);
			setState(130);
			match(PLEFT);
			setState(131);
			expression();
			setState(132);
			match(PRIGHT);
			setState(133);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(myParser.IF, 0); }
		public TerminalNode PLEFT() { return getToken(myParser.PLEFT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PRIGHT() { return getToken(myParser.PRIGHT, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(myParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(IF);
			setState(136);
			match(PLEFT);
			setState(137);
			expression();
			setState(138);
			match(PRIGHT);
			setState(139);
			block();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(140);
				match(ELSE);
				setState(141);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(myParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(RETURN);
			setState(145);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(myParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(PRINT);
			setState(148);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(myParser.CLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TerminalNode BRACKETLEFT() { return getToken(myParser.BRACKETLEFT, 0); }
		public TerminalNode BRACKETRIGHT() { return getToken(myParser.BRACKETRIGHT, 0); }
		public List<ClassVariableDeclContext> classVariableDecl() {
			return getRuleContexts(ClassVariableDeclContext.class);
		}
		public ClassVariableDeclContext classVariableDecl(int i) {
			return getRuleContext(ClassVariableDeclContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(CLASS);
			setState(151);
			match(IDENTIFIER);
			setState(152);
			match(BRACKETLEFT);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				{
				setState(153);
				classVariableDecl();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			match(BRACKETRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassVariableDeclContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(myParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassVariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classVariableDecl; }
	}

	public final ClassVariableDeclContext classVariableDecl() throws RecognitionException {
		ClassVariableDeclContext _localctx = new ClassVariableDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classVariableDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			simpleType();
			setState(162);
			match(IDENTIFIER);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(163);
				match(ASSIGN);
				setState(164);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(myParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDecl; }
	}

	public final VariableDeclContext variableDecl() throws RecognitionException {
		VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variableDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			type();
			setState(168);
			match(IDENTIFIER);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(169);
				match(ASSIGN);
				setState(170);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_type);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				simpleType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(myParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(myParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(myParser.INT, 0); }
		public TerminalNode STRING() { return getToken(myParser.STRING, 0); }
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_simpleType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public TerminalNode SQUAREPLEFT() { return getToken(myParser.SQUAREPLEFT, 0); }
		public TerminalNode SQUAREPRIGHT() { return getToken(myParser.SQUAREPRIGHT, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			simpleType();
			setState(181);
			match(SQUAREPLEFT);
			setState(182);
			match(SQUAREPRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(myParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(myParser.IDENTIFIER, i);
		}
		public TerminalNode ASSIGN() { return getToken(myParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(myParser.DOT, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(IDENTIFIER);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(185);
				match(DOT);
				setState(186);
				match(IDENTIFIER);
				}
			}

			setState(189);
			match(ASSIGN);
			setState(190);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TerminalNode SQUAREPLEFT() { return getToken(myParser.SQUAREPLEFT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SQUAREPRIGHT() { return getToken(myParser.SQUAREPRIGHT, 0); }
		public TerminalNode ASSIGN() { return getToken(myParser.ASSIGN, 0); }
		public ArrayAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAssignment; }
	}

	public final ArrayAssignmentContext arrayAssignment() throws RecognitionException {
		ArrayAssignmentContext _localctx = new ArrayAssignmentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arrayAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(IDENTIFIER);
			setState(193);
			match(SQUAREPLEFT);
			setState(194);
			expression();
			setState(195);
			match(SQUAREPRIGHT);
			setState(196);
			match(ASSIGN);
			setState(197);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public List<RelationalOpContext> relationalOp() {
			return getRuleContexts(RelationalOpContext.class);
		}
		public RelationalOpContext relationalOp(int i) {
			return getRuleContext(RelationalOpContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			simpleExpression();
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(200);
					relationalOp();
					setState(201);
					simpleExpression();
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<AdditiveOpContext> additiveOp() {
			return getRuleContexts(AdditiveOpContext.class);
		}
		public AdditiveOpContext additiveOp(int i) {
			return getRuleContext(AdditiveOpContext.class,i);
		}
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_simpleExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			term();
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(209);
					additiveOp();
					setState(210);
					term();
					}
					} 
				}
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<MultiplicativeOPContext> multiplicativeOP() {
			return getRuleContexts(MultiplicativeOPContext.class);
		}
		public MultiplicativeOPContext multiplicativeOP(int i) {
			return getRuleContext(MultiplicativeOPContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_term);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			factor();
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(218);
					multiplicativeOP();
					setState(219);
					factor();
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(myParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(myParser.IDENTIFIER, i);
		}
		public TerminalNode DOT() { return getToken(myParser.DOT, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ArrayLookupContext arrayLookup() {
			return getRuleContext(ArrayLookupContext.class,0);
		}
		public ArrayLengthContext arrayLength() {
			return getRuleContext(ArrayLengthContext.class,0);
		}
		public SubExpressionContext subExpression() {
			return getRuleContext(SubExpressionContext.class,0);
		}
		public ArrayAllocationExpressionContext arrayAllocationExpression() {
			return getRuleContext(ArrayAllocationExpressionContext.class,0);
		}
		public AllocationExpressionContext allocationExpression() {
			return getRuleContext(AllocationExpressionContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		int _la;
		try {
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(IDENTIFIER);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(228);
					match(DOT);
					setState(229);
					match(IDENTIFIER);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				arrayLookup();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				arrayLength();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(235);
				subExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(236);
				arrayAllocationExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(237);
				allocationExpression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(238);
				unary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalOpContext extends ParserRuleContext {
		public TerminalNode ORSYMBOL() { return getToken(myParser.ORSYMBOL, 0); }
		public TerminalNode AMPERTON() { return getToken(myParser.AMPERTON, 0); }
		public TerminalNode SMALLER() { return getToken(myParser.SMALLER, 0); }
		public TerminalNode GREATHER() { return getToken(myParser.GREATHER, 0); }
		public TerminalNode EQUALS() { return getToken(myParser.EQUALS, 0); }
		public TerminalNode DIFFERENT() { return getToken(myParser.DIFFERENT, 0); }
		public TerminalNode SMALLEREQUAL() { return getToken(myParser.SMALLEREQUAL, 0); }
		public TerminalNode GREATHEREQUAL() { return getToken(myParser.GREATHEREQUAL, 0); }
		public RelationalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalOp; }
	}

	public final RelationalOpContext relationalOp() throws RecognitionException {
		RelationalOpContext _localctx = new RelationalOpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_relationalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATHER) | (1L << SMALLER) | (1L << GREATHEREQUAL) | (1L << SMALLEREQUAL) | (1L << EQUALS) | (1L << DIFFERENT) | (1L << AMPERTON) | (1L << ORSYMBOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveOpContext extends ParserRuleContext {
		public TerminalNode MAS() { return getToken(myParser.MAS, 0); }
		public TerminalNode MINUS() { return getToken(myParser.MINUS, 0); }
		public TerminalNode OR() { return getToken(myParser.OR, 0); }
		public AdditiveOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveOp; }
	}

	public final AdditiveOpContext additiveOp() throws RecognitionException {
		AdditiveOpContext _localctx = new AdditiveOpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_additiveOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAS) | (1L << MINUS) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeOPContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(myParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(myParser.DIV, 0); }
		public TerminalNode AND() { return getToken(myParser.AND, 0); }
		public MultiplicativeOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeOP; }
	}

	public final MultiplicativeOPContext multiplicativeOP() throws RecognitionException {
		MultiplicativeOPContext _localctx = new MultiplicativeOPContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_multiplicativeOP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << AND))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public TerminalNode MAS() { return getToken(myParser.MAS, 0); }
		public TerminalNode MINUS() { return getToken(myParser.MINUS, 0); }
		public TerminalNode EXCLAMATION() { return getToken(myParser.EXCLAMATION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unary);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAS) | (1L << MINUS) | (1L << EXCLAMATION))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(248);
					expression();
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTLITERAL() { return getToken(myParser.INTLITERAL, 0); }
		public TerminalNode REALLITERAL() { return getToken(myParser.REALLITERAL, 0); }
		public TerminalNode BOOLLITERAL() { return getToken(myParser.BOOLLITERAL, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(myParser.STRINGLITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTLITERAL) | (1L << REALLITERAL) | (1L << BOOLLITERAL) | (1L << STRINGLITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllocationExpressionContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(myParser.NEW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TerminalNode PLEFT() { return getToken(myParser.PLEFT, 0); }
		public TerminalNode PRIGHT() { return getToken(myParser.PRIGHT, 0); }
		public AllocationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allocationExpression; }
	}

	public final AllocationExpressionContext allocationExpression() throws RecognitionException {
		AllocationExpressionContext _localctx = new AllocationExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_allocationExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(NEW);
			setState(257);
			match(IDENTIFIER);
			setState(258);
			match(PLEFT);
			setState(259);
			match(PRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAllocationExpressionContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(myParser.NEW, 0); }
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public TerminalNode SQUAREPLEFT() { return getToken(myParser.SQUAREPLEFT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SQUAREPRIGHT() { return getToken(myParser.SQUAREPRIGHT, 0); }
		public ArrayAllocationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAllocationExpression; }
	}

	public final ArrayAllocationExpressionContext arrayAllocationExpression() throws RecognitionException {
		ArrayAllocationExpressionContext _localctx = new ArrayAllocationExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arrayAllocationExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(NEW);
			setState(262);
			simpleType();
			setState(263);
			match(SQUAREPLEFT);
			setState(264);
			expression();
			setState(265);
			match(SQUAREPRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubExpressionContext extends ParserRuleContext {
		public TerminalNode PLEFT() { return getToken(myParser.PLEFT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PRIGHT() { return getToken(myParser.PRIGHT, 0); }
		public SubExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subExpression; }
	}

	public final SubExpressionContext subExpression() throws RecognitionException {
		SubExpressionContext _localctx = new SubExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_subExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(PLEFT);
			setState(268);
			expression();
			setState(269);
			match(PRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TerminalNode PLEFT() { return getToken(myParser.PLEFT, 0); }
		public TerminalNode PRIGHT() { return getToken(myParser.PRIGHT, 0); }
		public ActualParamsContext actualParams() {
			return getRuleContext(ActualParamsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(IDENTIFIER);
			setState(272);
			match(PLEFT);
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLEFT) | (1L << MAS) | (1L << MINUS) | (1L << EXCLAMATION) | (1L << NEW) | (1L << INTLITERAL) | (1L << REALLITERAL) | (1L << BOOLLITERAL) | (1L << STRINGLITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(273);
				actualParams();
				}
			}

			setState(276);
			match(PRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualParamsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(myParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(myParser.COMMA, i);
		}
		public ActualParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParams; }
	}

	public final ActualParamsContext actualParams() throws RecognitionException {
		ActualParamsContext _localctx = new ActualParamsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_actualParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			expression();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(279);
				match(COMMA);
				setState(280);
				expression();
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLookupContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TerminalNode SQUAREPLEFT() { return getToken(myParser.SQUAREPLEFT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SQUAREPRIGHT() { return getToken(myParser.SQUAREPRIGHT, 0); }
		public ArrayLookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLookup; }
	}

	public final ArrayLookupContext arrayLookup() throws RecognitionException {
		ArrayLookupContext _localctx = new ArrayLookupContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_arrayLookup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(IDENTIFIER);
			setState(287);
			match(SQUAREPLEFT);
			setState(288);
			expression();
			setState(289);
			match(SQUAREPRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLengthContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(myParser.IDENTIFIER, 0); }
		public TerminalNode DOT() { return getToken(myParser.DOT, 0); }
		public TerminalNode LENGTH() { return getToken(myParser.LENGTH, 0); }
		public ArrayLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLength; }
	}

	public final ArrayLengthContext arrayLength() throws RecognitionException {
		ArrayLengthContext _localctx = new ArrayLengthContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arrayLength);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(IDENTIFIER);
			setState(292);
			match(DOT);
			setState(293);
			match(LENGTH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3A\u012a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3e\n\3\3\4\3\4\7\4i\n\4\f\4\16\4l\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5"+
		"\5t\n\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6|\n\6\f\6\16\6\177\13\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0091\n\t\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u009d\n\f\f\f\16\f\u00a0\13"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00a8\n\r\3\16\3\16\3\16\3\16\5\16\u00ae"+
		"\n\16\3\17\3\17\3\17\5\17\u00b3\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\5\22\u00be\n\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\7\24\u00ce\n\24\f\24\16\24\u00d1\13\24\3\25"+
		"\3\25\3\25\3\25\7\25\u00d7\n\25\f\25\16\25\u00da\13\25\3\26\3\26\3\26"+
		"\3\26\7\26\u00e0\n\26\f\26\16\26\u00e3\13\26\3\27\3\27\3\27\3\27\5\27"+
		"\u00e9\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00f2\n\27\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\3\33\3\33\7\33\u00fc\n\33\f\33\16\33\u00ff\13"+
		"\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \5 \u0115\n \3 \3 \3!\3!\3!\7!\u011c\n!\f!"+
		"\16!\u011f\13!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\2\2$\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\b\4\2\'\'*,\6\2"+
		"\r\20\24\25\37\37$$\4\2\t\n&&\4\2\13\f%%\4\2\t\n\31\31\3\2;>\2\u012a\2"+
		"I\3\2\2\2\4d\3\2\2\2\6f\3\2\2\2\bo\3\2\2\2\nx\3\2\2\2\f\u0080\3\2\2\2"+
		"\16\u0083\3\2\2\2\20\u0089\3\2\2\2\22\u0092\3\2\2\2\24\u0095\3\2\2\2\26"+
		"\u0098\3\2\2\2\30\u00a3\3\2\2\2\32\u00a9\3\2\2\2\34\u00b2\3\2\2\2\36\u00b4"+
		"\3\2\2\2 \u00b6\3\2\2\2\"\u00ba\3\2\2\2$\u00c2\3\2\2\2&\u00c9\3\2\2\2"+
		"(\u00d2\3\2\2\2*\u00db\3\2\2\2,\u00f1\3\2\2\2.\u00f3\3\2\2\2\60\u00f5"+
		"\3\2\2\2\62\u00f7\3\2\2\2\64\u00f9\3\2\2\2\66\u0100\3\2\2\28\u0102\3\2"+
		"\2\2:\u0107\3\2\2\2<\u010d\3\2\2\2>\u0111\3\2\2\2@\u0118\3\2\2\2B\u0120"+
		"\3\2\2\2D\u0125\3\2\2\2FH\5\4\3\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2JL\3\2\2\2KI\3\2\2\2LM\7\2\2\3M\3\3\2\2\2NO\5\32\16\2OP\7\3\2\2Pe"+
		"\3\2\2\2QR\5\26\f\2RS\7\3\2\2Se\3\2\2\2TU\5\"\22\2UV\7\3\2\2Ve\3\2\2\2"+
		"WX\5$\23\2XY\7\3\2\2Ye\3\2\2\2Z[\5\24\13\2[\\\7\3\2\2\\e\3\2\2\2]e\5\20"+
		"\t\2^e\5\16\b\2_`\5\22\n\2`a\7\3\2\2ae\3\2\2\2be\5\b\5\2ce\5\6\4\2dN\3"+
		"\2\2\2dQ\3\2\2\2dT\3\2\2\2dW\3\2\2\2dZ\3\2\2\2d]\3\2\2\2d^\3\2\2\2d_\3"+
		"\2\2\2db\3\2\2\2dc\3\2\2\2e\5\3\2\2\2fj\7\32\2\2gi\5\4\3\2hg\3\2\2\2i"+
		"l\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\33\2\2n\7\3\2\2"+
		"\2op\5\34\17\2pq\7?\2\2qs\7\5\2\2rt\5\n\6\2sr\3\2\2\2st\3\2\2\2tu\3\2"+
		"\2\2uv\7\6\2\2vw\5\6\4\2w\t\3\2\2\2x}\5\f\7\2yz\7\30\2\2z|\5\f\7\2{y\3"+
		"\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\13\3\2\2\2\177}\3\2\2\2\u0080"+
		"\u0081\5\34\17\2\u0081\u0082\7?\2\2\u0082\r\3\2\2\2\u0083\u0084\7\61\2"+
		"\2\u0084\u0085\7\5\2\2\u0085\u0086\5&\24\2\u0086\u0087\7\6\2\2\u0087\u0088"+
		"\5\6\4\2\u0088\17\3\2\2\2\u0089\u008a\7\60\2\2\u008a\u008b\7\5\2\2\u008b"+
		"\u008c\5&\24\2\u008c\u008d\7\6\2\2\u008d\u0090\5\6\4\2\u008e\u008f\7\64"+
		"\2\2\u008f\u0091\5\6\4\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\21\3\2\2\2\u0092\u0093\7/\2\2\u0093\u0094\5&\24\2\u0094\23\3\2\2\2\u0095"+
		"\u0096\7.\2\2\u0096\u0097\5&\24\2\u0097\25\3\2\2\2\u0098\u0099\7-\2\2"+
		"\u0099\u009a\7?\2\2\u009a\u009e\7\32\2\2\u009b\u009d\5\30\r\2\u009c\u009b"+
		"\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7\33\2\2\u00a2\27\3\2\2"+
		"\2\u00a3\u00a4\5\36\20\2\u00a4\u00a7\7?\2\2\u00a5\u00a6\7\4\2\2\u00a6"+
		"\u00a8\5&\24\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\31\3\2\2"+
		"\2\u00a9\u00aa\5\34\17\2\u00aa\u00ad\7?\2\2\u00ab\u00ac\7\4\2\2\u00ac"+
		"\u00ae\5&\24\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\33\3\2\2"+
		"\2\u00af\u00b3\5\36\20\2\u00b0\u00b3\5 \21\2\u00b1\u00b3\7?\2\2\u00b2"+
		"\u00af\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\35\3\2\2"+
		"\2\u00b4\u00b5\t\2\2\2\u00b5\37\3\2\2\2\u00b6\u00b7\5\36\20\2\u00b7\u00b8"+
		"\7\26\2\2\u00b8\u00b9\7\27\2\2\u00b9!\3\2\2\2\u00ba\u00bd\7?\2\2\u00bb"+
		"\u00bc\7\22\2\2\u00bc\u00be\7?\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7\4\2\2\u00c0\u00c1\5&\24\2\u00c1"+
		"#\3\2\2\2\u00c2\u00c3\7?\2\2\u00c3\u00c4\7\26\2\2\u00c4\u00c5\5&\24\2"+
		"\u00c5\u00c6\7\27\2\2\u00c6\u00c7\7\4\2\2\u00c7\u00c8\5&\24\2\u00c8%\3"+
		"\2\2\2\u00c9\u00cf\5(\25\2\u00ca\u00cb\5.\30\2\u00cb\u00cc\5(\25\2\u00cc"+
		"\u00ce\3\2\2\2\u00cd\u00ca\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\'\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d8"+
		"\5*\26\2\u00d3\u00d4\5\60\31\2\u00d4\u00d5\5*\26\2\u00d5\u00d7\3\2\2\2"+
		"\u00d6\u00d3\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9)\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00e1\5,\27\2\u00dc"+
		"\u00dd\5\62\32\2\u00dd\u00de\5,\27\2\u00de\u00e0\3\2\2\2\u00df\u00dc\3"+
		"\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"+\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00f2\5\66\34\2\u00e5\u00e8\7?\2\2"+
		"\u00e6\u00e7\7\22\2\2\u00e7\u00e9\7?\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9\u00f2\3\2\2\2\u00ea\u00f2\5> \2\u00eb\u00f2\5B\"\2\u00ec"+
		"\u00f2\5D#\2\u00ed\u00f2\5<\37\2\u00ee\u00f2\5:\36\2\u00ef\u00f2\58\35"+
		"\2\u00f0\u00f2\5\64\33\2\u00f1\u00e4\3\2\2\2\u00f1\u00e5\3\2\2\2\u00f1"+
		"\u00ea\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f1\u00ed\3\2"+
		"\2\2\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2"+
		"-\3\2\2\2\u00f3\u00f4\t\3\2\2\u00f4/\3\2\2\2\u00f5\u00f6\t\4\2\2\u00f6"+
		"\61\3\2\2\2\u00f7\u00f8\t\5\2\2\u00f8\63\3\2\2\2\u00f9\u00fd\t\6\2\2\u00fa"+
		"\u00fc\5&\24\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fd\u00fe\3\2\2\2\u00fe\65\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101"+
		"\t\7\2\2\u0101\67\3\2\2\2\u0102\u0103\7)\2\2\u0103\u0104\7?\2\2\u0104"+
		"\u0105\7\5\2\2\u0105\u0106\7\6\2\2\u01069\3\2\2\2\u0107\u0108\7)\2\2\u0108"+
		"\u0109\5\36\20\2\u0109\u010a\7\26\2\2\u010a\u010b\5&\24\2\u010b\u010c"+
		"\7\27\2\2\u010c;\3\2\2\2\u010d\u010e\7\5\2\2\u010e\u010f\5&\24\2\u010f"+
		"\u0110\7\6\2\2\u0110=\3\2\2\2\u0111\u0112\7?\2\2\u0112\u0114\7\5\2\2\u0113"+
		"\u0115\5@!\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2"+
		"\2\u0116\u0117\7\6\2\2\u0117?\3\2\2\2\u0118\u011d\5&\24\2\u0119\u011a"+
		"\7\30\2\2\u011a\u011c\5&\24\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2"+
		"\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011eA\3\2\2\2\u011f\u011d\3"+
		"\2\2\2\u0120\u0121\7?\2\2\u0121\u0122\7\26\2\2\u0122\u0123\5&\24\2\u0123"+
		"\u0124\7\27\2\2\u0124C\3\2\2\2\u0125\u0126\7?\2\2\u0126\u0127\7\22\2\2"+
		"\u0127\u0128\7(\2\2\u0128E\3\2\2\2\25Idjs}\u0090\u009e\u00a7\u00ad\u00b2"+
		"\u00bd\u00cf\u00d8\u00e1\u00e8\u00f1\u00fd\u0114\u011d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}