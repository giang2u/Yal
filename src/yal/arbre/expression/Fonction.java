package yal.arbre.expression;

import java.util.ArrayList;

import yal.arbre.BlocDInstructions;
import yal.arbre.RetourneExpression;
import yal.arbre.StockErreur;
import yal.tds.EntreeFonction;
import yal.tds.Symbole;
import yal.tds.SymboleFonction;
import yal.tds.Tds;

public class Fonction extends Expression {
	private BlocDInstructions listeInstruction;
	private ArrayList<Idf> listeParametres;
	private String nomfonction;
	private int numRegion;
	private int nbparam;
	private Symbole s;
	protected Fonction(int n) {
		super(n);
	}
	
	public Fonction(int n, String nomf,int numR,BlocDInstructions linst,int nbPar) {
		super(n);
		listeInstruction=linst;	
		numRegion=numR;
		this.nomfonction = nomf;
		this.nbparam=nbPar;	
	}

	public Fonction(String nomF,int numR,int n,BlocDInstructions linst,ArrayList<Idf> listParametres) {
		super(n);
		nomfonction=nomF;
		numRegion=numR;
		listeInstruction=linst;
		listeParametres=listParametres;		
	}
	public Fonction(String nomF,int numR,int n,BlocDInstructions linst,int nbPar) {
		super(n);
		nomfonction=nomF;
		numRegion=numR;
		listeInstruction=linst;
		this.nbparam=nbPar;	
	}
	
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void verifier() {

		s=Tds.getInstance().identifier(new EntreeFonction(nomfonction,0,nbparam));
		if(s!=null) {
			setType(s.getType());
		}
		listeInstruction.verifier();	
		if(!listeInstruction.toString().contains("retourne")) {
			StockErreur.getInstance().ajouter(
					"ERREUR SEMANTIQUE : ligne "+this.getNoLigne()+" la fonction "
							+nomfonction+ " n a pas de retourner ");			
		}
		/*if(!verifierRetour()) {
			StockErreur.getInstance().ajouter(
					"ERREUR SEMANTIQUE : ligne "+this.getNoLigne()+" la fonction "
							+nomfonction+ " n a pas de retourner ");
		}*/
		//Tds.getInstance().afficher();
	}

	
	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		
		
		StringBuilder s = new StringBuilder("");

		s.append("fonction"+ nomfonction + nbparam+ ": \n");
		
		//empiler valeur de return
		//s.append("\tadd $sp, $sp,-4\n");
		
		
		//empiler @ de retourn
		s.append("\tsw $ra,($sp) \n");
		s.append("\tadd $sp, $sp,-4 \n");
		
		//empiler chainage dynamique
		s.append("\tsw $s7, ($sp) \n");
		s.append("\tadd $sp, $sp,-4 \n");
		
		//empiler nombre region
		s.append("\tli $v0," + numRegion + "\n");
		s.append("\tsw $v0, ($sp) \n");
		s.append("\tadd $sp, $sp, -4 \n");
		
		s.append("#les parametres de la fonction \n");
		//System.out.println(Tds.getInstance().avoirParam(numRegion));
		//System.out.println(numRegion);
		s.append("\tmove $t3, $zero\n");
		
		if(Tds.getInstance().avoirParam(numRegion)){
			
			int nb=Tds.getInstance().nbVariableTotal(numRegion);
			int nbTab=Tds.getInstance().nbTableauTotal(numRegion);
			
			s.append("\tmove $s7, $sp\n");
			s.append("\taddi $sp, $sp,"+nb*-4+" \n");
			s.append("#les tableaux de la fonction \n");

			s.append("\taddi $sp, $sp,"+nbTab*-8+" \n");
			
		}
		
		
		if(nbparam>0){
			int dep=nbparam*4+12;
			s.append("\tmove $t8, $s7\n");
			s.append("\taddi $t8, $t8,"+dep+" \n");
			for (int i = 0; i < nbparam; i++) {
				s.append("\tlw $v0,"+-4*i+"($t8) \n");
				s.append("\tsw $v0,"+-4*i+"($s7) \n");
			}
		}
		
		for(int i = 0; i < listeInstruction.getexpr().size();i++){
			s.append(listeInstruction.getexpr().get(i).toMIPS());
		}
		
		/* variable local*/
		return s.toString();
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
		
		sb.append("fin ");
		
		return sb.toString();
	}

	public boolean verifierRetour() {
		//System.out.println(listeInstruction.derniereInstruction());
		if (listeInstruction.derniereInstruction() instanceof RetourneExpression) {
			
			String etat=((RetourneExpression)listeInstruction.derniereInstruction()).getType();
			//((SymboleFonction)s).setTypeRetour(etat);
			return true;
			
		}
		else if(listeInstruction.derniereInstruction() instanceof Condition) {

			if( ((Condition)listeInstruction.derniereInstruction()).verifierRetourSI() ) {

				if( ((Condition)listeInstruction.derniereInstruction()).verifierRetourSINON() ) {
					return true;
				}
			}
	
		}
		return false;
	}

	public int getNumRegion() {
		return numRegion;
	}

	public void setNumRegion(int numRegion) {
		this.numRegion = numRegion;
	}
}
