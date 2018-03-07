package yal.arbre.expression;


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
	public String toMIPS() {
		return super.toMips();
		/*	StringBuilder sb = new StringBuilder();
		
		String sbg =  gauche.toMIPS() ;
		
		String sbd = droite.toMIPS() ;
		
		sb.append("#traitement operande gauche");
		sb.append(sbg);
		sb.append("\tsw $v0, 0($sp)\n");
		sb.append("\tadd $sp, $sp, -4 \n");
		sb.append(sbd);
		sb.append("\tadd $sp, $sp,4 \n");
		sb.append("\tlw $t8, ($sp) \n");
		
		
		sb.append("# Resultat Division \n");
		sb.append("\tdiv $t8, $v0\n");
		sb.append("\tmflo $v0\n");
		
		return sb.toString();*/
	}

	@Override
	public String mipsOperation() {
		StringBuilder sb=new StringBuilder();
		sb.append("# Resultat Division \n");
		sb.append("\tdiv $t8, $v0\n");
		sb.append("\tmflo $v0\n");
		
		return sb.toString();
	}
    
}
