package yal.tds;

public class SymboleVariable extends Symbole{

	public SymboleVariable(int deplacement) {
		super(deplacement);
	}
	
	public String getType(){
		return this.type.toString();
	}

}
