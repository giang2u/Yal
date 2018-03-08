package yal.arbre.expression;

import java.util.ArrayList;

import yal.arbre.BlocDInstructions;

public class Fonction extends Expression {
	private BlocDInstructions listeInstruction;
	private ArrayList<Idf> listeParametres;
	private String nomfonction;
	protected Fonction(int n) {
		super(n);
	}
	
	public Fonction(int n, String nomf,BlocDInstructions linst) {
		super(n);
		listeInstruction=linst;	
		this.nomfonction = nomf;
		listeParametres = new ArrayList<>();
	}

	public Fonction(int n,BlocDInstructions linst,ArrayList<Idf> listParametres) {
		super(n);
		listeInstruction=linst;
		listeParametres=listParametres;		
	}
	
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void verifier() {
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
