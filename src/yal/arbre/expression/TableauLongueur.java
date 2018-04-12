package yal.arbre.expression;

import yal.tds.EntreeTableau;
import yal.tds.Symbole;
import yal.tds.Tds;

public class TableauLongueur extends Expression {
		
		private String nom;
		private Symbole s;
		private int numRegion;
		public static int comptCur;

		public TableauLongueur(String idf,int no) {
			super(no);
			nom=idf;
			numRegion=Tds.getInstance().numRegionCourant;
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
		

		@Override
		public void verifier() {
			//System.out.println(nom + "***" +numRegion);
			s=Tds.getInstance().identifier(new EntreeTableau(nom,numRegion));
			if(s!=null) {
				setType(s.getType());
				this.setType("entier");
			}
		}
		
		public Symbole getSymbole() {
			return s;
		}
		public String toString() {
			return " "+nom+".longueur";
		}
		@Override
		public String toMIPS() {
			StringBuilder sb=new StringBuilder();
			
			sb.append("\t#longueur du tableau\n");


			if(s.getNumRegion() != numRegion && s.getNumRegion() ==0 ){
				
				sb.append("\t#recupere le numero de region courant \n");
				sb.append("\tlw $t7, 4($s7) \n");
				
				sb.append("\t#charger la base courante dans t8\n");
				
				sb.append("\tla $t8, 0($s7)\n");
				/*
				sb.append("\tlw $v0,"+s.getNombreDeplacement()+"($t5)\n");
				sb.append("\tlw $t8, 8($t7)\n");*/

				sb.append("chainTabLongueur"+ comptCur+":");
				sb.append("\tbeqz $t7, finchainTabLongueur"+comptCur + "\n");
				sb.append("\tlw $t8, 8($t8)\n");
				sb.append("\tlw $t7, 4($t8) \n");
				sb.append("\tj chainTabLongueur"+comptCur+ "\n");
				
				sb.append("finchainTabLongueur"+ comptCur+":\n");
				sb.append("\tlw $v0,"+s.getNombreDeplacement()+"($t8)\n");
			
			}
			else{

				sb.append("\tlw $v0,"+s.getNombreDeplacement()+"($s7)\n");

			}
			comptCur++;
			return sb.toString();
		}

}
