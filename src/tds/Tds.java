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
	/**
	 * ajouter le symbole et l´entree dans la tds 
	 * @param e l entree qu on veut insere dans la hashmap
	 * @param s le symbole qu on veut insere dans la hashmap
	 * @throws une exception de type Semantique si l entree symbole existe deja dans la Hashmap
	 * @see AnalyseSemantiqueException 
	 */
	public void ajouter(Entree e,Symbole s) {
		Iterator<Entree> lesentrees=hashmap.keySet().iterator();
		while(lesentrees.hasNext()) {
			if(e.toString().equals(lesentrees.next().toString())) {
				throw new AnalyseSemantiqueException("Double Declaration : la variable "+e.toString()+" deja declare ");
			}
		}
		hashmap.put(e,s);
		
	}
	/**
	 * identifier le symbole d une entree dans la tds passe en parametre
	 * @param e on veut recuperer le symbole de l entree e  
	 * @return le symbole de l entree e
	 * @throws une exception de type Semantique si on ne trouve pas le symbole correspondant a l entree
	 * @see AnalyseSemantiqueException
	 */
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
