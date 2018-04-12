package yal.arbre;

import java.util.ArrayList;

import yal.arbre.expression.Fonction;
import yal.exceptions.AnalyseSemantiqueException;
import yal.tds.Tds;

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
			if (entete && a instanceof RetourneExpression
					&& ((RetourneExpression)a).getNumR()==0) {
				
				StockErreur.getInstance().ajouter(
						"ERREUR SEMANTIQUE : ligne "+a.getNoLigne()+
						" on ne doit pas avoir de retourner ");
			}
		}
		
	}
	@Override
	public String toMIPS() {
		//Tds.getInstance().afficher();
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
			string.append("erreurDivisionZero:\t.asciiz	 \"Erreur D execution Division par zero\" \n");
			string.append("taillenegative:\t.asciiz	 \"Erreur tableau de taille negative\" \n");
			string.append("indiceenegative:\t.asciiz	 \"Erreur indice de tableau negatif\" \n");
			string.append("indiceout:\t.asciiz	 \"Erreur indice outofbound de tableau \" \n");
			
			
			string.append(".text\nmain:\n");
			entete = false;
			string.append("\tsw $zero,($sp) \n");
			string.append("\taddi $sp,$sp,-4\n");
			string.append("\t#allouer les variables\n");
			
			string.append("\tmove $s7,$sp\n");
			string.append("\taddi $sp,$sp,"+-4*Tds.getInstance().nbVariableTotal(0)+"\n");
			string.append("\t#allouer les tableaux\n");

			string.append("\taddi $sp,$sp,"+-8*Tds.getInstance().nbTableauTotal(0)+"\n");
			
			for(ArbreAbstrait a:expr) {
				if(!(a instanceof Fonction)){
					string.append(a.toMIPS());

				}
			}

			string.append("end :\n" +
					"move $v1, $v0      # copie de v0 dans v1 pour permettre les tests de yal0\n" +
					"li $v0, 10               # retour au systeme\n" +
					"syscall \n");
			for(ArbreAbstrait a:expr) {
				if((a instanceof Fonction)){
					string.append(a.toMIPS());
				}
			}
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
	public ArbreAbstrait derniereInstruction() {
		return this.expr.get(expr.size()-1);
	}
	public int nbInstruction(){
		return this.expr.size();
	}

}
