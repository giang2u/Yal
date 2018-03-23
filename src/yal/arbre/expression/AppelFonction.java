package yal.arbre.expression;

import yal.arbre.BlocDInstructions;
import yal.tds.EntreeFonction;
import yal.tds.Symbole;
import yal.tds.Tds;

public class AppelFonction extends Expression {
	private String nomFonction;
	//private BlocDInstructions parametresPasses;
	private int nbpar;
	
	public AppelFonction(String nom,int no) {
		super(no);
		nomFonction=nom;
	}	
	public AppelFonction(String nom,int no,int nbparam) {
		super(no);
		nomFonction=nom;
		nbpar=nbparam;
	}
	



	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void verifier() {//EntreeFonction(String idf,int num, int nbParam)
		System.out.println("ca passe");

		Symbole ss=Tds.getInstance().identifier(new EntreeFonction(nomFonction,0,nbpar));
		if(ss!=null) {

			setType("entier");
		}
		else{
			setType("Erreur");
		}
		
	}


	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder("");
		s.append("\tadd $sp, $sp,-4 \n");
		s.append("\tjal fonction" + nomFonction +"\n");

		s.append("\tadd $sp, $sp,4 \n");
		return s.toString();
	}
	public String toString() {
			return nomFonction+"()"+ nbpar;
	
		
	}

}

