package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
	private int bool;
    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }
    


	@Override
	public int getValue() {
		return valeur;
	}
	
	public String getType() {
		return "bool";
	}



	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return cste;
	}

	

}
