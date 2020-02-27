Copyright 2015-2020 Eduworks Corporation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

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
