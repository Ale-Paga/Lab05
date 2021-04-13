package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model {
	

	public Map<String,boolean> anagrammi(String parola){
		List<String> risultato = new ArrayList<>();  
		permuta("",parola, 0, risultato); 
		
		return null;
		
	}

	
	
	
	

	private void permuta(String parziale, String lettere,  int livello, List<String> risultato) {
		if(lettere.length()==0) { //caso terminale
			risultato.add(parziale);
			
		}else {
			// fai ricorsione
			for(int pos=0; pos<lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);
				
				
				String nuovaParziale = parziale + tentativo;
				String nuoveLettere = lettere.substring(0, pos) + lettere.substring(pos+1); //togli il carattere pos da lettere 
				
				permuta(nuovaParziale, nuoveLettere, livello+1, risultato);
				
				// Backtracking (NON SERVE!!!)
				
			}
		}
	}
}
