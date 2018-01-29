package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

    public OuLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }


	@Override
	public int getValue() {
		return 0;
	}
	

	@Override
	public String toMIPS() {
		return super.toMips();
		/*
		StringBuilder string = new StringBuilder("");
		string.append(gauche.toMIPS() + "\n");
		string.append("\tsw $v0,0($sp) \n");
		string.append("\tadd $sp, $sp, -4 \n");
		string.append(droite.toMIPS() + "\n");
		string.append("\tadd $sp, $sp, 4 \n");
		string.append("\tlw $t8,($sp) \n");
		string.append("\tor $v0,$v0,$t8 \n");
		return string.toString();*/
	}

	@Override
	public String mipsOperation() {
		StringBuilder string = new StringBuilder("");
		string.append("\tor $v0,$v0,$t8 \n");
		return string.toString();
	}

}
