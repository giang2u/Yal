package yal.arbre.expression;

import yal.arbre.StockErreur;
import yal.tds.EntreeTableau;
import yal.tds.Symbole;
import yal.tds.Tds;

public class TableauElement extends Expression {
	
	private String nom;
	private Symbole s;
	private int numRegion;
	public static int comptCur;
	private Expression indice;

	public TableauElement(String idf,int no,Expression indice) {
		super(no);
		nom=idf;
		numRegion=Tds.getInstance().numRegionCourant;
		this.indice=indice;
	}
		
	@Override
	public int getValue() {
		return 0;
	}
	
		@Override
	public void verifier() {
		//System.out.println(nom + "***" +numRegion);
		s=Tds.getInstance().identifier(new EntreeTableau(nom,numRegion));
		if(s!=null) {
			//setType(s.getType());
			this.setType("entier");
			indice.verifier();
			if (indice.getType()==null || (!indice.getType().equals("entier")) ) {
				StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +
						" la taille du tableau n est pas un entier");
			}
		}
	
	}
	
	public Symbole getSymbole() {
		return s;
	}
	public String toString() {
		return " "+nom+"["+indice.toString()+"]";
	}
	@Override
	public String toMIPS() {
		StringBuilder sb=new StringBuilder();
		//System.out.println(nom +" "+s.getNumRegion());

		if(s.getNumRegion() != numRegion && s.getNumRegion() ==0 ){
			
			sb.append("\t#recupere le numero de region courant \n");
			sb.append("\tlw $t7, 4($s7) \n");
			
			sb.append("\t#charger la base courante dans t8\n");
			
			sb.append("\tla $t8, 0($s7)\n");
			/*
			sb.append("\tlw $v0,"+s.getNombreDeplacement()+"($t5)\n");
			sb.append("\tlw $t8, 8($t7)\n");*/

			sb.append("chain"+ comptCur+":");
			sb.append("\tbeqz $t7, finchain"+comptCur + "\n");
			sb.append("\tlw $t8, 8($t8)\n");
			sb.append("\tlw $t7, 4($t8) \n");
			sb.append("\tj chain"+comptCur+ "\n");
			
			sb.append("finchain"+ comptCur+":\n");
			sb.append("\tlw $v0,"+s.getNombreDeplacement()+"($t8)\n");
			
		}
		else{

			sb.append("\tlw $v0,"+s.getNombreDeplacement()+"($s7)\n");

		}
		comptCur++;
		//sb.append("\tlw $v0,"+"-4($s7)\n");
		return sb.toString();
	}

	public void setValue(int value) {
		this.valeur=value;
	}
}