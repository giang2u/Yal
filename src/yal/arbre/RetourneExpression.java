package yal.arbre;

import yal.arbre.expression.Expression;

public class RetourneExpression extends Instruction{
	private Expression retourneExpr;
	public static String typeRetour;

	public RetourneExpression(int no) {
		super(no);
		// TODO Auto-generated constructor stub
	}
	public RetourneExpression(int no,Expression e) {
		super(no);
		retourneExpr=e;
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
		s.append(retourneExpr.toMIPS());
		/*s.append("\tsw $v0,16($sp)\n");
		//s.append("\tlw $s7,($sp) \n");
		s.append("\tadd $sp, $sp, 12\n");
		s.append("\tlw $ra,($sp) \n");
		s.append("\tadd $sp, $sp, 4\n");*/
		s.append("\tadd $sp,$sp, 12\n");
		//s.append("\tlw $s7, 8($s) \n");
		s.append("\tlw $ra, ($sp) \n");
		s.append("\tjr $ra \n");
		return s.toString();
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("retourne "+retourneExpr.toString()+" ");
		return sb.toString();
	}
	
	public String getType() {
		return retourneExpr.getType();
	}

}
