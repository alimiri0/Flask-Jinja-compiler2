// Generated from src/grammers/MiniFlaskParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniFlaskParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEF=1, IF=2, RETURN=3, APP=4, ROUTE=5, FOR=6, IN=7, FROM=8, IMPORT=9, 
		NONE=10, TRUE=11, FALSE=12, STRING=13, NUMBER=14, IDENT=15, AT=16, DOT=17, 
		LPAREN=18, RPAREN=19, LBRACK=20, RBRACK=21, LBRACE=22, RBRACE=23, COMMA=24, 
		COLON=25, EQUALS=26, PLUS=27, STAR=28, DOUBLESTAR=29, EQEQ=30, COMMENT=31, 
		WS=32, NEWLINE=33;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_importStmt = 2, RULE_importNames = 3, 
		RULE_routeDef = 4, RULE_routeArgs = 5, RULE_routeArg = 6, RULE_funcDef = 7, 
		RULE_params = 8, RULE_param = 9, RULE_simpleParam = 10, RULE_defaultParam = 11, 
		RULE_typeAnnotatedParam = 12, RULE_typeAnnotatedDefaultParam = 13, RULE_starParam = 14, 
		RULE_doubleStarParam = 15, RULE_typeExpr = 16, RULE_assign = 17, RULE_ifStmt = 18, 
		RULE_returnStmt = 19, RULE_exprStmt = 20, RULE_expr = 21, RULE_additive = 22, 
		RULE_primary = 23, RULE_suffix = 24, RULE_routeArgKws = 25, RULE_arg = 26, 
		RULE_atom = 27, RULE_listLiteral = 28, RULE_dictLiteral = 29, RULE_pair = 30, 
		RULE_genExpr = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "importStmt", "importNames", "routeDef", "routeArgs", 
			"routeArg", "funcDef", "params", "param", "simpleParam", "defaultParam", 
			"typeAnnotatedParam", "typeAnnotatedDefaultParam", "starParam", "doubleStarParam", 
			"typeExpr", "assign", "ifStmt", "returnStmt", "exprStmt", "expr", "additive", 
			"primary", "suffix", "routeArgKws", "arg", "atom", "listLiteral", "dictLiteral", 
			"pair", "genExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'if'", "'return'", "'app'", "'route'", "'for'", "'in'", 
			"'from'", "'import'", "'None'", "'True'", "'False'", null, null, null, 
			"'@'", "'.'", "'('", "')'", "'['", "']'", "'{'", "'}'", "','", "':'", 
			"'='", "'+'", "'*'", "'**'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DEF", "IF", "RETURN", "APP", "ROUTE", "FOR", "IN", "FROM", "IMPORT", 
			"NONE", "TRUE", "FALSE", "STRING", "NUMBER", "IDENT", "AT", "DOT", "LPAREN", 
			"RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "COMMA", "COLON", "EQUALS", 
			"PLUS", "STAR", "DOUBLESTAR", "EQEQ", "COMMENT", "WS", "NEWLINE"
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
	public String getGrammarFileName() { return "MiniFlaskParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniFlaskParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniFlaskParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(MiniFlaskParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MiniFlaskParser.NEWLINE, i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8595570462L) != 0)) {
				{
				{
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(64);
					match(NEWLINE);
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(70);
				statement();
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(71);
						match(NEWLINE);
						}
						} 
					}
					setState(76);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAssignStmtContext extends StatementContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public FlaskAssignStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAssignStmt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskRouteDefStmtContext extends StatementContext {
		public RouteDefContext routeDef() {
			return getRuleContext(RouteDefContext.class,0);
		}
		public FlaskRouteDefStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskRouteDefStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskRouteDefStmt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskFuncDefStmtContext extends StatementContext {
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public FlaskFuncDefStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskFuncDefStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskFuncDefStmt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskIfStmtContext extends StatementContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public FlaskIfStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskIfStmt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskReturnStmtContext extends StatementContext {
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public FlaskReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskReturnStmt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskImportStmtContext extends StatementContext {
		public ImportStmtContext importStmt() {
			return getRuleContext(ImportStmtContext.class,0);
		}
		public FlaskImportStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskImportStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskImportStmt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskExprStmtContext extends StatementContext {
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public FlaskExprStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskExprStmt(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new FlaskImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				importStmt();
				}
				break;
			case 2:
				_localctx = new FlaskRouteDefStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				routeDef();
				}
				break;
			case 3:
				_localctx = new FlaskFuncDefStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				funcDef();
				}
				break;
			case 4:
				_localctx = new FlaskAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				assign();
				}
				break;
			case 5:
				_localctx = new FlaskIfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				ifStmt();
				}
				break;
			case 6:
				_localctx = new FlaskReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
				returnStmt();
				}
				break;
			case 7:
				_localctx = new FlaskExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(90);
				exprStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStmtContext extends ParserRuleContext {
		public ImportStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStmt; }
	 
		public ImportStmtContext() { }
		public void copyFrom(ImportStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskFromImportStmtContext extends ImportStmtContext {
		public TerminalNode FROM() { return getToken(MiniFlaskParser.FROM, 0); }
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public TerminalNode IMPORT() { return getToken(MiniFlaskParser.IMPORT, 0); }
		public ImportNamesContext importNames() {
			return getRuleContext(ImportNamesContext.class,0);
		}
		public FlaskFromImportStmtContext(ImportStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskFromImportStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskFromImportStmt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskImportNamesStmtContext extends ImportStmtContext {
		public TerminalNode IMPORT() { return getToken(MiniFlaskParser.IMPORT, 0); }
		public ImportNamesContext importNames() {
			return getRuleContext(ImportNamesContext.class,0);
		}
		public FlaskImportNamesStmtContext(ImportStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskImportNamesStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskImportNamesStmt(this);
		}
	}

	public final ImportStmtContext importStmt() throws RecognitionException {
		ImportStmtContext _localctx = new ImportStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importStmt);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				_localctx = new FlaskImportNamesStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(IMPORT);
				setState(94);
				importNames();
				}
				break;
			case FROM:
				_localctx = new FlaskFromImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(FROM);
				setState(96);
				match(IDENT);
				setState(97);
				match(IMPORT);
				setState(98);
				importNames();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportNamesContext extends ParserRuleContext {
		public ImportNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importNames; }
	 
		public ImportNamesContext() { }
		public void copyFrom(ImportNamesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskImportNameListContext extends ImportNamesContext {
		public List<TerminalNode> IDENT() { return getTokens(MiniFlaskParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(MiniFlaskParser.IDENT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public FlaskImportNameListContext(ImportNamesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskImportNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskImportNameList(this);
		}
	}

	public final ImportNamesContext importNames() throws RecognitionException {
		ImportNamesContext _localctx = new ImportNamesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importNames);
		int _la;
		try {
			_localctx = new FlaskImportNameListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IDENT);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(102);
				match(COMMA);
				setState(103);
				match(IDENT);
				}
				}
				setState(108);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RouteDefContext extends ParserRuleContext {
		public RouteDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeDef; }
	 
		public RouteDefContext() { }
		public void copyFrom(RouteDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskRouteDefinitionContext extends RouteDefContext {
		public TerminalNode AT() { return getToken(MiniFlaskParser.AT, 0); }
		public TerminalNode APP() { return getToken(MiniFlaskParser.APP, 0); }
		public TerminalNode DOT() { return getToken(MiniFlaskParser.DOT, 0); }
		public TerminalNode ROUTE() { return getToken(MiniFlaskParser.ROUTE, 0); }
		public TerminalNode LPAREN() { return getToken(MiniFlaskParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniFlaskParser.RPAREN, 0); }
		public TerminalNode NEWLINE() { return getToken(MiniFlaskParser.NEWLINE, 0); }
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public RouteArgsContext routeArgs() {
			return getRuleContext(RouteArgsContext.class,0);
		}
		public FlaskRouteDefinitionContext(RouteDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskRouteDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskRouteDefinition(this);
		}
	}

	public final RouteDefContext routeDef() throws RecognitionException {
		RouteDefContext _localctx = new RouteDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_routeDef);
		int _la;
		try {
			_localctx = new FlaskRouteDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(AT);
			setState(110);
			match(APP);
			setState(111);
			match(DOT);
			setState(112);
			match(ROUTE);
			setState(113);
			match(LPAREN);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING || _la==IDENT) {
				{
				setState(114);
				routeArgs();
				}
			}

			setState(117);
			match(RPAREN);
			setState(118);
			match(NEWLINE);
			setState(119);
			funcDef();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RouteArgsContext extends ParserRuleContext {
		public RouteArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeArgs; }
	 
		public RouteArgsContext() { }
		public void copyFrom(RouteArgsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskRouteArgsListContext extends RouteArgsContext {
		public List<RouteArgContext> routeArg() {
			return getRuleContexts(RouteArgContext.class);
		}
		public RouteArgContext routeArg(int i) {
			return getRuleContext(RouteArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public FlaskRouteArgsListContext(RouteArgsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskRouteArgsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskRouteArgsList(this);
		}
	}

	public final RouteArgsContext routeArgs() throws RecognitionException {
		RouteArgsContext _localctx = new RouteArgsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_routeArgs);
		int _la;
		try {
			_localctx = new FlaskRouteArgsListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			routeArg();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(122);
				match(COMMA);
				setState(123);
				routeArg();
				}
				}
				setState(128);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RouteArgContext extends ParserRuleContext {
		public RouteArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeArg; }
	 
		public RouteArgContext() { }
		public void copyFrom(RouteArgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskRouteArgStringContext extends RouteArgContext {
		public TerminalNode STRING() { return getToken(MiniFlaskParser.STRING, 0); }
		public FlaskRouteArgStringContext(RouteArgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskRouteArgString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskRouteArgString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskRouteArgKwContext extends RouteArgContext {
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public TerminalNode EQUALS() { return getToken(MiniFlaskParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FlaskRouteArgKwContext(RouteArgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskRouteArgKw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskRouteArgKw(this);
		}
	}

	public final RouteArgContext routeArg() throws RecognitionException {
		RouteArgContext _localctx = new RouteArgContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_routeArg);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new FlaskRouteArgStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(STRING);
				}
				break;
			case IDENT:
				_localctx = new FlaskRouteArgKwContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(IDENT);
				setState(131);
				match(EQUALS);
				setState(132);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	 
		public FuncDefContext() { }
		public void copyFrom(FuncDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskFunctionDefContext extends FuncDefContext {
		public TerminalNode DEF() { return getToken(MiniFlaskParser.DEF, 0); }
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(MiniFlaskParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniFlaskParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(MiniFlaskParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(MiniFlaskParser.NEWLINE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FlaskFunctionDefContext(FuncDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskFunctionDef(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcDef);
		int _la;
		try {
			int _alt;
			_localctx = new FlaskFunctionDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(DEF);
			setState(136);
			match(IDENT);
			setState(137);
			match(LPAREN);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 805339136L) != 0)) {
				{
				setState(138);
				params();
				}
			}

			setState(141);
			match(RPAREN);
			setState(142);
			match(COLON);
			setState(143);
			match(NEWLINE);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(144);
					statement();
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	 
		public ParamsContext() { }
		public void copyFrom(ParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskParamsListContext extends ParamsContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public FlaskParamsListContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskParamsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskParamsList(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_params);
		int _la;
		try {
			_localctx = new FlaskParamsListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			param();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(151);
				match(COMMA);
				setState(152);
				param();
				}
				}
				setState(157);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskParamDoubleStarContext extends ParamContext {
		public DoubleStarParamContext doubleStarParam() {
			return getRuleContext(DoubleStarParamContext.class,0);
		}
		public FlaskParamDoubleStarContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskParamDoubleStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskParamDoubleStar(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskParamTypeDefaultContext extends ParamContext {
		public TypeAnnotatedDefaultParamContext typeAnnotatedDefaultParam() {
			return getRuleContext(TypeAnnotatedDefaultParamContext.class,0);
		}
		public FlaskParamTypeDefaultContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskParamTypeDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskParamTypeDefault(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskParamTypeContext extends ParamContext {
		public TypeAnnotatedParamContext typeAnnotatedParam() {
			return getRuleContext(TypeAnnotatedParamContext.class,0);
		}
		public FlaskParamTypeContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskParamType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskParamType(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskParamSimpleContext extends ParamContext {
		public SimpleParamContext simpleParam() {
			return getRuleContext(SimpleParamContext.class,0);
		}
		public FlaskParamSimpleContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskParamSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskParamSimple(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskParamDefaultContext extends ParamContext {
		public DefaultParamContext defaultParam() {
			return getRuleContext(DefaultParamContext.class,0);
		}
		public FlaskParamDefaultContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskParamDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskParamDefault(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskParamStarContext extends ParamContext {
		public StarParamContext starParam() {
			return getRuleContext(StarParamContext.class,0);
		}
		public FlaskParamStarContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskParamStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskParamStar(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_param);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new FlaskParamSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				simpleParam();
				}
				break;
			case 2:
				_localctx = new FlaskParamDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				defaultParam();
				}
				break;
			case 3:
				_localctx = new FlaskParamTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				typeAnnotatedParam();
				}
				break;
			case 4:
				_localctx = new FlaskParamTypeDefaultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				typeAnnotatedDefaultParam();
				}
				break;
			case 5:
				_localctx = new FlaskParamStarContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
				starParam();
				}
				break;
			case 6:
				_localctx = new FlaskParamDoubleStarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(163);
				doubleStarParam();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleParamContext extends ParserRuleContext {
		public SimpleParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleParam; }
	 
		public SimpleParamContext() { }
		public void copyFrom(SimpleParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskSimpleParamContext extends SimpleParamContext {
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public FlaskSimpleParamContext(SimpleParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskSimpleParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskSimpleParam(this);
		}
	}

	public final SimpleParamContext simpleParam() throws RecognitionException {
		SimpleParamContext _localctx = new SimpleParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_simpleParam);
		try {
			_localctx = new FlaskSimpleParamContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultParamContext extends ParserRuleContext {
		public DefaultParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultParam; }
	 
		public DefaultParamContext() { }
		public void copyFrom(DefaultParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskDefaultParamContext extends DefaultParamContext {
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public TerminalNode EQUALS() { return getToken(MiniFlaskParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FlaskDefaultParamContext(DefaultParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskDefaultParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskDefaultParam(this);
		}
	}

	public final DefaultParamContext defaultParam() throws RecognitionException {
		DefaultParamContext _localctx = new DefaultParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_defaultParam);
		try {
			_localctx = new FlaskDefaultParamContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(IDENT);
			setState(169);
			match(EQUALS);
			setState(170);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeAnnotatedParamContext extends ParserRuleContext {
		public TypeAnnotatedParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeAnnotatedParam; }
	 
		public TypeAnnotatedParamContext() { }
		public void copyFrom(TypeAnnotatedParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskTypeAnnotatedParamContext extends TypeAnnotatedParamContext {
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public TerminalNode COLON() { return getToken(MiniFlaskParser.COLON, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public FlaskTypeAnnotatedParamContext(TypeAnnotatedParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskTypeAnnotatedParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskTypeAnnotatedParam(this);
		}
	}

	public final TypeAnnotatedParamContext typeAnnotatedParam() throws RecognitionException {
		TypeAnnotatedParamContext _localctx = new TypeAnnotatedParamContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typeAnnotatedParam);
		try {
			_localctx = new FlaskTypeAnnotatedParamContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(IDENT);
			setState(173);
			match(COLON);
			setState(174);
			typeExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeAnnotatedDefaultParamContext extends ParserRuleContext {
		public TypeAnnotatedDefaultParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeAnnotatedDefaultParam; }
	 
		public TypeAnnotatedDefaultParamContext() { }
		public void copyFrom(TypeAnnotatedDefaultParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskTypeAnnotatedDefaultParamContext extends TypeAnnotatedDefaultParamContext {
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public TerminalNode COLON() { return getToken(MiniFlaskParser.COLON, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(MiniFlaskParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FlaskTypeAnnotatedDefaultParamContext(TypeAnnotatedDefaultParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskTypeAnnotatedDefaultParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskTypeAnnotatedDefaultParam(this);
		}
	}

	public final TypeAnnotatedDefaultParamContext typeAnnotatedDefaultParam() throws RecognitionException {
		TypeAnnotatedDefaultParamContext _localctx = new TypeAnnotatedDefaultParamContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeAnnotatedDefaultParam);
		try {
			_localctx = new FlaskTypeAnnotatedDefaultParamContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(IDENT);
			setState(177);
			match(COLON);
			setState(178);
			typeExpr();
			setState(179);
			match(EQUALS);
			setState(180);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StarParamContext extends ParserRuleContext {
		public StarParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starParam; }
	 
		public StarParamContext() { }
		public void copyFrom(StarParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskStarParamContext extends StarParamContext {
		public TerminalNode STAR() { return getToken(MiniFlaskParser.STAR, 0); }
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public FlaskStarParamContext(StarParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskStarParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskStarParam(this);
		}
	}

	public final StarParamContext starParam() throws RecognitionException {
		StarParamContext _localctx = new StarParamContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_starParam);
		try {
			_localctx = new FlaskStarParamContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(STAR);
			setState(183);
			match(IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DoubleStarParamContext extends ParserRuleContext {
		public DoubleStarParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleStarParam; }
	 
		public DoubleStarParamContext() { }
		public void copyFrom(DoubleStarParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskDoubleStarParamContext extends DoubleStarParamContext {
		public TerminalNode DOUBLESTAR() { return getToken(MiniFlaskParser.DOUBLESTAR, 0); }
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public FlaskDoubleStarParamContext(DoubleStarParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskDoubleStarParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskDoubleStarParam(this);
		}
	}

	public final DoubleStarParamContext doubleStarParam() throws RecognitionException {
		DoubleStarParamContext _localctx = new DoubleStarParamContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_doubleStarParam);
		try {
			_localctx = new FlaskDoubleStarParamContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(DOUBLESTAR);
			setState(186);
			match(IDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeExprContext extends ParserRuleContext {
		public TypeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeExpr; }
	 
		public TypeExprContext() { }
		public void copyFrom(TypeExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskTypeExprContext extends TypeExprContext {
		public List<TerminalNode> IDENT() { return getTokens(MiniFlaskParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(MiniFlaskParser.IDENT, i);
		}
		public List<TerminalNode> DOT() { return getTokens(MiniFlaskParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MiniFlaskParser.DOT, i);
		}
		public FlaskTypeExprContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskTypeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskTypeExpr(this);
		}
	}

	public final TypeExprContext typeExpr() throws RecognitionException {
		TypeExprContext _localctx = new TypeExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeExpr);
		int _la;
		try {
			_localctx = new FlaskTypeExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(IDENT);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(189);
				match(DOT);
				setState(190);
				match(IDENT);
				}
				}
				setState(195);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	 
		public AssignContext() { }
		public void copyFrom(AssignContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAssignmentContext extends AssignContext {
		public TerminalNode EQUALS() { return getToken(MiniFlaskParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public TerminalNode APP() { return getToken(MiniFlaskParser.APP, 0); }
		public FlaskAssignmentContext(AssignContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAssignment(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assign);
		int _la;
		try {
			_localctx = new FlaskAssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_la = _input.LA(1);
			if ( !(_la==APP || _la==IDENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(197);
			match(EQUALS);
			setState(198);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	 
		public IfStmtContext() { }
		public void copyFrom(IfStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskIfStatementContext extends IfStmtContext {
		public TerminalNode IF() { return getToken(MiniFlaskParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MiniFlaskParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(MiniFlaskParser.NEWLINE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FlaskIfStatementContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskIfStatement(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStmt);
		try {
			int _alt;
			_localctx = new FlaskIfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(IF);
			setState(201);
			expr();
			setState(202);
			match(COLON);
			setState(203);
			match(NEWLINE);
			setState(205); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(204);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(207); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	 
		public ReturnStmtContext() { }
		public void copyFrom(ReturnStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskReturnStatementContext extends ReturnStmtContext {
		public TerminalNode RETURN() { return getToken(MiniFlaskParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FlaskReturnStatementContext(ReturnStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskReturnStatement(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStmt);
		try {
			_localctx = new FlaskReturnStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(RETURN);
			setState(210);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends ParserRuleContext {
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
	 
		public ExprStmtContext() { }
		public void copyFrom(ExprStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskExpressionStatementContext extends ExprStmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FlaskExpressionStatementContext(ExprStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskExpressionStatement(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprStmt);
		try {
			_localctx = new FlaskExpressionStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskEqualityExprContext extends ExprContext {
		public List<AdditiveContext> additive() {
			return getRuleContexts(AdditiveContext.class);
		}
		public AdditiveContext additive(int i) {
			return getRuleContext(AdditiveContext.class,i);
		}
		public TerminalNode EQEQ() { return getToken(MiniFlaskParser.EQEQ, 0); }
		public FlaskEqualityExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskEqualityExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr);
		int _la;
		try {
			_localctx = new FlaskEqualityExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			additive();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQEQ) {
				{
				setState(215);
				match(EQEQ);
				setState(216);
				additive();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveContext extends ParserRuleContext {
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
	 
		public AdditiveContext() { }
		public void copyFrom(AdditiveContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAdditiveExprContext extends AdditiveContext {
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(MiniFlaskParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(MiniFlaskParser.PLUS, i);
		}
		public FlaskAdditiveExprContext(AdditiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAdditiveExpr(this);
		}
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_additive);
		int _la;
		try {
			_localctx = new FlaskAdditiveExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			primary();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(220);
				match(PLUS);
				setState(221);
				primary();
				}
				}
				setState(226);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskPrimaryExprContext extends PrimaryContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<SuffixContext> suffix() {
			return getRuleContexts(SuffixContext.class);
		}
		public SuffixContext suffix(int i) {
			return getRuleContext(SuffixContext.class,i);
		}
		public FlaskPrimaryExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskPrimaryExpr(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_primary);
		try {
			int _alt;
			_localctx = new FlaskPrimaryExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			atom();
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(228);
					suffix();
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SuffixContext extends ParserRuleContext {
		public SuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix; }
	 
		public SuffixContext() { }
		public void copyFrom(SuffixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskCallSuffixContext extends SuffixContext {
		public TerminalNode LPAREN() { return getToken(MiniFlaskParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniFlaskParser.RPAREN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(MiniFlaskParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MiniFlaskParser.NEWLINE, i);
		}
		public RouteArgKwsContext routeArgKws() {
			return getRuleContext(RouteArgKwsContext.class,0);
		}
		public FlaskCallSuffixContext(SuffixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskCallSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskCallSuffix(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskGenExprContext extends SuffixContext {
		public GenExprContext genExpr() {
			return getRuleContext(GenExprContext.class,0);
		}
		public FlaskGenExprContext(SuffixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskGenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskGenExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAttrAccessContext extends SuffixContext {
		public TerminalNode DOT() { return getToken(MiniFlaskParser.DOT, 0); }
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public FlaskAttrAccessContext(SuffixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAttrAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAttrAccess(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskIndexingContext extends SuffixContext {
		public TerminalNode LBRACK() { return getToken(MiniFlaskParser.LBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(MiniFlaskParser.RBRACK, 0); }
		public FlaskIndexingContext(SuffixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskIndexing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskIndexing(this);
		}
	}

	public final SuffixContext suffix() throws RecognitionException {
		SuffixContext _localctx = new SuffixContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_suffix);
		int _la;
		try {
			int _alt;
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new FlaskAttrAccessContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(DOT);
				setState(235);
				match(IDENT);
				}
				break;
			case 2:
				_localctx = new FlaskIndexingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(LBRACK);
				setState(237);
				expr();
				setState(238);
				match(RBRACK);
				}
				break;
			case 3:
				_localctx = new FlaskCallSuffixContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(LPAREN);
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(241);
						match(NEWLINE);
						}
						} 
					}
					setState(246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5569552L) != 0)) {
					{
					setState(247);
					routeArgKws();
					}
				}

				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(250);
					match(NEWLINE);
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(256);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new FlaskGenExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				genExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RouteArgKwsContext extends ParserRuleContext {
		public RouteArgKwsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeArgKws; }
	 
		public RouteArgKwsContext() { }
		public void copyFrom(RouteArgKwsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskArgsListContext extends RouteArgKwsContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(MiniFlaskParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MiniFlaskParser.NEWLINE, i);
		}
		public FlaskArgsListContext(RouteArgKwsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskArgsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskArgsList(this);
		}
	}

	public final RouteArgKwsContext routeArgKws() throws RecognitionException {
		RouteArgKwsContext _localctx = new RouteArgKwsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_routeArgKws);
		int _la;
		try {
			int _alt;
			_localctx = new FlaskArgsListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			arg();
			setState(277);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(261);
						match(NEWLINE);
						}
						}
						setState(266);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(267);
					match(COMMA);
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(268);
						match(NEWLINE);
						}
						}
						setState(273);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(274);
					arg();
					}
					} 
				}
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgContext extends ParserRuleContext {
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
	 
		public ArgContext() { }
		public void copyFrom(ArgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskKwArgContext extends ArgContext {
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public TerminalNode EQUALS() { return getToken(MiniFlaskParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FlaskKwArgContext(ArgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskKwArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskKwArg(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskPosArgContext extends ArgContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FlaskPosArgContext(ArgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskPosArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskPosArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_arg);
		try {
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new FlaskKwArgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(IDENT);
				setState(281);
				match(EQUALS);
				setState(282);
				expr();
				}
				break;
			case 2:
				_localctx = new FlaskPosArgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomStringContext extends AtomContext {
		public TerminalNode STRING() { return getToken(MiniFlaskParser.STRING, 0); }
		public FlaskAtomStringContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomListContext extends AtomContext {
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public FlaskAtomListContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomList(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomFalseContext extends AtomContext {
		public TerminalNode FALSE() { return getToken(MiniFlaskParser.FALSE, 0); }
		public FlaskAtomFalseContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomFalse(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomGenExprContext extends AtomContext {
		public GenExprContext genExpr() {
			return getRuleContext(GenExprContext.class,0);
		}
		public FlaskAtomGenExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomGenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomGenExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomNumberContext extends AtomContext {
		public TerminalNode NUMBER() { return getToken(MiniFlaskParser.NUMBER, 0); }
		public FlaskAtomNumberContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomNumber(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlskAtomAppContext extends AtomContext {
		public TerminalNode APP() { return getToken(MiniFlaskParser.APP, 0); }
		public FlskAtomAppContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlskAtomApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlskAtomApp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomTrueContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(MiniFlaskParser.TRUE, 0); }
		public FlaskAtomTrueContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomTrue(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomDictContext extends AtomContext {
		public DictLiteralContext dictLiteral() {
			return getRuleContext(DictLiteralContext.class,0);
		}
		public FlaskAtomDictContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomDict(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomDict(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomNameContext extends AtomContext {
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public FlaskAtomNameContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomName(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomParenContext extends AtomContext {
		public TerminalNode LPAREN() { return getToken(MiniFlaskParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniFlaskParser.RPAREN, 0); }
		public FlaskAtomParenContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomParen(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskAtomNoneContext extends AtomContext {
		public TerminalNode NONE() { return getToken(MiniFlaskParser.NONE, 0); }
		public FlaskAtomNoneContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskAtomNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskAtomNone(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_atom);
		try {
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new FlaskAtomNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(IDENT);
				}
				break;
			case 2:
				_localctx = new FlaskAtomStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(STRING);
				}
				break;
			case 3:
				_localctx = new FlaskAtomNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				match(NUMBER);
				}
				break;
			case 4:
				_localctx = new FlskAtomAppContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(289);
				match(APP);
				}
				break;
			case 5:
				_localctx = new FlaskAtomNoneContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(290);
				match(NONE);
				}
				break;
			case 6:
				_localctx = new FlaskAtomTrueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(291);
				match(TRUE);
				}
				break;
			case 7:
				_localctx = new FlaskAtomFalseContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(292);
				match(FALSE);
				}
				break;
			case 8:
				_localctx = new FlaskAtomListContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(293);
				listLiteral();
				}
				break;
			case 9:
				_localctx = new FlaskAtomDictContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(294);
				dictLiteral();
				}
				break;
			case 10:
				_localctx = new FlaskAtomGenExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(295);
				genExpr();
				}
				break;
			case 11:
				_localctx = new FlaskAtomParenContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(296);
				match(LPAREN);
				setState(297);
				expr();
				setState(298);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListLiteralContext extends ParserRuleContext {
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
	 
		public ListLiteralContext() { }
		public void copyFrom(ListLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskListLiteralContext extends ListLiteralContext {
		public TerminalNode LBRACK() { return getToken(MiniFlaskParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MiniFlaskParser.RBRACK, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(MiniFlaskParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MiniFlaskParser.NEWLINE, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public FlaskListLiteralContext(ListLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskListLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskListLiteral(this);
		}
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_listLiteral);
		int _la;
		try {
			int _alt;
			_localctx = new FlaskListLiteralContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(LBRACK);
			setState(306);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(303);
					match(NEWLINE);
					}
					} 
				}
				setState(308);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5569552L) != 0)) {
				{
				setState(309);
				expr();
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(313);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(310);
							match(NEWLINE);
							}
							}
							setState(315);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(316);
						match(COMMA);
						setState(320);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(317);
							match(NEWLINE);
							}
							}
							setState(322);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(323);
						expr();
						}
						} 
					}
					setState(328);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(329);
						match(NEWLINE);
						}
						} 
					}
					setState(334);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(335);
					match(COMMA);
					}
				}

				}
			}

			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(340);
				match(NEWLINE);
				}
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(346);
			match(RBRACK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DictLiteralContext extends ParserRuleContext {
		public DictLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictLiteral; }
	 
		public DictLiteralContext() { }
		public void copyFrom(DictLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskDictLiteralContext extends DictLiteralContext {
		public TerminalNode LBRACE() { return getToken(MiniFlaskParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniFlaskParser.RBRACE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(MiniFlaskParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MiniFlaskParser.NEWLINE, i);
		}
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniFlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniFlaskParser.COMMA, i);
		}
		public FlaskDictLiteralContext(DictLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskDictLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskDictLiteral(this);
		}
	}

	public final DictLiteralContext dictLiteral() throws RecognitionException {
		DictLiteralContext _localctx = new DictLiteralContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_dictLiteral);
		int _la;
		try {
			int _alt;
			_localctx = new FlaskDictLiteralContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(LBRACE);
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(349);
					match(NEWLINE);
					}
					} 
				}
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING || _la==IDENT) {
				{
				setState(355);
				pair();
				setState(372);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(359);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(356);
							match(NEWLINE);
							}
							}
							setState(361);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(362);
						match(COMMA);
						setState(366);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(363);
							match(NEWLINE);
							}
							}
							setState(368);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(369);
						pair();
						}
						} 
					}
					setState(374);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(375);
						match(NEWLINE);
						}
						} 
					}
					setState(380);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(381);
					match(COMMA);
					}
				}

				}
			}

			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(386);
				match(NEWLINE);
				}
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(392);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PairContext extends ParserRuleContext {
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
	 
		public PairContext() { }
		public void copyFrom(PairContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskDictPairContext extends PairContext {
		public TerminalNode COLON() { return getToken(MiniFlaskParser.COLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING() { return getToken(MiniFlaskParser.STRING, 0); }
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public FlaskDictPairContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskDictPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskDictPair(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pair);
		int _la;
		try {
			_localctx = new FlaskDictPairContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==IDENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(395);
			match(COLON);
			setState(396);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class GenExprContext extends ParserRuleContext {
		public GenExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genExpr; }
	 
		public GenExprContext() { }
		public void copyFrom(GenExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskGeneratorExprContext extends GenExprContext {
		public TerminalNode LPAREN() { return getToken(MiniFlaskParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FOR() { return getToken(MiniFlaskParser.FOR, 0); }
		public TerminalNode IDENT() { return getToken(MiniFlaskParser.IDENT, 0); }
		public TerminalNode IN() { return getToken(MiniFlaskParser.IN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniFlaskParser.RPAREN, 0); }
		public TerminalNode IF() { return getToken(MiniFlaskParser.IF, 0); }
		public FlaskGeneratorExprContext(GenExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).enterFlaskGeneratorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniFlaskParserListener ) ((MiniFlaskParserListener)listener).exitFlaskGeneratorExpr(this);
		}
	}

	public final GenExprContext genExpr() throws RecognitionException {
		GenExprContext _localctx = new GenExprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_genExpr);
		int _la;
		try {
			_localctx = new FlaskGeneratorExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(LPAREN);
			setState(399);
			expr();
			setState(400);
			match(FOR);
			setState(401);
			match(IDENT);
			setState(402);
			match(IN);
			setState(403);
			expr();
			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(404);
				match(IF);
				setState(405);
				expr();
				}
			}

			setState(408);
			match(RPAREN);
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
		"\u0004\u0001!\u019b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0001\u0000\u0005\u0000B\b\u0000\n\u0000\f\u0000"+
		"E\t\u0000\u0001\u0000\u0001\u0000\u0005\u0000I\b\u0000\n\u0000\f\u0000"+
		"L\t\u0000\u0005\u0000N\b\u0000\n\u0000\f\u0000Q\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\\\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002d\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003i\b\u0003\n\u0003\f\u0003l\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004t\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005}\b\u0005\n\u0005"+
		"\f\u0005\u0080\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u0086\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u008c\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u0092\b\u0007\n\u0007\f\u0007\u0095\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u009a\b\b\n\b\f\b\u009d\t\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u00a5\b\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u00c0\b\u0010\n\u0010\f\u0010\u00c3\t\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0004\u0012\u00ce\b\u0012\u000b\u0012\f\u0012"+
		"\u00cf\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00da\b\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u00df\b\u0016\n\u0016\f\u0016\u00e2\t\u0016"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u00e6\b\u0017\n\u0017\f\u0017\u00e9"+
		"\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u00f3\b\u0018\n\u0018\f\u0018"+
		"\u00f6\t\u0018\u0001\u0018\u0003\u0018\u00f9\b\u0018\u0001\u0018\u0005"+
		"\u0018\u00fc\b\u0018\n\u0018\f\u0018\u00ff\t\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0103\b\u0018\u0001\u0019\u0001\u0019\u0005\u0019\u0107\b"+
		"\u0019\n\u0019\f\u0019\u010a\t\u0019\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u010e\b\u0019\n\u0019\f\u0019\u0111\t\u0019\u0001\u0019\u0005\u0019\u0114"+
		"\b\u0019\n\u0019\f\u0019\u0117\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u011d\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u012d\b\u001b\u0001\u001c\u0001\u001c\u0005\u001c\u0131\b\u001c\n\u001c"+
		"\f\u001c\u0134\t\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0138\b\u001c"+
		"\n\u001c\f\u001c\u013b\t\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u013f"+
		"\b\u001c\n\u001c\f\u001c\u0142\t\u001c\u0001\u001c\u0005\u001c\u0145\b"+
		"\u001c\n\u001c\f\u001c\u0148\t\u001c\u0001\u001c\u0005\u001c\u014b\b\u001c"+
		"\n\u001c\f\u001c\u014e\t\u001c\u0001\u001c\u0003\u001c\u0151\b\u001c\u0003"+
		"\u001c\u0153\b\u001c\u0001\u001c\u0005\u001c\u0156\b\u001c\n\u001c\f\u001c"+
		"\u0159\t\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0005\u001d"+
		"\u015f\b\u001d\n\u001d\f\u001d\u0162\t\u001d\u0001\u001d\u0001\u001d\u0005"+
		"\u001d\u0166\b\u001d\n\u001d\f\u001d\u0169\t\u001d\u0001\u001d\u0001\u001d"+
		"\u0005\u001d\u016d\b\u001d\n\u001d\f\u001d\u0170\t\u001d\u0001\u001d\u0005"+
		"\u001d\u0173\b\u001d\n\u001d\f\u001d\u0176\t\u001d\u0001\u001d\u0005\u001d"+
		"\u0179\b\u001d\n\u001d\f\u001d\u017c\t\u001d\u0001\u001d\u0003\u001d\u017f"+
		"\b\u001d\u0003\u001d\u0181\b\u001d\u0001\u001d\u0005\u001d\u0184\b\u001d"+
		"\n\u001d\f\u001d\u0187\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0197"+
		"\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0000\u0000 \u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>\u0000\u0002\u0002\u0000\u0004\u0004\u000f\u000f\u0002"+
		"\u0000\r\r\u000f\u000f\u01ba\u0000O\u0001\u0000\u0000\u0000\u0002[\u0001"+
		"\u0000\u0000\u0000\u0004c\u0001\u0000\u0000\u0000\u0006e\u0001\u0000\u0000"+
		"\u0000\bm\u0001\u0000\u0000\u0000\ny\u0001\u0000\u0000\u0000\f\u0085\u0001"+
		"\u0000\u0000\u0000\u000e\u0087\u0001\u0000\u0000\u0000\u0010\u0096\u0001"+
		"\u0000\u0000\u0000\u0012\u00a4\u0001\u0000\u0000\u0000\u0014\u00a6\u0001"+
		"\u0000\u0000\u0000\u0016\u00a8\u0001\u0000\u0000\u0000\u0018\u00ac\u0001"+
		"\u0000\u0000\u0000\u001a\u00b0\u0001\u0000\u0000\u0000\u001c\u00b6\u0001"+
		"\u0000\u0000\u0000\u001e\u00b9\u0001\u0000\u0000\u0000 \u00bc\u0001\u0000"+
		"\u0000\u0000\"\u00c4\u0001\u0000\u0000\u0000$\u00c8\u0001\u0000\u0000"+
		"\u0000&\u00d1\u0001\u0000\u0000\u0000(\u00d4\u0001\u0000\u0000\u0000*"+
		"\u00d6\u0001\u0000\u0000\u0000,\u00db\u0001\u0000\u0000\u0000.\u00e3\u0001"+
		"\u0000\u0000\u00000\u0102\u0001\u0000\u0000\u00002\u0104\u0001\u0000\u0000"+
		"\u00004\u011c\u0001\u0000\u0000\u00006\u012c\u0001\u0000\u0000\u00008"+
		"\u012e\u0001\u0000\u0000\u0000:\u015c\u0001\u0000\u0000\u0000<\u018a\u0001"+
		"\u0000\u0000\u0000>\u018e\u0001\u0000\u0000\u0000@B\u0005!\u0000\u0000"+
		"A@\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000"+
		"\u0000CD\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000EC\u0001\u0000"+
		"\u0000\u0000FJ\u0003\u0002\u0001\u0000GI\u0005!\u0000\u0000HG\u0001\u0000"+
		"\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"MC\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000RS\u0005\u0000\u0000\u0001S\u0001\u0001\u0000\u0000\u0000"+
		"T\\\u0003\u0004\u0002\u0000U\\\u0003\b\u0004\u0000V\\\u0003\u000e\u0007"+
		"\u0000W\\\u0003\"\u0011\u0000X\\\u0003$\u0012\u0000Y\\\u0003&\u0013\u0000"+
		"Z\\\u0003(\u0014\u0000[T\u0001\u0000\u0000\u0000[U\u0001\u0000\u0000\u0000"+
		"[V\u0001\u0000\u0000\u0000[W\u0001\u0000\u0000\u0000[X\u0001\u0000\u0000"+
		"\u0000[Y\u0001\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\\u0003\u0001"+
		"\u0000\u0000\u0000]^\u0005\t\u0000\u0000^d\u0003\u0006\u0003\u0000_`\u0005"+
		"\b\u0000\u0000`a\u0005\u000f\u0000\u0000ab\u0005\t\u0000\u0000bd\u0003"+
		"\u0006\u0003\u0000c]\u0001\u0000\u0000\u0000c_\u0001\u0000\u0000\u0000"+
		"d\u0005\u0001\u0000\u0000\u0000ej\u0005\u000f\u0000\u0000fg\u0005\u0018"+
		"\u0000\u0000gi\u0005\u000f\u0000\u0000hf\u0001\u0000\u0000\u0000il\u0001"+
		"\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"k\u0007\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005\u0010"+
		"\u0000\u0000no\u0005\u0004\u0000\u0000op\u0005\u0011\u0000\u0000pq\u0005"+
		"\u0005\u0000\u0000qs\u0005\u0012\u0000\u0000rt\u0003\n\u0005\u0000sr\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"uv\u0005\u0013\u0000\u0000vw\u0005!\u0000\u0000wx\u0003\u000e\u0007\u0000"+
		"x\t\u0001\u0000\u0000\u0000y~\u0003\f\u0006\u0000z{\u0005\u0018\u0000"+
		"\u0000{}\u0003\f\u0006\u0000|z\u0001\u0000\u0000\u0000}\u0080\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u000b\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081"+
		"\u0086\u0005\r\u0000\u0000\u0082\u0083\u0005\u000f\u0000\u0000\u0083\u0084"+
		"\u0005\u001a\u0000\u0000\u0084\u0086\u0003*\u0015\u0000\u0085\u0081\u0001"+
		"\u0000\u0000\u0000\u0085\u0082\u0001\u0000\u0000\u0000\u0086\r\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005\u0001\u0000\u0000\u0088\u0089\u0005\u000f"+
		"\u0000\u0000\u0089\u008b\u0005\u0012\u0000\u0000\u008a\u008c\u0003\u0010"+
		"\b\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0013\u0000"+
		"\u0000\u008e\u008f\u0005\u0019\u0000\u0000\u008f\u0093\u0005!\u0000\u0000"+
		"\u0090\u0092\u0003\u0002\u0001\u0000\u0091\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u000f\u0001\u0000\u0000\u0000"+
		"\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u009b\u0003\u0012\t\u0000\u0097"+
		"\u0098\u0005\u0018\u0000\u0000\u0098\u009a\u0003\u0012\t\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u0011"+
		"\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u00a5"+
		"\u0003\u0014\n\u0000\u009f\u00a5\u0003\u0016\u000b\u0000\u00a0\u00a5\u0003"+
		"\u0018\f\u0000\u00a1\u00a5\u0003\u001a\r\u0000\u00a2\u00a5\u0003\u001c"+
		"\u000e\u0000\u00a3\u00a5\u0003\u001e\u000f\u0000\u00a4\u009e\u0001\u0000"+
		"\u0000\u0000\u00a4\u009f\u0001\u0000\u0000\u0000\u00a4\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a5\u0013\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0005\u000f\u0000\u0000\u00a7\u0015\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0005\u000f\u0000\u0000\u00a9\u00aa\u0005\u001a"+
		"\u0000\u0000\u00aa\u00ab\u0003*\u0015\u0000\u00ab\u0017\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0005\u000f\u0000\u0000\u00ad\u00ae\u0005\u0019\u0000"+
		"\u0000\u00ae\u00af\u0003 \u0010\u0000\u00af\u0019\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0005\u000f\u0000\u0000\u00b1\u00b2\u0005\u0019\u0000\u0000"+
		"\u00b2\u00b3\u0003 \u0010\u0000\u00b3\u00b4\u0005\u001a\u0000\u0000\u00b4"+
		"\u00b5\u0003*\u0015\u0000\u00b5\u001b\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0005\u001c\u0000\u0000\u00b7\u00b8\u0005\u000f\u0000\u0000\u00b8\u001d"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u001d\u0000\u0000\u00ba\u00bb"+
		"\u0005\u000f\u0000\u0000\u00bb\u001f\u0001\u0000\u0000\u0000\u00bc\u00c1"+
		"\u0005\u000f\u0000\u0000\u00bd\u00be\u0005\u0011\u0000\u0000\u00be\u00c0"+
		"\u0005\u000f\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c2!\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0007\u0000\u0000\u0000\u00c5\u00c6\u0005"+
		"\u001a\u0000\u0000\u00c6\u00c7\u0003*\u0015\u0000\u00c7#\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0005\u0002\u0000\u0000\u00c9\u00ca\u0003*\u0015\u0000"+
		"\u00ca\u00cb\u0005\u0019\u0000\u0000\u00cb\u00cd\u0005!\u0000\u0000\u00cc"+
		"\u00ce\u0003\u0002\u0001\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0%\u0001\u0000\u0000\u0000\u00d1\u00d2"+
		"\u0005\u0003\u0000\u0000\u00d2\u00d3\u0003*\u0015\u0000\u00d3\'\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0003*\u0015\u0000\u00d5)\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d9\u0003,\u0016\u0000\u00d7\u00d8\u0005\u001e\u0000\u0000"+
		"\u00d8\u00da\u0003,\u0016\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da+\u0001\u0000\u0000\u0000\u00db\u00e0"+
		"\u0003.\u0017\u0000\u00dc\u00dd\u0005\u001b\u0000\u0000\u00dd\u00df\u0003"+
		".\u0017\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e1-\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e7\u00036\u001b\u0000\u00e4\u00e6\u00030\u0018\u0000\u00e5"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8"+
		"/\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea\u00eb"+
		"\u0005\u0011\u0000\u0000\u00eb\u0103\u0005\u000f\u0000\u0000\u00ec\u00ed"+
		"\u0005\u0014\u0000\u0000\u00ed\u00ee\u0003*\u0015\u0000\u00ee\u00ef\u0005"+
		"\u0015\u0000\u0000\u00ef\u0103\u0001\u0000\u0000\u0000\u00f0\u00f4\u0005"+
		"\u0012\u0000\u0000\u00f1\u00f3\u0005!\u0000\u0000\u00f2\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00f9\u00032\u0019"+
		"\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fd\u0001\u0000\u0000\u0000\u00fa\u00fc\u0005!\u0000\u0000"+
		"\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000"+
		"\u00fe\u0100\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000"+
		"\u0100\u0103\u0005\u0013\u0000\u0000\u0101\u0103\u0003>\u001f\u0000\u0102"+
		"\u00ea\u0001\u0000\u0000\u0000\u0102\u00ec\u0001\u0000\u0000\u0000\u0102"+
		"\u00f0\u0001\u0000\u0000\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103"+
		"1\u0001\u0000\u0000\u0000\u0104\u0115\u00034\u001a\u0000\u0105\u0107\u0005"+
		"!\u0000\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000"+
		"\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000"+
		"\u0000\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000"+
		"\u0000\u0000\u010b\u010f\u0005\u0018\u0000\u0000\u010c\u010e\u0005!\u0000"+
		"\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010e\u0111\u0001\u0000\u0000"+
		"\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000"+
		"\u0000\u0110\u0112\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000"+
		"\u0000\u0112\u0114\u00034\u001a\u0000\u0113\u0108\u0001\u0000\u0000\u0000"+
		"\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0001\u0000\u0000\u0000\u01163\u0001\u0000\u0000\u0000\u0117"+
		"\u0115\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u000f\u0000\u0000\u0119"+
		"\u011a\u0005\u001a\u0000\u0000\u011a\u011d\u0003*\u0015\u0000\u011b\u011d"+
		"\u0003*\u0015\u0000\u011c\u0118\u0001\u0000\u0000\u0000\u011c\u011b\u0001"+
		"\u0000\u0000\u0000\u011d5\u0001\u0000\u0000\u0000\u011e\u012d\u0005\u000f"+
		"\u0000\u0000\u011f\u012d\u0005\r\u0000\u0000\u0120\u012d\u0005\u000e\u0000"+
		"\u0000\u0121\u012d\u0005\u0004\u0000\u0000\u0122\u012d\u0005\n\u0000\u0000"+
		"\u0123\u012d\u0005\u000b\u0000\u0000\u0124\u012d\u0005\f\u0000\u0000\u0125"+
		"\u012d\u00038\u001c\u0000\u0126\u012d\u0003:\u001d\u0000\u0127\u012d\u0003"+
		">\u001f\u0000\u0128\u0129\u0005\u0012\u0000\u0000\u0129\u012a\u0003*\u0015"+
		"\u0000\u012a\u012b\u0005\u0013\u0000\u0000\u012b\u012d\u0001\u0000\u0000"+
		"\u0000\u012c\u011e\u0001\u0000\u0000\u0000\u012c\u011f\u0001\u0000\u0000"+
		"\u0000\u012c\u0120\u0001\u0000\u0000\u0000\u012c\u0121\u0001\u0000\u0000"+
		"\u0000\u012c\u0122\u0001\u0000\u0000\u0000\u012c\u0123\u0001\u0000\u0000"+
		"\u0000\u012c\u0124\u0001\u0000\u0000\u0000\u012c\u0125\u0001\u0000\u0000"+
		"\u0000\u012c\u0126\u0001\u0000\u0000\u0000\u012c\u0127\u0001\u0000\u0000"+
		"\u0000\u012c\u0128\u0001\u0000\u0000\u0000\u012d7\u0001\u0000\u0000\u0000"+
		"\u012e\u0132\u0005\u0014\u0000\u0000\u012f\u0131\u0005!\u0000\u0000\u0130"+
		"\u012f\u0001\u0000\u0000\u0000\u0131\u0134\u0001\u0000\u0000\u0000\u0132"+
		"\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133"+
		"\u0152\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135"+
		"\u0146\u0003*\u0015\u0000\u0136\u0138\u0005!\u0000\u0000\u0137\u0136\u0001"+
		"\u0000\u0000\u0000\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001"+
		"\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013c\u0001"+
		"\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u0140\u0005"+
		"\u0018\u0000\u0000\u013d\u013f\u0005!\u0000\u0000\u013e\u013d\u0001\u0000"+
		"\u0000\u0000\u013f\u0142\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000"+
		"\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0143\u0001\u0000"+
		"\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0143\u0145\u0003*\u0015"+
		"\u0000\u0144\u0139\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000\u0000"+
		"\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000"+
		"\u0000\u0147\u014c\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000"+
		"\u0000\u0149\u014b\u0005!\u0000\u0000\u014a\u0149\u0001\u0000\u0000\u0000"+
		"\u014b\u014e\u0001\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000"+
		"\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u0150\u0001\u0000\u0000\u0000"+
		"\u014e\u014c\u0001\u0000\u0000\u0000\u014f\u0151\u0005\u0018\u0000\u0000"+
		"\u0150\u014f\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000"+
		"\u0151\u0153\u0001\u0000\u0000\u0000\u0152\u0135\u0001\u0000\u0000\u0000"+
		"\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0157\u0001\u0000\u0000\u0000"+
		"\u0154\u0156\u0005!\u0000\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0156"+
		"\u0159\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0157"+
		"\u0158\u0001\u0000\u0000\u0000\u0158\u015a\u0001\u0000\u0000\u0000\u0159"+
		"\u0157\u0001\u0000\u0000\u0000\u015a\u015b\u0005\u0015\u0000\u0000\u015b"+
		"9\u0001\u0000\u0000\u0000\u015c\u0160\u0005\u0016\u0000\u0000\u015d\u015f"+
		"\u0005!\u0000\u0000\u015e\u015d\u0001\u0000\u0000\u0000\u015f\u0162\u0001"+
		"\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160\u0161\u0001"+
		"\u0000\u0000\u0000\u0161\u0180\u0001\u0000\u0000\u0000\u0162\u0160\u0001"+
		"\u0000\u0000\u0000\u0163\u0174\u0003<\u001e\u0000\u0164\u0166\u0005!\u0000"+
		"\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0166\u0169\u0001\u0000\u0000"+
		"\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000"+
		"\u0000\u0168\u016a\u0001\u0000\u0000\u0000\u0169\u0167\u0001\u0000\u0000"+
		"\u0000\u016a\u016e\u0005\u0018\u0000\u0000\u016b\u016d\u0005!\u0000\u0000"+
		"\u016c\u016b\u0001\u0000\u0000\u0000\u016d\u0170\u0001\u0000\u0000\u0000"+
		"\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000"+
		"\u016f\u0171\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000"+
		"\u0171\u0173\u0003<\u001e\u0000\u0172\u0167\u0001\u0000\u0000\u0000\u0173"+
		"\u0176\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0174"+
		"\u0175\u0001\u0000\u0000\u0000\u0175\u017a\u0001\u0000\u0000\u0000\u0176"+
		"\u0174\u0001\u0000\u0000\u0000\u0177\u0179\u0005!\u0000\u0000\u0178\u0177"+
		"\u0001\u0000\u0000\u0000\u0179\u017c\u0001\u0000\u0000\u0000\u017a\u0178"+
		"\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000\u0000\u017b\u017e"+
		"\u0001\u0000\u0000\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017d\u017f"+
		"\u0005\u0018\u0000\u0000\u017e\u017d\u0001\u0000\u0000\u0000\u017e\u017f"+
		"\u0001\u0000\u0000\u0000\u017f\u0181\u0001\u0000\u0000\u0000\u0180\u0163"+
		"\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u0185"+
		"\u0001\u0000\u0000\u0000\u0182\u0184\u0005!\u0000\u0000\u0183\u0182\u0001"+
		"\u0000\u0000\u0000\u0184\u0187\u0001\u0000\u0000\u0000\u0185\u0183\u0001"+
		"\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186\u0188\u0001"+
		"\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188\u0189\u0005"+
		"\u0017\u0000\u0000\u0189;\u0001\u0000\u0000\u0000\u018a\u018b\u0007\u0001"+
		"\u0000\u0000\u018b\u018c\u0005\u0019\u0000\u0000\u018c\u018d\u0003*\u0015"+
		"\u0000\u018d=\u0001\u0000\u0000\u0000\u018e\u018f\u0005\u0012\u0000\u0000"+
		"\u018f\u0190\u0003*\u0015\u0000\u0190\u0191\u0005\u0006\u0000\u0000\u0191"+
		"\u0192\u0005\u000f\u0000\u0000\u0192\u0193\u0005\u0007\u0000\u0000\u0193"+
		"\u0196\u0003*\u0015\u0000\u0194\u0195\u0005\u0002\u0000\u0000\u0195\u0197"+
		"\u0003*\u0015\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0196\u0197\u0001"+
		"\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u0198\u0199\u0005"+
		"\u0013\u0000\u0000\u0199?\u0001\u0000\u0000\u0000,CJO[cjs~\u0085\u008b"+
		"\u0093\u009b\u00a4\u00c1\u00cf\u00d9\u00e0\u00e7\u00f4\u00f8\u00fd\u0102"+
		"\u0108\u010f\u0115\u011c\u012c\u0132\u0139\u0140\u0146\u014c\u0150\u0152"+
		"\u0157\u0160\u0167\u016e\u0174\u017a\u017e\u0180\u0185\u0196";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}