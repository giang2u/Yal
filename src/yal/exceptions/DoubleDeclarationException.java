package yal.exceptions;

public class DoubleDeclarationException extends AnalyseException {

	protected DoubleDeclarationException(String m) {
		super("ERREUR SEMANTIQUE :"+m);
	}

}
