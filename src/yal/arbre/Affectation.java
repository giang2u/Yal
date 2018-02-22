package yal.arbre;


import yal.tds.EntreeVariable;
import yal.tds.Symbole;
import yal.tds.Tds;
import yal.arbre.expression.Expression;
import yal.exceptions.AnalyseSemantiqueException;

public class Affectation extends Instruction {

	private Expression expression;
	private String idf;
	private Symbole s;
	
	
	public Affectation(int no,String idf,Expression e) {
		super(no);
		this.idf=idf;
		expression=e; 
	}

	@Override
	public void verifier() {
		s = Tds.getInstance().identifier(new EntreeVariable(this.idf));
		if(expression!=null && s!=null) {
		expression.verifier();
		
		// verifie que les types du symbole et de l'expression
		if ( s != null) {
		if (!s.getType().equals(expression.getType()) ) {
			StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE : numero ligne d erreur "+this.noLigne +""
					+ " le type de l'idf et de l'expression ne son pas compatibles");
			
//			throw new AnalyseSemantiqueException(" numero ligne d erreur "+this.noLigne +""
//					+ " le type de l'idf et de l'expression ne son pas compatibles");
		}
		}
		
	}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb=new StringBuilder();
		sb.append(expression.toMIPS());
		sb.append("sw $v0,"+s.getNombreDeplacement()+"($s7)\n");
		
		return sb.toString();
	}
	public String toString() {
		return idf+" = "+expression.toString();
	}

}
