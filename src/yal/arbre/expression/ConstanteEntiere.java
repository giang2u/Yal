package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public int getValue() {
		return valeur;
	}
	
	public String getType() {
		return "entier";
	}

	@Override
	public String toMIPS() {
		StringBuilder string = new StringBuilder("");
		
		string.append("\tli $v0," + this.cste + "\n");
		return string.toString();
	}

	

	
}
