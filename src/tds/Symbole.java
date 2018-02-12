package tds;

/**
 * 
 * @author AS
 * 
 * la classe Symbole va nous servir pour la Tds
 * @see Tds
 */
public abstract class Symbole {
	
	protected int nombre_deplacement;
	protected String type;
	
	/**
	 * le constructeur 
	 * @param  le nombre de deplacement 
	 */
	public Symbole(int deplacement){
		this.type = "entier";
		this.nombre_deplacement = deplacement;
	}
	/**
	 * getter pour l attribut nombredeplacement
	 * @return un int nombre de deplacement
	 */
	public int getNombreDeplacement(){
		return this.nombre_deplacement;
	}
	/**
	 * getter pour l attribut type
	 * @return un String le type du symbole 
	 */	
	public String getType(){
		return this.type;
	}
	
	/**
	 * setter met a jour le type 
	 * @param s le nouveau type de type String
	 * 
	 */
	public void setType(String s){
		this.type = s;
	}
	
	/**
	 * 
	 * @param deplacement
	 * Mise � jour du d�placment
	 */
	public void setDeplacement(int deplacement) {
		this.nombre_deplacement = -4*deplacement; 
	}
	
}
