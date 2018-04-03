package yal.arbre.expression;

import yal.tds.EntreeTableau;
import yal.tds.EntreeVariable;
import yal.tds.Symbole;
import yal.tds.Tds;

public class Tableau  extends Expression {
		
		private String nom;
		private Symbole s;
		private int numRegion;
		public static int comptCur;
		private int nombreElement;

		public Tableau(String idf,int no,int nombreElement) {
			super(no);
			nom=idf;
			numRegion=Tds.getInstance().numRegionCourant;
			this.nombreElement=nombreElement;
		}
		
		public void setNumRegion(int numReg) {
			numRegion=numReg;
		}
		
		public int getNumRegion() {
			return this.numRegion;
		}
		
		@Override
		public int getValue() {
			return 0;
		}
		
		public int getNombreElement() {
			return nombreElement;
		}

		public void setNombreElement(int nombreElement) {
			this.nombreElement = nombreElement;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getNom() {
			return nom;
		}
		@Override
		public void verifier() {
			//System.out.println(nom + "***" +numRegion);
			s=Tds.getInstance().identifier(new EntreeTableau(nom,numRegion));
			if(s!=null) {
				setType(s.getType());
				this.setType("entier");
			}
			if(nombreElement<0) {
				
			}
		}
		
		public Symbole getSymbole() {
			return s;
		}
		public String toString() {
			return "entier "+nom;
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

