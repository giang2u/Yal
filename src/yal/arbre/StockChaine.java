package yal.arbre;

import java.util.ArrayList;
/**
 * 
 * @author AS
 * une classe Singleton 
 * cette classe stocke les chaines de caracteres non vides 
 */
public class StockChaine {
	private ArrayList<String> chaines ;
	private static StockChaine  s = new StockChaine();
	
	
	public static StockChaine getInstance(){
		return s;
	}
	
	private StockChaine(){
		chaines = new ArrayList<>();
	}
	/**
	 *  ajouter une chaine de caractere dans la liste des chaines
	 * @param s la chaine a rajouter dans la liste
	 * on enleve de la chaine les guillements qui l entourent
	 * si la chaine contient des 2 guillemets suivis 
	 * pour chaque 2 guillemets 
	 * on modifie le premier guillement en slash 
	 * pour pouvoir les afficher dans le code mips  
	 */
	public void ajouter(String s){
		

		s = s.substring(1, s.length() - 1);
		if(s.contains("\"\"")) {
			char[] tableau=s.toCharArray();
			for (int i = 0; i < tableau.length-1; i++) {
				if(tableau[i]==tableau[i+1] && tableau[i]=='\"'){
					tableau[i]='\\';
					i++;
				}
			}
			s=String.copyValueOf(tableau);				
		}
		s=s.replaceAll("[\n\r]","");
		this.chaines.add(s);
		
	}

	/**
	 * retourner le dernier element de la liste de chaine de caractere
	 * @return une chaine de  caractere string 
	 */
	public String getDerniereChaine(){
		return this.chaines.get(this.chaines.size() -1);
	}
	/**
	 * verifie si la liste de chaine est vide 
	 * @return un booleen
	 */
	public boolean estVideChaine(){
		return this.chaines.size() == 0;
	}
	/**
	 * reunit tous les elements de la chaine de caracteres en une seule 
	 * chaine de caractere
	 * @return une chaine de caracteres String
	 */
	public String fusionChaine(){
		StringBuilder sb = new StringBuilder("");
		for(String s : this.chaines){
			sb.append(s + "");
		}
		return sb.toString();
	}
	
	public int taille() {
		return this.chaines.size();
	}
	public ArrayList<String> getChaines(){
		return this.chaines;
	}
	
	
}
