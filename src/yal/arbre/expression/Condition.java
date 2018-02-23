package yal.arbre.expression;

import java.util.ArrayList;

import yal.arbre.Instruction;

public class Condition extends Instruction {
	private ArrayList<Instruction> lesinstructionSI;
	private ArrayList<Instruction> lesinstructionSINON;
	
	private Expression conditionExpr;
	 
	public Condition(int no) {
		super(no);
	}
	public Condition(Expression expr,int no) {
		super(no);
		conditionExpr=expr;
		
	}

	public Condition(Expression expression,ArrayList<Instruction> listinstruction,int no) {
		super(no);
		lesinstructionSI=listinstruction;
		conditionExpr=expression;
	}
	public Condition(Expression expression,ArrayList<Instruction> listinstructionSI,
			ArrayList<Instruction> listinstructionSINon,int no) {
		super(no);
		lesinstructionSI=listinstructionSI;
		lesinstructionSINON=listinstructionSINon;
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
