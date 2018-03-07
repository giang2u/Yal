package yal.analyse ;

import java_cup.runtime.*;
import yal.exceptions.AnalyseLexicaleException;

%%

%class AnalyseurLexical
%public

%line
%column

%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}
%state commentaire

debut= "debut"
programme= "programme"
fin="fin"
csteE = [0-9]+
csteB = "vrai" | "faux"
type ="entier"
idf = [a-zA-Z][a-zA-Z0-9]*
finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]
commentaireSlashSlash = [/][/].*
commentaireSlashEtoile = [/][*]
commentaireEtoileSlash = [*][/]
csteChaine = [\"] ([\"][\"]|[^\"])+[\"]
%%
<YYINITIAL>{
","                 { return symbol(CodesLexicaux.VIRGULE); }

";"                 { return symbol(CodesLexicaux.POINTVIRGULE); }
"+"                	{ return symbol(CodesLexicaux.PLUS); }
"-"                	{ return symbol(CodesLexicaux.MOINS); }
"*"                	{ return symbol(CodesLexicaux.MULT); }
"/"                	{ return symbol(CodesLexicaux.DIV); }
"="                    { return symbol(CodesLexicaux.EGAL); }
"=="                    { return symbol(CodesLexicaux.EGALEGAL); }
"!="                    { return symbol(CodesLexicaux.DIFF); }
"<"                	{ return symbol(CodesLexicaux.INF); }
">"                	{ return symbol(CodesLexicaux.SUP); }

"et"                	{ return symbol(CodesLexicaux.ET); }
"ou"                	{ return symbol(CodesLexicaux.OU); }
"non"                	{ return symbol(CodesLexicaux.NON); }
"("                	{ return symbol(CodesLexicaux.PAROUV); }
")"                	{ return symbol(CodesLexicaux.PARFER); }
"ecrire"            { return symbol(CodesLexicaux.ECRIRE);}
"alors"					       { return symbol(CodesLexicaux.ALORS, yytext()); }
"si"					       { return symbol(CodesLexicaux.SI, yytext()); }
"sinon"					       { return symbol(CodesLexicaux.SINON, yytext()); }
"fsi"					       { return symbol(CodesLexicaux.FSI, yytext()); }

"lire"					       { return symbol(CodesLexicaux.LIRE, yytext()); }
"tantque"					       { return symbol(CodesLexicaux.TANTQUE, yytext()); }
"repeter"					       { return symbol(CodesLexicaux.REPETER, yytext()); }
"retourne"			{ return symbol(CodesLexicaux.RETOURNE, yytext()); }
"fintantque"	{ return symbol(CodesLexicaux.FINTANTQUE, yytext()); }
"fonction"		{ return symbol(CodesLexicaux.FONCTION, yytext()); }

{csteChaine}        { return symbol(CodesLexicaux.CSTECHAINE,yytext());}
{csteE}      	        { return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
{csteB}      	        { return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }
{type}      	        { return symbol(CodesLexicaux.TYPE, yytext()); }
{debut}					{ return symbol(CodesLexicaux.DEBUT, yytext()); }
{programme}					{ return symbol(CodesLexicaux.PROGRAMME, yytext()); }
{fin}					{ return symbol(CodesLexicaux.FIN, yytext()); }

{idf}               { return symbol(CodesLexicaux.IDF, yytext()); }
{commentaireSlashSlash} {}
{commentaireSlashEtoile} { yybegin(commentaire); }
{espace}                { }
.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }

}

<commentaire> {
	{commentaireEtoileSlash} { yybegin(YYINITIAL); }
	.                       {}
	\n                      {}
	\r						{}
}
