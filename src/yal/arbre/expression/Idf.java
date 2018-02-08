package yal.arbre.expression;


import tds.EntreeVariable;
import tds.Symbole;
import tds.SymboleVariable;
import tds.Tds;
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
		if(!s.getType().equals("entier")){
			throw new AnalyseSemantiqueException("Le type de la varialbe doit etre un entier");
		}
		else{
			s.setType("entier");
		}
		
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
