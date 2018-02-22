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
	/*	for(Instruction ins : listIns){
			ins.verifier();
		}*/
		
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("tant ");
		sb.append(listIns.toString());
		sb.append("fintantque\n");
		
		return sb.toString();
	}
	

}
