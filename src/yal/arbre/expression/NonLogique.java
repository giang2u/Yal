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
		// TODO Auto-generated method stub
		return null;
	}

}
