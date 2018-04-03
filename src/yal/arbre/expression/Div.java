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

	}

	@Override
	public String mipsOperation() {
		StringBuilder sb=new StringBuilder();
		sb.append("# Resultat Division \n");
		
		sb.append("\tbeqz $v0,ErreurDivision\n");
		
		sb.append("\tdiv $t8, $v0\n");
		sb.append("\tmflo $v0\n");
		sb.append("\tj pasErreurDiv\n");

		
		sb.append("ErreurDivision:\n");
		sb.append("\tli $v0, 4\n");
		sb.append("\tla $a0, erreurDivisionZero\n");
		sb.append("\tsyscall\n");
		sb.append("\tj end\n");
		
		sb.append("\tpasErreurDiv:\n");
		
		return sb.toString();
	}
    
}
