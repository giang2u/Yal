package yal.arbre;

<<<<<<< HEAD
import tds.EntreeVariable;
import tds.Symbole;
import tds.Tds;
=======
import yal.tds.Symbole;
>>>>>>> 64012cd57feb203f2acd571446bee6eac05a2500
import yal.arbre.expression.Expression;
import yal.exceptions.AnalyseSemantiqueException;

public class Affectation extends ArbreAbstrait {

	private Expression expression;
	private String idf;
	private Symbole s;
	
	
	protected Affectation(int no,String idf,Expression e) {
		super(no);
		this.idf=idf;
		expression=e;
		s = Tds.getInstance().identifier(new EntreeVariable(idf));
	}

	@Override
	public void verifier() {
		EntreeVariable e = new EntreeVariable(idf);
		Tds t = Tds.getInstance();
		t.identifier(e);
		if (s.getType().equals(expression.getType()) ) {
			throw new AnalyseSemantiqueException(" numero ligne d erreur "+this.noLigne +""
					+ " le type de l'idf et de l'expression ne son pas compatibles");
		}
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		
		
		
		return "la methode affect a faire";
	}

}
