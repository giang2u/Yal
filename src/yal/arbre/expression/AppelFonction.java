package yal.arbre.expression;

import yal.arbre.BlocDInstructions;
import yal.tds.EntreeFonction;
import yal.tds.Symbole;
import yal.tds.Tds;

public class AppelFonction extends Expression {
	private String nomFonction;
	private BlocDInstructions parametresPasses;
	
	
	public AppelFonction(String nom,int no) {
		super(no);
		nomFonction=nom;
	}
	



	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void verifier() {
		Symbole ss=Tds.getInstance().identifier(new EntreeFonction(nomFonction));
		if(ss!=null) {
			setType("entier");
		}
		
	}


	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder("");
		s.append("\tadd $sp, $sp,-4");
		s.append("\tjal fonction" + nomFonction +"\n");
		s.append("\tlw $sp, $s7,12 \n");
		s.append("\tlw $s7, 8($s7) \n");
		s.append("\tlw $ra, ($sp) \n");
		s.append("\tjr $ra \n");
		return s.toString();
	}
	public String toString() {
		if(parametresPasses==null) {
			return nomFonction+"()";
		}
		return "";
		
	}

}

