package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;


public class Model {
	
	private AnagrammaDAO anagrammaDAO;
	
	public Model() {
		anagrammaDAO = new AnagrammaDAO();
	}
	

	public Map<String,Boolean> anagrammi(String parola){
		Set<String> risultato = new HashSet<>();  
		Map<String,Boolean> parole = new HashMap<String,Boolean>();
		permuta("",parola, 0, risultato); 
		
		/*for(int i =0; i<risultato.size(); i++) {              se uso lista anzichè set
			if(!parole.containsKey(risultato.get(i))) {
				if(anagrammaDAO.paroleEsistenti(risultato.get(i))) {    
					parole.put(risultato.get(i), true);
				}else {
					parole.put(risultato.get(i), false);
				
			}
			}
		}*/ 
		
		for(String s: risultato) {
			if(anagrammaDAO.paroleEsistenti(s)) {    
				parole.put(s, true);
			}else {
				parole.put(s, false);
			}
		}
		return parole;
		
		
	}
	
	

	private void permuta(String parziale, String lettere,  int livello, Set<String> risultato) {
		if(lettere.length()==0) { 
			risultato.add(parziale);
			
		}else {
			for(int pos=0; pos<lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);
				
				
				String nuovaParziale = parziale + tentativo;
				String nuoveLettere = lettere.substring(0, pos) + lettere.substring(pos+1);
				
				permuta(nuovaParziale, nuoveLettere, livello+1, risultato);
				
				
			}
		}
	}
}
