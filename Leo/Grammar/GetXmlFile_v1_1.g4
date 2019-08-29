/**
 * Define a grammar called Hello
 */
grammar GetXmlFile_v1_1;

@parser::header {
package Leo.GetXmlFile;

import java.util.*;
}

@parser::members {
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
}

// ��ǰ�汾���ڹ淶����ʡ������ע������

// ��׼��xmlע��
comment_correct
	:	COMMENT_CORRECT {comment.put(i_c++, $COMMENT_CORRECT.getText());}
	;
	
// ���õĵ���ע�͸�ʽ
comment_other_a_line
	:	COMMENT_OTHER_A_LINE {comment.put(i_c++, $COMMENT_OTHER_A_LINE.getText());}
	;
	
// ���õĶ���ע�͸�ʽ
comment_other_multi_line
	:	COMMENT_OTHER_MULTI_LINE {comment.put(i_c++, $COMMENT_OTHER_MULTI_LINE.getText());}
	;

// �ڵ�
node
	:	( pri_node_begin | abb_node_begin | abb2_node_begin )
		( pri_node_value | abb_node_value ) 
		( pri_node_end | abb_node_end | abb2_node_end )
	|	( pri_node_begin | abb_node_begin | abb2_node_begin )
		node* 
		( pri_node_end | abb_node_end | abb2_node_end )
	;

// ��׼��xml�ڵ��ͷ
pri_node_begin
	:	'<' 
		Identifier {node_name.put(i_n, $Identifier.getText());} 			// ��¼�ڵ���
		{node_depth.put(i_n, i_d++);} 										// ��¼�ڵ���Ȳ�������ڵ���ȵı���+1
		{node_property_first.put(i_n, i_p);}								// ��¼�ڵ��Ӧ��һ�������Եı��
		( pri_node_property )* 
		'>'
	;
	
// ���򻯵�xml�ڵ��ͷ
abb_node_begin
	:	'<' 
		Identifier {node_name.put(i_n, $Identifier.getText());} 			// ��¼�ڵ���
		{node_depth.put(i_n, i_d++);} 										// ��¼�ڵ���Ȳ�������ڵ���ȵı���+1
		{node_property_first.put(i_n, i_p);}								// ��¼�ڵ��Ӧ��һ�������Եı��
		( LB abb_node_property+ RB )?
	;
	
// ����v2��Xml�ڵ��ͷ
abb2_node_begin
	:	Identifier {node_name.put(i_n, $Identifier.getText());} 			// ��¼�ڵ���
		{node_depth.put(i_n, i_d++);} 										// ��¼�ڵ���Ȳ�������ڵ���ȵı���+1
		{node_property_first.put(i_n, i_p);}								// ��¼�ڵ��Ӧ��һ�������Եı��
		( LB abb_node_property+ RB )? 
		':' 
		( LB abb_node_property+ RB )?
	;
	
// ��׼��xml�ڵ��β
pri_node_end
	:	'</' 
		Identifier 
		'>'
		{i_d--;} 		// �ڵ����,������ڵ���ȵı���-1
	;
	
// ���򻯵�xml�ڵ��β
abb_node_end
	:	( LB abb_node_property+ RB )? 
		'/>'
		{i_d--;} 		// �ڵ����,������ڵ���ȵı���-1
	;
	
// ����v2��Xml�ڵ��β
abb2_node_end
	:	( LB abb_node_property+ RB )? 
		';'
		{i_d--;} 		// �ڵ����,������ڵ���ȵı���-1
	;
	
// ��׼��xml�ڵ������(�����˴������ʽ)
pri_node_property
	:	Identifier {property_name.put(i_p, $Identifier.getText());} 					// ��¼������
		'=' 
		(	StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// ��¼����ֵ
		|	'\''
			StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// ͬ��
			'\''
		|	'"'
			StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// ͬ��	
			'"'
		)
	;

// ���򻯵�xml�ڵ������(���������޸�,����)
// ��token��pri_node_property��ʹ�õ������ͬ,���Բ�����ɳ�ͻ
abb_node_property
	:	Identifier {property_name.put(i_p, $Identifier.getText());} 					// ��¼������
		'=' 
		(	StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// ��¼����ֵ
		|	'\''
			StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// ͬ��
			'\''
		|	'"'
			StringCharacters {property_value.put(i_p++, $StringCharacters.getText());}	// ͬ��	
			'"'
		)
	;
	
