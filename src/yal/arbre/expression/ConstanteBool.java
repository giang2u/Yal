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
        this.bool=(texte.equals("vrai") ? 1: 0);
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
		StringBuilder string = new StringBuilder("");
		string.append("\tli $v0,"+bool);
		
		return string.toString();
	}

	

}
