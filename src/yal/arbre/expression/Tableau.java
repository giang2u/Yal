package yal.arbre.expression;

import yal.arbre.StockErreur;
import yal.tds.EntreeTableau;
import yal.tds.Symbole;
import yal.tds.Tds;

public class Tableau  extends Expression {
		
		private String nom;
		private Symbole s;
		private int numRegion;
		public static int comptCur;
		private Expression nombreElement;

		public Tableau(String idf,int no,Expression nombreElement) {
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
				//setType(s.getType());
				this.setType("entier");
				nombreElement.verifier();
				if (nombreElement.getType()==null || (!nombreElement.getType().equals("entier") ) ) {
					StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +
							" la taille du tableau n est pas un entier");
				}
				if (nombreElement.toString().contains("idf") && numRegion==0) {
					StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +
							" la taille du tableau contient un idf");
				}
				
			}
		
		}
		
		public Symbole getSymbole() {
			return s;
		}
		public String toString() {
			return "entier [] "+nom;
		}
		@Override
		public String toMIPS() {
			StringBuilder sb=new StringBuilder();
			//System.out.println(nom +" "+s.getNombreDeplacement());
			sb.append("#declaration tableau\n");
			sb.append(nombreElement.toMIPS());
			sb.append("\tbgez $v0, superieur"+compteCondition+"\n");
			sb.append("\tli $v0, 4\n");
			sb.append("\tla $a0, taillenegative\n");
			sb.append("\tsyscall\n");
			sb.append("\tj end\n");

			sb.append("superieur"+compteCondition+":\n");
			//sb.append("\taddi $sp,$sp,-8\n");
			sb.append("\tsw $v0,"+s.getNombreDeplacement()+"($s7)\n");
			sb.append("\tsw $sp,"+(s.getNombreDeplacement()+4)+"($s7)\n");
			sb.append("\tlw $t8,"+s.getNombreDeplacement()+"($s7)\n");
			sb.append("reserve"+ comptCur+":");
			sb.append("\tbeqz $t8, finreserve"+comptCur + "\n");
			sb.append("\tsw $zero,($sp)\n");
			sb.append("\taddi $sp,$sp,-4\n");

			sb.append("\taddi $t3,$t3,4\n");
			sb.append("\tsub $t8,$t8,1\n");
			sb.append("\tj reserve"+comptCur+ "\n");
			sb.append("finreserve"+ comptCur+":\n");
			compteCondition++;
			comptCur++;
			return sb.toString();
		}

		public void setValue(int value) {
			this.valeur=value;
		}

}

