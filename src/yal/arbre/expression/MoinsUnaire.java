package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }

	@Override
	public void verifier() {
		if(expression.getType()!="entier") {
			throw new AnalyseSemantiqueException("l operande pour le Non logique n�est pas de type entier");
		}
		else {
			setType("entier");
		}
	}
	
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return valeur;
	}

	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "entier";
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
