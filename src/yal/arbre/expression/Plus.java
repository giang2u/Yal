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
	public void verifier() {
		// TODO Auto-generated method stub
		
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
		
		sb.append("# initialiser s7 avec sp\n");
		sb.append("move $s7, $sp\n");
		
		sb.append("# Reservation de l'espace pour gauche droite et res\n");
		sb.append("addi $sp, $sp, -12\n");
		
		sb.append("li $v0," + sbg + "\n");
		sb.append("sw $v0, 0($s7)\n");
		
		sb.append("sw $v0, 0($sp)\n");
		
		sb.append("add $sp, $sp, -4 \n");
		
		
		
		sb.append("li $v0,"+ sbd + "\n");
		sb.append("add $sp, $sp,4 \n");
		sb.append("lw $t8, ($sp) \n");
		
		
		sb.append("# Resultat addition \n");
		sb.append("add $v0, $t8, $v0\n");
		sb.append("sw $v0, 12($s7) \n");
		
		
		return sb.toString();
	}

}
