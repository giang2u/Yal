package yal.arbre.expression;

import java.util.ArrayList;

import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
import yal.arbre.StockErreur;
import yal.tds.EntreeFonction;
import yal.tds.Symbole;
import yal.tds.Tds;

public class AppelFonction extends Expression {
	private String nomFonction;
	private BlocDInstructions parametresPasses;
	private int nbpar;
	private BlocDInstructions listeparam;
	
	public AppelFonction(String nom,int no) {
		super(no);
		nomFonction=nom;
		this.parametresPasses=new BlocDInstructions(no);

	}	
	public AppelFonction(String nom,int no,int nbparam) {
		super(no);
		nomFonction=nom;
		nbpar=nbparam;
		this.parametresPasses=new BlocDInstructions(no);
	}
	
	public AppelFonction(String nom,int no,int nbparam,BlocDInstructions parametresPasses) {
		super(no);
		nomFonction=nom;
		nbpar=nbparam;
		this.parametresPasses=parametresPasses;
	}
	

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void verifier() {//EntreeFonction(String idf,int num, int nbParam)
		//System.out.println("ca passe");

		Symbole ss=Tds.getInstance().identifier(new EntreeFonction(nomFonction,0,nbpar));
		if(ss!=null) {

			setType("entier");
		}
		else{
			setType("Erreur");
		}
		this.parametresPasses.verifier();
		for (ArbreAbstrait a : parametresPasses.getexpr()) {
			if (!((Expression)a).getType().equals("entier")) {
				StockErreur.getInstance().ajouter(
						"ERREUR SEMANTIQUE : ligne "+this.getNoLigne()+" la fonction "
								+nomFonction+ " a le parametre "+a+" n est pas entier");
			}
		}
		
	}


	@Override
	public String toMIPS() {
		StringBuilder s = new StringBuilder("");
		
		s.append("\tadd $sp, $sp,-4 \n");
		for (ArbreAbstrait a : parametresPasses.getexpr()) {
			s.append(((Expression)a).toMIPS());
			s.append("\tsw $v0, ($sp) \n");
			s.append("\tadd $sp, $sp,-4 \n");
		}
		s.append("\tjal fonction" + nomFonction+nbpar+"\n");
		s.append("\tadd $sp, $sp,"+4*nbpar+" \n");
		
		s.append("\tadd $sp, $sp,4 \n");

		return s.toString();
	}
	public String toString() {
			return nomFonction+"("+parametresPasses.toString()+")";
	
		
	}

}

