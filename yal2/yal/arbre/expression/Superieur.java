package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Superieur extends Comparaison {

    public Superieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " > ";
    }
    
 
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toMIPS() {
		return super.toMips();
		/*
		StringBuilder string = new StringBuilder("");
		
		string.append("si"+ compteCondition+":	");
		string.append(gauche.toMIPS() + "\n");
		string.append("\tsw $v0,0($sp) \n");
		string.append("\tadd $sp, $sp, -4 \n");

		string.append("\t" + droite.toMIPS() + "\n");
		string.append("\tadd $sp, $sp, 4 \n");
		string.append("\tlw $t8,($sp) \n");
		string.append("\tsub $v0, $v0, $t8 \n");
		string.append("\tbgtz $v0, sinon"+compteCondition+"\n");
		string.append("alors"+compteCondition+":\n");
		string.append("\tli $v0, 0\n");
		string.append("\tj finsi"+compteCondition+"\n");
		string.append("sinon"+compteCondition+":\n");
		string.append("\tli $v0, 1\n");
		string.append("finsi"+compteCondition+": \n");
		
		compteCondition++;
		return string.toString();
	*/}

	@Override
	public String mipsOperation() {
		StringBuilder string=new StringBuilder();
		
		string.append("si"+ compteCondition+":	");
		string.append("\tsub $v0, $t8, $v0 \n");
		string.append("\tbgtz $v0, sinon"+compteCondition+"\n");
		string.append("alors"+compteCondition+":\n");
		string.append("\tli $v0, 0\n");
		string.append("\tj finsi"+compteCondition+"\n");
		string.append("sinon"+compteCondition+":\n");
		string.append("\tli $v0, 1\n");
		string.append("finsi"+compteCondition+": \n");
		
		compteCondition++;
		return string.toString();
	}
    
}
