package yal.arbre;

import yal.arbre.expression.Expression;
import yal.tds.Tds;

public class RetourneExpression extends Instruction{
	private Expression retourneExpr;
	public static String typeRetour;
	private int numR;

	public RetourneExpression(int no) {
		super(no);
		// TODO Auto-generated constructor stub
	}
	public RetourneExpression(int no,Expression e,int numeroBloc) {
		super(no);
		retourneExpr=e;
		numR=numeroBloc;
		
	}
	
	@Override
	public void verifier() {

		retourneExpr.verifier();

		if(retourneExpr.getType() != null && !retourneExpr.getType().equals("entier") ) {
			StockErreur.getInstance().ajouter(
					"ERREUR SEMANTIQUE :  "+this.getNoLigne()+" le type de la valeur de retour n est pas entier");		
		}

	}
	
	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder("");
		int n=Tds.getInstance().nbVariableTotal(numR)*4+Tds.getInstance().nbTableauTotal(numR)*8+8;
		//System.out.print(n);
		s.append(retourneExpr.toMIPS());
		/*s.append("\tsw $v0,16($sp)\n");
		//s.append("\tlw $s7,($sp) \n");
		s.append("\tadd $sp, $sp, 12\n");
		s.append("\tlw $ra,($sp) \n");
		s.append("\tadd $sp, $sp, 4\n");*/
		s.append("\t#retourner \n");
		
		s.append("\taddi $sp,$sp, "+n+"\n");
		s.append("\tadd $sp,$sp, $t3\n");
		
		s.append("\tlw $s7, 0($sp) \n");
		s.append("\taddi $sp,$sp, "+4+"\n");

		s.append("\tlw $ra, ($sp) \n");
		s.append("\tjr $ra \n");
		return s.toString();
	}//0x7fffefe8 
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("retourne "+retourneExpr.toString()+" "+numR);
		return sb.toString();
	}
	
	public String getType() {
		return retourneExpr.getType();
	}
	public int getNumR() {
		return numR;
	}
	

}
