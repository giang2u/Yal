package yal.arbre.expression;

import yal.arbre.Instruction;

public class Lire extends Instruction{
	private Expression expression;
	
	public Lire(Expression expr,int no) {
		super(no);
		expression=expr;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
