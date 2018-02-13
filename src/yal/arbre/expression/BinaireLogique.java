package yal.arbre.expression;

import yal.arbre.StockErreur;
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
    	if(!(gauche.getType().equals(droite.getType()) && gauche.getType().equals("bool"))){
    	/*	throw new AnalyseSemantiqueException(" numero de ligne "+this.noLigne +" Operation logique " 
    	+ operateur() + " avec: " +
    				gauche.getType() + " - " + droite.getType() +  " impossible");
    		*/
    		StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +" Operation logique " 
    	+ operateur() + " avec: " +
    				gauche.getType() + " - " + droite.getType() +  " impossible");
    	
    	} 
    	else {
    		setType("bool");
    	}
    	
    }
    
    
    
}
