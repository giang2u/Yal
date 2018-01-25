package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

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
		StringBuilder string = new StringBuilder("");
		
		string.append("si"+compteCondition+":	");
		string.append(gauche.toMIPS() + "\n");
		string.append("\tsw $v0,0($sp) \n");
		string.append("\tadd $sp, $sp, -4 \n");

		string.append("\t" + droite.toMIPS() + "\n");
		string.append("\tadd $sp, $sp, 4 \n");
		string.append("\tlw $t8,($sp) \n");
		string.append("\tbne $v0,$t8 sinon"+compteCondition+"\n");
		string.append("alors"+compteCondition+":\n");
		string.append("\tli $v0, 1\n");
		string.append("\tj finsi"+compteCondition+"\n");
		string.append("sinon"+compteCondition+":\n");
		string.append("\tli $v0, 0\n");
		string.append("finsi"+compteCondition+": \n");
		
		compteCondition++;
		return string.toString();
	}

	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "entier";
	}

	
  
}
