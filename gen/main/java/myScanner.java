// Generated from C:/Users/andre/Desktop/TEC/Compiladores/Proyecto 1/interpreter-backend/src/main/java\myScanner.g4 by ANTLR 4.9.1
package main.java;
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
		CHAR=40, INT=41, REAL=42, STRING=43, CLASS=44, PRINT=45, RETURN=46, IF=47, 
		WHILE=48, LET=49, THEN=50, ELSE=51, IN=52, DO=53, BEGIN=54, END=55, CONST=56, 
		VAR=57, INTLITERAL=58, REALLITERAL=59, BOOLLITERAL=60, STRINGLITERAL=61, 
		CHARLITERAL=62, IDENTIFIER=63, WS=64, COMMENT=65, LINE_COMMENT=66, NUM=67;
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
			"ORSYMBOL", "AND", "OR", "BOOLEAN", "LENGTH", "NEW", "CHAR", "INT", "REAL", 
			"STRING", "TRUE", "FALSE", "CLASS", "PRINT", "RETURN", "IF", "WHILE", 
			"LET", "THEN", "ELSE", "IN", "DO", "BEGIN", "END", "CONST", "VAR", "INTLITERAL", 
			"REALLITERAL", "BOOLLITERAL", "STRINGLITERAL", "CHARLITERAL", "PRINTABLE", 
			"IDENTIFIER", "WS", "COMMENT", "LINE_COMMENT", "LETTER", "DIGIT", "NUMBER", 
			"NUM"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'('", "')'", "'~'", "':'", "'+'", "'-'", "'*'", 
			"'/'", "'>'", "'<'", "'>='", "'<='", "'\"'", "'.'", "'_'", "'=='", "'!='", 
			"'['", "']'", "','", "'!'", "'{'", "'}'", "'#'", "'$'", "'%'", "'&&'", 
			"'?'", "'@'", "'^'", "'''", "'||'", "'and'", "'or'", "'boolean'", "'length'", 
			"'new'", "'char'", "'int'", "'real'", "'string'", "'class'", "'print'", 
			"'return'", "'if'", "'while'", "'let'", "'then'", "'else'", "'in'", "'do'", 
			"'begin'", "'end'", "'const'", "'var'"
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
			"ORSYMBOL", "AND", "OR", "BOOLEAN", "LENGTH", "NEW", "CHAR", "INT", "REAL", 
			"STRING", "CLASS", "PRINT", "RETURN", "IF", "WHILE", "LET", "THEN", "ELSE", 
			"IN", "DO", "BEGIN", "END", "CONST", "VAR", "INTLITERAL", "REALLITERAL", 
			"BOOLLITERAL", "STRINGLITERAL", "CHARLITERAL", "IDENTIFIER", "WS", "COMMENT", 
			"LINE_COMMENT", "NUM"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2E\u01d0\b\1\4\2\t"+
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
		"\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3"+
		"$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3"+
		",\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3"+
		"\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\39\39\39\39\3:\3"+
		":\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3=\3=\7=\u0160\n=\f=\16=\u0163\13"+
		"=\3>\3>\7>\u0167\n>\f>\16>\u016a\13>\3>\3>\7>\u016e\n>\f>\16>\u0171\13"+
		">\3>\3>\3>\7>\u0176\n>\f>\16>\u0179\13>\5>\u017b\n>\3?\3?\5?\u017f\n?"+
		"\3@\3@\7@\u0183\n@\f@\16@\u0186\13@\3@\3@\3A\3A\3A\3A\3B\3B\3B\5B\u0191"+
		"\nB\3C\3C\5C\u0195\nC\3C\3C\3C\7C\u019a\nC\fC\16C\u019d\13C\3D\6D\u01a0"+
		"\nD\rD\16D\u01a1\3D\3D\3E\3E\3E\3E\7E\u01aa\nE\fE\16E\u01ad\13E\3E\3E"+
		"\3E\3E\3E\3F\3F\3F\3F\7F\u01b8\nF\fF\16F\u01bb\13F\3F\3F\3G\3G\3H\3H\3"+
		"I\3I\7I\u01c5\nI\fI\16I\u01c8\13I\3J\3J\7J\u01cc\nJ\fJ\16J\u01cf\13J\3"+
		"\u01ab\2K\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2[\2]._/a\60c\61e\62g\63i\64"+
		"k\65m\66o\67q8s9u:w;y<{=}>\177?\u0081@\u0083\2\u0085A\u0087B\u0089C\u008b"+
		"D\u008d\2\u008f\2\u0091\2\u0093E\3\2\7\4\2$$^^\6\2\f\f\17\17$$^^\5\2\13"+
		"\f\17\17\"\"\4\2\f\f\17\17\4\2C\\c|\2\u01db\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2"+
		"w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2"+
		"\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u0093"+
		"\3\2\2\2\3\u0095\3\2\2\2\5\u0097\3\2\2\2\7\u0099\3\2\2\2\t\u009b\3\2\2"+
		"\2\13\u009d\3\2\2\2\r\u009f\3\2\2\2\17\u00a1\3\2\2\2\21\u00a3\3\2\2\2"+
		"\23\u00a5\3\2\2\2\25\u00a7\3\2\2\2\27\u00a9\3\2\2\2\31\u00ab\3\2\2\2\33"+
		"\u00ad\3\2\2\2\35\u00b0\3\2\2\2\37\u00b3\3\2\2\2!\u00b5\3\2\2\2#\u00b7"+
		"\3\2\2\2%\u00b9\3\2\2\2\'\u00bc\3\2\2\2)\u00bf\3\2\2\2+\u00c1\3\2\2\2"+
		"-\u00c3\3\2\2\2/\u00c5\3\2\2\2\61\u00c7\3\2\2\2\63\u00c9\3\2\2\2\65\u00cb"+
		"\3\2\2\2\67\u00cd\3\2\2\29\u00cf\3\2\2\2;\u00d1\3\2\2\2=\u00d4\3\2\2\2"+
		"?\u00d6\3\2\2\2A\u00d8\3\2\2\2C\u00da\3\2\2\2E\u00dc\3\2\2\2G\u00df\3"+
		"\2\2\2I\u00e3\3\2\2\2K\u00e6\3\2\2\2M\u00ee\3\2\2\2O\u00f5\3\2\2\2Q\u00f9"+
		"\3\2\2\2S\u00fe\3\2\2\2U\u0102\3\2\2\2W\u0107\3\2\2\2Y\u010e\3\2\2\2["+
		"\u0113\3\2\2\2]\u0119\3\2\2\2_\u011f\3\2\2\2a\u0125\3\2\2\2c\u012c\3\2"+
		"\2\2e\u012f\3\2\2\2g\u0135\3\2\2\2i\u0139\3\2\2\2k\u013e\3\2\2\2m\u0143"+
		"\3\2\2\2o\u0146\3\2\2\2q\u0149\3\2\2\2s\u014f\3\2\2\2u\u0153\3\2\2\2w"+
		"\u0159\3\2\2\2y\u015d\3\2\2\2{\u017a\3\2\2\2}\u017e\3\2\2\2\177\u0180"+
		"\3\2\2\2\u0081\u0189\3\2\2\2\u0083\u0190\3\2\2\2\u0085\u0194\3\2\2\2\u0087"+
		"\u019f\3\2\2\2\u0089\u01a5\3\2\2\2\u008b\u01b3\3\2\2\2\u008d\u01be\3\2"+
		"\2\2\u008f\u01c0\3\2\2\2\u0091\u01c6\3\2\2\2\u0093\u01c9\3\2\2\2\u0095"+
		"\u0096\7=\2\2\u0096\4\3\2\2\2\u0097\u0098\7?\2\2\u0098\6\3\2\2\2\u0099"+
		"\u009a\7*\2\2\u009a\b\3\2\2\2\u009b\u009c\7+\2\2\u009c\n\3\2\2\2\u009d"+
		"\u009e\7\u0080\2\2\u009e\f\3\2\2\2\u009f\u00a0\7<\2\2\u00a0\16\3\2\2\2"+
		"\u00a1\u00a2\7-\2\2\u00a2\20\3\2\2\2\u00a3\u00a4\7/\2\2\u00a4\22\3\2\2"+
		"\2\u00a5\u00a6\7,\2\2\u00a6\24\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8\26\3"+
		"\2\2\2\u00a9\u00aa\7@\2\2\u00aa\30\3\2\2\2\u00ab\u00ac\7>\2\2\u00ac\32"+
		"\3\2\2\2\u00ad\u00ae\7@\2\2\u00ae\u00af\7?\2\2\u00af\34\3\2\2\2\u00b0"+
		"\u00b1\7>\2\2\u00b1\u00b2\7?\2\2\u00b2\36\3\2\2\2\u00b3\u00b4\7$\2\2\u00b4"+
		" \3\2\2\2\u00b5\u00b6\7\60\2\2\u00b6\"\3\2\2\2\u00b7\u00b8\7a\2\2\u00b8"+
		"$\3\2\2\2\u00b9\u00ba\7?\2\2\u00ba\u00bb\7?\2\2\u00bb&\3\2\2\2\u00bc\u00bd"+
		"\7#\2\2\u00bd\u00be\7?\2\2\u00be(\3\2\2\2\u00bf\u00c0\7]\2\2\u00c0*\3"+
		"\2\2\2\u00c1\u00c2\7_\2\2\u00c2,\3\2\2\2\u00c3\u00c4\7.\2\2\u00c4.\3\2"+
		"\2\2\u00c5\u00c6\7#\2\2\u00c6\60\3\2\2\2\u00c7\u00c8\7}\2\2\u00c8\62\3"+
		"\2\2\2\u00c9\u00ca\7\177\2\2\u00ca\64\3\2\2\2\u00cb\u00cc\7%\2\2\u00cc"+
		"\66\3\2\2\2\u00cd\u00ce\7&\2\2\u00ce8\3\2\2\2\u00cf\u00d0\7\'\2\2\u00d0"+
		":\3\2\2\2\u00d1\u00d2\7(\2\2\u00d2\u00d3\7(\2\2\u00d3<\3\2\2\2\u00d4\u00d5"+
		"\7A\2\2\u00d5>\3\2\2\2\u00d6\u00d7\7B\2\2\u00d7@\3\2\2\2\u00d8\u00d9\7"+
		"`\2\2\u00d9B\3\2\2\2\u00da\u00db\7)\2\2\u00dbD\3\2\2\2\u00dc\u00dd\7~"+
		"\2\2\u00dd\u00de\7~\2\2\u00deF\3\2\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1"+
		"\7p\2\2\u00e1\u00e2\7f\2\2\u00e2H\3\2\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5"+
		"\7t\2\2\u00e5J\3\2\2\2\u00e6\u00e7\7d\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9"+
		"\7q\2\2\u00e9\u00ea\7n\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7c\2\2\u00ec"+
		"\u00ed\7p\2\2\u00edL\3\2\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0\7g\2\2\u00f0"+
		"\u00f1\7p\2\2\u00f1\u00f2\7i\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7j\2\2"+
		"\u00f4N\3\2\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7y\2"+
		"\2\u00f8P\3\2\2\2\u00f9\u00fa\7e\2\2\u00fa\u00fb\7j\2\2\u00fb\u00fc\7"+
		"c\2\2\u00fc\u00fd\7t\2\2\u00fdR\3\2\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100"+
		"\7p\2\2\u0100\u0101\7v\2\2\u0101T\3\2\2\2\u0102\u0103\7t\2\2\u0103\u0104"+
		"\7g\2\2\u0104\u0105\7c\2\2\u0105\u0106\7n\2\2\u0106V\3\2\2\2\u0107\u0108"+
		"\7u\2\2\u0108\u0109\7v\2\2\u0109\u010a\7t\2\2\u010a\u010b\7k\2\2\u010b"+
		"\u010c\7p\2\2\u010c\u010d\7i\2\2\u010dX\3\2\2\2\u010e\u010f\7v\2\2\u010f"+
		"\u0110\7t\2\2\u0110\u0111\7w\2\2\u0111\u0112\7g\2\2\u0112Z\3\2\2\2\u0113"+
		"\u0114\7h\2\2\u0114\u0115\7c\2\2\u0115\u0116\7n\2\2\u0116\u0117\7u\2\2"+
		"\u0117\u0118\7g\2\2\u0118\\\3\2\2\2\u0119\u011a\7e\2\2\u011a\u011b\7n"+
		"\2\2\u011b\u011c\7c\2\2\u011c\u011d\7u\2\2\u011d\u011e\7u\2\2\u011e^\3"+
		"\2\2\2\u011f\u0120\7r\2\2\u0120\u0121\7t\2\2\u0121\u0122\7k\2\2\u0122"+
		"\u0123\7p\2\2\u0123\u0124\7v\2\2\u0124`\3\2\2\2\u0125\u0126\7t\2\2\u0126"+
		"\u0127\7g\2\2\u0127\u0128\7v\2\2\u0128\u0129\7w\2\2\u0129\u012a\7t\2\2"+
		"\u012a\u012b\7p\2\2\u012bb\3\2\2\2\u012c\u012d\7k\2\2\u012d\u012e\7h\2"+
		"\2\u012ed\3\2\2\2\u012f\u0130\7y\2\2\u0130\u0131\7j\2\2\u0131\u0132\7"+
		"k\2\2\u0132\u0133\7n\2\2\u0133\u0134\7g\2\2\u0134f\3\2\2\2\u0135\u0136"+
		"\7n\2\2\u0136\u0137\7g\2\2\u0137\u0138\7v\2\2\u0138h\3\2\2\2\u0139\u013a"+
		"\7v\2\2\u013a\u013b\7j\2\2\u013b\u013c\7g\2\2\u013c\u013d\7p\2\2\u013d"+
		"j\3\2\2\2\u013e\u013f\7g\2\2\u013f\u0140\7n\2\2\u0140\u0141\7u\2\2\u0141"+
		"\u0142\7g\2\2\u0142l\3\2\2\2\u0143\u0144\7k\2\2\u0144\u0145\7p\2\2\u0145"+
		"n\3\2\2\2\u0146\u0147\7f\2\2\u0147\u0148\7q\2\2\u0148p\3\2\2\2\u0149\u014a"+
		"\7d\2\2\u014a\u014b\7g\2\2\u014b\u014c\7i\2\2\u014c\u014d\7k\2\2\u014d"+
		"\u014e\7p\2\2\u014er\3\2\2\2\u014f\u0150\7g\2\2\u0150\u0151\7p\2\2\u0151"+
		"\u0152\7f\2\2\u0152t\3\2\2\2\u0153\u0154\7e\2\2\u0154\u0155\7q\2\2\u0155"+
		"\u0156\7p\2\2\u0156\u0157\7u\2\2\u0157\u0158\7v\2\2\u0158v\3\2\2\2\u0159"+
		"\u015a\7x\2\2\u015a\u015b\7c\2\2\u015b\u015c\7t\2\2\u015cx\3\2\2\2\u015d"+
		"\u0161\5\u008fH\2\u015e\u0160\5\u008fH\2\u015f\u015e\3\2\2\2\u0160\u0163"+
		"\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162z\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0164\u0168\5\u008fH\2\u0165\u0167\5\u008fH\2\u0166\u0165"+
		"\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"\u016b\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016f\5!\21\2\u016c\u016e\5\u008f"+
		"H\2\u016d\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u017b\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\5!"+
		"\21\2\u0173\u0177\5\u008fH\2\u0174\u0176\5\u008fH\2\u0175\u0174\3\2\2"+
		"\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017b"+
		"\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u0164\3\2\2\2\u017a\u0172\3\2\2\2\u017b"+
		"|\3\2\2\2\u017c\u017f\5Y-\2\u017d\u017f\5[.\2\u017e\u017c\3\2\2\2\u017e"+
		"\u017d\3\2\2\2\u017f~\3\2\2\2\u0180\u0184\5\37\20\2\u0181\u0183\5\u0083"+
		"B\2\u0182\u0181\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u0187\3\2\2\2\u0186\u0184\3\2\2\2\u0187\u0188\5\37"+
		"\20\2\u0188\u0080\3\2\2\2\u0189\u018a\5C\"\2\u018a\u018b\5\u0083B\2\u018b"+
		"\u018c\5C\"\2\u018c\u0082\3\2\2\2\u018d\u018e\7^\2\2\u018e\u0191\t\2\2"+
		"\2\u018f\u0191\n\3\2\2\u0190\u018d\3\2\2\2\u0190\u018f\3\2\2\2\u0191\u0084"+
		"\3\2\2\2\u0192\u0195\5#\22\2\u0193\u0195\5\u008dG\2\u0194\u0192\3\2\2"+
		"\2\u0194\u0193\3\2\2\2\u0195\u019b\3\2\2\2\u0196\u019a\5#\22\2\u0197\u019a"+
		"\5\u008dG\2\u0198\u019a\5\u008fH\2\u0199\u0196\3\2\2\2\u0199\u0197\3\2"+
		"\2\2\u0199\u0198\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u0086\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u01a0\t\4"+
		"\2\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\bD\2\2\u01a4\u0088\3\2"+
		"\2\2\u01a5\u01a6\7\61\2\2\u01a6\u01a7\7,\2\2\u01a7\u01ab\3\2\2\2\u01a8"+
		"\u01aa\13\2\2\2\u01a9\u01a8\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01ac\3"+
		"\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ae\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ae"+
		"\u01af\7,\2\2\u01af\u01b0\7\61\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\bE"+
		"\2\2\u01b2\u008a\3\2\2\2\u01b3\u01b4\7\61\2\2\u01b4\u01b5\7\61\2\2\u01b5"+
		"\u01b9\3\2\2\2\u01b6\u01b8\n\5\2\2\u01b7\u01b6\3\2\2\2\u01b8\u01bb\3\2"+
		"\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bc\3\2\2\2\u01bb"+
		"\u01b9\3\2\2\2\u01bc\u01bd\bF\2\2\u01bd\u008c\3\2\2\2\u01be\u01bf\t\6"+
		"\2\2\u01bf\u008e\3\2\2\2\u01c0\u01c1\4\62;\2\u01c1\u0090\3\2\2\2\u01c2"+
		"\u01c5\5\u008fH\2\u01c3\u01c5\5\u008fH\2\u01c4\u01c2\3\2\2\2\u01c4\u01c3"+
		"\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"\u0092\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01cd\5\u008fH\2\u01ca\u01cc"+
		"\5\u008fH\2\u01cb\u01ca\3\2\2\2\u01cc\u01cf\3\2\2\2\u01cd\u01cb\3\2\2"+
		"\2\u01cd\u01ce\3\2\2\2\u01ce\u0094\3\2\2\2\u01cf\u01cd\3\2\2\2\24\2\u0161"+
		"\u0168\u016f\u0177\u017a\u017e\u0184\u0190\u0194\u0199\u019b\u01a1\u01ab"+
		"\u01b9\u01c4\u01c6\u01cd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}