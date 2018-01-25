package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Moins extends BinaireArithmetique {

    public Moins(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " - ";
    }


	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	protected String getType() {
		// TODO Auto-generated method stub
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
		
		
		sb.append("# Resultat soustraction \n");
		sb.append("\tsub $v0, $t8, $v0\n");
		
		return sb.toString();
	}
    
}
