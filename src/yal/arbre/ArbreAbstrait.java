package yal.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    
    // numéro de ligne du début de l'instruction
    protected int noLigne ;
    public static int compteCondition;
    
    protected ArbreAbstrait(int no) {
        noLigne = no ;
        compteCondition = 0;
    }
    
    public int getNoLigne() {
            return noLigne ;
    }

    
     public abstract void verifier() ;
     public abstract String toMIPS() ; 
}
