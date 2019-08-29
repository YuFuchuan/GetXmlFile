/**
 * Define a grammar called Hello
 */
grammar GetXmlFile_v1_1;

@parser::header {
package Leo.GetXmlFile;

import java.util.*;
}

@parser::members {
public static Map<Integer, String> node_name = new HashMap<Integer, String>();				//<节点编号i_n,节点名xxx.getText()>
public static Map<Integer, String> node_value = new HashMap<Integer, String>();				//<节点编号i_n,节点值xxx.getText()>
public static Map<Integer, Integer> node_depth = new HashMap<Integer, Integer>();			//<节点编号i_n,节点深度i_d>
public static Map<Integer, Integer> node_property_first = new HashMap<Integer, Integer>();	//<节点编号i_n,第一个属性编号i_p>
public static Map<Integer, Integer> node_property_final = new HashMap<Integer, Integer>();	//<节点编号i_n,最后一个属性编号i_p>
public static Map<Integer, String> property_name = new HashMap<Integer, String>();			//<属性编号i_n,属性名xxx.getText()>
public static Map<Integer, String> property_value = new HashMap<Integer, String>();			//<属性编号i_n,属性值xxx.getText()>
public static Map<Integer, String> comment = new HashMap<Integer, String>();				//<注释编号i_n,注释内容xxx.getText()>

public static int i_n = 1;		//控制节点编号计算
public static int i_p = 1;		//控制属性编号计算
public static int i_c = 1;		//控制注释编号计算
public static int i_d = 1;		//控制节点深度计算
}

// 当前版本会在规范化后省略所有注释内容

// 标准的xml注释
comment_correct
	:	COMMENT_CORRECT {comment.put(i_c++, $COMMENT_CORRECT.getText());}
	;
	
// 常用的单行注释格式
comment_other_a_line
	:	COMMENT_OTHER_A_LINE {comment.put(i_c++, $COMMENT_OTHER_A_LINE.getText());}
	;
	
// 常用的多行注释格式
comment_other_multi_line
	:	COMMENT_OTHER_MULTI_LINE {comment.put(i_c++, $COMMENT_OTHER_MULTI_LINE.getText());}
	;

// 节点
node
	:	( pri_node_begin | abb_node_begin | abb2_node_begin )
		( pri_node_value | abb_node_value ) 
		( pri_node_end | abb_node_end | abb2_node_end )
	|	( pri_node_begin | abb_node_begin | abb2_node_begin )
		node* 
		( pri_node_end | abb_node_end | abb2_node_end )
	;

// 标准的xml节点的头
pri_node_begin
	:	'<' 
		Identifier {node_name.put(i_n, $Identifier.getText());} 			// 记录节点名
		{node_depth.put(i_n, i_d++);} 										// 记录节点深度并将计算节点深度的变量+1
		{node_property_first.put(i_n, i_p);}								// 记录节点对应第一个的属性的编号
		( pri_node_property )* 
		'>'
	;
	
// 精简化的xml节点的头
abb_node_begin
	:	'<' 
		Identifier {node_name.put(i_n, $Identifier.getText());} 			// 记录节点名
		{node_depth.put(i_n, i_d++);} 										// 记录节点深度并将计算节点深度的变量+1
		{node_property_first.put(i_n, i_p);}								// 记录节点对应第一个的属性的编号
		( LB abb_node_property+ RB )?
	;
	
// 精简化v2的Xml节点的头
abb2_node_begin
	:	Identifier {node_name.put(i_n, $Identifier.getText());} 			// 记录节点名
		{node_depth.put(i_n, i_d++);} 										// 记录节点深度并将计算节点深度的变量+1
		{node_property_first.put(i_n, i_p);}								// 记录节点对应第一个的属性的编号
		( LB abb_node_property+ RB )? 
		':' 
		( LB abb_node_property+ RB )?
	;
	
// 标准的xml节点的尾
pri_node_end
	:	'</' 
		Identifier 
		'>'
		{i_d--;} 		// 节点结束,将计算节点深度的变量-1
	;
	
// 精简化的xml节点的尾
abb_node_end
	:	( LB abb_node_property+ RB )? 
		'/>'
		{i_d--;} 		// 节点结束,将计算节点深度的变量-1
	;
	
// 精简化v2的Xml节点的尾
abb2_node_end
	:	( LB abb_node_property+ RB )? 
		';'
		{i_d--;} 		// 节点结束,将计算节点深度的变量-1
	;
	
// 标准的xml节点的属性(兼容了错误的形式)
pri_node_property
	:	Identifier {property_name.put(i_p, $Identifier.getText());} 					// 记录属性名
		'=' 
		(	StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// 记录属性值
		|	'\''
			StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// 同上
			'\''
		|	'"'
			StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// 同上	
			'"'
		)
	;

