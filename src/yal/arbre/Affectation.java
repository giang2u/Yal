package yal.arbre;


import yal.tds.Symbole;
import yal.arbre.expression.Expression;
import yal.arbre.expression.Idf;

public class Affectation extends Instruction {

	private Expression expression;
	private String idf;
	private Symbole s;
	private Idf idf1;
	
	
	public Affectation(int no,String idf,Expression e) {
		super(no);
		this.idf=idf;
		expression=e; 
	}
	
	public Affectation(int no,Idf idf,Expression e) {
		super(no);
		this.idf1=idf;
		expression=e; 
	}

	@Override
	public void verifier() {
		/*s = Tds.getInstance().identifier(new EntreeVariable(this.idf));
		if(expression!=null && s!=null) {
		expression.verifier();
		
		// verifie que les types du symbole et de l'expression
		if (!s.getType().equals(expression.getType()) ) {
			StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE : numero ligne d erreur "+this.noLigne +""
					+ " le type de l'idf et de l'expression ne son pas compatibles");
			
//			throw new AnalyseSemantiqueException(" numero ligne d erreur "+this.noLigne +""
//					+ " le type de l'idf et de l'expression ne son pas compatibles");
		}
		}*/
		idf1.verifier();
		if(idf1.getSymbole()!=null) {
			if(expression!=null) {
				expression.verifier();			
				if(!idf1.getType().equals(expression.getType())) {
					StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE : numero ligne d erreur "+this.noLigne +""
						+ " le type de l'idf et de l'expression ne son pas compatibles");
					
				}
				else {
					idf1.setValue(expression.getValue());
				}
				
			}
		}		
	}

	@Override
	public String toMIPS() {
		StringBuilder sb=new StringBuilder();
		sb.append(expression.toMIPS());
		sb.append("\tsw $v0,"+idf1.getSymbole().getNombreDeplacement()+"($s7)\n");
		
		return sb.toString();
	}
	public String toString() {
		return idf+" = "+expression.toString();
	}
	

}
