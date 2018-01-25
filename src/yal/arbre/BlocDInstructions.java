package yal.arbre;

import java.util.ArrayList;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<ArbreAbstrait> expr ;
    
    public BlocDInstructions(int n) {
        super(n) ;
        expr=new ArrayList<>();
    }
    /**
     * ajouter une instruction dans l arbre 
     * @param a l instruction a ajouter dans l arbre de type ArbreAbstrait
     * @see ArbreAbstrait
     */
    public void ajouter(ArbreAbstrait a) {
        expr.add(a) ;
    }
    
    @Override
    public String toString() {
        return expr.toString() ;
    }

	@Override
	/**
	 * 
	 * verifier tous les instructions 
	 */
	public void verifier() {
		for(ArbreAbstrait a:expr) {
			a.verifier();
		}
	}
	@Override
	public String toMIPS() {
		StringBuilder string = new StringBuilder("");
		for(ArbreAbstrait a:expr) {
			string.append(a.toMIPS());
		}
		return string.toString();
	}


}
