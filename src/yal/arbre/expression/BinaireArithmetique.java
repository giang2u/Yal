package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    @Override
	public void verifier() {
    	
    	gauche.verifier();
    	droite.verifier();
    	
		if ( !gauche.getType().equals("entier") || !droite.getType().equals("entier") ) {
			
			throw new AnalyseSemantiqueException(" une ou plusieurs expressions" +
					" ne sont pas de type entier");
		}
		else {
			setType("entier");
		}
	}
 

}
