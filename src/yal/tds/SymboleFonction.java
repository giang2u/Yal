package yal.tds;

public class SymboleFonction extends Symbole {
	
	
	
	public SymboleFonction(int deplacement) {
		
		super(deplacement);
		this.type="fonction";
	}
	
	
	public String getType(){
		return this.type.toString();
	}

}
