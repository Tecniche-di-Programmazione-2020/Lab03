/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.sspellchecker.model.Model;
import it.polito.tdp.sspellchecker.model.Model.Lingua;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class FXMLController {
	Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Lingua> choiceLanguage;
    
    @FXML
    private TextArea txtInput;

    @FXML
    private TextArea txtOutput;


    @FXML
    private HBox txtErrorsPhrase;

    @FXML
    private Label txtErrors;

    @FXML
    private HBox txtTimePhrase;

    @FXML
    private Label txtTime;

    @FXML
    void doClearText(ActionEvent event) {
    	txtTimePhrase.setVisible(false);
    	txtErrorsPhrase.setVisible(false);
    	txtInput.clear();
    	txtOutput.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	String str= "";
    	List<String> response=model.spellcheck(choiceLanguage.getSelectionModel().getSelectedItem(), txtInput.getText());
    	for(String s:response) {
    		str+=s+"\n";
    	}
    	txtOutput.setText(str);
    	txtErrors.setText(Integer.toString(response.size()));
    	txtErrorsPhrase.setVisible(true);
    	
    	

    }

    @FXML
    void initialize() {
        assert choiceLanguage != null : "fx:id=\"choiceLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrorsPhrase != null : "fx:id=\"txtErrorsPhrase\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrors != null : "fx:id=\"txtErrors\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTimePhrase != null : "fx:id=\"txtTimePhrase\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        model= new Model();
        
        for(Lingua l: Lingua.values()){
        choiceLanguage.getItems().add(l);}
        choiceLanguage.getSelectionModel().select(Lingua.ITALIAN);
        

    }
    
    public void setModel(Model model) {
		this.model = model;
	}
}
