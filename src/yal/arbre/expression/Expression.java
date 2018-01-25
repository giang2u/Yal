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
	protected Expression(int n,String type) {
        super(n) ;
        this.type = type;
    }

    protected String getType(){
    	return type;
    }
    public abstract int getValue();
    
   
}
