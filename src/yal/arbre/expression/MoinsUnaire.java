package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }

	@Override
	public void verifier() {
		if(expression.getType()!="entier") {
			throw new AnalyseSemantiqueException("l operande pour le Non logique n�est pas de type entier");
		}
		else {
			setType("entier");
		}
	}

	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "bool";
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
