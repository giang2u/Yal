package yal.arbre.expression;

import yal.arbre.Instruction;

public class Ecrire extends Instruction {
	private String chaine;
	private Expression expr;
	private boolean estChaine;

	public Ecrire(String chai,int no) {
		super(no);
		chaine=chai;
		estChaine=true;
	}

	public Ecrire(Expression expr,int no) {
		super(no);
		this.expr=expr;
		estChaine=false;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return "A faire pour Ecrire";
	}
	public String toString(){
		if (estChaine) {
			return "ecrire "+chaine;
		}
		return "ecrire "+expr.toString();
	}

}
