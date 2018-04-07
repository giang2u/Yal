package yal.arbre.expression;

import yal.arbre.Instruction;
import yal.arbre.StockErreur;

public class Lire extends Instruction{
	private Idf expression;
	
	public Lire(Idf expr,int no) {
		super(no);
		expression=expr;
	}

	@Override
	public void verifier() {
		expression.verifier();
		
		if(!expression.getType().equals("entier")){
			StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +" Expression n'est pas un nom de variable");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("");
		sb.append("\tli $v0 , 5 \n");
		sb.append("syscall \n");
		//System.out.println(expression.getSymbole().getNombreDeplacement());
		sb.append("\tsw $v0,"+expression.getSymbole().getNombreDeplacement()+"($s7)\n");
		return sb.toString();
	}

}
