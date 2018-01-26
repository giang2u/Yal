package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }
    
    @Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "bool";
	}


	@Override
	public void verifier() {
		if (expression.getType()!="bool") {
			throw new AnalyseSemantiqueException(" l operande pour le non logique n est pas de type "
					+ " type Bool");
		}
		else {
			setType("bool");
		}
		
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toMIPS() {
		StringBuilder string = new StringBuilder("");
		string.append(expression.toMIPS() + "\n");
		string.append("\tbeqz $v0, sinon"+compteCondition+"\n");
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
