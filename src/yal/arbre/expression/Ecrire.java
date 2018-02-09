package yal.arbre.expression;

import yal.arbre.Instruction;
import yal.arbre.StockChaine;

public class Ecrire extends Instruction {
	private String chaine;
	private Expression expr;
	private boolean estChaine;

	public Ecrire(String chai,int no) {
		super(no);		
		if(chai.length() == 2) {
			this.chaine = "";
		}
		else {
			this.chaine = chai.substring(1, chai.length() - 1);
		}
		estChaine=true;
	}

	public Ecrire(Expression expr,int no) {
		super(no);
		this.expr=expr;
		estChaine=false;
	}

	@Override
	public void verifier() {
		if(!estChaine){
			expr.verifier();
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder s = new StringBuilder("");
		if(estChaine){
			if (StockChaine.getInstance().getDerniereChaine().equals(chaine)){
				s.append("\tli $v0, 4\n");
				s.append("\tla $a0, str\n");
				s.append("\tsyscall\n");
			}
		}
		else{
			s.append(expr.toMIPS());
			s.append("\tmove $t8,$v0\n");
			s.append("\tli $v0 , 1\n");
			s.append("\tmove $a0, $t8\n");
			s.append("\tsyscall\n");
		}
		
		return s.toString();
	}
	public String toString(){
		if (estChaine) {
			return "ecrire "+chaine;
		}
		return "ecrire "+expr.toString();
	}

}
