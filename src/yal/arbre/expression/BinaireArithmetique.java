package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;
import yal.exceptions.ExecutionException;

/**
 * 3 d√©c. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    
    
    @Override 
    public int getValue() {
    	switch (operateur()) {
    	case " / ":
			return this.valeur=gauche.getValue()/droite.getValue();	
    	case " + ":
			return this.valeur=gauche.getValue()+droite.getValue();
    	case " - ":
			return this.valeur=gauche.getValue()-droite.getValue();
    	case " * ":
			return this.valeur=gauche.getValue()*droite.getValue();
		default:
			return -1;
    	}
    }
    /**
     * 
     * verifier si les operandes sont de meme types
     * verifier si on a une division par 0 
     *@throws AnalyseSemantiqueException une exeption d analyse 
     *@throws ExecutionException une ERREUR de type d¥EXECUTION 
     *@see AnalyseSemantiqueException
     */
    @Override
	public void verifier() {
    	gauche.verifier();
    	droite.verifier();

		if ( !gauche.getType().equals("entier") || !droite.getType().equals("entier") ) {
			
			throw new AnalyseSemantiqueException(this.noLigne +": une ou plusieurs expressions" +
					" ne sont pas de type entier");
		}
		else {
			
			if(operateur().equals(" / ")) {

				if(droite.getValue()==0) {
					 throw new ExecutionException(" vous avez une division par 0 ");
				}
				else {
					setType("entier");
				}
			}
			else {
				setType("entier");				
			}
		}
	}
    
    


}
