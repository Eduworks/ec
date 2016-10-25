/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar Rollup;


NUMBER : '0'..'9' + ('.' '0'..'9'+)?
	;
BOOLEAN : 'true' | 'false'
	;
LOGICAL_OPERATOR : 'AND' | 'OR'
	;
MATH_OPERATOR : '+' | '-' | '*' | '/'
	;
QUANTATIVE_OPERATOR : ':<' | ':>' | ':<=' | ':>=' | ':!=' | ':' 
	;
WS : (' '|'\t'|'\r'|'\n')+
	;
	
KEY : ('a'..'z'|'A'..'Z'|'.')+
	;

LEFT_BRACE : '[' ;
RIGHT_BRACE : ']' ;

VALUE 	:	'http' ~' '+
	;


s : token WS? (WS? cLogic=logical_or_math_operator WS? token WS?)*
	;
token : cNumber=NUMBER | query | cBoolean=BOOLEAN
	;
query : LEFT_BRACE WS? cQuery=innerquery WS? RIGHT_BRACE
	;
innerquery : cKey=KEY cOperator=QUANTATIVE_OPERATOR WS? (cValue=VALUE|cNumber=NUMBER) WS? (cLogic=LOGICAL_OPERATOR WS? innerquery)*
	;
logical_or_math_operator : cLogic=LOGICAL_OPERATOR | cMath=MATH_OPERATOR
	;
