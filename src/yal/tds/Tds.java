package yal.tds;

import java.util.HashMap;
import java.util.Iterator;

import yal.arbre.StockErreur;

public class Tds {
	private HashMap<Entree , Symbole > hashmap;
	private static Tds tds=new Tds();
	public static int numRegionCourant = 0;
	public static int numRegion = 0;
	private int deplacement;
	
	
	private Tds(){
		deplacement=1;
		hashmap = new HashMap<Entree , Symbole >();
	}
	
	public static Tds getInstance() {
		return tds;
	}
	public void ajouter(Entree e,Symbole s) {
		Iterator<Entree> lesentrees=hashmap.keySet().iterator();
		boolean existedeja=false;
		//e.setRegion(numRegionCourant);// à corriger si ça marche 

		//System.out.println("dans ajouter: " + e.toString() + "*" + e.getRegion());
		
		while(lesentrees.hasNext()) {
			Entree ee=lesentrees.next();
			if(	e.getType().equals(ee.getType()) && e.getType().equals("fonction")
				&& (((EntreeFonction)e).getnbParam()==((EntreeFonction)ee).getnbParam())) {
				if(e.toString().equals(ee.toString())) {
				StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE :Double Declaration : la fonction"
						+ " "+e.toString()+" deja declare ");
					existedeja=true;
				}
			}
			else {
				if(e.toString().equals(ee.toString()) &&
					e.getRegion() == ee.numRegion	) {
					
					//throw new AnalyseSemantiqueException("Double Declaration : la variable "+e.toString()+" deja declare ");
					StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE :Double Declaration : la variable"
							+ " "+e.toString()+" deja declare "
									+ "et sa region est "+e.getRegion());
					existedeja=true;
				}
			}
		}
		//afficher();
		if(!existedeja) {
			s.setDeplacement(deplacement);
			hashmap.put(e,s);
			deplacement++;
		}
	}
	
	public Symbole identifier(Entree e) {
		Iterator<Entree> lesentrees=hashmap.keySet().iterator();
		//System.out.println(" essai "+e.getIdf());
		while(lesentrees.hasNext()) {
			Entree entree=lesentrees.next();
			//System.out.print(entree.getIdf()+" "+e.getIdf()+" - ");
			//System.out.println(e);
			//System.out.println(e);
			if(e.getIdf().equals(entree.getIdf()) && e.getType().equals("fonction")) {
				if(((EntreeFonction)e).getnbParam()==((EntreeFonction)entree).getnbParam()){
					return hashmap.get(entree);
				}
			}
			if(e.getIdf().equals(entree.getIdf()) && e.getRegion() ==entree.getRegion()
					&& e.getType().equals("variable")
					) {
					return hashmap.get(entree);
			}
		}
		lesentrees=hashmap.keySet().iterator();

		while(lesentrees.hasNext()) {
			Entree entree=lesentrees.next();
			if(e.getIdf().equals(entree.getIdf()) && e.getType().equals("variable")) {
				//System.out.println(hashmap.get(entree));
					return hashmap.get(entree);
			}
		}
		
		//throw new AnalyseSemantiqueException(" la variable "+e.toString()+" n est pas declare ");
		
		StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE : la "+e.getType()+" "+e.toString()+" n est pas declare ");
		return null;
	}
	
	public HashMap<Entree , Symbole > getMap() {
		return hashmap;
	}
	
	public void entreBlock(){
		numRegion++;
		numRegionCourant = numRegion;
		//System.out.println("dans entreebloc: "+numRegionCourant);
		
	}
	
	public void sortieBlock(){
		//System.out.println("dans sortiebloc: "+numRegionCourant);

		numRegionCourant = 0;
		
	}
	public void afficher() {
		for (Entree e:hashmap.keySet()) {
			System.out.print(e.toString());
			System.out.println(hashmap.get(e).toString());
		}
		System.out.println();
	}
	
}
