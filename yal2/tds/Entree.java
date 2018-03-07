package tds;

public abstract class Entree {

	private String idf;
	
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
