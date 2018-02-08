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
		s = new SymboleVariable(4);
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void verifier() {
		
		EntreeVariable entre = new EntreeVariable(this.nom);
		Tds.getInstance().identifier(entre);
		if(!s.getType().equals("entier")){
			throw new AnalyseSemantiqueException("Le type de la varialbe doit etre un entier");
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
