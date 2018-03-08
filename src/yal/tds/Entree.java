package yal.tds;

public abstract class Entree {

	private String idf;
	static protected int numRegion;
	
	public Entree(String idf){
		this.idf = idf; 
	}
	
	public String getIdf(){
		return idf; 
	}
	
	@Override
	public String toString() {
		return idf;
	}	
}