package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
        
	@Override
	public void verifier() {
    

		gauche.verifier();
    	droite.verifier();

    	
    	if(operateur().equals(" < ") || operateur().equals(" > ") ) {
			if (!(this.gauche.getType().equals(this.droite.getType()) 
				&& this.gauche.getType().equals("entier")	)){
				throw new AnalyseSemantiqueException(this.noLigne +": " +
						"Comparaison operateur "+ operateur() + " incorrect entre " +
								"" + this.gauche.getType() + " & " + this.droite.getType());
			}
			else {
				setType("bool");
			}
    	}
    	else if(operateur().equals(" == ") || operateur().equals(" != ")) {
    		if(!(this.gauche.getType().equals(this.droite.getType()))){
				throw new AnalyseSemantiqueException(" n° ligne d'erreur " + this.noLigne + "" +
						": Comparaison operateur "+ operateur() + " incorrect entre " +
								"" + this.gauche.getType() + " & " + this.droite.getType());

    		}
    		else {
    			setType("bool");
    		}
    	}	

	}

}
