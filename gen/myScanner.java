// Generated from C:/Users/Andres/Desktop/Tec/5to semestre/Compiladores/Proyecto/interpreter-backend/src/main/java\myScanner.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class myScanner extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PYCOMA", "ASSIGN", "PLEFT", "PRIGHT", "VIR", "COLON", "MAS", "MINUS", 
			"MUL", "DIV", "GREATHER", "SMALLER", "GREATHEREQUAL", "SMALLEREQUAL", 
			"QMARK", "DOT", "UNDERSCORE", "EQUALS", "DIFFERENT", "SQUAREPLEFT", "SQUAREPRIGHT", 
			"COMMA", "EXCLAMATION", "BRACKETLEFT", "BRACKETRIGHT", "CAT", "DOLLAR", 
			"PERCENT", "AMPERTON", "QUESTIONMARK", "AT", "EXPONENTIAL", "SIMPLEQMARK", 
			"ORSYMBOL", "AND", "OR", "BOOLEAN", "LENGTH", "NEW", "CHAR", "INT", "STRING", 
			"TRUE", "FALSE", "CLASS", "PRINT", "RETURN", "IF", "WHILE", "LET", "THEN", 
			"ELSE", "IN", "DO", "BEGIN", "END", "CONST", "VAR", "INTLITERAL", "REALLITERAL", 
			"BOOLLITERAL", "STRINGLITERAL", "PRINTABLE", "IDENTIFIER", "WS", "LETTER", 
			"DIGIT", "NUMBER", "NUM"
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


	public myScanner(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "myScanner.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u01c8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3"+
		"*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3"+
		".\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38"+
		"\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\7<\u0151"+
		"\n<\f<\16<\u0154\13<\3=\3=\7=\u0158\n=\f=\16=\u015b\13=\3=\3=\7=\u015f"+
		"\n=\f=\16=\u0162\13=\3=\3=\3=\7=\u0167\n=\f=\16=\u016a\13=\5=\u016c\n"+
		"=\3>\3>\5>\u0170\n>\3?\3?\7?\u0174\n?\f?\16?\u0177\13?\3?\3?\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u01a2\n@\3A\3A\5A\u01a6\nA"+
		"\3A\3A\3A\7A\u01ab\nA\fA\16A\u01ae\13A\3B\6B\u01b1\nB\rB\16B\u01b2\3B"+
		"\3B\3C\3C\3D\3D\3E\3E\7E\u01bd\nE\fE\16E\u01c0\13E\3F\3F\7F\u01c4\nF\f"+
		"F\16F\u01c7\13F\2\2G\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W\2Y\2[-]._/a\60c\61e"+
		"\62g\63i\64k\65m\66o\67q8s9u:w;y<{=}>\177\2\u0081?\u0083@\u0085\2\u0087"+
		"\2\u0089\2\u008bA\3\2\4\5\2\13\f\17\17\"\"\4\2C\\c|\2\u01f6\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2"+
		"\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\u0081\3\2"+
		"\2\2\2\u0083\3\2\2\2\2\u008b\3\2\2\2\3\u008d\3\2\2\2\5\u008f\3\2\2\2\7"+
		"\u0091\3\2\2\2\t\u0093\3\2\2\2\13\u0095\3\2\2\2\r\u0097\3\2\2\2\17\u0099"+
		"\3\2\2\2\21\u009b\3\2\2\2\23\u009d\3\2\2\2\25\u009f\3\2\2\2\27\u00a1\3"+
		"\2\2\2\31\u00a3\3\2\2\2\33\u00a5\3\2\2\2\35\u00a8\3\2\2\2\37\u00ab\3\2"+
		"\2\2!\u00ad\3\2\2\2#\u00af\3\2\2\2%\u00b1\3\2\2\2\'\u00b4\3\2\2\2)\u00b7"+
		"\3\2\2\2+\u00b9\3\2\2\2-\u00bb\3\2\2\2/\u00bd\3\2\2\2\61\u00bf\3\2\2\2"+
		"\63\u00c1\3\2\2\2\65\u00c3\3\2\2\2\67\u00c5\3\2\2\29\u00c7\3\2\2\2;\u00c9"+
		"\3\2\2\2=\u00cb\3\2\2\2?\u00cd\3\2\2\2A\u00cf\3\2\2\2C\u00d1\3\2\2\2E"+
		"\u00d3\3\2\2\2G\u00d5\3\2\2\2I\u00d9\3\2\2\2K\u00dc\3\2\2\2M\u00e4\3\2"+
		"\2\2O\u00eb\3\2\2\2Q\u00ef\3\2\2\2S\u00f4\3\2\2\2U\u00f8\3\2\2\2W\u00ff"+
		"\3\2\2\2Y\u0104\3\2\2\2[\u010a\3\2\2\2]\u0110\3\2\2\2_\u0116\3\2\2\2a"+
		"\u011d\3\2\2\2c\u0120\3\2\2\2e\u0126\3\2\2\2g\u012a\3\2\2\2i\u012f\3\2"+
		"\2\2k\u0134\3\2\2\2m\u0137\3\2\2\2o\u013a\3\2\2\2q\u0140\3\2\2\2s\u0144"+
		"\3\2\2\2u\u014a\3\2\2\2w\u014e\3\2\2\2y\u016b\3\2\2\2{\u016f\3\2\2\2}"+
		"\u0171\3\2\2\2\177\u01a1\3\2\2\2\u0081\u01a5\3\2\2\2\u0083\u01b0\3\2\2"+
		"\2\u0085\u01b6\3\2\2\2\u0087\u01b8\3\2\2\2\u0089\u01be\3\2\2\2\u008b\u01c1"+
		"\3\2\2\2\u008d\u008e\7=\2\2\u008e\4\3\2\2\2\u008f\u0090\7?\2\2\u0090\6"+
		"\3\2\2\2\u0091\u0092\7*\2\2\u0092\b\3\2\2\2\u0093\u0094\7+\2\2\u0094\n"+
		"\3\2\2\2\u0095\u0096\7\u0080\2\2\u0096\f\3\2\2\2\u0097\u0098\7<\2\2\u0098"+
		"\16\3\2\2\2\u0099\u009a\7-\2\2\u009a\20\3\2\2\2\u009b\u009c\7/\2\2\u009c"+
		"\22\3\2\2\2\u009d\u009e\7,\2\2\u009e\24\3\2\2\2\u009f\u00a0\7\61\2\2\u00a0"+
		"\26\3\2\2\2\u00a1\u00a2\7@\2\2\u00a2\30\3\2\2\2\u00a3\u00a4\7>\2\2\u00a4"+
		"\32\3\2\2\2\u00a5\u00a6\7@\2\2\u00a6\u00a7\7?\2\2\u00a7\34\3\2\2\2\u00a8"+
		"\u00a9\7>\2\2\u00a9\u00aa\7?\2\2\u00aa\36\3\2\2\2\u00ab\u00ac\7$\2\2\u00ac"+
		" \3\2\2\2\u00ad\u00ae\7\60\2\2\u00ae\"\3\2\2\2\u00af\u00b0\7a\2\2\u00b0"+
		"$\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2\u00b3\7?\2\2\u00b3&\3\2\2\2\u00b4\u00b5"+
		"\7#\2\2\u00b5\u00b6\7?\2\2\u00b6(\3\2\2\2\u00b7\u00b8\7]\2\2\u00b8*\3"+
		"\2\2\2\u00b9\u00ba\7_\2\2\u00ba,\3\2\2\2\u00bb\u00bc\7.\2\2\u00bc.\3\2"+
		"\2\2\u00bd\u00be\7#\2\2\u00be\60\3\2\2\2\u00bf\u00c0\7}\2\2\u00c0\62\3"+
		"\2\2\2\u00c1\u00c2\7\177\2\2\u00c2\64\3\2\2\2\u00c3\u00c4\7%\2\2\u00c4"+
		"\66\3\2\2\2\u00c5\u00c6\7&\2\2\u00c68\3\2\2\2\u00c7\u00c8\7\'\2\2\u00c8"+
		":\3\2\2\2\u00c9\u00ca\7(\2\2\u00ca<\3\2\2\2\u00cb\u00cc\7A\2\2\u00cc>"+
		"\3\2\2\2\u00cd\u00ce\7B\2\2\u00ce@\3\2\2\2\u00cf\u00d0\7`\2\2\u00d0B\3"+
		"\2\2\2\u00d1\u00d2\7b\2\2\u00d2D\3\2\2\2\u00d3\u00d4\7~\2\2\u00d4F\3\2"+
		"\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7f\2\2\u00d8H\3"+
		"\2\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7t\2\2\u00dbJ\3\2\2\2\u00dc\u00dd"+
		"\7d\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7q\2\2\u00df\u00e0\7n\2\2\u00e0"+
		"\u00e1\7g\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7p\2\2\u00e3L\3\2\2\2\u00e4"+
		"\u00e5\7n\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7p\2\2\u00e7\u00e8\7i\2\2"+
		"\u00e8\u00e9\7v\2\2\u00e9\u00ea\7j\2\2\u00eaN\3\2\2\2\u00eb\u00ec\7p\2"+
		"\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7y\2\2\u00eeP\3\2\2\2\u00ef\u00f0\7"+
		"e\2\2\u00f0\u00f1\7j\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7t\2\2\u00f3R"+
		"\3\2\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7v\2\2\u00f7"+
		"T\3\2\2\2\u00f8\u00f9\7u\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7t\2\2\u00fb"+
		"\u00fc\7k\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe\7i\2\2\u00feV\3\2\2\2\u00ff"+
		"\u0100\7v\2\2\u0100\u0101\7t\2\2\u0101\u0102\7w\2\2\u0102\u0103\7g\2\2"+
		"\u0103X\3\2\2\2\u0104\u0105\7h\2\2\u0105\u0106\7c\2\2\u0106\u0107\7n\2"+
		"\2\u0107\u0108\7u\2\2\u0108\u0109\7g\2\2\u0109Z\3\2\2\2\u010a\u010b\7"+
		"e\2\2\u010b\u010c\7n\2\2\u010c\u010d\7c\2\2\u010d\u010e\7u\2\2\u010e\u010f"+
		"\7u\2\2\u010f\\\3\2\2\2\u0110\u0111\7r\2\2\u0111\u0112\7t\2\2\u0112\u0113"+
		"\7k\2\2\u0113\u0114\7p\2\2\u0114\u0115\7v\2\2\u0115^\3\2\2\2\u0116\u0117"+
		"\7t\2\2\u0117\u0118\7g\2\2\u0118\u0119\7v\2\2\u0119\u011a\7w\2\2\u011a"+
		"\u011b\7t\2\2\u011b\u011c\7p\2\2\u011c`\3\2\2\2\u011d\u011e\7k\2\2\u011e"+
		"\u011f\7h\2\2\u011fb\3\2\2\2\u0120\u0121\7y\2\2\u0121\u0122\7j\2\2\u0122"+
		"\u0123\7k\2\2\u0123\u0124\7n\2\2\u0124\u0125\7g\2\2\u0125d\3\2\2\2\u0126"+
		"\u0127\7n\2\2\u0127\u0128\7g\2\2\u0128\u0129\7v\2\2\u0129f\3\2\2\2\u012a"+
		"\u012b\7v\2\2\u012b\u012c\7j\2\2\u012c\u012d\7g\2\2\u012d\u012e\7p\2\2"+
		"\u012eh\3\2\2\2\u012f\u0130\7g\2\2\u0130\u0131\7n\2\2\u0131\u0132\7u\2"+
		"\2\u0132\u0133\7g\2\2\u0133j\3\2\2\2\u0134\u0135\7k\2\2\u0135\u0136\7"+
		"p\2\2\u0136l\3\2\2\2\u0137\u0138\7f\2\2\u0138\u0139\7q\2\2\u0139n\3\2"+
		"\2\2\u013a\u013b\7d\2\2\u013b\u013c\7g\2\2\u013c\u013d\7i\2\2\u013d\u013e"+
		"\7k\2\2\u013e\u013f\7p\2\2\u013fp\3\2\2\2\u0140\u0141\7g\2\2\u0141\u0142"+
		"\7p\2\2\u0142\u0143\7f\2\2\u0143r\3\2\2\2\u0144\u0145\7e\2\2\u0145\u0146"+
		"\7q\2\2\u0146\u0147\7p\2\2\u0147\u0148\7u\2\2\u0148\u0149\7v\2\2\u0149"+
		"t\3\2\2\2\u014a\u014b\7x\2\2\u014b\u014c\7c\2\2\u014c\u014d\7t\2\2\u014d"+
		"v\3\2\2\2\u014e\u0152\5\u0087D\2\u014f\u0151\5\u0087D\2\u0150\u014f\3"+
		"\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"x\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0159\5\u0087D\2\u0156\u0158\5\u0087"+
		"D\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u0160\5!"+
		"\21\2\u015d\u015f\5\u0087D\2\u015e\u015d\3\2\2\2\u015f\u0162\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u016c\3\2\2\2\u0162\u0160\3\2"+
		"\2\2\u0163\u0164\5!\21\2\u0164\u0168\5\u0087D\2\u0165\u0167\5\u0087D\2"+
		"\u0166\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u0155\3\2\2\2\u016b"+
		"\u0163\3\2\2\2\u016cz\3\2\2\2\u016d\u0170\5W,\2\u016e\u0170\5Y-\2\u016f"+
		"\u016d\3\2\2\2\u016f\u016e\3\2\2\2\u0170|\3\2\2\2\u0171\u0175\5\37\20"+
		"\2\u0172\u0174\5\177@\2\u0173\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175"+
		"\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2"+
		"\2\2\u0178\u0179\5\37\20\2\u0179~\3\2\2\2\u017a\u01a2\5\u0087D\2\u017b"+
		"\u01a2\5\u0085C\2\u017c\u01a2\5\u0083B\2\u017d\u01a2\5/\30\2\u017e\u01a2"+
		"\5%\23\2\u017f\u01a2\5\37\20\2\u0180\u01a2\5\65\33\2\u0181\u01a2\5\67"+
		"\34\2\u0182\u01a2\59\35\2\u0183\u01a2\5;\36\2\u0184\u01a2\5\7\4\2\u0185"+
		"\u01a2\5\t\5\2\u0186\u01a2\5\23\n\2\u0187\u01a2\5\17\b\2\u0188\u01a2\5"+
		"\'\24\2\u0189\u01a2\5-\27\2\u018a\u01a2\5\21\t\2\u018b\u01a2\5!\21\2\u018c"+
		"\u01a2\5\25\13\2\u018d\u01a2\5\r\7\2\u018e\u01a2\5\3\2\2\u018f\u01a2\5"+
		"\31\r\2\u0190\u01a2\5\35\17\2\u0191\u01a2\5\5\3\2\u0192\u01a2\5\27\f\2"+
		"\u0193\u01a2\5G$\2\u0194\u01a2\5I%\2\u0195\u01a2\5\33\16\2\u0196\u01a2"+
		"\5=\37\2\u0197\u01a2\5? \2\u0198\u01a2\5)\25\2\u0199\u01a2\5+\26\2\u019a"+
		"\u01a2\5A!\2\u019b\u01a2\5#\22\2\u019c\u01a2\5C\"\2\u019d\u01a2\5\61\31"+
		"\2\u019e\u01a2\5E#\2\u019f\u01a2\5\63\32\2\u01a0\u01a2\5\13\6\2\u01a1"+
		"\u017a\3\2\2\2\u01a1\u017b\3\2\2\2\u01a1\u017c\3\2\2\2\u01a1\u017d\3\2"+
		"\2\2\u01a1\u017e\3\2\2\2\u01a1\u017f\3\2\2\2\u01a1\u0180\3\2\2\2\u01a1"+
		"\u0181\3\2\2\2\u01a1\u0182\3\2\2\2\u01a1\u0183\3\2\2\2\u01a1\u0184\3\2"+
		"\2\2\u01a1\u0185\3\2\2\2\u01a1\u0186\3\2\2\2\u01a1\u0187\3\2\2\2\u01a1"+
		"\u0188\3\2\2\2\u01a1\u0189\3\2\2\2\u01a1\u018a\3\2\2\2\u01a1\u018b\3\2"+
		"\2\2\u01a1\u018c\3\2\2\2\u01a1\u018d\3\2\2\2\u01a1\u018e\3\2\2\2\u01a1"+
		"\u018f\3\2\2\2\u01a1\u0190\3\2\2\2\u01a1\u0191\3\2\2\2\u01a1\u0192\3\2"+
		"\2\2\u01a1\u0193\3\2\2\2\u01a1\u0194\3\2\2\2\u01a1\u0195\3\2\2\2\u01a1"+
		"\u0196\3\2\2\2\u01a1\u0197\3\2\2\2\u01a1\u0198\3\2\2\2\u01a1\u0199\3\2"+
		"\2\2\u01a1\u019a\3\2\2\2\u01a1\u019b\3\2\2\2\u01a1\u019c\3\2\2\2\u01a1"+
		"\u019d\3\2\2\2\u01a1\u019e\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a0\3\2"+
		"\2\2\u01a2\u0080\3\2\2\2\u01a3\u01a6\5#\22\2\u01a4\u01a6\5\u0085C\2\u01a5"+
		"\u01a3\3\2\2\2\u01a5\u01a4\3\2\2\2\u01a6\u01ac\3\2\2\2\u01a7\u01ab\5#"+
		"\22\2\u01a8\u01ab\5\u0085C\2\u01a9\u01ab\5\u0087D\2\u01aa\u01a7\3\2\2"+
		"\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa"+
		"\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u0082\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af"+
		"\u01b1\t\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b0\3\2"+
		"\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\bB\2\2\u01b5"+
		"\u0084\3\2\2\2\u01b6\u01b7\t\3\2\2\u01b7\u0086\3\2\2\2\u01b8\u01b9\4\62"+
		";\2\u01b9\u0088\3\2\2\2\u01ba\u01bd\5\u0087D\2\u01bb\u01bd\5\u0087D\2"+
		"\u01bc\u01ba\3\2\2\2\u01bc\u01bb\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc"+
		"\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u008a\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1"+
		"\u01c5\5\u0087D\2\u01c2\u01c4\5\u0087D\2\u01c3\u01c2\3\2\2\2\u01c4\u01c7"+
		"\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u008c\3\2\2\2\u01c7"+
		"\u01c5\3\2\2\2\22\2\u0152\u0159\u0160\u0168\u016b\u016f\u0175\u01a1\u01a5"+
		"\u01aa\u01ac\u01b2\u01bc\u01be\u01c5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}