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

		if (gauche.getType() != "entier" || droite.getType() != "entier") {
			
			throw new AnalyseSemantiqueException(" une ou plusieurs expressions" +
					" ne sont pas de type entier");
		}
	}
 

}
