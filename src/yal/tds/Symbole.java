package yal.tds;

public abstract class Symbole {
	
	protected int nombre_deplacement;
	protected String type;
	protected int numRegion;
	
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
	
	public void setType(String s){
		this.type = s;
	}
	
	/**
	 * 
	 * @param deplacement
	 * Mise � jour du d�placment
	 */
	public void setDeplacement(int deplacement) {
		if (  !(this instanceof SymboleFonction )){ 
			this.nombre_deplacement = -4*deplacement; 
		}
		if ((this instanceof SymboleTableau )){ 
			this.nombre_deplacement = -4*deplacement -4; 
		}
		
	}
	
	public String toString() {
		return "le symbole" + "  nombre deplacement " + nombre_deplacement ;
	}
	public int getNumRegion(){
		return this.numRegion;
	}
	public void setNumRegion(int numRegion){
		this.numRegion=numRegion;
	}

	
	
}
