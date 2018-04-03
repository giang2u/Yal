package yal.tds;

public class SymboleTableau extends Symbole {
	
	public SymboleTableau(int deplacement) {
		
		super(0);
		this.type="tableau";
		
	}
	
	
	public String getType(){
		return this.type.toString();
	}

}
