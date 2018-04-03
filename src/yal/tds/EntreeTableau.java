package yal.tds;

public class EntreeTableau extends Entree{
	protected int nbElement;
	

	public EntreeTableau(String idf,int num, int nbElement) {
		super(idf,num);
		type="tableau";
		this.nbElement = nbElement;
	}	
	public EntreeTableau(String idf, int numRegion) {
		super(idf,numRegion);
		type="tableau";
	}
	public String toString() {
		return super.toString()+" et nbElement "+this.nbElement;
	}

	public int getnbElement(){
		return this.nbElement;
	}
}
