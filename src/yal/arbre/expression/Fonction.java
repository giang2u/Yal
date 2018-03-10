package yal.arbre.expression;

import java.util.ArrayList;
import java.util.Iterator;

import jflex.Out;
import yal.arbre.BlocDInstructions;
import yal.arbre.Instruction;
import yal.arbre.StockErreur;
import yal.tds.EntreeFonction;
import yal.tds.Symbole;
import yal.tds.Tds;

public class Fonction extends Expression {
	private BlocDInstructions listeInstruction;
	private ArrayList<Idf> listeParametres;
	private String nomfonction;
	private int numRegion;
	private Expression retourExpr;
	
	private Symbole s;
	protected Fonction(int n) {
		super(n);
	}
	
	public Fonction(int n, String nomf,int numR,BlocDInstructions linst,Expression eprR) {
		super(n);
		listeInstruction=linst;	
		numRegion=numR;
		this.nomfonction = nomf;
		retourExpr=eprR;

	}

	public Fonction(String nomF,int numR,int n,BlocDInstructions linst,ArrayList<Idf> listParametres,Expression eprR) {
		super(n);
		nomfonction=nomF;
		numRegion=numR;
		retourExpr=eprR;
		listeInstruction=linst;
		listeParametres=listParametres;		
	}
	
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void verifier() {
		s=Tds.getInstance().identifier(new EntreeFonction(nomfonction,numRegion));
		if(s!=null) {
			setType(s.getType());
		}
		listeInstruction.verifier();
		retourExpr.verifier();
		if(!retourExpr.getType().equals("entier")){
			StockErreur.getInstance().ajouter(
					"ERREUR SEMANTIQUE : ligne "+retourExpr.getNoLigne()+" le type de la valeur de retour n est pas entier");

		}
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("\nfonction "+nomfonction+" ");
		sb.append("les parametres (");
		if(listeParametres!=null) {
			sb.append(" "+listeParametres.toString());
		}
		else {
			sb.append(")");		
		}
		sb.append(" ");
		sb.append(listeInstruction.toString());
		sb.append("retourne "+retourExpr.toString()+" ");
		
		sb.append("fin ");
		
		return sb.toString();
	}
}