// ��׼��xml�ڵ��ֵ(�����˴�����ַ�����ʽ)
pri_node_value
	:	'\'' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// ��¼�ڵ�ֵ
		'\''
	|	'"' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// ͬ��
		'"'
	|	StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// ͬ��
	|	IntegerLiteral {node_value.put(i_n, $IntegerLiteral.getText());} 				// ͬ��
	|	FloatingPointLiteral {node_value.put(i_n, $FloatingPointLiteral.getText());} 	// ͬ��
	;
	
// ���򻯵�xml�ڵ��ֵ
abb_node_value
	:	'=' '\'' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// ��¼�ڵ�ֵ
		'\''
	|	'=' '"' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// ͬ��
		'"'
	|	'=' 
		StringCharacters {node_value.put(i_n, $StringCharacters.getText());} 			// ͬ��
	|	'=' 
		IntegerLiteral {node_value.put(i_n, $IntegerLiteral.getText());} 				// ͬ��
	|	'=' 
		FloatingPointLiteral {node_value.put(i_n, $FloatingPointLiteral.getText());} 	// ͬ��
	;
	
// ��ʶ��(��ʱ����,Identifier���ڵĴʷ����·�)
//Identifier
//	:	(( Underscores ( Letter_L | Letter_C )) | Letter_L | Letter_C )
//		( Letter_L | Letter_C | Underscores | Digit )* 
//	;

// ����������
IntegerLiteral
	:	DecimalIntegerLiteral
	|	HexIntegerLiteral
	|	OctalIntegerLiteral
	|	BinaryIntegerLiteral
	;

// ʮ��������������
fragment
DecimalIntegerLiteral
	:	DecimalNumeral IntegerTypeSuffix?
	;

// ʮ����������������
fragment
HexIntegerLiteral
	:	HexNumeral IntegerTypeSuffix?
	;

// �˽�������������
fragment
OctalIntegerLiteral
	:	OctalNumeral IntegerTypeSuffix?
	;

// ����������������
fragment
BinaryIntegerLiteral
	:	BinaryNumeral IntegerTypeSuffix?
	;

// �������ͺ�׺
fragment
IntegerTypeSuffix
	:	[lL]
	;

// ʮ������
fragment
DecimalNumeral
	:	'0'
	|	NonZeroDigit (Digits? | Underscores Digits)
	;

// ʮ�������ִ�
fragment
Digits
	:	Digit (DigitsAndUnderscores? Digit)?
	;

// ʮ��������
fragment
Digit
	:	'0'
	|	NonZeroDigit
	;

// ����ʮ��������
fragment
NonZeroDigit
	:	[1-9]
	;

// ʮ�������ֺ��»���
fragment
DigitsAndUnderscores
	:	DigitOrUnderscore+
	;

// ʮ�������ֺ��»���
fragment
DigitOrUnderscore
	:	Digit
	|	'_'
	;

// �»���
fragment
Underscores
	:	'_'+
	;

// ʮ��������
fragment
HexNumeral
	:	'0' [xX] HexDigits
	;

// ʮ���������ִ�
fragment
HexDigits
	:	HexDigit (HexDigitsAndUnderscores? HexDigit)?
	;

// ʮ����������
fragment
HexDigit
	:	[0-9a-fA-F]
	;

// ʮ���������ֺ��»���
fragment
HexDigitsAndUnderscores
	:	HexDigitOrUnderscore+
	;

// ʮ���������ֻ��»���
fragment
HexDigitOrUnderscore
	:	HexDigit
	|	'_'
	;

// �˽�����
fragment
OctalNumeral
	:	'0' Underscores? OctalDigits
	;

// �˽������ִ�
fragment
OctalDigits
	:	OctalDigit (OctalDigitsAndUnderscores? OctalDigit)?
	;

// �˽�������
fragment
OctalDigit
	:	[0-7]
	;

// �˽������ֺ��»���
fragment
OctalDigitsAndUnderscores
	:	OctalDigitOrUnderscore+
	;

// �˽������ֻ��»���
fragment
OctalDigitOrUnderscore
	:	OctalDigit
	|	'_'
	;

// ��������
fragment
BinaryNumeral
	:	'0' [bB] BinaryDigits
	;

