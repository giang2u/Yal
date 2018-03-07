package yal.arbre.expression;



/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
        
    }

    @Override
    public String operateur() {
        return " != ";
    }
    
	@Override
	public int getValue() {
		return this.valeur;
	}

	@Override
	public String toMIPS() {
		return super.toMips();
	}

	@Override
	public String mipsOperation() {
		StringBuilder string=new StringBuilder();
		string.append("si"+compteCondition+":	");
		string.append("\tbne $v0,$t8,sinon"+compteCondition+"\n");
		string.append("alors"+compteCondition+":\n");
		string.append("\tli $v0, 0\n");
		string.append("\tj finsi"+compteCondition+"\n");
		string.append("sinon"+compteCondition+":\n");
		string.append("\tli $v0, 1\n");
		string.append("finsi"+compteCondition+": \n");
		
		compteCondition++;
		return string.toString();
	}


  
}
