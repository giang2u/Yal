package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class EtLogique extends BinaireLogique {

    public EtLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " et " ;
    }
    

	@Override
	public int getValue() {
		return 0;
	}

	@Override
	public String toMIPS() {
		return super.toMips();
	}

	@Override
	public String mipsOperation() {
		StringBuilder string=new StringBuilder();
		string.append("\tand $v0,$v0,$t8 \n");
		return string.toString();
	}

}
