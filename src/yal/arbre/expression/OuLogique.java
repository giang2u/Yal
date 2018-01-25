package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

    public OuLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }


	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "bool";
	}


	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
