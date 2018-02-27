package yal.arbre;

import java.util.ArrayList;
import java.util.Iterator;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    public static boolean entete = true;
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
	 * verifier toutes les instructions de l�arbre abstrait  
	 */
	public void verifier() {
		for(ArbreAbstrait a:expr) {
			a.verifier();
		}
		if(!StockErreur.getInstance().estVideChaine()) {
			throw new AnalyseSemantiqueException(StockErreur.getInstance().fusionDesErreurs());
		}
	}
	@Override
	public String toMIPS() {
		StringBuilder string = new StringBuilder("");
		if(entete){
			string.append(".data\n");
			//string.append("str:\t.asciiz " +  "\"" + StockChaine.getInstance().fusionChaine() +"\" \n");
			
			for (int i = 0; i <StockChaine.getInstance().taille() ; i++) {
				string.append("str"+i+":\t.asciiz " +  "\"" 
			+ StockChaine.getInstance().getChaines().get(i) +"\" \n");				
			}
			
			string.append("vrai:\t.asciiz    \"vrai\" \n");
			string.append("faux:\t.asciiz	 \"faux\" \n");
			
	        string.append(".text\nmain:\n");
	        for(ArbreAbstrait a:expr) {
				string.append(a.toMIPS());
			}
			
		      string.append("end :\n" +
	         "move $v1, $v0      # copie de v0 dans v1 pour permettre les tests de yal0\n" +
	         "li $v0, 10               # retour au systeme\n" +
	         "syscall");
		} 
		else {
			for(ArbreAbstrait a:expr) {
				string.append(a.toMIPS());
			}
		}

		
		return string.toString();
	}

	public ArrayList<ArbreAbstrait> getexpr(){
		return this.expr;
	}

}
