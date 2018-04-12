package yal.arbre;


import yal.tds.Symbole;
import yal.arbre.expression.Expression;
import yal.arbre.expression.Fonction;
import yal.arbre.expression.Idf;

public class Affectation extends Instruction {

	private Expression expression;
	private String idf;
	private Idf idf1;
	private Fonction fonction;
	public static int comptCur;


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
	
	public Affectation(int no,Idf idf,Fonction f) {
		super(no);
		this.idf1=idf;
		fonction=f; 
	}
	
	@Override
	public void verifier() {
		
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
		sb.append("\t#notre qffectation\n");

		//sb.append("\tsw $v0,"+idf1.getSymbole().getNombreDeplacement()+"($s7)\n");


		if(idf1.getSymbole().getNumRegion() != idf1.getNumRegion() && idf1.getSymbole().getNumRegion() ==0 ){
			
			sb.append("\t#recupere le numero de region courant \n");
			sb.append("\tlw $t7, 4($s7) \n");
			
			sb.append("\t#charger la base courante dans t8\n");
			
			sb.append("\tla $t8, 0($s7)\n");

			sb.append("chainAffVar"+ comptCur+":");
			sb.append("\tbeqz $t7, finchainAffVar"+comptCur + "\n");
			sb.append("\tlw $t8, 8($t8)\n");
			sb.append("\tlw $t7, 4($t8) \n");
			sb.append("\tj chainAffVar"+comptCur+ "\n");
			
			sb.append("finchainAffVar"+ comptCur+":\n");
			sb.append("\tsw $v0,"+idf1.getSymbole().getNombreDeplacement()+"($t8)\n");
		
		}
		else{

			sb.append("\tsw $v0,"+idf1.getSymbole().getNombreDeplacement()+"($s7)\n");

		}
		comptCur++;
		return sb.toString();
	}
	
	public String toString() {
		return idf1.toString()+" = "+expression.toString();
	}
	

}