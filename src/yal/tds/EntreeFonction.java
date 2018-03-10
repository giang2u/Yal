package yal.tds;


public class EntreeFonction extends Entree {

	
	public EntreeFonction(String idf) {
		super(idf+"()");
	}
	public EntreeFonction(String idf,int num) {
		super(idf,num);
	}	

	public String toString() {
		return super.toString();
	}

}
