package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

    protected BinaireLogique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    
    
    
    @Override
    /**
     * verifier les operandes gauche et droite sont corrects semantiquement puis 
     * verifier si ces deux operandes sont de type bool 
     * retourner AnalyseSemantiqueException
     * @see AnalyseSemantiqueException 
     */
    public void verifier() {
    	gauche.verifier();
    	droite.verifier();
    	if(gauche.getType().equals(droite.getType()) && gauche.getType().equals("bool")){
    		this.setType("bool");
    	} else {
			throw new AnalyseSemantiqueException("Operation logique avec entier impossible"); 
    	}		
    }
    
    
    
}
