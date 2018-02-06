package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 dÃ©c. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Unaire extends Expression {
    
    protected Expression expression ;

    protected Unaire(Expression expr) {
        super(expr.getNoLigne());
        expression = expr ;

    }
    
    public abstract String operateur() ;

    @Override
    public String toString() {
        return "(" + operateur() + expression + ")" ;
    }
    
    @Override
    public void verifier() {
    	expression.verifier();
    	if (operateur().equals("- ")) {
    		if(!expression.getType().equals("entier")) {
    			throw new AnalyseSemantiqueException(" numero ligne d´erreur "+this.noLigne +""
    					+ " l operande pour le Non logique nï¿½est pas de type entier");
    		}
    		else {
    			setType("entier");
    		}
		}
    	else if(operateur().equals(" non ")) {
    		if (!expression.getType().equals("bool")) {
    			throw new AnalyseSemantiqueException(" numero ligne d´erreur "+this.noLigne +""
    					+ " l operande pour le non logique n est pas de type "
    					+ " Bool");
    		}
    		else {
    			setType("bool");
    		}    		
    	}
    }
}
