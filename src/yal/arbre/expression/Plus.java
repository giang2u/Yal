package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

    public Plus(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }


    @Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "entier";
	}


	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		
		String sbg =  gauche.toMIPS() ;
		
		String sbd = droite.toMIPS() ;
		
		
		sb.append(sbg);
		
		sb.append("\tsw $v0, 0($sp)\n");
		
		sb.append("\tadd $sp, $sp, -4 \n");
		
		
		
		sb.append(sbd);
		sb.append("\tadd $sp, $sp,4 \n");
		sb.append("\tlw $t8, ($sp) \n");
		
		
		sb.append("# Resultat addition \n");
		sb.append("\tadd $v0, $t8, $v0\n");
		
		return sb.toString();
	}

}
