// Generated from C:/Users/andre/Desktop/TEC/Compiladores/interpreter-backend/src/main/java\myParser.g4 by ANTLR 4.9.1
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
		PYCOMA=1, ASSIGN=2, PLEFT=3, PRIGHT=4, VIR=5, COLON=6, PLUS=7, MINUS=8, 
		MUL=9, DIV=10, QMARK=11, DOT=12, UNDERSCORE=13, SQUAREPLEFT=14, SQUAREPRIGHT=15, 
		COMMA=16, EXCLAMATION=17, BRACKETLEFT=18, BRACKETRIGHT=19, CAT=20, DOLLAR=21, 
		PERCENT=22, AMPERTON=23, QUESTIONMARK=24, AT=25, EXPONENTIAL=26, SIMPLEQMARK=27, 
		ORSYMBOL=28, AND=29, OR=30, BOOLEAN=31, LENGTH=32, NEW=33, CHAR=34, INT=35, 
		STRING=36, CLASS=37, PRINT=38, RETURN=39, IF=40, WHILE=41, LET=42, THEN=43, 
		ELSE=44, IN=45, DO=46, BEGIN=47, END=48, CONST=49, VAR=50, RELATIONALOP=51, 
		ADDITIVEOP=52, MULTIPLICATIVEOP=53, LITERAL=54, INTLITERAL=55, REALLITERAL=56, 
		BOOLLITERAL=57, STRINGLITERAL=58, IDENTIFIER=59, WS=60, NUM=61;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_functionDecl = 3, 
		RULE_formalParams = 4, RULE_formalParam = 5, RULE_whileStatement = 6, 
		RULE_ifStatement = 7, RULE_returnStatement = 8, RULE_printStatement = 9, 
		RULE_classDeclaration = 10, RULE_classVariableDecl = 11, RULE_variableDecl = 12, 
		RULE_type = 13, RULE_simpleType = 14, RULE_arrayType = 15, RULE_assignment = 16, 
		RULE_arrayAssignment = 17, RULE_expression = 18, RULE_simpleExpression = 19, 
		RULE_term = 20, RULE_factor = 21, RULE_unary = 22, RULE_allocationExpression = 23, 
		RULE_arrayAllocationExpression = 24, RULE_subExpression = 25, RULE_functionCall = 26, 
		RULE_actualParams = 27, RULE_arrayLookup = 28, RULE_arrayLength = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "block", "functionDecl", "formalParams", "formalParam", 
			"whileStatement", "ifStatement", "returnStatement", "printStatement", 
			"classDeclaration", "classVariableDecl", "variableDecl", "type", "simpleType", 
			"arrayType", "assignment", "arrayAssignment", "expression", "simpleExpression", 
			"term", "factor", "unary", "allocationExpression", "arrayAllocationExpression", 
			"subExpression", "functionCall", "actualParams", "arrayLookup", "arrayLength"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'('", "')'", "'~'", "':'", "'+'", "'-'", "'*'", 
			"'/'", "'\"'", "'.'", "'_'", "'['", "']'", "','", "'!'", "'{'", "'}'", 
			"'#'", "'$'", "'%'", "'&'", "'?'", "'@'", "'^'", "'`'", "'|'", "'and'", 
			"'or'", "'boolean'", "'length'", "'new'", "'char'", "'int'", "'string'", 
			"'class'", "'print'", "'return'", "'if'", "'while'", "'let'", "'then'", 
			"'else'", "'in'", "'do'", "'begin'", "'end'", "'const'", "'var'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PYCOMA", "ASSIGN", "PLEFT", "PRIGHT", "VIR", "COLON", "PLUS", 
			"MINUS", "MUL", "DIV", "QMARK", "DOT", "UNDERSCORE", "SQUAREPLEFT", "SQUAREPRIGHT", 
			"COMMA", "EXCLAMATION", "BRACKETLEFT", "BRACKETRIGHT", "CAT", "DOLLAR", 
			"PERCENT", "AMPERTON", "QUESTIONMARK", "AT", "EXPONENTIAL", "SIMPLEQMARK", 
			"ORSYMBOL", "AND", "OR", "BOOLEAN", "LENGTH", "NEW", "CHAR", "INT", "STRING", 
			"CLASS", "PRINT", "RETURN", "IF", "WHILE", "LET", "THEN", "ELSE", "IN", 
			"DO", "BEGIN", "END", "CONST", "VAR", "RELATIONALOP", "ADDITIVEOP", "MULTIPLICATIVEOP", 
			"LITERAL", "INTLITERAL", "REALLITERAL", "BOOLLITERAL", "STRINGLITERAL", 
			"IDENTIFIER", "WS", "NUM"
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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BRACKETLEFT) | (1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING) | (1L << CLASS) | (1L << PRINT) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(60);
				statement();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				variableDecl();
				setState(69);
				match(PYCOMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				classDeclaration();
				setState(72);
				match(PYCOMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				assignment();
				setState(75);
				match(PYCOMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				arrayAssignment();
				setState(78);
				match(PYCOMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				printStatement();
				setState(81);
				match(PYCOMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				ifStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				whileStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(85);
				returnStatement();
				setState(86);
				match(PYCOMA);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(88);
				functionDecl();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(89);
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
			setState(92);
			match(BRACKETLEFT);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BRACKETLEFT) | (1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING) | (1L << CLASS) | (1L << PRINT) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(93);
				statement();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
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
			setState(101);
			type();
			setState(102);
			match(IDENTIFIER);
			setState(103);
			match(PLEFT);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(104);
				formalParams();
				}
			}

			setState(107);
			match(PRIGHT);
			setState(108);
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
			setState(110);
			formalParam();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(111);
				match(COMMA);
				setState(112);
				formalParam();
				}
				}
				setState(117);
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
			setState(118);
			type();
			setState(119);
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
			setState(121);
			match(WHILE);
			setState(122);
			match(PLEFT);
			setState(123);
			expression();
			setState(124);
			match(PRIGHT);
			setState(125);
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
			setState(127);
			match(IF);
			setState(128);
			match(PLEFT);
			setState(129);
			expression();
			setState(130);
			match(PRIGHT);
			setState(131);
			block();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(132);
				match(ELSE);
				setState(133);
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
			setState(136);
			match(RETURN);
			setState(137);
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
			setState(139);
			match(PRINT);
			setState(140);
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
			setState(142);
			match(CLASS);
			setState(143);
			match(IDENTIFIER);
			setState(144);
			match(BRACKETLEFT);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				{
				setState(145);
				classVariableDecl();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
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
			setState(153);
			simpleType();
			setState(154);
			match(IDENTIFIER);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(155);
				match(ASSIGN);
				setState(156);
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
			setState(159);
			type();
			setState(160);
			match(IDENTIFIER);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(161);
				match(ASSIGN);
				setState(162);
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
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				simpleType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
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
			setState(170);
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
			setState(172);
			simpleType();
			setState(173);
			match(SQUAREPLEFT);
			setState(174);
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
			setState(176);
			match(IDENTIFIER);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(177);
				match(DOT);
				setState(178);
				match(IDENTIFIER);
				}
			}

			setState(181);
			match(ASSIGN);
			setState(182);
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
			setState(184);
			match(IDENTIFIER);
			setState(185);
			match(SQUAREPLEFT);
			setState(186);
			expression();
			setState(187);
			match(SQUAREPRIGHT);
			setState(188);
			match(ASSIGN);
			setState(189);
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
		public List<TerminalNode> RELATIONALOP() { return getTokens(myParser.RELATIONALOP); }
		public TerminalNode RELATIONALOP(int i) {
			return getToken(myParser.RELATIONALOP, i);
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
			setState(191);
			simpleExpression();
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(192);
					match(RELATIONALOP);
					setState(193);
					simpleExpression();
					}
					} 
				}
				setState(198);
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
		public List<TerminalNode> ADDITIVEOP() { return getTokens(myParser.ADDITIVEOP); }
		public TerminalNode ADDITIVEOP(int i) {
			return getToken(myParser.ADDITIVEOP, i);
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
			setState(199);
			term();
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(200);
					match(ADDITIVEOP);
					setState(201);
					term();
					}
					} 
				}
				setState(206);
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
		public List<TerminalNode> MULTIPLICATIVEOP() { return getTokens(myParser.MULTIPLICATIVEOP); }
		public TerminalNode MULTIPLICATIVEOP(int i) {
			return getToken(myParser.MULTIPLICATIVEOP, i);
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
			setState(207);
			factor();
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(208);
					match(MULTIPLICATIVEOP);
					setState(209);
					factor();
					}
					} 
				}
				setState(214);
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
		public TerminalNode LITERAL() { return getToken(myParser.LITERAL, 0); }
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
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(IDENTIFIER);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(217);
					match(DOT);
					setState(218);
					match(IDENTIFIER);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(222);
				arrayLookup();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(223);
				arrayLength();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(224);
				subExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(225);
				arrayAllocationExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(226);
				allocationExpression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(227);
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

	public static class UnaryContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(myParser.PLUS, 0); }
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
		enterRule(_localctx, 44, RULE_unary);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << EXCLAMATION))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					expression();
					}
					} 
				}
				setState(236);
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
		enterRule(_localctx, 46, RULE_allocationExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(NEW);
			setState(238);
			match(IDENTIFIER);
			setState(239);
			match(PLEFT);
			setState(240);
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
		enterRule(_localctx, 48, RULE_arrayAllocationExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(NEW);
			setState(243);
			simpleType();
			setState(244);
			match(SQUAREPLEFT);
			setState(245);
			expression();
			setState(246);
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
		enterRule(_localctx, 50, RULE_subExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(PLEFT);
			setState(249);
			expression();
			setState(250);
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
		enterRule(_localctx, 52, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(IDENTIFIER);
			setState(253);
			match(PLEFT);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLEFT) | (1L << PLUS) | (1L << MINUS) | (1L << EXCLAMATION) | (1L << NEW) | (1L << LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(254);
				actualParams();
				}
			}

			setState(257);
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
		enterRule(_localctx, 54, RULE_actualParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			expression();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(260);
				match(COMMA);
				setState(261);
				expression();
				}
				}
				setState(266);
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
		enterRule(_localctx, 56, RULE_arrayLookup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(IDENTIFIER);
			setState(268);
			match(SQUAREPLEFT);
			setState(269);
			expression();
			setState(270);
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
		enterRule(_localctx, 58, RULE_arrayLength);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(IDENTIFIER);
			setState(273);
			match(DOT);
			setState(274);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u0117\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\7\2@"+
		"\n\2\f\2\16\2C\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3]\n\3\3\4\3\4\7\4a\n"+
		"\4\f\4\16\4d\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5l\n\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\7\6t\n\6\f\6\16\6w\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u0089\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\7\f\u0095\n\f\f\f\16\f\u0098\13\f\3\f\3\f\3\r\3\r\3\r\3\r\5"+
		"\r\u00a0\n\r\3\16\3\16\3\16\3\16\5\16\u00a6\n\16\3\17\3\17\3\17\5\17\u00ab"+
		"\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u00b6\n\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u00c5"+
		"\n\24\f\24\16\24\u00c8\13\24\3\25\3\25\3\25\7\25\u00cd\n\25\f\25\16\25"+
		"\u00d0\13\25\3\26\3\26\3\26\7\26\u00d5\n\26\f\26\16\26\u00d8\13\26\3\27"+
		"\3\27\3\27\3\27\5\27\u00de\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u00e7\n\27\3\30\3\30\7\30\u00eb\n\30\f\30\16\30\u00ee\13\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\5\34\u0102\n\34\3\34\3\34\3\35\3\35\3\35\7\35\u0109\n\35\f"+
		"\35\16\35\u010c\13\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\2\2 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2"+
		"\4\4\2!!$&\4\2\t\n\23\23\2\u011b\2A\3\2\2\2\4\\\3\2\2\2\6^\3\2\2\2\bg"+
		"\3\2\2\2\np\3\2\2\2\fx\3\2\2\2\16{\3\2\2\2\20\u0081\3\2\2\2\22\u008a\3"+
		"\2\2\2\24\u008d\3\2\2\2\26\u0090\3\2\2\2\30\u009b\3\2\2\2\32\u00a1\3\2"+
		"\2\2\34\u00aa\3\2\2\2\36\u00ac\3\2\2\2 \u00ae\3\2\2\2\"\u00b2\3\2\2\2"+
		"$\u00ba\3\2\2\2&\u00c1\3\2\2\2(\u00c9\3\2\2\2*\u00d1\3\2\2\2,\u00e6\3"+
		"\2\2\2.\u00e8\3\2\2\2\60\u00ef\3\2\2\2\62\u00f4\3\2\2\2\64\u00fa\3\2\2"+
		"\2\66\u00fe\3\2\2\28\u0105\3\2\2\2:\u010d\3\2\2\2<\u0112\3\2\2\2>@\5\4"+
		"\3\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\2"+
		"\2\3E\3\3\2\2\2FG\5\32\16\2GH\7\3\2\2H]\3\2\2\2IJ\5\26\f\2JK\7\3\2\2K"+
		"]\3\2\2\2LM\5\"\22\2MN\7\3\2\2N]\3\2\2\2OP\5$\23\2PQ\7\3\2\2Q]\3\2\2\2"+
		"RS\5\24\13\2ST\7\3\2\2T]\3\2\2\2U]\5\20\t\2V]\5\16\b\2WX\5\22\n\2XY\7"+
		"\3\2\2Y]\3\2\2\2Z]\5\b\5\2[]\5\6\4\2\\F\3\2\2\2\\I\3\2\2\2\\L\3\2\2\2"+
		"\\O\3\2\2\2\\R\3\2\2\2\\U\3\2\2\2\\V\3\2\2\2\\W\3\2\2\2\\Z\3\2\2\2\\["+
		"\3\2\2\2]\5\3\2\2\2^b\7\24\2\2_a\5\4\3\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2"+
		"bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7\25\2\2f\7\3\2\2\2gh\5\34\17\2hi\7="+
		"\2\2ik\7\5\2\2jl\5\n\6\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\7\6\2\2no\5\6"+
		"\4\2o\t\3\2\2\2pu\5\f\7\2qr\7\22\2\2rt\5\f\7\2sq\3\2\2\2tw\3\2\2\2us\3"+
		"\2\2\2uv\3\2\2\2v\13\3\2\2\2wu\3\2\2\2xy\5\34\17\2yz\7=\2\2z\r\3\2\2\2"+
		"{|\7+\2\2|}\7\5\2\2}~\5&\24\2~\177\7\6\2\2\177\u0080\5\6\4\2\u0080\17"+
		"\3\2\2\2\u0081\u0082\7*\2\2\u0082\u0083\7\5\2\2\u0083\u0084\5&\24\2\u0084"+
		"\u0085\7\6\2\2\u0085\u0088\5\6\4\2\u0086\u0087\7.\2\2\u0087\u0089\5\6"+
		"\4\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\21\3\2\2\2\u008a\u008b"+
		"\7)\2\2\u008b\u008c\5&\24\2\u008c\23\3\2\2\2\u008d\u008e\7(\2\2\u008e"+
		"\u008f\5&\24\2\u008f\25\3\2\2\2\u0090\u0091\7\'\2\2\u0091\u0092\7=\2\2"+
		"\u0092\u0096\7\24\2\2\u0093\u0095\5\30\r\2\u0094\u0093\3\2\2\2\u0095\u0098"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009a\7\25\2\2\u009a\27\3\2\2\2\u009b\u009c\5\36"+
		"\20\2\u009c\u009f\7=\2\2\u009d\u009e\7\4\2\2\u009e\u00a0\5&\24\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\31\3\2\2\2\u00a1\u00a2\5\34\17"+
		"\2\u00a2\u00a5\7=\2\2\u00a3\u00a4\7\4\2\2\u00a4\u00a6\5&\24\2\u00a5\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\33\3\2\2\2\u00a7\u00ab\5\36\20\2\u00a8"+
		"\u00ab\5 \21\2\u00a9\u00ab\7=\2\2\u00aa\u00a7\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00aa\u00a9\3\2\2\2\u00ab\35\3\2\2\2\u00ac\u00ad\t\2\2\2\u00ad\37"+
		"\3\2\2\2\u00ae\u00af\5\36\20\2\u00af\u00b0\7\20\2\2\u00b0\u00b1\7\21\2"+
		"\2\u00b1!\3\2\2\2\u00b2\u00b5\7=\2\2\u00b3\u00b4\7\16\2\2\u00b4\u00b6"+
		"\7=\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b8\7\4\2\2\u00b8\u00b9\5&\24\2\u00b9#\3\2\2\2\u00ba\u00bb\7=\2\2\u00bb"+
		"\u00bc\7\20\2\2\u00bc\u00bd\5&\24\2\u00bd\u00be\7\21\2\2\u00be\u00bf\7"+
		"\4\2\2\u00bf\u00c0\5&\24\2\u00c0%\3\2\2\2\u00c1\u00c6\5(\25\2\u00c2\u00c3"+
		"\7\65\2\2\u00c3\u00c5\5(\25\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2"+
		"\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\'\3\2\2\2\u00c8\u00c6\3"+
		"\2\2\2\u00c9\u00ce\5*\26\2\u00ca\u00cb\7\66\2\2\u00cb\u00cd\5*\26\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf)\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d6\5,\27\2\u00d2\u00d3"+
		"\7\67\2\2\u00d3\u00d5\5,\27\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2"+
		"\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7+\3\2\2\2\u00d8\u00d6\3"+
		"\2\2\2\u00d9\u00e7\78\2\2\u00da\u00dd\7=\2\2\u00db\u00dc\7\16\2\2\u00dc"+
		"\u00de\7=\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e7\3\2"+
		"\2\2\u00df\u00e7\5\66\34\2\u00e0\u00e7\5:\36\2\u00e1\u00e7\5<\37\2\u00e2"+
		"\u00e7\5\64\33\2\u00e3\u00e7\5\62\32\2\u00e4\u00e7\5\60\31\2\u00e5\u00e7"+
		"\5.\30\2\u00e6\u00d9\3\2\2\2\u00e6\u00da\3\2\2\2\u00e6\u00df\3\2\2\2\u00e6"+
		"\u00e0\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e6\u00e3\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7-\3\2\2\2\u00e8\u00ec"+
		"\t\3\2\2\u00e9\u00eb\5&\24\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed/\3\2\2\2\u00ee\u00ec\3\2\2\2"+
		"\u00ef\u00f0\7#\2\2\u00f0\u00f1\7=\2\2\u00f1\u00f2\7\5\2\2\u00f2\u00f3"+
		"\7\6\2\2\u00f3\61\3\2\2\2\u00f4\u00f5\7#\2\2\u00f5\u00f6\5\36\20\2\u00f6"+
		"\u00f7\7\20\2\2\u00f7\u00f8\5&\24\2\u00f8\u00f9\7\21\2\2\u00f9\63\3\2"+
		"\2\2\u00fa\u00fb\7\5\2\2\u00fb\u00fc\5&\24\2\u00fc\u00fd\7\6\2\2\u00fd"+
		"\65\3\2\2\2\u00fe\u00ff\7=\2\2\u00ff\u0101\7\5\2\2\u0100\u0102\58\35\2"+
		"\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104"+
		"\7\6\2\2\u0104\67\3\2\2\2\u0105\u010a\5&\24\2\u0106\u0107\7\22\2\2\u0107"+
		"\u0109\5&\24\2\u0108\u0106\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b9\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e"+
		"\7=\2\2\u010e\u010f\7\20\2\2\u010f\u0110\5&\24\2\u0110\u0111\7\21\2\2"+
		"\u0111;\3\2\2\2\u0112\u0113\7=\2\2\u0113\u0114\7\16\2\2\u0114\u0115\7"+
		"\"\2\2\u0115=\3\2\2\2\25A\\bku\u0088\u0096\u009f\u00a5\u00aa\u00b5\u00c6"+
		"\u00ce\u00d6\u00dd\u00e6\u00ec\u0101\u010a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}