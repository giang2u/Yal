package yal.tds;


public class EntreeFonction extends Entree {

	
	public EntreeFonction(String idf) {
		super(idf);
		type="fonction";
	}
	public EntreeFonction(String idf,int num) {
		super(idf,num);
		type="fonction";
	}	

	public String toString() {
		return super.toString();
	}

}
