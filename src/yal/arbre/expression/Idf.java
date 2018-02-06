package yal.arbre.expression;

import com.sun.java_cup.internal.runtime.Symbol;

public class Idf extends Expression {
	
	protected String nom;
	
	protected Idf(int n) {
		super(n);
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

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
