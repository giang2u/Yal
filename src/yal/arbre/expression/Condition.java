package yal.arbre.expression;

import java.util.ArrayList;

import yal.arbre.Instruction;

public class Condition extends Instruction {
	private ArrayList<Instruction> lesinstructionSI;
	private Expression conditionExpr;
	 
	public Condition(int no) {
		super(no);
	}

	public Condition(Expression expression,ArrayList<Instruction> listinstruction,int no) {
		super(no);
		lesinstructionSI=listinstruction;
		conditionExpr=expression;
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
