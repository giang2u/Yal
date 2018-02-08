
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu Feb 08 12:31:42 CET 2018
//----------------------------------------------------

package yal.analyse;

import java.util.*;
import yal.arbre.*;
import yal.arbre.expression.*;
import yal.exceptions.AnalyseSyntaxiqueException;
import java_cup.runtime.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu Feb 08 12:31:42 CET 2018
  */
public class AnalyseurSyntaxique extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalyseurSyntaxique() {super();}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\004\000\002\002\003\000\002\002" +
    "\003\000\002\003\004\000\002\003\003\000\002\005\003" +
    "\000\002\006\005\000\002\006\007\000\002\007\005\000" +
    "\002\007\005\000\002\007\005\000\002\007\005\000\002" +
    "\007\005\000\002\007\005\000\002\007\005\000\002\007" +
    "\005\000\002\007\004\000\002\007\005\000\002\007\005" +
    "\000\002\007\004\000\002\007\003\000\002\007\005\000" +
    "\002\010\003\000\002\010\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\004\025\010\001\002\000\004\002\056\001" +
    "\002\000\006\002\ufffd\025\ufffd\001\002\000\004\002\uffff" +
    "\001\002\000\006\002\000\025\010\001\002\000\004\026" +
    "\012\001\002\000\006\002\ufffc\025\ufffc\001\002\000\006" +
    "\012\014\022\013\001\002\000\006\002\ufffb\025\ufffb\001" +
    "\002\000\014\005\016\010\022\021\023\023\017\024\021" +
    "\001\002\000\030\004\027\005\033\006\025\007\030\013" +
    "\035\014\031\015\036\016\032\017\026\020\034\022\054" +
    "\001\002\000\014\005\016\010\022\021\023\023\017\024" +
    "\021\001\002\000\032\004\uffeb\005\uffeb\006\uffeb\007\uffeb" +
    "\011\uffeb\013\uffeb\014\uffeb\015\uffeb\016\uffeb\017\uffeb\020" +
    "\uffeb\022\uffeb\001\002\000\032\004\uffed\005\uffed\006\uffed" +
    "\007\uffed\011\uffed\013\uffed\014\uffed\015\uffed\016\uffed\017" +
    "\uffed\020\uffed\022\uffed\001\002\000\032\004\uffea\005\uffea" +
    "\006\uffea\007\uffea\011\uffea\013\uffea\014\uffea\015\uffea\016" +
    "\uffea\017\uffea\020\uffea\022\uffea\001\002\000\014\005\016" +
    "\010\022\021\023\023\017\024\021\001\002\000\014\005" +
    "\016\010\022\021\023\023\017\024\021\001\002\000\032" +
    "\004\uffee\005\uffee\006\uffee\007\uffee\011\uffee\013\uffee\014" +
    "\uffee\015\uffee\016\uffee\017\uffee\020\uffee\022\uffee\001\002" +
    "\000\014\005\016\010\022\021\023\023\017\024\021\001" +
    "\002\000\014\005\016\010\022\021\023\023\017\024\021" +
    "\001\002\000\014\005\016\010\022\021\023\023\017\024" +
    "\021\001\002\000\014\005\016\010\022\021\023\023\017" +
    "\024\021\001\002\000\014\005\016\010\022\021\023\023" +
    "\017\024\021\001\002\000\014\005\016\010\022\021\023" +
    "\023\017\024\021\001\002\000\014\005\016\010\022\021" +
    "\023\023\017\024\021\001\002\000\014\005\016\010\022" +
    "\021\023\023\017\024\021\001\002\000\014\005\016\010" +
    "\022\021\023\023\017\024\021\001\002\000\014\005\016" +
    "\010\022\021\023\023\017\024\021\001\002\000\032\004" +
    "\027\005\033\006\025\007\030\011\ufff3\013\035\014\031" +
    "\015\ufff3\016\ufff3\017\ufff3\020\ufff3\022\ufff3\001\002\000" +
    "\032\004\027\005\033\006\025\007\030\011\ufff4\013\ufff4" +
    "\014\ufff4\015\ufff4\016\ufff4\017\ufff4\020\ufff4\022\ufff4\001" +
    "\002\000\032\004\027\005\033\006\025\007\030\011\uffef" +
    "\013\035\014\031\015\036\016\032\017\026\020\uffef\022" +
    "\uffef\001\002\000\032\004\ufff8\005\ufff8\006\025\007\030" +
    "\011\ufff8\013\ufff8\014\ufff8\015\ufff8\016\ufff8\017\ufff8\020" +
    "\ufff8\022\ufff8\001\002\000\032\004\027\005\033\006\025" +
    "\007\030\011\ufff2\013\035\014\031\015\ufff2\016\ufff2\017" +
    "\ufff2\020\ufff2\022\ufff2\001\002\000\032\004\027\005\033" +
    "\006\025\007\030\011\ufff5\013\ufff5\014\ufff5\015\ufff5\016" +
    "\ufff5\017\ufff5\020\ufff5\022\ufff5\001\002\000\032\004\ufff6" +
    "\005\ufff6\006\ufff6\007\ufff6\011\ufff6\013\ufff6\014\ufff6\015" +
    "\ufff6\016\ufff6\017\ufff6\020\ufff6\022\ufff6\001\002\000\032" +
    "\004\ufff9\005\ufff9\006\025\007\030\011\ufff9\013\ufff9\014" +
    "\ufff9\015\ufff9\016\ufff9\017\ufff9\020\ufff9\022\ufff9\001\002" +
    "\000\032\004\027\005\033\006\025\007\030\011\ufff0\013" +
    "\035\014\031\015\036\016\032\017\ufff0\020\ufff0\022\ufff0" +
    "\001\002\000\032\004\ufff7\005\ufff7\006\ufff7\007\ufff7\011" +
    "\ufff7\013\ufff7\014\ufff7\015\ufff7\016\ufff7\017\ufff7\020\ufff7" +
    "\022\ufff7\001\002\000\030\004\027\005\033\006\025\007" +
    "\030\011\052\013\035\014\031\015\036\016\032\017\026" +
    "\020\034\001\002\000\032\004\uffec\005\uffec\006\uffec\007" +
    "\uffec\011\uffec\013\uffec\014\uffec\015\uffec\016\uffec\017\uffec" +
    "\020\uffec\022\uffec\001\002\000\032\004\ufff1\005\ufff1\006" +
    "\025\007\030\011\ufff1\013\ufff1\014\ufff1\015\ufff1\016\ufff1" +
    "\017\ufff1\020\ufff1\022\ufff1\001\002\000\006\002\ufffa\025" +
    "\ufffa\001\002\000\006\002\ufffe\025\ufffe\001\002\000\004" +
    "\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\014\002\003\003\006\004\005\005\004\006" +
    "\010\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\005\054\006\010\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\007\014\010\017\001\001\000\002\001\001\000" +
    "\006\007\052\010\017\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\007\050\010\017\001" +
    "\001\000\006\007\023\010\017\001\001\000\002\001\001" +
    "\000\006\007\047\010\017\001\001\000\006\007\046\010" +
    "\017\001\001\000\006\007\045\010\017\001\001\000\006" +
    "\007\044\010\017\001\001\000\006\007\043\010\017\001" +
    "\001\000\006\007\042\010\017\001\001\000\006\007\041" +
    "\010\017\001\001\000\006\007\040\010\017\001\001\000" +
    "\006\007\037\010\017\001\001\000\006\007\036\010\017" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalyseurSyntaxique$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalyseurSyntaxique$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalyseurSyntaxique$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public void report_error(String message, Object info) {

        HashMap<Integer, String> lesTerminaux = new HashMap<>() ;

        lesTerminaux.put(new Integer(CodesLexicaux.PLUS), "+") ;
        lesTerminaux.put(new Integer(CodesLexicaux.MOINS), "-") ;
        lesTerminaux.put(new Integer(CodesLexicaux.MULT), "*") ;
        lesTerminaux.put(new Integer(CodesLexicaux.DIV), "/") ;
        lesTerminaux.put(new Integer(CodesLexicaux.PAROUV), "(") ;
        lesTerminaux.put(new Integer(CodesLexicaux.PARFER), ")") ;
        lesTerminaux.put(new Integer(CodesLexicaux.SUP), ">") ;
        lesTerminaux.put(new Integer(CodesLexicaux.INF), "<") ;
        lesTerminaux.put(new Integer(CodesLexicaux.EGALEGAL), "==") ;
        lesTerminaux.put(new Integer(CodesLexicaux.DIFF), "!=") ;
        lesTerminaux.put(new Integer(CodesLexicaux.ET), "et") ;
        lesTerminaux.put(new Integer(CodesLexicaux.OU), "ou") ;
        lesTerminaux.put(new Integer(CodesLexicaux.NON), "non") ;

        StringBuffer m = new StringBuffer() ;

        if (info instanceof java_cup.runtime.Symbol) {
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);

            if (s.left >= 0) {
                m.append("\tligne : " + (s.left + 1)) ;
                if (s.right >= 0)
                    m.append(" colonne : " + (s.right+1)) ;
            }

            if (s.value != null) {
                lesTerminaux.put(CodesLexicaux.CONSTANTEINT, "" + s.value) ;
                lesTerminaux.put(CodesLexicaux.CONSTANTEBOOL, "" + s.value) ;
            }

            if (lesTerminaux.containsKey(new Integer(s.sym))) {
                m.append(" dernier token lu : " + lesTerminaux.get(new Integer(s.sym))) ;
            }
            else {
                m.append(" expression non terminée") ;
            }

        }
        throw new AnalyseSyntaxiqueException("" + m) ;
    }

    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalyseurSyntaxique$actions {


  BlocDInstructions arbre = new BlocDInstructions(0) ;

             
  private final AnalyseurSyntaxique parser;

  /** Constructor */
  CUP$AnalyseurSyntaxique$actions(AnalyseurSyntaxique parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$do_action(
    int                        CUP$AnalyseurSyntaxique$act_num,
    java_cup.runtime.lr_parser CUP$AnalyseurSyntaxique$parser,
    java.util.Stack            CUP$AnalyseurSyntaxique$stack,
    int                        CUP$AnalyseurSyntaxique$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$result;

      /* select the action based on the action number */
      switch (CUP$AnalyseurSyntaxique$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // CSTE ::= CONSTANTEBOOL 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new ConstanteBool(e, eleft+1) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("CSTE",6, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // CSTE ::= CONSTANTEINT 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new ConstanteEntiere(e, eleft+1) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("CSTE",6, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EXPR ::= PAROUV EXPR PARFER 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = e ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXPR ::= CSTE 
            {
              Expression RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression c = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = c ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXPR ::= NON EXPR 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new NonLogique(e); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXPR ::= EXPR OU EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new OuLogique(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXPR ::= EXPR ET EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new EtLogique(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXPR ::= MOINS EXPR 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new MoinsUnaire(e); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXPR ::= EXPR DIFF EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Different(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPR ::= EXPR EGALEGAL EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Egal(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPR ::= EXPR SUP EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Superieur(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPR ::= EXPR INF EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Inferieur(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPR ::= EXPR DIV EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Div(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPR ::= EXPR MULT EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Mult(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPR ::= EXPR MOINS EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Moins(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXPR ::= EXPR PLUS EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Plus(g, d) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // DECL_VAR ::= TYPE IDF EGAL EXPR POINTVIRGULE 
            {
              ArbreAbstrait RESULT =null;
		int idfleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)).left;
		int idfright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)).right;
		String idf = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		
            Idf i=new Idf(idf);
            //Affectation af = new Affectation(eleft+1,idf,e);
            //rajouter les symboles
            //RESULT doit soit contenir l Affectation ou l idf je ne suis pas
            //sur qui est la plus convenable
            RESULT=i;

          
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("DECL_VAR",4, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-4)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // DECL_VAR ::= TYPE IDF POINTVIRGULE 
            {
              ArbreAbstrait RESULT =null;
		int idfleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int idfright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		String idf = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		//rajoute les entres et symboles et tds
            RESULT=new Idf(idf);
          
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("DECL_VAR",4, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // DECLARATION ::= DECL_VAR 
            {
              ArbreAbstrait RESULT =null;
		int dvleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dvright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait dv = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
                  RESULT=dv;
                
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("DECLARATION",3, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // LISTDECLARATION ::= DECLARATION 
            {
              ArbreAbstrait RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait d = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
                  arbre.ajouter(d);
                  RESULT=arbre;
                
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("LISTDECLARATION",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // LISTDECLARATION ::= LISTDECLARATION DECLARATION 
            {
              ArbreAbstrait RESULT =null;
		int declleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int declright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait decl = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
                  arbre.ajouter(decl);
                  RESULT=arbre;
                
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("LISTDECLARATION",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // PROG ::= LINST 
            {
              ArbreAbstrait RESULT =null;
		int lileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int liright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait li = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
                  RESULT=li;
                
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("PROG",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // PROG ::= LISTDECLARATION 
            {
              ArbreAbstrait RESULT =null;
		
                  RESULT=arbre;
                
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("PROG",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= PROG EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait start_val = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		RESULT = start_val;
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalyseurSyntaxique$parser.done_parsing();
          return CUP$AnalyseurSyntaxique$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

