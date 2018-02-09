package yal.arbre;

import java.util.ArrayList;

public class StockChaine {
	private ArrayList<String> chaines ;
	private static StockChaine  s = new StockChaine();
	
	
	public static StockChaine getInstance(){
		return s;
	}
	
	private StockChaine(){
		chaines = new ArrayList<>();
	}
	
	public void ajouter(String s){
		if(s.length() == 2) {
			this.chaines.add("");
		}
		else {
			s = s.substring(1, s.length() - 1);
			this.chaines.add(s);
		}
	}

	
	public String getDerniereChaine(){
		return this.chaines.get(this.chaines.size() -1);
	}
	
	public boolean estVideChaine(){
		return this.chaines.size() == 0;
	}
	
	public String fusionChaine(){
		StringBuilder sb = new StringBuilder("");
		for(String s : this.chaines){
			sb.append(s + " ");
		}
		return sb.toString();
	}
}
