package yal.arbre.expression;

import yal.tds.EntreeVariable;
import yal.tds.Symbole;
import yal.tds.Tds;
/**
 * 
 * @author AS
 *la classe identifiant 
 */
public class Idf extends Expression {
	
	private String nom;
	private Symbole s;
	private int numRegion;
	
	public Idf(String idf,int no) {
		super(no);
		nom=idf;
		numRegion=Tds.getInstance().numRegionCourant;
	}
	public Idf(String idf,int no,int numReg) {
		super(no);
		nom=idf;
		numRegion=numReg;
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
	
	

	public String getNom() {
		return nom;
	}
	@Override
	public void verifier() {
		//System.out.println(nom + "***" +numRegion);
		s=Tds.getInstance().identifier(new EntreeVariable(nom,numRegion));
		if(s!=null) {
			setType(s.getType());
			this.setType("entier");
		}
		/*else{
			s=Tds.getInstance().identifier(new EntreeVariable(nom,0));
			if(s!=null) {
				setType(s.getType());
			}
		}*/
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
			sb.append("\tlw $t7, 8($s7) \n");
			sb.append("\tlw $t5, 4($t7)\n");
			sb.append("\tlw $v0,"+s.getNombreDeplacement()+"($t5)\n");
		
		}
		else{

			sb.append("\tlw $v0,"+s.getNombreDeplacement()+"($s7)\n");

		}
		//sb.append("\tlw $v0,"+"-4($s7)\n");
		return sb.toString();
	}

	public void setValue(int value) {
		this.valeur=value;
	}

}
