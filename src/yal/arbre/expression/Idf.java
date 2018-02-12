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
	
	public Idf(String idf) {
		super(0);
		nom=idf;
	}

	@Override
	public int getValue() {
		return 0;
	}

	@Override
	public void verifier() {
		s=Tds.getInstance().identifier(new EntreeVariable(nom));
		setType(s.getType());
	}
	public String toString() {
		return "entier "+nom;
	}
	@Override
	public String toMIPS() {
		StringBuilder sb=new StringBuilder();
		sb.append("lw $v0,"+s.getNombreDeplacement()+"($s7)\n");
		return sb.toString();
	}

}
