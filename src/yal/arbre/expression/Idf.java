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

	@Override
	public void verifier() {
		s=Tds.getInstance().identifier(new EntreeVariable(nom));
		if(s!=null) {
			setType(s.getType());
		}
	}
	
	public Symbole getSymbole() {
		Symbole ss=Tds.getInstance().identifier(new EntreeVariable(nom));
		return ss;
	}
	public String toString() {
		return "entier "+nom;
	}
	@Override
	public String toMIPS() {
		StringBuilder sb=new StringBuilder();
		sb.append("\tlw $v0,"+s.getNombreDeplacement()+"($s7)\n");
		return sb.toString();
	}

	public void setValue(int value) {
		this.valeur=value;
	}

}
