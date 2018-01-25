package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
	private int bool;
    public ConstanteBool(String texte, int n) {
        super(texte, n, "bool") ;
        this.bool = (texte.equals("vrai") ? 1 : 0); 
    }
    


	@Override
	public int getValue() {
		return valeur;
	}



	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return Integer.toString(valeur);
	}

	

}
