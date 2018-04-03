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
			return sb.toString();
		}

}
