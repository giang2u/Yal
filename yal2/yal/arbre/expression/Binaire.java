package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Binaire extends Expression {
    
    protected Expression gauche ;
    protected Expression droite ;

    protected Binaire(Expression gauche, Expression droite) {
        super(gauche.getNoLigne());
        this.gauche = gauche;
        this.droite = droite;
    }
    
    public abstract String operateur() ;
    public abstract String mipsOperation();

    @Override
    public String toString() {
        return "(" + gauche + operateur() + droite + ")" ;
    }
    
    public String toMips() {
    	StringBuilder sb=new StringBuilder();
		//sb.append("#traitement operande gauche\n");
		sb.append(gauche.toMIPS());
		sb.append("\tsw $v0, 0($sp)\n");
		sb.append("\tadd $sp, $sp, -4 \n");
		
//		sb.append("#traitement operande droite\n");
		sb.append(droite.toMIPS());
		sb.append("\tadd $sp, $sp,4 \n");
		sb.append("\tlw $t8, ($sp) \n");
		sb.append(mipsOperation());
		
		return sb.toString();
    }

}
