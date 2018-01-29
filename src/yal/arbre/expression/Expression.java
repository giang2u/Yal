package yal.arbre.expression;

import yal.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
	
	protected String type;
	protected int valeur;
    
    public void setType(String type) {
		this.type = type;
	}

	protected Expression(int n) {
        super(n) ;
    }
	
    protected String getType() {
    	return type;
    }
    /**
     * 
     * ce getter abstrait nous sevira pour recupperer la valeur du resultat 
     * d une operation arithmetiques pour savoir si on a une division par 0 ou non
     * redefini dans une sous classe
     * @see BinaireArithmetique
     * @return entier
     */
    public abstract int getValue();
    
   
}
