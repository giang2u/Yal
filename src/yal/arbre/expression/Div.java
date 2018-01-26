package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " / ";
    }

	

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	protected String getType() {
		return "entier";
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
		
		
		sb.append("# Resultat Division \n");
		sb.append("\tdiv $t8, $v0\n");
		
		return sb.toString();
	}
    
}
