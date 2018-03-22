package yal.arbre.expression;


import yal.arbre.BlocDInstructions;
import yal.arbre.Instruction;
import yal.arbre.RetourneExpression;
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

	/**
	 * constructeur pour sinon diff de condition de si
	 * @param expression
	 * @param no
	 * @param listinstructionSinon
	 */
	public Condition(Expression expression,int no,BlocDInstructions listinstructionSinon) {
		super(no);
		lesinstructionSINON=listinstructionSinon;
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
		StringBuilder sb=new StringBuilder();
		BlocDInstructions.entete = false;
		int tempt = compteCondition;
		sb.append(this.conditionExpr.toMIPS());
		sb.append("conditionSi"+tempt+":");
		sb.append("\tbeqz $v0, conditionSinon"+tempt + "\n");
		sb.append("conditionAlors"+tempt+":\n");
		if(lesinstructionSI!=null){		
			sb.append(lesinstructionSI.toMIPS());
		}
		sb.append("\tj conditionFinsi"+tempt+"\n");
		sb.append("conditionSinon"+tempt+":\n");
		if(lesinstructionSINON!=null){
			sb.append(lesinstructionSINON.toMIPS());
		}
		sb.append("conditionFinsi"+tempt+":\n");
		compteCondition++;
		return sb.toString();
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(" Si "+conditionExpr.toString());
		sb.append(" Alors ");
		if(lesinstructionSI!=null){
			sb.append(lesinstructionSI.toString());
		}
		sb.append("sinon ");
		if(lesinstructionSINON!=null){
			sb.append(lesinstructionSINON.toString());
		}
		sb.append(" Fsi");
		return sb.toString();
	}
	public boolean verifierRetourSI() {

		if(lesinstructionSI==null) {
			return false;
		}
		if(lesinstructionSI.derniereInstruction() instanceof RetourneExpression) {
			return true;
		}
		return false;
	}
	
	public boolean verifierRetourSINON() {

		if(lesinstructionSINON==null ) {
			return false;
		}
		if(lesinstructionSINON.derniereInstruction() instanceof RetourneExpression) {
			return true;
		}
		return false;
		
	}

}
