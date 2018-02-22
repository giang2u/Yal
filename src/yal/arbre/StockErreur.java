package yal.arbre;

import java.util.ArrayList;

public class StockErreur {
	private ArrayList<String> leserreurs ;
	private static StockErreur  s = new StockErreur();
	
	
	public static StockErreur getInstance(){
		return s;
	}
	
	private StockErreur(){
		leserreurs = new ArrayList<>();
	}

	public void ajouter(String s){
			leserreurs.add(s);
	}


	public boolean estVideChaine(){
		return this.leserreurs.size() == 0;
	}
	
	public int getNbErreur() {
		return this.leserreurs.size();
	}

	public String fusionDesErreurs(){
		StringBuilder sb = new StringBuilder("");
		for(String s : this.leserreurs){
			sb.append(s + "\n");
		}
		return sb.toString();
	}
}