// 精简化的xml节点的属性(可能做出修改,备用)
// 本token和pri_node_property因使用的情况不同,所以不会造成冲突
abb_node_property
	:	Identifier {property_name.put(i_p, $Identifier.getText());} 					// 记录属性名
		'=' 
		(	StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// 记录属性值
		|	'\''
			StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// 同上
			'\''
		|	'"'
			StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// 同上	
			'"'
		)
	;
	
// 标准的xml节点的值(兼容了错误的字符串形式)
pri_node_value
	:	'\'' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// 记录节点值
		'\''
	|	'"' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// 同上
		'"'
	|	StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// 同上
	|	IntegerLiteral {node_value.put(i_n, $IntegerLiteral.getText());} 				// 同上
	|	FloatingPointLiteral {node_value.put(i_n, $FloatingPointLiteral.getText());} 	// 同上
	;
	
// 精简化的xml节点的值
abb_node_value
	:	'=' '\'' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// 记录节点值
		'\''
	|	'=' '"' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// 同上
		'"'
	|	'=' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// 同上
	|	'=' 
		IntegerLiteral {node_value.put(i_n, $IntegerLiteral.getText());} 				// 同上
	|	'=' 
		FloatingPointLiteral {node_value.put(i_n, $FloatingPointLiteral.getText());} 	// 同上
	;
	
// 标识符(暂时废置,Identifier现在的词法在下方)
//Identifier
//	:	(( Underscores ( Letter_L | Letter_C )) | Letter_L | Letter_C )
//		( Letter_L | Letter_C | Underscores | Digit )* 
//	;

// 整型字面量
IntegerLiteral
	:	DecimalIntegerLiteral
	|	HexIntegerLiteral
	|	OctalIntegerLiteral
	|	BinaryIntegerLiteral
	;

// 十进制整型字面量
fragment
DecimalIntegerLiteral
	:	DecimalNumeral IntegerTypeSuffix?
	;

// 十六进制整型字面量
fragment
HexIntegerLiteral
	:	HexNumeral IntegerTypeSuffix?
	;

// 八进制整型字面量
fragment
OctalIntegerLiteral
	:	OctalNumeral IntegerTypeSuffix?
	;

// 二进制整型字面量
fragment
BinaryIntegerLiteral
	:	BinaryNumeral IntegerTypeSuffix?
	;

// 整数类型后缀
fragment
IntegerTypeSuffix
	:	[lL]
	;

// 十进制数
fragment
DecimalNumeral
	:	'0'
	|	NonZeroDigit (Digits? | Underscores Digits)
	;

// 十进制数字串
fragment
Digits
	:	Digit (DigitsAndUnderscores? Digit)?
	;

// 十进制数字
fragment
Digit
	:	'0'
	|	NonZeroDigit
	;

// 非零十进制数字
fragment
NonZeroDigit
	:	[1-9]
	;

// 十进制数字和下划线
fragment
DigitsAndUnderscores
	:	DigitOrUnderscore+
	;

// 十进制数字和下划线
fragment
DigitOrUnderscore
	:	Digit
	|	'_'
	;

// 下划线
fragment
Underscores
	:	'_'+
	;

// 十六进制数
fragment
HexNumeral
	:	'0' [xX] HexDigits
	;

// 十六进制数字串
fragment
HexDigits
	:	HexDigit (HexDigitsAndUnderscores? HexDigit)?
	;

// 十六进制数字
fragment
HexDigit
	:	[0-9a-fA-F]
	;

// 十六进制数字和下划线
fragment
HexDigitsAndUnderscores
	:	HexDigitOrUnderscore+
	;

// 十六进制数字或下划线
fragment
HexDigitOrUnderscore
	:	HexDigit
	|	'_'
	;

// 八进制数
fragment
OctalNumeral
	:	'0' Underscores? OctalDigits
	;

// 八进制数字串
fragment
OctalDigits
	:	OctalDigit (OctalDigitsAndUnderscores? OctalDigit)?
	;

// 八进制数字
fragment
OctalDigit
	:	[0-7]
	;

// 八进制数字和下划线
fragment
OctalDigitsAndUnderscores
	:	OctalDigitOrUnderscore+
	;

// 八进制数字或下划线
fragment
OctalDigitOrUnderscore
	:	OctalDigit
	|	'_'
	;

// 二进制数
fragment
BinaryNumeral
	:	'0' [bB] BinaryDigits
	;

// 二进制数字串
fragment
BinaryDigits
	:	BinaryDigit (BinaryDigitsAndUnderscores? BinaryDigit)?
	;

// 二进制数字
fragment
BinaryDigit
	:	[01]
	;

// 二进制数字和下划线
fragment
BinaryDigitsAndUnderscores
	:	BinaryDigitOrUnderscore+
	;

