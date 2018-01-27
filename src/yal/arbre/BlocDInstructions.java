package yal.arbre;

import java.util.ArrayList;

/**
 * 3 d√©c. 2015
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
	 * verifier toutes les instructions de l¥arbre abstrait  
	 */
	public void verifier() {
		for(ArbreAbstrait a:expr) {
			a.verifier();
		}
	}
	@Override
	public String toMIPS() {
		StringBuilder string = new StringBuilder("");
        string.append(".text\nmain:\n");
		for(ArbreAbstrait a:expr) {
			string.append(a.toMIPS());
		}
	      string.append("end :\n" +
         "move $v1, $v0      # copie de v0 dans v1 pour permettre les tests de yal0\n" +
         "li $v0, 10               # retour au systeme\n" +
         "syscall");
		return string.toString();
	}


}
