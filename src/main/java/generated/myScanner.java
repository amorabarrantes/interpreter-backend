// Generated from C:/Users/andre/Desktop/TEC/Compiladores/interpreter-backend/src/main/java\myScanner.g4 by ANTLR 4.9.1
package generated;
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
		PYCOMA=1, ASSIGN=2, PLEFT=3, PRIGHT=4, VIR=5, COLON=6, PLUS=7, MINUS=8, 
		MUL=9, DIV=10, QMARK=11, DOT=12, UNDERSCORE=13, SQUAREPLEFT=14, SQUAREPRIGHT=15, 
		COMMA=16, EXCLAMATION=17, BRACKETLEFT=18, BRACKETRIGHT=19, CAT=20, DOLLAR=21, 
		PERCENT=22, AMPERTON=23, QUESTIONMARK=24, AT=25, EXPONENTIAL=26, SIMPLEQMARK=27, 
		ORSYMBOL=28, AND=29, OR=30, BOOLEAN=31, LENGTH=32, NEW=33, CHAR=34, INT=35, 
		STRING=36, CLASS=37, PRINT=38, RETURN=39, IF=40, WHILE=41, LET=42, THEN=43, 
		ELSE=44, IN=45, DO=46, BEGIN=47, END=48, CONST=49, VAR=50, RELATIONALOP=51, 
		ADDITIVEOP=52, MULTIPLICATIVEOP=53, LITERAL=54, INTLITERAL=55, REALLITERAL=56, 
		BOOLLITERAL=57, STRINGLITERAL=58, IDENTIFIER=59, WS=60, NUM=61;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PYCOMA", "ASSIGN", "PLEFT", "PRIGHT", "VIR", "COLON", "PLUS", "MINUS", 
			"MUL", "DIV", "GREATHER", "SMALLER", "GREATHEREQUAL", "SMALLEREQUAL", 
			"QMARK", "DOT", "UNDERSCORE", "EQUALS", "DIFFERENT", "SQUAREPLEFT", "SQUAREPRIGHT", 
			"COMMA", "EXCLAMATION", "BRACKETLEFT", "BRACKETRIGHT", "CAT", "DOLLAR", 
			"PERCENT", "AMPERTON", "QUESTIONMARK", "AT", "EXPONENTIAL", "SIMPLEQMARK", 
			"ORSYMBOL", "AND", "OR", "BOOLEAN", "LENGTH", "NEW", "CHAR", "INT", "STRING", 
			"TRUE", "FALSE", "CLASS", "PRINT", "RETURN", "IF", "WHILE", "LET", "THEN", 
			"ELSE", "IN", "DO", "BEGIN", "END", "CONST", "VAR", "RELATIONALOP", "ADDITIVEOP", 
			"MULTIPLICATIVEOP", "LITERAL", "INTLITERAL", "REALLITERAL", "BOOLLITERAL", 
			"STRINGLITERAL", "PRINTABLE", "IDENTIFIER", "WS", "LETTER", "DIGIT", 
			"NUMBER", "NUM"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u01e8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\3%"+
		"\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3"+
		"(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3"+
		"-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\67\3\67\3\67\38\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3:\3:\3"+
		";\3;\3;\3;\3<\3<\3<\3<\3<\3<\5<\u015d\n<\3=\3=\3=\5=\u0162\n=\3>\3>\3"+
		">\5>\u0167\n>\3?\3?\3?\3?\5?\u016d\n?\3@\3@\7@\u0171\n@\f@\16@\u0174\13"+
		"@\3A\3A\7A\u0178\nA\fA\16A\u017b\13A\3A\3A\7A\u017f\nA\fA\16A\u0182\13"+
		"A\3A\3A\3A\7A\u0187\nA\fA\16A\u018a\13A\5A\u018c\nA\3B\3B\5B\u0190\nB"+
		"\3C\3C\7C\u0194\nC\fC\16C\u0197\13C\3C\3C\3D\3D\3D\3D\3D\3D\3D\3D\3D\3"+
		"D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3"+
		"D\3D\3D\3D\3D\3D\3D\5D\u01c2\nD\3E\3E\5E\u01c6\nE\3E\3E\3E\7E\u01cb\n"+
		"E\fE\16E\u01ce\13E\3F\6F\u01d1\nF\rF\16F\u01d2\3F\3F\3G\3G\3H\3H\3I\3"+
		"I\7I\u01dd\nI\fI\16I\u01e0\13I\3J\3J\7J\u01e4\nJ\fJ\16J\u01e7\13J\2\2"+
		"K\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\2\33\2\35\2\37"+
		"\r!\16#\17%\2\'\2)\20+\21-\22/\23\61\24\63\25\65\26\67\279\30;\31=\32"+
		"?\33A\34C\35E\36G\37I K!M\"O#Q$S%U&W\2Y\2[\'](_)a*c+e,g-i.k/m\60o\61q"+
		"\62s\63u\64w\65y\66{\67}8\1779\u0081:\u0083;\u0085<\u0087\2\u0089=\u008b"+
		">\u008d\2\u008f\2\u0091\2\u0093?\3\2\4\5\2\13\f\17\17\"\"\4\2C\\c|\2\u021c"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\37\3\2\2\2"+
		"\2!\3\2\2\2\2#\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s"+
		"\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u0093\3\2\2\2\3\u0095\3\2\2\2\5\u0097\3\2\2\2\7\u0099"+
		"\3\2\2\2\t\u009b\3\2\2\2\13\u009d\3\2\2\2\r\u009f\3\2\2\2\17\u00a1\3\2"+
		"\2\2\21\u00a3\3\2\2\2\23\u00a5\3\2\2\2\25\u00a7\3\2\2\2\27\u00a9\3\2\2"+
		"\2\31\u00ab\3\2\2\2\33\u00ad\3\2\2\2\35\u00b0\3\2\2\2\37\u00b3\3\2\2\2"+
		"!\u00b5\3\2\2\2#\u00b7\3\2\2\2%\u00b9\3\2\2\2\'\u00bc\3\2\2\2)\u00bf\3"+
		"\2\2\2+\u00c1\3\2\2\2-\u00c3\3\2\2\2/\u00c5\3\2\2\2\61\u00c7\3\2\2\2\63"+
		"\u00c9\3\2\2\2\65\u00cb\3\2\2\2\67\u00cd\3\2\2\29\u00cf\3\2\2\2;\u00d1"+
		"\3\2\2\2=\u00d3\3\2\2\2?\u00d5\3\2\2\2A\u00d7\3\2\2\2C\u00d9\3\2\2\2E"+
		"\u00db\3\2\2\2G\u00dd\3\2\2\2I\u00e1\3\2\2\2K\u00e4\3\2\2\2M\u00ec\3\2"+
		"\2\2O\u00f3\3\2\2\2Q\u00f7\3\2\2\2S\u00fc\3\2\2\2U\u0100\3\2\2\2W\u0107"+
		"\3\2\2\2Y\u010c\3\2\2\2[\u0112\3\2\2\2]\u0118\3\2\2\2_\u011e\3\2\2\2a"+
		"\u0125\3\2\2\2c\u0128\3\2\2\2e\u012e\3\2\2\2g\u0132\3\2\2\2i\u0137\3\2"+
		"\2\2k\u013c\3\2\2\2m\u013f\3\2\2\2o\u0142\3\2\2\2q\u0148\3\2\2\2s\u014c"+
		"\3\2\2\2u\u0152\3\2\2\2w\u015c\3\2\2\2y\u0161\3\2\2\2{\u0166\3\2\2\2}"+
		"\u016c\3\2\2\2\177\u016e\3\2\2\2\u0081\u018b\3\2\2\2\u0083\u018f\3\2\2"+
		"\2\u0085\u0191\3\2\2\2\u0087\u01c1\3\2\2\2\u0089\u01c5\3\2\2\2\u008b\u01d0"+
		"\3\2\2\2\u008d\u01d6\3\2\2\2\u008f\u01d8\3\2\2\2\u0091\u01de\3\2\2\2\u0093"+
		"\u01e1\3\2\2\2\u0095\u0096\7=\2\2\u0096\4\3\2\2\2\u0097\u0098\7?\2\2\u0098"+
		"\6\3\2\2\2\u0099\u009a\7*\2\2\u009a\b\3\2\2\2\u009b\u009c\7+\2\2\u009c"+
		"\n\3\2\2\2\u009d\u009e\7\u0080\2\2\u009e\f\3\2\2\2\u009f\u00a0\7<\2\2"+
		"\u00a0\16\3\2\2\2\u00a1\u00a2\7-\2\2\u00a2\20\3\2\2\2\u00a3\u00a4\7/\2"+
		"\2\u00a4\22\3\2\2\2\u00a5\u00a6\7,\2\2\u00a6\24\3\2\2\2\u00a7\u00a8\7"+
		"\61\2\2\u00a8\26\3\2\2\2\u00a9\u00aa\7@\2\2\u00aa\30\3\2\2\2\u00ab\u00ac"+
		"\7>\2\2\u00ac\32\3\2\2\2\u00ad\u00ae\7@\2\2\u00ae\u00af\7?\2\2\u00af\34"+
		"\3\2\2\2\u00b0\u00b1\7>\2\2\u00b1\u00b2\7?\2\2\u00b2\36\3\2\2\2\u00b3"+
		"\u00b4\7$\2\2\u00b4 \3\2\2\2\u00b5\u00b6\7\60\2\2\u00b6\"\3\2\2\2\u00b7"+
		"\u00b8\7a\2\2\u00b8$\3\2\2\2\u00b9\u00ba\7?\2\2\u00ba\u00bb\7?\2\2\u00bb"+
		"&\3\2\2\2\u00bc\u00bd\7#\2\2\u00bd\u00be\7?\2\2\u00be(\3\2\2\2\u00bf\u00c0"+
		"\7]\2\2\u00c0*\3\2\2\2\u00c1\u00c2\7_\2\2\u00c2,\3\2\2\2\u00c3\u00c4\7"+
		".\2\2\u00c4.\3\2\2\2\u00c5\u00c6\7#\2\2\u00c6\60\3\2\2\2\u00c7\u00c8\7"+
		"}\2\2\u00c8\62\3\2\2\2\u00c9\u00ca\7\177\2\2\u00ca\64\3\2\2\2\u00cb\u00cc"+
		"\7%\2\2\u00cc\66\3\2\2\2\u00cd\u00ce\7&\2\2\u00ce8\3\2\2\2\u00cf\u00d0"+
		"\7\'\2\2\u00d0:\3\2\2\2\u00d1\u00d2\7(\2\2\u00d2<\3\2\2\2\u00d3\u00d4"+
		"\7A\2\2\u00d4>\3\2\2\2\u00d5\u00d6\7B\2\2\u00d6@\3\2\2\2\u00d7\u00d8\7"+
		"`\2\2\u00d8B\3\2\2\2\u00d9\u00da\7b\2\2\u00daD\3\2\2\2\u00db\u00dc\7~"+
		"\2\2\u00dcF\3\2\2\2\u00dd\u00de\7c\2\2\u00de\u00df\7p\2\2\u00df\u00e0"+
		"\7f\2\2\u00e0H\3\2\2\2\u00e1\u00e2\7q\2\2\u00e2\u00e3\7t\2\2\u00e3J\3"+
		"\2\2\2\u00e4\u00e5\7d\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7q\2\2\u00e7"+
		"\u00e8\7n\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7p\2\2"+
		"\u00ebL\3\2\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7g\2\2\u00ee\u00ef\7p\2"+
		"\2\u00ef\u00f0\7i\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2\7j\2\2\u00f2N\3\2"+
		"\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6\7y\2\2\u00f6P\3"+
		"\2\2\2\u00f7\u00f8\7e\2\2\u00f8\u00f9\7j\2\2\u00f9\u00fa\7c\2\2\u00fa"+
		"\u00fb\7t\2\2\u00fbR\3\2\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7p\2\2\u00fe"+
		"\u00ff\7v\2\2\u00ffT\3\2\2\2\u0100\u0101\7u\2\2\u0101\u0102\7v\2\2\u0102"+
		"\u0103\7t\2\2\u0103\u0104\7k\2\2\u0104\u0105\7p\2\2\u0105\u0106\7i\2\2"+
		"\u0106V\3\2\2\2\u0107\u0108\7v\2\2\u0108\u0109\7t\2\2\u0109\u010a\7w\2"+
		"\2\u010a\u010b\7g\2\2\u010bX\3\2\2\2\u010c\u010d\7h\2\2\u010d\u010e\7"+
		"c\2\2\u010e\u010f\7n\2\2\u010f\u0110\7u\2\2\u0110\u0111\7g\2\2\u0111Z"+
		"\3\2\2\2\u0112\u0113\7e\2\2\u0113\u0114\7n\2\2\u0114\u0115\7c\2\2\u0115"+
		"\u0116\7u\2\2\u0116\u0117\7u\2\2\u0117\\\3\2\2\2\u0118\u0119\7r\2\2\u0119"+
		"\u011a\7t\2\2\u011a\u011b\7k\2\2\u011b\u011c\7p\2\2\u011c\u011d\7v\2\2"+
		"\u011d^\3\2\2\2\u011e\u011f\7t\2\2\u011f\u0120\7g\2\2\u0120\u0121\7v\2"+
		"\2\u0121\u0122\7w\2\2\u0122\u0123\7t\2\2\u0123\u0124\7p\2\2\u0124`\3\2"+
		"\2\2\u0125\u0126\7k\2\2\u0126\u0127\7h\2\2\u0127b\3\2\2\2\u0128\u0129"+
		"\7y\2\2\u0129\u012a\7j\2\2\u012a\u012b\7k\2\2\u012b\u012c\7n\2\2\u012c"+
		"\u012d\7g\2\2\u012dd\3\2\2\2\u012e\u012f\7n\2\2\u012f\u0130\7g\2\2\u0130"+
		"\u0131\7v\2\2\u0131f\3\2\2\2\u0132\u0133\7v\2\2\u0133\u0134\7j\2\2\u0134"+
		"\u0135\7g\2\2\u0135\u0136\7p\2\2\u0136h\3\2\2\2\u0137\u0138\7g\2\2\u0138"+
		"\u0139\7n\2\2\u0139\u013a\7u\2\2\u013a\u013b\7g\2\2\u013bj\3\2\2\2\u013c"+
		"\u013d\7k\2\2\u013d\u013e\7p\2\2\u013el\3\2\2\2\u013f\u0140\7f\2\2\u0140"+
		"\u0141\7q\2\2\u0141n\3\2\2\2\u0142\u0143\7d\2\2\u0143\u0144\7g\2\2\u0144"+
		"\u0145\7i\2\2\u0145\u0146\7k\2\2\u0146\u0147\7p\2\2\u0147p\3\2\2\2\u0148"+
		"\u0149\7g\2\2\u0149\u014a\7p\2\2\u014a\u014b\7f\2\2\u014br\3\2\2\2\u014c"+
		"\u014d\7e\2\2\u014d\u014e\7q\2\2\u014e\u014f\7p\2\2\u014f\u0150\7u\2\2"+
		"\u0150\u0151\7v\2\2\u0151t\3\2\2\2\u0152\u0153\7x\2\2\u0153\u0154\7c\2"+
		"\2\u0154\u0155\7t\2\2\u0155v\3\2\2\2\u0156\u015d\5\31\r\2\u0157\u015d"+
		"\5\27\f\2\u0158\u015d\5%\23\2\u0159\u015d\5\'\24\2\u015a\u015d\5\35\17"+
		"\2\u015b\u015d\5\33\16\2\u015c\u0156\3\2\2\2\u015c\u0157\3\2\2\2\u015c"+
		"\u0158\3\2\2\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2"+
		"\2\2\u015dx\3\2\2\2\u015e\u0162\5\17\b\2\u015f\u0162\5\21\t\2\u0160\u0162"+
		"\5I%\2\u0161\u015e\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0160\3\2\2\2\u0162"+
		"z\3\2\2\2\u0163\u0167\5\23\n\2\u0164\u0167\5\25\13\2\u0165\u0167\5G$\2"+
		"\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2\2\2\u0167|\3"+
		"\2\2\2\u0168\u016d\5\177@\2\u0169\u016d\5\u0081A\2\u016a\u016d\5\u0083"+
		"B\2\u016b\u016d\5\u0085C\2\u016c\u0168\3\2\2\2\u016c\u0169\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016b\3\2\2\2\u016d~\3\2\2\2\u016e\u0172\5\u008f"+
		"H\2\u016f\u0171\5\u008fH\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0080\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0175\u0179\5\u008fH\2\u0176\u0178\5\u008fH\2\u0177\u0176\3\2\2\2"+
		"\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c"+
		"\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u0180\5!\21\2\u017d\u017f\5\u008fH"+
		"\2\u017e\u017d\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181"+
		"\3\2\2\2\u0181\u018c\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0184\5!\21\2\u0184"+
		"\u0188\5\u008fH\2\u0185\u0187\5\u008fH\2\u0186\u0185\3\2\2\2\u0187\u018a"+
		"\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018c\3\2\2\2\u018a"+
		"\u0188\3\2\2\2\u018b\u0175\3\2\2\2\u018b\u0183\3\2\2\2\u018c\u0082\3\2"+
		"\2\2\u018d\u0190\5W,\2\u018e\u0190\5Y-\2\u018f\u018d\3\2\2\2\u018f\u018e"+
		"\3\2\2\2\u0190\u0084\3\2\2\2\u0191\u0195\5\37\20\2\u0192\u0194\5\u0087"+
		"D\2\u0193\u0192\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u0195\3\2\2\2\u0198\u0199\5\37"+
		"\20\2\u0199\u0086\3\2\2\2\u019a\u01c2\5\u008fH\2\u019b\u01c2\5\u008dG"+
		"\2\u019c\u01c2\5\u008bF\2\u019d\u01c2\5/\30\2\u019e\u01c2\5%\23\2\u019f"+
		"\u01c2\5\37\20\2\u01a0\u01c2\5\65\33\2\u01a1\u01c2\5\67\34\2\u01a2\u01c2"+
		"\59\35\2\u01a3\u01c2\5;\36\2\u01a4\u01c2\5\7\4\2\u01a5\u01c2\5\t\5\2\u01a6"+
		"\u01c2\5\23\n\2\u01a7\u01c2\5\17\b\2\u01a8\u01c2\5\'\24\2\u01a9\u01c2"+
		"\5-\27\2\u01aa\u01c2\5\21\t\2\u01ab\u01c2\5!\21\2\u01ac\u01c2\5\25\13"+
		"\2\u01ad\u01c2\5\r\7\2\u01ae\u01c2\5\3\2\2\u01af\u01c2\5\31\r\2\u01b0"+
		"\u01c2\5\35\17\2\u01b1\u01c2\5\5\3\2\u01b2\u01c2\5\27\f\2\u01b3\u01c2"+
		"\5G$\2\u01b4\u01c2\5I%\2\u01b5\u01c2\5\33\16\2\u01b6\u01c2\5=\37\2\u01b7"+
		"\u01c2\5? \2\u01b8\u01c2\5)\25\2\u01b9\u01c2\5+\26\2\u01ba\u01c2\5A!\2"+
		"\u01bb\u01c2\5#\22\2\u01bc\u01c2\5C\"\2\u01bd\u01c2\5\61\31\2\u01be\u01c2"+
		"\5E#\2\u01bf\u01c2\5\63\32\2\u01c0\u01c2\5\13\6\2\u01c1\u019a\3\2\2\2"+
		"\u01c1\u019b\3\2\2\2\u01c1\u019c\3\2\2\2\u01c1\u019d\3\2\2\2\u01c1\u019e"+
		"\3\2\2\2\u01c1\u019f\3\2\2\2\u01c1\u01a0\3\2\2\2\u01c1\u01a1\3\2\2\2\u01c1"+
		"\u01a2\3\2\2\2\u01c1\u01a3\3\2\2\2\u01c1\u01a4\3\2\2\2\u01c1\u01a5\3\2"+
		"\2\2\u01c1\u01a6\3\2\2\2\u01c1\u01a7\3\2\2\2\u01c1\u01a8\3\2\2\2\u01c1"+
		"\u01a9\3\2\2\2\u01c1\u01aa\3\2\2\2\u01c1\u01ab\3\2\2\2\u01c1\u01ac\3\2"+
		"\2\2\u01c1\u01ad\3\2\2\2\u01c1\u01ae\3\2\2\2\u01c1\u01af\3\2\2\2\u01c1"+
		"\u01b0\3\2\2\2\u01c1\u01b1\3\2\2\2\u01c1\u01b2\3\2\2\2\u01c1\u01b3\3\2"+
		"\2\2\u01c1\u01b4\3\2\2\2\u01c1\u01b5\3\2\2\2\u01c1\u01b6\3\2\2\2\u01c1"+
		"\u01b7\3\2\2\2\u01c1\u01b8\3\2\2\2\u01c1\u01b9\3\2\2\2\u01c1\u01ba\3\2"+
		"\2\2\u01c1\u01bb\3\2\2\2\u01c1\u01bc\3\2\2\2\u01c1\u01bd\3\2\2\2\u01c1"+
		"\u01be\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2\u0088\3\2"+
		"\2\2\u01c3\u01c6\5#\22\2\u01c4\u01c6\5\u008dG\2\u01c5\u01c3\3\2\2\2\u01c5"+
		"\u01c4\3\2\2\2\u01c6\u01cc\3\2\2\2\u01c7\u01cb\5#\22\2\u01c8\u01cb\5\u008d"+
		"G\2\u01c9\u01cb\5\u008fH\2\u01ca\u01c7\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca"+
		"\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2"+
		"\2\2\u01cd\u008a\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d1\t\2\2\2\u01d0"+
		"\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2"+
		"\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\bF\2\2\u01d5\u008c\3\2\2\2\u01d6"+
		"\u01d7\t\3\2\2\u01d7\u008e\3\2\2\2\u01d8\u01d9\4\62;\2\u01d9\u0090\3\2"+
		"\2\2\u01da\u01dd\5\u008fH\2\u01db\u01dd\5\u008fH\2\u01dc\u01da\3\2\2\2"+
		"\u01dc\u01db\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df"+
		"\3\2\2\2\u01df\u0092\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e5\5\u008fH"+
		"\2\u01e2\u01e4\5\u008fH\2\u01e3\u01e2\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5"+
		"\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u0094\3\2\2\2\u01e7\u01e5\3\2"+
		"\2\2\26\2\u015c\u0161\u0166\u016c\u0172\u0179\u0180\u0188\u018b\u018f"+
		"\u0195\u01c1\u01c5\u01ca\u01cc\u01d2\u01dc\u01de\u01e5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}