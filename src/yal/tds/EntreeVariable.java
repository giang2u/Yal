package yal.tds;

public class EntreeVariable extends Entree {

	public EntreeVariable(String idf) {
		super(idf);
	}
	public EntreeVariable(String idf,int num) {
		super(idf,num);
		type="variable";

	}
	public String toString() {
		return super.toString();
	}
}
