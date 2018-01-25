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
		StringBuilder string = new StringBuilder("");
		if(cste.equals("vrai")){
			string.append("\tli $v0, 1");
		}
		if(cste.equals("faux")){
			string.append("\tli $v0, 0");
		}
		return string.toString();
	}

	

}
