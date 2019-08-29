// Generated from GetXmlFile_v1_1.g4 by ANTLR 4.4

package Leo.GetXmlFile;

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GetXmlFile_v1_1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		IntegerLiteral=10, FloatingPointLiteral=11, StringCharacters=12, LB=13, 
		RB=14, LT=15, RT=16, AMP=17, APOS=18, QUOT=19, Identifier=20, Identifier_L=21, 
		Identifier_C=22, WS=23, COMMENT_CORRECT=24, COMMENT_OTHER_A_LINE=25, COMMENT_OTHER_MULTI_LINE=26;
	public static final String[] tokenNames = {
		"<INVALID>", "'</'", "'\"'", "'''", "':'", "';'", "'/>'", "'<'", "'='", 
		"'>'", "IntegerLiteral", "FloatingPointLiteral", "StringCharacters", "LB", 
		"RB", "'&lt'", "'&rt'", "AMP", "APOS", "'&quot'", "Identifier", "Identifier_L", 
		"Identifier_C", "WS", "COMMENT_CORRECT", "COMMENT_OTHER_A_LINE", "COMMENT_OTHER_MULTI_LINE"
	};
	public static final int
		RULE_comment_correct = 0, RULE_comment_other_a_line = 1, RULE_comment_other_multi_line = 2, 
		RULE_node = 3, RULE_pri_node_begin = 4, RULE_abb_node_begin = 5, RULE_abb2_node_begin = 6, 
		RULE_pri_node_end = 7, RULE_abb_node_end = 8, RULE_abb2_node_end = 9, 
		RULE_pri_node_property = 10, RULE_abb_node_property = 11, RULE_pri_node_value = 12, 
		RULE_abb_node_value = 13;
	public static final String[] ruleNames = {
		"comment_correct", "comment_other_a_line", "comment_other_multi_line", 
		"node", "pri_node_begin", "abb_node_begin", "abb2_node_begin", "pri_node_end", 
		"abb_node_end", "abb2_node_end", "pri_node_property", "abb_node_property", 
		"pri_node_value", "abb_node_value"
	};

	@Override
	public String getGrammarFileName() { return "GetXmlFile_v1_1.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	public static Map<Integer, String> node_name = new HashMap<Integer, String>();				//<�ڵ���i_n,�ڵ���xxx.getText()>
	public static Map<Integer, String> node_value = new HashMap<Integer, String>();				//<�ڵ���i_n,�ڵ�ֵxxx.getText()>
	public static Map<Integer, Integer> node_depth = new HashMap<Integer, Integer>();			//<�ڵ���i_n,�ڵ����i_d>
	public static Map<Integer, Integer> node_property_first = new HashMap<Integer, Integer>();	//<�ڵ���i_n,��һ�����Ա��i_p>
	public static Map<Integer, Integer> node_property_final = new HashMap<Integer, Integer>();	//<�ڵ���i_n,���һ�����Ա��i_p>
	public static Map<Integer, String> property_name = new HashMap<Integer, String>();			//<���Ա��i_n,������xxx.getText()>
	public static Map<Integer, String> property_value = new HashMap<Integer, String>();			//<���Ա��i_n,����ֵxxx.getText()>
	public static Map<Integer, String> comment = new HashMap<Integer, String>();				//<ע�ͱ��i_n,ע������xxx.getText()>

	public static int i_n = 1;		//���ƽڵ��ż���
	public static int i_p = 1;		//�������Ա�ż���
	public static int i_c = 1;		//����ע�ͱ�ż���
	public static int i_d = 1;		//���ƽڵ���ȼ���

	public GetXmlFile_v1_1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Comment_correctContext extends ParserRuleContext {
		public Token COMMENT_CORRECT;
		public TerminalNode COMMENT_CORRECT() { return getToken(GetXmlFile_v1_1Parser.COMMENT_CORRECT, 0); }
		public Comment_correctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment_correct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterComment_correct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitComment_correct(this);
		}
	}

	public final Comment_correctContext comment_correct() throws RecognitionException {
		Comment_correctContext _localctx = new Comment_correctContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_comment_correct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); ((Comment_correctContext)_localctx).COMMENT_CORRECT = match(COMMENT_CORRECT);
			comment.put(i_c++, ((Comment_correctContext)_localctx).COMMENT_CORRECT.getText());
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

	public static class Comment_other_a_lineContext extends ParserRuleContext {
		public Token COMMENT_OTHER_A_LINE;
		public TerminalNode COMMENT_OTHER_A_LINE() { return getToken(GetXmlFile_v1_1Parser.COMMENT_OTHER_A_LINE, 0); }
		public Comment_other_a_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment_other_a_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterComment_other_a_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitComment_other_a_line(this);
		}
	}

	public final Comment_other_a_lineContext comment_other_a_line() throws RecognitionException {
		Comment_other_a_lineContext _localctx = new Comment_other_a_lineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comment_other_a_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); ((Comment_other_a_lineContext)_localctx).COMMENT_OTHER_A_LINE = match(COMMENT_OTHER_A_LINE);
			comment.put(i_c++, ((Comment_other_a_lineContext)_localctx).COMMENT_OTHER_A_LINE.getText());
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

	public static class Comment_other_multi_lineContext extends ParserRuleContext {
		public Token COMMENT_OTHER_MULTI_LINE;
		public TerminalNode COMMENT_OTHER_MULTI_LINE() { return getToken(GetXmlFile_v1_1Parser.COMMENT_OTHER_MULTI_LINE, 0); }
		public Comment_other_multi_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment_other_multi_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterComment_other_multi_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitComment_other_multi_line(this);
		}
	}

	public final Comment_other_multi_lineContext comment_other_multi_line() throws RecognitionException {
		Comment_other_multi_lineContext _localctx = new Comment_other_multi_lineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comment_other_multi_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); ((Comment_other_multi_lineContext)_localctx).COMMENT_OTHER_MULTI_LINE = match(COMMENT_OTHER_MULTI_LINE);
			comment.put(i_c++, ((Comment_other_multi_lineContext)_localctx).COMMENT_OTHER_MULTI_LINE.getText());
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

	public static class NodeContext extends ParserRuleContext {
		public Abb_node_valueContext abb_node_value() {
			return getRuleContext(Abb_node_valueContext.class,0);
		}
		public Abb2_node_endContext abb2_node_end() {
			return getRuleContext(Abb2_node_endContext.class,0);
		}
		public Pri_node_beginContext pri_node_begin() {
			return getRuleContext(Pri_node_beginContext.class,0);
		}
		public Abb_node_beginContext abb_node_begin() {
			return getRuleContext(Abb_node_beginContext.class,0);
		}
		public Abb2_node_beginContext abb2_node_begin() {
			return getRuleContext(Abb2_node_beginContext.class,0);
		}
		public Pri_node_endContext pri_node_end() {
			return getRuleContext(Pri_node_endContext.class,0);
		}
		public Abb_node_endContext abb_node_end() {
			return getRuleContext(Abb_node_endContext.class,0);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public Pri_node_valueContext pri_node_value() {
			return getRuleContext(Pri_node_valueContext.class,0);
		}
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitNode(this);
		}
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_node);
		int _la;
		try {
			setState(67);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(37); pri_node_begin();
					}
					break;
				case 2:
					{
					setState(38); abb_node_begin();
					}
					break;
				case 3:
					{
					setState(39); abb2_node_begin();
					}
					break;
				}
				setState(44);
				switch (_input.LA(1)) {
				case T__7:
				case T__6:
				case IntegerLiteral:
				case FloatingPointLiteral:
				case StringCharacters:
					{
					setState(42); pri_node_value();
					}
					break;
				case T__1:
					{
					setState(43); abb_node_value();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(49);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(46); pri_node_end();
					}
					break;
				case 2:
					{
					setState(47); abb_node_end();
					}
					break;
				case 3:
					{
					setState(48); abb2_node_end();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(51); pri_node_begin();
					}
					break;
				case 2:
					{
					setState(52); abb_node_begin();
					}
					break;
				case 3:
					{
					setState(53); abb2_node_begin();
					}
					break;
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2 || _la==Identifier) {
					{
					{
					setState(56); node();
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(62); pri_node_end();
					}
					break;
				case 2:
					{
					setState(63); abb_node_end();
					}
					break;
				case 3:
					{
					setState(64); abb2_node_end();
					}
					break;
				}
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

	public static class Pri_node_beginContext extends ParserRuleContext {
		public Token Identifier;
		public TerminalNode Identifier() { return getToken(GetXmlFile_v1_1Parser.Identifier, 0); }
		public Pri_node_propertyContext pri_node_property(int i) {
			return getRuleContext(Pri_node_propertyContext.class,i);
		}
		public List<Pri_node_propertyContext> pri_node_property() {
			return getRuleContexts(Pri_node_propertyContext.class);
		}
		public Pri_node_beginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pri_node_begin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterPri_node_begin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitPri_node_begin(this);
		}
	}

	public final Pri_node_beginContext pri_node_begin() throws RecognitionException {
		Pri_node_beginContext _localctx = new Pri_node_beginContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pri_node_begin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); match(T__2);
			setState(70); ((Pri_node_beginContext)_localctx).Identifier = match(Identifier);
			node_name.put(i_n, ((Pri_node_beginContext)_localctx).Identifier.getText());
			node_depth.put(i_n, i_d++);
			node_property_first.put(i_n, i_p);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(74); pri_node_property();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80); match(T__0);
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

	public static class Abb_node_beginContext extends ParserRuleContext {
		public Token Identifier;
		public Abb_node_propertyContext abb_node_property(int i) {
			return getRuleContext(Abb_node_propertyContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(GetXmlFile_v1_1Parser.Identifier, 0); }
		public List<Abb_node_propertyContext> abb_node_property() {
			return getRuleContexts(Abb_node_propertyContext.class);
		}
		public TerminalNode RB() { return getToken(GetXmlFile_v1_1Parser.RB, 0); }
		public TerminalNode LB() { return getToken(GetXmlFile_v1_1Parser.LB, 0); }
		public Abb_node_beginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abb_node_begin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterAbb_node_begin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitAbb_node_begin(this);
		}
	}

	public final Abb_node_beginContext abb_node_begin() throws RecognitionException {
		Abb_node_beginContext _localctx = new Abb_node_beginContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_abb_node_begin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); match(T__2);
			setState(83); ((Abb_node_beginContext)_localctx).Identifier = match(Identifier);
			node_name.put(i_n, ((Abb_node_beginContext)_localctx).Identifier.getText());
			node_depth.put(i_n, i_d++);
			node_property_first.put(i_n, i_p);
			setState(95);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(87); match(LB);
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(88); abb_node_property();
					}
					}
					setState(91); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Identifier );
				setState(93); match(RB);
				}
				break;
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

	public static class Abb2_node_beginContext extends ParserRuleContext {
		public Token Identifier;
		public Abb_node_propertyContext abb_node_property(int i) {
			return getRuleContext(Abb_node_propertyContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(GetXmlFile_v1_1Parser.Identifier, 0); }
		public TerminalNode RB(int i) {
			return getToken(GetXmlFile_v1_1Parser.RB, i);
		}
		public List<Abb_node_propertyContext> abb_node_property() {
			return getRuleContexts(Abb_node_propertyContext.class);
		}
		public TerminalNode LB(int i) {
			return getToken(GetXmlFile_v1_1Parser.LB, i);
		}
		public List<TerminalNode> RB() { return getTokens(GetXmlFile_v1_1Parser.RB); }
		public List<TerminalNode> LB() { return getTokens(GetXmlFile_v1_1Parser.LB); }
		public Abb2_node_beginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abb2_node_begin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterAbb2_node_begin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitAbb2_node_begin(this);
		}
	}

	public final Abb2_node_beginContext abb2_node_begin() throws RecognitionException {
		Abb2_node_beginContext _localctx = new Abb2_node_beginContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_abb2_node_begin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); ((Abb2_node_beginContext)_localctx).Identifier = match(Identifier);
			node_name.put(i_n, ((Abb2_node_beginContext)_localctx).Identifier.getText());
			node_depth.put(i_n, i_d++);
			node_property_first.put(i_n, i_p);
			setState(109);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(101); match(LB);
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(102); abb_node_property();
					}
					}
					setState(105); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Identifier );
				setState(107); match(RB);
				}
			}

			setState(111); match(T__5);
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(112); match(LB);
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(113); abb_node_property();
					}
					}
					setState(116); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Identifier );
				setState(118); match(RB);
				}
				break;
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

	public static class Pri_node_endContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(GetXmlFile_v1_1Parser.Identifier, 0); }
		public Pri_node_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pri_node_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterPri_node_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitPri_node_end(this);
		}
	}

	public final Pri_node_endContext pri_node_end() throws RecognitionException {
		Pri_node_endContext _localctx = new Pri_node_endContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pri_node_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(T__8);
			setState(123); match(Identifier);
			setState(124); match(T__0);
			i_d--;
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

	public static class Abb_node_endContext extends ParserRuleContext {
		public Abb_node_propertyContext abb_node_property(int i) {
			return getRuleContext(Abb_node_propertyContext.class,i);
		}
		public List<Abb_node_propertyContext> abb_node_property() {
			return getRuleContexts(Abb_node_propertyContext.class);
		}
		public TerminalNode RB() { return getToken(GetXmlFile_v1_1Parser.RB, 0); }
		public TerminalNode LB() { return getToken(GetXmlFile_v1_1Parser.LB, 0); }
		public Abb_node_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abb_node_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterAbb_node_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitAbb_node_end(this);
		}
	}

	public final Abb_node_endContext abb_node_end() throws RecognitionException {
		Abb_node_endContext _localctx = new Abb_node_endContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_abb_node_end);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(127); match(LB);
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(128); abb_node_property();
					}
					}
					setState(131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Identifier );
				setState(133); match(RB);
				}
			}

			setState(137); match(T__3);
			i_d--;
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

	public static class Abb2_node_endContext extends ParserRuleContext {
		public Abb_node_propertyContext abb_node_property(int i) {
			return getRuleContext(Abb_node_propertyContext.class,i);
		}
		public List<Abb_node_propertyContext> abb_node_property() {
			return getRuleContexts(Abb_node_propertyContext.class);
		}
		public TerminalNode RB() { return getToken(GetXmlFile_v1_1Parser.RB, 0); }
		public TerminalNode LB() { return getToken(GetXmlFile_v1_1Parser.LB, 0); }
		public Abb2_node_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abb2_node_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterAbb2_node_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitAbb2_node_end(this);
		}
	}

	public final Abb2_node_endContext abb2_node_end() throws RecognitionException {
		Abb2_node_endContext _localctx = new Abb2_node_endContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_abb2_node_end);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(140); match(LB);
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(141); abb_node_property();
					}
					}
					setState(144); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Identifier );
				setState(146); match(RB);
				}
			}

			setState(150); match(T__4);
			i_d--;
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

	public static class Pri_node_propertyContext extends ParserRuleContext {
		public Token Identifier;
		public Token StringCharacters;
		public TerminalNode Identifier() { return getToken(GetXmlFile_v1_1Parser.Identifier, 0); }
		public TerminalNode StringCharacters() { return getToken(GetXmlFile_v1_1Parser.StringCharacters, 0); }
		public Pri_node_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pri_node_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterPri_node_property(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitPri_node_property(this);
		}
	}

	public final Pri_node_propertyContext pri_node_property() throws RecognitionException {
		Pri_node_propertyContext _localctx = new Pri_node_propertyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pri_node_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); ((Pri_node_propertyContext)_localctx).Identifier = match(Identifier);
			property_name.put(i_p, ((Pri_node_propertyContext)_localctx).Identifier.getText());
			setState(155); match(T__1);
			setState(166);
			switch (_input.LA(1)) {
			case StringCharacters:
				{
				setState(156); ((Pri_node_propertyContext)_localctx).StringCharacters = match(StringCharacters);
				property_value.put(i_p++, ((Pri_node_propertyContext)_localctx).StringCharacters.getText());
				}
				break;
			case T__6:
				{
				setState(158); match(T__6);
				setState(159); ((Pri_node_propertyContext)_localctx).StringCharacters = match(StringCharacters);
				property_value.put(i_p++, ((Pri_node_propertyContext)_localctx).StringCharacters.getText());
				setState(161); match(T__6);
				}
				break;
			case T__7:
				{
				setState(162); match(T__7);
				setState(163); ((Pri_node_propertyContext)_localctx).StringCharacters = match(StringCharacters);
				property_value.put(i_p++, ((Pri_node_propertyContext)_localctx).StringCharacters.getText());
				setState(165); match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Abb_node_propertyContext extends ParserRuleContext {
		public Token Identifier;
		public Token StringCharacters;
		public TerminalNode Identifier() { return getToken(GetXmlFile_v1_1Parser.Identifier, 0); }
		public TerminalNode StringCharacters() { return getToken(GetXmlFile_v1_1Parser.StringCharacters, 0); }
		public Abb_node_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abb_node_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterAbb_node_property(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitAbb_node_property(this);
		}
	}

	public final Abb_node_propertyContext abb_node_property() throws RecognitionException {
		Abb_node_propertyContext _localctx = new Abb_node_propertyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_abb_node_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); ((Abb_node_propertyContext)_localctx).Identifier = match(Identifier);
			property_name.put(i_p, ((Abb_node_propertyContext)_localctx).Identifier.getText());
			setState(170); match(T__1);
			setState(181);
			switch (_input.LA(1)) {
			case StringCharacters:
				{
				setState(171); ((Abb_node_propertyContext)_localctx).StringCharacters = match(StringCharacters);
				property_value.put(i_p++, ((Abb_node_propertyContext)_localctx).StringCharacters.getText());
				}
				break;
			case T__6:
				{
				setState(173); match(T__6);
				setState(174); ((Abb_node_propertyContext)_localctx).StringCharacters = match(StringCharacters);
				property_value.put(i_p++, ((Abb_node_propertyContext)_localctx).StringCharacters.getText());
				setState(176); match(T__6);
				}
				break;
			case T__7:
				{
				setState(177); match(T__7);
				setState(178); ((Abb_node_propertyContext)_localctx).StringCharacters = match(StringCharacters);
				property_value.put(i_p++, ((Abb_node_propertyContext)_localctx).StringCharacters.getText());
				setState(180); match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Pri_node_valueContext extends ParserRuleContext {
		public Token StringCharacters;
		public Token IntegerLiteral;
		public Token FloatingPointLiteral;
		public TerminalNode StringCharacters() { return getToken(GetXmlFile_v1_1Parser.StringCharacters, 0); }
		public TerminalNode IntegerLiteral() { return getToken(GetXmlFile_v1_1Parser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(GetXmlFile_v1_1Parser.FloatingPointLiteral, 0); }
		public Pri_node_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pri_node_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterPri_node_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitPri_node_value(this);
		}
	}

	public final Pri_node_valueContext pri_node_value() throws RecognitionException {
		Pri_node_valueContext _localctx = new Pri_node_valueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pri_node_value);
		try {
			setState(197);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(183); match(T__6);
				setState(184); ((Pri_node_valueContext)_localctx).StringCharacters = match(StringCharacters);
				node_value.put(i_n, ((Pri_node_valueContext)_localctx).StringCharacters.getText());
				setState(186); match(T__6);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(187); match(T__7);
				setState(188); ((Pri_node_valueContext)_localctx).StringCharacters = match(StringCharacters);
				node_value.put(i_n, ((Pri_node_valueContext)_localctx).StringCharacters.getText());
				setState(190); match(T__7);
				}
				break;
			case StringCharacters:
				enterOuterAlt(_localctx, 3);
				{
				setState(191); ((Pri_node_valueContext)_localctx).StringCharacters = match(StringCharacters);
				node_value.put(i_n, ((Pri_node_valueContext)_localctx).StringCharacters.getText());
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(193); ((Pri_node_valueContext)_localctx).IntegerLiteral = match(IntegerLiteral);
				node_value.put(i_n, ((Pri_node_valueContext)_localctx).IntegerLiteral.getText());
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(195); ((Pri_node_valueContext)_localctx).FloatingPointLiteral = match(FloatingPointLiteral);
				node_value.put(i_n, ((Pri_node_valueContext)_localctx).FloatingPointLiteral.getText());
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

	public static class Abb_node_valueContext extends ParserRuleContext {
		public Token StringCharacters;
		public Token IntegerLiteral;
		public Token FloatingPointLiteral;
		public TerminalNode StringCharacters() { return getToken(GetXmlFile_v1_1Parser.StringCharacters, 0); }
		public TerminalNode IntegerLiteral() { return getToken(GetXmlFile_v1_1Parser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(GetXmlFile_v1_1Parser.FloatingPointLiteral, 0); }
		public Abb_node_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abb_node_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).enterAbb_node_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GetXmlFile_v1_1Listener ) ((GetXmlFile_v1_1Listener)listener).exitAbb_node_value(this);
		}
	}

	public final Abb_node_valueContext abb_node_value() throws RecognitionException {
		Abb_node_valueContext _localctx = new Abb_node_valueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_abb_node_value);
		try {
			setState(218);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199); match(T__1);
				setState(200); match(T__6);
				setState(201); ((Abb_node_valueContext)_localctx).StringCharacters = match(StringCharacters);
				node_value.put(i_n, ((Abb_node_valueContext)_localctx).StringCharacters.getText());
				setState(203); match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); match(T__1);
				setState(205); match(T__7);
				setState(206); ((Abb_node_valueContext)_localctx).StringCharacters = match(StringCharacters);
				node_value.put(i_n, ((Abb_node_valueContext)_localctx).StringCharacters.getText());
				setState(208); match(T__7);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(209); match(T__1);
				setState(210); ((Abb_node_valueContext)_localctx).StringCharacters = match(StringCharacters);
				node_value.put(i_n, ((Abb_node_valueContext)_localctx).StringCharacters.getText());
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(212); match(T__1);
				setState(213); ((Abb_node_valueContext)_localctx).IntegerLiteral = match(IntegerLiteral);
				node_value.put(i_n, ((Abb_node_valueContext)_localctx).IntegerLiteral.getText());
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(215); match(T__1);
				setState(216); ((Abb_node_valueContext)_localctx).FloatingPointLiteral = match(FloatingPointLiteral);
				node_value.put(i_n, ((Abb_node_valueContext)_localctx).FloatingPointLiteral.getText());
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00df\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\5\5+\n\5\3\5\3\5\5\5/\n\5\3\5\3\5\3\5\5\5\64\n\5"+
		"\3\5\3\5\3\5\5\59\n\5\3\5\7\5<\n\5\f\5\16\5?\13\5\3\5\3\5\3\5\5\5D\n\5"+
		"\5\5F\n\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\6\7\\\n\7\r\7\16\7]\3\7\3\7\5\7b\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\6\bj\n\b\r\b\16\bk\3\b\3\b\5\bp\n\b\3\b\3\b\3\b\6\bu"+
		"\n\b\r\b\16\bv\3\b\3\b\5\b{\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\6\n\u0084"+
		"\n\n\r\n\16\n\u0085\3\n\3\n\5\n\u008a\n\n\3\n\3\n\3\n\3\13\3\13\6\13\u0091"+
		"\n\13\r\13\16\13\u0092\3\13\3\13\5\13\u0097\n\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a9\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b8\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c8\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00dd\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\2\2\u00f2\2\36\3\2\2\2\4!\3\2\2\2\6$\3\2\2\2\bE\3\2"+
		"\2\2\nG\3\2\2\2\fT\3\2\2\2\16c\3\2\2\2\20|\3\2\2\2\22\u0089\3\2\2\2\24"+
		"\u0096\3\2\2\2\26\u009b\3\2\2\2\30\u00aa\3\2\2\2\32\u00c7\3\2\2\2\34\u00dc"+
		"\3\2\2\2\36\37\7\32\2\2\37 \b\2\1\2 \3\3\2\2\2!\"\7\33\2\2\"#\b\3\1\2"+
		"#\5\3\2\2\2$%\7\34\2\2%&\b\4\1\2&\7\3\2\2\2\'+\5\n\6\2(+\5\f\7\2)+\5\16"+
		"\b\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+.\3\2\2\2,/\5\32\16\2-/\5\34\17\2"+
		".,\3\2\2\2.-\3\2\2\2/\63\3\2\2\2\60\64\5\20\t\2\61\64\5\22\n\2\62\64\5"+
		"\24\13\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64F\3\2\2\2\659\5\n"+
		"\6\2\669\5\f\7\2\679\5\16\b\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29=\3"+
		"\2\2\2:<\5\b\5\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>C\3\2\2\2?=\3"+
		"\2\2\2@D\5\20\t\2AD\5\22\n\2BD\5\24\13\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2"+
		"DF\3\2\2\2E*\3\2\2\2E8\3\2\2\2F\t\3\2\2\2GH\7\t\2\2HI\7\26\2\2IJ\b\6\1"+
		"\2JK\b\6\1\2KO\b\6\1\2LN\5\26\f\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2"+
		"\2\2PR\3\2\2\2QO\3\2\2\2RS\7\13\2\2S\13\3\2\2\2TU\7\t\2\2UV\7\26\2\2V"+
		"W\b\7\1\2WX\b\7\1\2Xa\b\7\1\2Y[\7\17\2\2Z\\\5\30\r\2[Z\3\2\2\2\\]\3\2"+
		"\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\20\2\2`b\3\2\2\2aY\3\2\2\2ab\3"+
		"\2\2\2b\r\3\2\2\2cd\7\26\2\2de\b\b\1\2ef\b\b\1\2fo\b\b\1\2gi\7\17\2\2"+
		"hj\5\30\r\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\7\20\2"+
		"\2np\3\2\2\2og\3\2\2\2op\3\2\2\2pq\3\2\2\2qz\7\6\2\2rt\7\17\2\2su\5\30"+
		"\r\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\20\2\2y{\3"+
		"\2\2\2zr\3\2\2\2z{\3\2\2\2{\17\3\2\2\2|}\7\3\2\2}~\7\26\2\2~\177\7\13"+
		"\2\2\177\u0080\b\t\1\2\u0080\21\3\2\2\2\u0081\u0083\7\17\2\2\u0082\u0084"+
		"\5\30\r\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2"+
		"\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\20\2\2\u0088\u008a"+
		"\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\7\b\2\2\u008c\u008d\b\n\1\2\u008d\23\3\2\2\2\u008e\u0090\7\17\2"+
		"\2\u008f\u0091\5\30\r\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7\20"+
		"\2\2\u0095\u0097\3\2\2\2\u0096\u008e\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0099\7\7\2\2\u0099\u009a\b\13\1\2\u009a\25\3\2\2"+
		"\2\u009b\u009c\7\26\2\2\u009c\u009d\b\f\1\2\u009d\u00a8\7\n\2\2\u009e"+
		"\u009f\7\16\2\2\u009f\u00a9\b\f\1\2\u00a0\u00a1\7\5\2\2\u00a1\u00a2\7"+
		"\16\2\2\u00a2\u00a3\b\f\1\2\u00a3\u00a9\7\5\2\2\u00a4\u00a5\7\4\2\2\u00a5"+
		"\u00a6\7\16\2\2\u00a6\u00a7\b\f\1\2\u00a7\u00a9\7\4\2\2\u00a8\u009e\3"+
		"\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a9\27\3\2\2\2\u00aa"+
		"\u00ab\7\26\2\2\u00ab\u00ac\b\r\1\2\u00ac\u00b7\7\n\2\2\u00ad\u00ae\7"+
		"\16\2\2\u00ae\u00b8\b\r\1\2\u00af\u00b0\7\5\2\2\u00b0\u00b1\7\16\2\2\u00b1"+
		"\u00b2\b\r\1\2\u00b2\u00b8\7\5\2\2\u00b3\u00b4\7\4\2\2\u00b4\u00b5\7\16"+
		"\2\2\u00b5\u00b6\b\r\1\2\u00b6\u00b8\7\4\2\2\u00b7\u00ad\3\2\2\2\u00b7"+
		"\u00af\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b8\31\3\2\2\2\u00b9\u00ba\7\5\2"+
		"\2\u00ba\u00bb\7\16\2\2\u00bb\u00bc\b\16\1\2\u00bc\u00c8\7\5\2\2\u00bd"+
		"\u00be\7\4\2\2\u00be\u00bf\7\16\2\2\u00bf\u00c0\b\16\1\2\u00c0\u00c8\7"+
		"\4\2\2\u00c1\u00c2\7\16\2\2\u00c2\u00c8\b\16\1\2\u00c3\u00c4\7\f\2\2\u00c4"+
		"\u00c8\b\16\1\2\u00c5\u00c6\7\r\2\2\u00c6\u00c8\b\16\1\2\u00c7\u00b9\3"+
		"\2\2\2\u00c7\u00bd\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\33\3\2\2\2\u00c9\u00ca\7\n\2\2\u00ca\u00cb\7\5\2"+
		"\2\u00cb\u00cc\7\16\2\2\u00cc\u00cd\b\17\1\2\u00cd\u00dd\7\5\2\2\u00ce"+
		"\u00cf\7\n\2\2\u00cf\u00d0\7\4\2\2\u00d0\u00d1\7\16\2\2\u00d1\u00d2\b"+
		"\17\1\2\u00d2\u00dd\7\4\2\2\u00d3\u00d4\7\n\2\2\u00d4\u00d5\7\16\2\2\u00d5"+
		"\u00dd\b\17\1\2\u00d6\u00d7\7\n\2\2\u00d7\u00d8\7\f\2\2\u00d8\u00dd\b"+
		"\17\1\2\u00d9\u00da\7\n\2\2\u00da\u00db\7\r\2\2\u00db\u00dd\b\17\1\2\u00dc"+
		"\u00c9\3\2\2\2\u00dc\u00ce\3\2\2\2\u00dc\u00d3\3\2\2\2\u00dc\u00d6\3\2"+
		"\2\2\u00dc\u00d9\3\2\2\2\u00dd\35\3\2\2\2\30*.\638=CEO]akovz\u0085\u0089"+
		"\u0092\u0096\u00a8\u00b7\u00c7\u00dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}