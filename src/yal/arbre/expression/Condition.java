package yal.arbre.expression;

import java.util.ArrayList;

import yal.arbre.BlocDInstructions;
import yal.arbre.Instruction;
import yal.arbre.StockErreur;

public class Condition extends Instruction {
	private BlocDInstructions lesinstructionSI;
	private BlocDInstructions lesinstructionSINON;
	
	private Expression conditionExpr;
	 
	public Condition(Expression expression,int no) {
		super(no);
		conditionExpr=expression;
	}
	
	public Condition(Expression expression,BlocDInstructions listinstruction,int no) {
		super(no);
		lesinstructionSI=listinstruction;
		conditionExpr=expression;
	}
	
	public Condition(Expression expression,BlocDInstructions listinstruction,int no,BlocDInstructions listinstructionSinon) {
		super(no);
		lesinstructionSI=listinstruction;
		lesinstructionSINON=listinstructionSinon;
		conditionExpr=expression;
	}


	@Override
	public void verifier() {
		if(conditionExpr!=null){
			conditionExpr.verifier();
			if(!conditionExpr.getType().equals("bool")){
				StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +" Expression n'est pas de type boolean");
			}
			else{
				if(lesinstructionSI!= null){
					lesinstructionSI.verifier();
				}
				if(lesinstructionSINON != null){
					lesinstructionSINON.verifier();
				}
			}
		}
	}

	@Override
	public String toMIPS() {
		return null;
	}

}
