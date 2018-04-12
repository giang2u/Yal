package yal ;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import yal.analyse.AnalyseurLexical;
import yal.analyse.AnalyseurSyntaxique;
import yal.arbre.ArbreAbstrait;
import yal.arbre.StockErreur;
import yal.exceptions.AnalyseException;
import yal.exceptions.AnalyseSemantiqueException;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Yal {
    
    public Yal(String fichier) {
        try {
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
           // System.err.println("expression stockée dans l'arbre : " + arbre);            
            arbre.verifier() ; 
            if(	!StockErreur.getInstance().estVideChaine()) {
    			throw new AnalyseSemantiqueException(StockErreur.getInstance().fusionDesErreurs());
    		}
        	ecrire(arbre.toMIPS(), fichier);
        	System.out.println("COMPILATION OK !"); 

         
        } 
        catch (FileNotFoundException ex) {
            System.err.println("Fichier " + fichier + " inexistant") ;
        }
        catch (AnalyseException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception ex) {
            Logger.getLogger(Yal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ecrire(String expr, String filename){
	 //Creation de  File
	   filename = filename.substring(0, filename.length() - 4)+".mips";
	   File f = new File(filename);
	    
		// Creation du "Buffer"
		BufferedWriter ecrireFichier;
		
		try{
			// Instanciation de l'objet ecrireFichier qui va �crire dans fichierTexte.txt
			ecrireFichier = new BufferedWriter(new FileWriter(f)) ;			
			ecrireFichier.write(expr);
			ecrireFichier.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
   }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Nombre incorrect d'arguments") ;
            System.err.println("\tjava -jar yal.jar <fichierSource.yal>") ;
            System.exit(1) ;
        }
        new Yal(args[0]) ;
    }
    
}
