package yal.arbre.expression;


import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
import yal.arbre.Instruction;
import yal.arbre.StockErreur;

public class BoucleTANT extends Instruction{
	protected BlocDInstructions listIns;
	protected Expression exp;
	
	public BoucleTANT(int no) {
		super(no);
	}
	
	/*public BoucleTANT(int no, Expression exp, Instruction ins){
		super(no);
		this.exp = exp;
		listIns = new ArrayList<Instruction>();
		listIns.add(ins);
	}*/
	
	public BoucleTANT(int no, Expression exp, BlocDInstructions listIns){
		super(no);
		this.listIns =listIns;
		this.exp = exp;
	}
	

	@Override
	public void verifier() {
	
		this.exp.verifier();
		if(!(this.exp.getType().equals("bool") && this.exp != null)){
			StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +" Expression n'est pas de type boolean");
		}
		for(ArbreAbstrait ins : listIns.getexpr()){
			ins.verifier();
		}
		
		
	}

	@Override
	public String toMIPS() {
		int comptCur = compteCondition;
		StringBuilder sb=new StringBuilder();

		BlocDInstructions.entete = false;
		sb.append(this.exp.toMIPS());
		sb.append("tq"+ comptCur+":");
		sb.append("\tbeqz $v0, fintq"+comptCur + "\n");
		for(int i = 0; i < listIns.getexpr().size();i++){
			sb.append(listIns.getexpr().get(i).toMIPS());
		}
		sb.append(this.exp.toMIPS());
		sb.append("\tj tq"+comptCur+ "\n");
		sb.append("fintq"+ comptCur+":\n");
		return sb.toString();
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("tant ");
		sb.append(listIns.toString());
		sb.append("fintantque\n");
		
		return sb.toString();
	}
	

}