// 二进制数字或下划线
fragment
BinaryDigitOrUnderscore
	:	BinaryDigit
	|	'_'
	;

// 浮点字面量
FloatingPointLiteral
	:	DecimalFloatingPointLiteral
	|	HexadecimalFloatingPointLiteral
	;

// 十进制浮点字面量
fragment
DecimalFloatingPointLiteral
	:	Digits '.' Digits? ExponentPart? FloatTypeSuffix?
	|	'.' Digits ExponentPart? FloatTypeSuffix?
	|	Digits ExponentPart FloatTypeSuffix?
	|	Digits FloatTypeSuffix
	;

// 指数部分
fragment
ExponentPart
	:	ExponentIndicator SignedInteger
	;

// 指数标志
fragment
ExponentIndicator
	:	[eE]
	;

// 带符号整型数
fragment
SignedInteger
	:	Sign? Digits
	;

// 正负符号
fragment
Sign
	:	[+-]
	;

// 浮点类型后缀
fragment
FloatTypeSuffix
	:	[fFdD]
	;

// 十六进制浮点字面量
fragment
HexadecimalFloatingPointLiteral
	:	HexSignificand BinaryExponent FloatTypeSuffix?
	;

// 十六进制有效数
fragment
HexSignificand
	:	HexNumeral '.'?
	|	'0' [xX] HexDigits? '.' HexDigits
	;

// 二进制指数
fragment
BinaryExponent
	:	BinaryExponentIndicator SignedInteger
	;

// 二进制指数标志
fragment
BinaryExponentIndicator
	:	[pP]
	;

// 字符字面量
//CharacterLiteral
//	:	'\'' SingleCharacter '\''
//	|	'\'' EscapeSequence '\''
//	;

// 单字符
//fragment
//SingleCharacter
//	:	~['\\\r\n]
//	;

// 字符串字面量
//StringLiteral
//	:	'"' StringCharacters? '"'
//	;

// 字符串字符组
//fragment
StringCharacters
	:	StringCharacter+
	;

// 字符串字符
fragment
StringCharacter
	:	~["\\\r\n]
	|	EscapeSequence
	;
	
// 转义序列
fragment
EscapeSequence
	:	'\\' [btnfr"'\\]
	|	OctalEscape
    |   UnicodeEscape
	;

// 八进制转义
fragment
OctalEscape
	:	'\\' OctalDigit
	|	'\\' OctalDigit OctalDigit
	|	'\\' ZeroToThree OctalDigit OctalDigit
	;

// 0、1、2、3(用于8进制转义中)
fragment
ZeroToThree
	:	[0-3]
	;

// 16进制Unicode转义
fragment
UnicodeEscape
    :   '\\' 'u'+  HexDigit HexDigit HexDigit HexDigit
    ;

LB		:		'<' | '(' | '[' | '{';	// 左括号
RB		:		'>' | ')' | ']' | '}';	// 右括号

// 备用(以下字符在xml中可以被转义)
LT		:		'&lt';		// <
RT		:		'&rt';		// >
AMP		:		'&apos';	// &
APOS	:		'&apos';	// '
QUOT	:		'&quot';	// "

Identifier
	:	Identifier_L
	|	Identifier_C
	;

fragment
Identifier_L
	:	Letter_L LetterOrDigit*
	;

fragment
Identifier_C
	:	Letter_C LetterOrDigit*
	;

//fragment
//Identifier_C_All
//	:	Letter_C ( Letter_C | Letter_Other | IdentifierDigit)*
//	;

fragment
Letter
	:	Letter_L
	|	Letter_C
	|	Letter_Other
	;
	
fragment
LetterOrDigit
	:	IdentifierDigit
	|	Letter_L
	|	Letter_C
	|	Letter_Other
	;

fragment
IdentifierDigit:[0-9];

fragment
Letter_L:		[a-z];

fragment
Letter_C:		[A-Z];

fragment
Letter_Other
	:	[$_]	
		~[\u0000-\u007F\uD800-\uDBFF] 		// 覆盖0x7f以上的所有字符，这些字符不是替代项
		{Character.isJavaIdentifierPart(_input.LA(-1))}?
	|	[\uD800-\uDBFF] [\uDC00-\uDFFF] 	// 覆盖U+10000到U+10ffff的UTF-16替代编码
		{Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
	;

WS 		:	[ \t\r\n\u000C]+ -> skip;

// 标准的xml注释
COMMENT_CORRECT
	:	'<!--' .*? '-->'	// -> channel(HIDDEN)
	;

// 常用的单行注释格式
COMMENT_OTHER_A_LINE
    :   '//' ~[\r\n]*		// -> channel(HIDDEN)
    ;
    
// 常用的多行注释格式
COMMENT_OTHER_MULTI_LINE
    :   '/*' .*? '*/'		// -> channel(HIDDEN)
    ;