// ���������ִ�
fragment
BinaryDigits
	:	BinaryDigit (BinaryDigitsAndUnderscores? BinaryDigit)?
	;

// ����������
fragment
BinaryDigit
	:	[01]
	;

// ���������ֺ��»���
fragment
BinaryDigitsAndUnderscores
	:	BinaryDigitOrUnderscore+
	;

// ���������ֻ��»���
fragment
BinaryDigitOrUnderscore
	:	BinaryDigit
	|	'_'
	;

// ����������
FloatingPointLiteral
	:	DecimalFloatingPointLiteral
	|	HexadecimalFloatingPointLiteral
	;

// ʮ���Ƹ���������
fragment
DecimalFloatingPointLiteral
	:	Digits '.' Digits? ExponentPart? FloatTypeSuffix?
	|	'.' Digits ExponentPart? FloatTypeSuffix?
	|	Digits ExponentPart FloatTypeSuffix?
	|	Digits FloatTypeSuffix
	;

// ָ������
fragment
ExponentPart
	:	ExponentIndicator SignedInteger
	;

// ָ����־
fragment
ExponentIndicator
	:	[eE]
	;

// ������������
fragment
SignedInteger
	:	Sign? Digits
	;

// ��������
fragment
Sign
	:	[+-]
	;

// �������ͺ�׺
fragment
FloatTypeSuffix
	:	[fFdD]
	;

// ʮ�����Ƹ���������
fragment
HexadecimalFloatingPointLiteral
	:	HexSignificand BinaryExponent FloatTypeSuffix?
	;

// ʮ��������Ч��
fragment
HexSignificand
	:	HexNumeral '.'?
	|	'0' [xX] HexDigits? '.' HexDigits
	;

// ������ָ��
fragment
BinaryExponent
	:	BinaryExponentIndicator SignedInteger
	;

// ������ָ����־
fragment
BinaryExponentIndicator
	:	[pP]
	;

// �ַ�������
//CharacterLiteral
//	:	'\'' SingleCharacter '\''
//	|	'\'' EscapeSequence '\''
//	;

// ���ַ�
//fragment
//SingleCharacter
//	:	~['\\\r\n]
//	;

// �ַ���������
//StringLiteral
//	:	'"' StringCharacters? '"'
//	;

// �ַ����ַ���
//fragment
StringCharacters
	:	StringCharacter+
	;

// �ַ����ַ�
fragment
StringCharacter
	:	~["\\\r\n]
	|	EscapeSequence
	;
	
// ת������
fragment
EscapeSequence
	:	'\\' [btnfr"'\\]
	|	OctalEscape
    |   UnicodeEscape
	;

// �˽���ת��
fragment
OctalEscape
	:	'\\' OctalDigit
	|	'\\' OctalDigit OctalDigit
	|	'\\' ZeroToThree OctalDigit OctalDigit
	;

// 0��1��2��3(����8����ת����)
fragment
ZeroToThree
	:	[0-3]
	;

// 16����Unicodeת��
fragment
UnicodeEscape
    :   '\\' 'u'+  HexDigit HexDigit HexDigit HexDigit
    ;

LB		:		'<' | '(' | '[' | '{';	// ������
RB		:		'>' | ')' | ']' | '}';	// ������

// ����(�����ַ���xml�п��Ա�ת��)
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
		~[\u0000-\u007F\uD800-\uDBFF] 		// ����0x7f���ϵ������ַ�����Щ�ַ����������
		{Character.isJavaIdentifierPart(_input.LA(-1))}?
	|	[\uD800-\uDBFF] [\uDC00-\uDFFF] 	// ����U+10000��U+10ffff��UTF-16�������
		{Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
	;

WS 		:	[ \t\r\n\u000C]+ -> skip;

// ��׼��xmlע��
COMMENT_CORRECT
	:	'<!--' .*? '-->'	// -> channel(HIDDEN)
	;

// ���õĵ���ע�͸�ʽ
COMMENT_OTHER_A_LINE
    :   '//' ~[\r\n]*		// -> channel(HIDDEN)
    ;
    
// ���õĶ���ע�͸�ʽ
COMMENT_OTHER_MULTI_LINE
    :   '/*' .*? '*/'		// -> channel(HIDDEN)
    ;