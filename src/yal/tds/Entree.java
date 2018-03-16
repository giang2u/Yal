package yal.tds;

public abstract class Entree {

	private String idf;
	protected int numRegion;
	protected String type;
	
	public Entree(String idf){
		this.idf = idf; 
		this.numRegion =0;
	}
	
	public Entree(String idf, int e){
		this.idf = idf; 
		this.numRegion = e;
	}
	
	
	public String getIdf(){
		return idf; 
	}
	
	public int getRegion(){
		return this.numRegion;
	}
	
	public void setRegion(int nb){
		this.numRegion = nb;
	}
	
	@Override
	public String toString() {
		return idf;
	}
	public String getType() {
		return type;
	}
}	
