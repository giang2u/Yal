package yal.arbre.expression;


import tds.Symbole;

public class Idf extends Expression {
	
	private String nom;
	private Symbole s;
	
	public Idf(String idf) {
		super(0);
		nom=idf;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}
	public String toString() {
		return nom;
	}
	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return "je vais la commencer";
	}

}
