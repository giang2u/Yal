package yal.arbre;

import yal.arbre.expression.Expression;
import yal.tds.EntreeTableau;
import yal.tds.Symbole;
import yal.tds.Tds;

public class AffectationTableau extends Instruction {
	private Expression indice;
	private Expression expression;
	private String idf;
	private Symbole s;
	private int numRegion;

	public AffectationTableau(int no,String idf,Expression i,Expression e) {
		super(no);
		this.idf=idf;
		indice=i; 
		expression=e;
		numRegion=Tds.numRegionCourant;
	}

	
	@Override
	public void verifier() {
		s=Tds.getInstance().identifier(new EntreeTableau(idf,numRegion));
		if(s!=null) {
			System.out.println(idf+" et "+numRegion);
			//setType(s.getType());
			indice.verifier();
			expression.verifier();
			if (indice.getType()==null || (!indice.getType().equals("entier")) ) {
				StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +
						" la taille du tableau n est pas un entier");
			}
			if (expression.getType()==null || (!expression.getType().equals("entier")) ) {
				StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +
						" affectation entre deux types differents ");
			}
			
		}
	}
	

	@Override
	public String toMIPS() {
		StringBuilder sb=new StringBuilder();

		return sb.toString();
	}
	
	public String toString() {
		return idf+"["+indice.toString()+"] = "+expression.toString();
	}
	

}
