package yal.arbre.expression;

import yal.tds.EntreeVariable;
import yal.tds.Symbole;
import yal.tds.SymboleVariable;
import yal.tds.Tds;
import yal.exceptions.AnalyseSemantiqueException;

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
		s=Tds.getInstance().identifier(new EntreeVariable(nom));		
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
