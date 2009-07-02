tree grammar WaebricTreeWalker;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
}

module:		^( MODULE moduleId END );
moduleId:	^( IDCON ( '.' IDCON )* );
