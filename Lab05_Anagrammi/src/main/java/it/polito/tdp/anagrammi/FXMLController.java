/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretto"
    private TextArea txtCorretto; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrato"
    private TextArea txtErrato; // Value injected by FXMLLoader

    @FXML
    void handleCalcola(ActionEvent event) {

    	this.txtCorretto.clear();
    	this.txtErrato.clear();
    	String parola=this.txtParola.getText();
    	if(parola.equals("")) {
    		this.txtCorretto.setText("ERRORE: devi inserire una parola \n");
    		return;
    	}
    	
    	Map<String,Boolean> parole = new HashMap<String,Boolean>();
    	
    	parole=model.anagrammi(parola);
    	for(String key: parole.keySet()) {
    		if(parole.get(key)) {
    			this.txtCorretto.appendText(key+"\n");
    		}else {
    			this.txtErrato.appendText(key+"\n");
    		}
    	}
    	
    }

    @FXML
    void handleReset(ActionEvent event) {
    	this.txtCorretto.clear();
    	this.txtErrato.clear();
    	this.txtParola.clear();
    }
    
    public void setModel(Model m) {
    	this.model = m ;
        }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrato != null : "fx:id=\"txtErrato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
