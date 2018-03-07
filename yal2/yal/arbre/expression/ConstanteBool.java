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
        this.type="bool";
        this.valeur=this.bool;
    }
    

	@Override
	public int getValue() {
		return valeur;
	}
	
	public String getType() {
		return type;
	}


	@Override
	public String toMIPS() {
		StringBuilder string = new StringBuilder("");
		string.append("\tli $v0,"+this.bool+"\n");
		
		return string.toString();
	}

	

}
