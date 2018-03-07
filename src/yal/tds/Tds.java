package yal.tds;

import java.util.HashMap;
import java.util.Iterator;

import yal.arbre.StockErreur;
import yal.exceptions.AnalyseSemantiqueException;

public class Tds {
	private HashMap<Entree , Symbole > hashmap;
	private HashMap<String, Symbole> hashmapLocal;
	private static Tds tds=new Tds();
	private int deplacement;
	
	
	private Tds(){
		deplacement=0;
		hashmap = new HashMap<Entree , Symbole >();
		hashmapLocal = new HashMap<String, Symbole>();//yal 3 initialiser le hashmaplocal
	}
	
	public static Tds getInstance() {
		return tds;
	}
	public void ajouter(Entree e,Symbole s) {
		Iterator<Entree> lesentrees=hashmap.keySet().iterator();
		boolean existedeja=false;
		while(lesentrees.hasNext()) {
			if(e.toString().equals(lesentrees.next().toString())) {
				//throw new AnalyseSemantiqueException("Double Declaration : la variable "+e.toString()+" deja declare ");
				StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE :Double Declaration : la variable "+e.toString()+" deja declare ");
				existedeja=true;
			}
		}
		if(!existedeja) {
			deplacement++;
			s.setDeplacement(deplacement);
			hashmap.put(e,s);
		}
		
	}
	
	public Symbole identifier(Entree e) {
		Iterator<Entree> lesentrees=hashmap.keySet().iterator();
		while(lesentrees.hasNext()) {
			Entree entree=lesentrees.next();
			if(e.getIdf().equals(entree.getIdf())) {
				return hashmap.get(entree);
			}
		}
		//throw new AnalyseSemantiqueException(" la variable "+e.toString()+" n est pas declare ");
		StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE : la variable "+e.toString()+" n est pas declare ");
		return null;
	}
	
	public HashMap<Entree , Symbole > getMap() {
		return hashmap;
	}
	
	//yal3
	public Symbole identifier(Entree e, int num ){
		Iterator<String> lesentrees=hashmapLocal.keySet().iterator();
		while(lesentrees.hasNext()) {
			String cleMap = lesentrees.next();
			String cleparametre = e.getIdf()+num;
			if(cleparametre.equals(cleMap)) {
				return hashmapLocal.get(cleMap);
			}
		}
		//throw new AnalyseSemantiqueException(" la variable "+e.toString()+" n est pas declare ");
		StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE : la variable "+e.toString()+" n est pas declare ");
		return null;
	}
	 
	public void entreBlock(Entree e, Symbole s){
		Entree.numRegion++;
		this.hashmapLocal.put(e.getIdf() + Entree.numRegion, s);
		
	}
	
	public void sortieBlock(){
		
	}
}
