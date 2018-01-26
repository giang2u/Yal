package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Mult extends BinaireArithmetique {

    public Mult(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
  
    @Override
    public String operateur() {
        return " * ";
    }


	@Override
	public String toMIPS() {
StringBuilder sb = new StringBuilder();
		
		String sbg =  gauche.toMIPS() ;
		
		String sbd = droite.toMIPS() ;
		
		
		sb.append("\t"+ sbg +"\n");
		
		sb.append("\tsw $v0, 0($sp)\n");
		
		sb.append("\tadd $sp, $sp, -4 \n");
		
		
		
		sb.append("\t"+ sbd + "\n");
		sb.append("\tadd $sp, $sp,4 \n");
		sb.append("\tlw $t8, ($sp) \n");
		
		
		sb.append("# Resultat multiplication \n");
		sb.append("\tmult $t8, $v0\n");
		
		return sb.toString();
	}

}
