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
		this.chaines.add(s);
	}

	
	public String getDerniereCahine(){
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
