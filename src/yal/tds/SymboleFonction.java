package yal.tds;


public class SymboleFonction extends Symbole {
	private String typeRetour;
	
	public SymboleFonction(int deplacement) {
		
		super(deplacement);
		this.type="fonction";
		
	}
	
	
	public String getType(){
		return this.type.toString();
	}
	public void setTypeRetour(String etat) {
		typeRetour=etat;
	}
	public String getTypeRetour() {
		return typeRetour;
	}
	

}
