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
		if(s==null) {
			//System.out.println(idf+" et "+numRegion);
			//setType(s.getType());			
		}
		indice.verifier();
		expression.verifier();
		if (indice.getType()==null || (!indice.getType().equals("entier")) ) {
			StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +
					" la taille du tableau n est pas un entier");
			StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +
					" affectation entre deux types differents ");
		
		}
		if (expression.getType()==null || (!expression.getType().equals("entier")) ) {
			StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +
					" affectation entre deux types differents ");
			StockErreur.getInstance().ajouter("ERREUR SEMANTIQUE numero de ligne "+this.noLigne +
					" affectation entre deux types differents ");
			
		}
	}
	

	@Override
	public String toMIPS() {
		StringBuilder sb=new StringBuilder();
		sb.append("\n");

		sb.append("#affectation\n");
		
		sb.append("#verification indice\n");
		
		sb.append(indice.toMIPS());
		sb.append("\tmove $t5,$v0\n");
		
		sb.append("\tbgtz $v0, superieur"+compteCondition+"\n");
		sb.append("\tli $v0, 4\n");
		sb.append("\tla $a0, indiceenegative\n");
		sb.append("\tsyscall\n");
		sb.append("\tj end\n");
		sb.append("superieur"+compteCondition+":\n");
		sb.append("\tlw $t8,"+s.getNombreDeplacement()+"($s7)\n");
		
		sb.append("\t sub $v0,$t8,$v0\n");
		
		compteCondition++;
			
		sb.append("\tbgtz $v0, superieur"+compteCondition+"\n");
		sb.append("\tli $v0, 4\n");
		sb.append("\tla $a0, indiceout\n");
		sb.append("\tsyscall\n");
		sb.append("\tj end\n");
		sb.append("superieur"+compteCondition+":\n");
		compteCondition++;
		sb.append("\tli $v0, 4\n");		
		sb.append("\tmult $t5,$v0\n");
		sb.append("\tmflo $t5\n");
		sb.append("\taddi $t5,$t5,8\n");
		sb.append("# l operande droite\n");
		sb.append("\tmove $t2,$t5\n");

		sb.append(expression.toMIPS());
		sb.append("#fins l operande droite\n");
		sb.append("\tsub $s7,$s7,$t2\n");
		sb.append("\tsw $v0,0($s7)\n");
		sb.append("\tadd $s7,$s7,$t2\n");
		
		return sb.toString();
	}
	
	public String toString() {
		return idf+"["+indice.toString()+"] = "+expression.toString();
	}
	

}
