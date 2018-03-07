package yal.exceptions;

public class ExecutionException extends AnalyseException {
	
	public ExecutionException(String m) {
		super("ERREUR EXECUTION :"+m);
	}


}