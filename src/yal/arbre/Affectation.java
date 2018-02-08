package yal.arbre;

import tds.Symbole;
import yal.arbre.expression.Expression;

public class Affectation extends ArbreAbstrait {

	private Expression expression;
	private String idf;
	private Symbole s;
	
	
	protected Affectation(int no,String idf,Expression e) {
		super(no);
		this.idf=idf;
		expression=e;
	}

	@Override
	public void verifier() {
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return "la methode affect a faire";
	}

}
