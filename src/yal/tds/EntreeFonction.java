package yal.tds;


public class EntreeFonction extends Entree {

	protected int nbParam;
	
	public EntreeFonction(String idf) {
		super(idf);
		type="fonction";
		this.nbParam = 0;
	}
	public EntreeFonction(String idf,int num) {
		super(idf,num);
		type="fonction";
		this.nbParam = 0;
	}	

	public EntreeFonction(String idf,int num, int nbParam) {
		super(idf,num);
		type="fonction";
		this.nbParam = nbParam;
	}	
	public String toString() {
		return super.toString()+" et nbpar "+this.nbParam;
	}

	public int getnbParam(){
		return this.nbParam;
	}
}
