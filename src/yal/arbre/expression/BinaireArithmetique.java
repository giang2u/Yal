package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;
import yal.exceptions.ExecutionException;

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
    
    @Override
	public void verifier() {
    	gauche.verifier();
    	droite.verifier();
    	/*System.out.println( gauche.getValue() + "     " + droite.getValue());
    	
    	System.out.println( gauche.getType() + "     " + droite.getType());
    	*/
    	
		if ( !gauche.getType().equals("entier") || !droite.getType().equals("entier") ) {
			
			throw new AnalyseSemantiqueException(" une ou plusieurs expressions" +
					" ne sont pas de type entier");
		}
		else {
			
			if(operateur().equals(" / ")) {

				if(droite.getValue()==0) {
					 throw new ExecutionException(" vous avez une division par 0 est impossible");
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
