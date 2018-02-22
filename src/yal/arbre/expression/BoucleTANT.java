package yal.arbre.expression;

import java.util.ArrayList;

import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
import yal.arbre.Instruction;
import yal.arbre.StockChaine;
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
		StringBuilder sb=new StringBuilder();
		sb.append(this.exp.toMIPS());
		sb.append("\ttq"+ compteCondition+":");
		sb.append("\tbeqz $v0, fintq"+compteCondition + "\n");
		for(int i = 0; i < listIns.getexpr().size();i++){
			sb.append(listIns.getexpr().get(i).toMIPS());
		}
		sb.append(this.exp.toMIPS());
		compteCondition--;
		sb.append("\tj tq"+compteCondition+ "\n");
		sb.append("\tfintq"+ compteCondition+":\n");
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
