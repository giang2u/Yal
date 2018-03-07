package yal.arbre.expression;


/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
        //expression.setType(expr.getType());
    }

    @Override
    public String operateur() {
        return "- " ;
    }


	@Override
	public int getValue() {
		return -expression.getValue();
	}

	

	@Override
	public String toMIPS() {
		StringBuilder string = new StringBuilder("");
		//string.append("li $v0,-"+ this.valeur);
		


		string.append("\tli $v0,0\n");
		
		string.append("\tsw $v0, 0($sp)\n");
		
		string.append("\tadd $sp, $sp, -4 \n");
		
		string.append(expression.toMIPS());
		string.append("\tadd $sp, $sp,4 \n");
		string.append("\tlw $t8, ($sp) \n");
		
		string.append("# Resultat soustraction \n");
		string.append("\tsub $v0, $t8, $v0\n");
		return string.toString();
	}



}
