package tds;

public abstract class Symbole {
	
	protected int nombre_deplacement;
	protected String type;
	
	public Symbole(int deplacement){
		this.type = "entier";
		this.nombre_deplacement = deplacement;
	}
	
	public int getNombreDeplacement(){
		return this.nombre_deplacement;
	}
	
	public String getType(){
		return this.type;
	}
	
	/**
	 * 
	 * @param deplacement
	 * Mise à jour du déplacment
	 */
	public void setDeplacement(int deplacement) {
		this.nombre_deplacement = -4*deplacement; 
	}
	
}
