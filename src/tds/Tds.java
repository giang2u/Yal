package tds;

import java.util.HashMap;
import java.util.Iterator;
import yal.exceptions.AnalyseSemantiqueException;

public class Tds {
	private HashMap<Entree , Symbole > hashmap;
	private static Tds tds=new Tds();
	
	
	public static Tds getInstance() {
		return tds;
	}
	public void ajouter(Entree e,Symbole s) {
		Iterator<Entree> lesentrees=hashmap.keySet().iterator();
		while(lesentrees.hasNext()) {
			if(e.toString().equals(lesentrees.next().toString())) {
				throw new AnalyseSemantiqueException("Double Declaration : la variable "+e.toString()+" deja declare ");
			}
		}
		hashmap.put(e,s);
		
	}
	public Symbole identifier(Entree e) {
		Iterator<Entree> lesentrees=hashmap.keySet().iterator();
		while(lesentrees.hasNext()) {
			if(e.toString().equals(lesentrees.next().toString())) {
				return hashmap.get(e);
			}
		}
		throw new AnalyseSemantiqueException(" la variable "+e.toString()+" n est pas declare ");
	}
	 
}