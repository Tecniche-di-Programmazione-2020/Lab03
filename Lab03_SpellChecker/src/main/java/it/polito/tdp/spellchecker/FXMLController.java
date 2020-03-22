/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.sspellchecker.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FXMLController {
	private Model model;
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ChoiceBox<?> choiceLanguage;

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

	    }

	    @FXML
	    void doSpellCheck(ActionEvent event) {
	    	//txtTimePhrase.setVisible(true);

	    }

	    @FXML
	    void initialize() {
	        assert choiceLanguage != null : "fx:id=\"choiceLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtErrorsPhrase != null : "fx:id=\"txtErrorsPhrase\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtErrors != null : "fx:id=\"txtErrors\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtTimePhrase != null : "fx:id=\"txtTimePhrase\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

	    }
	    public void setModel(Model model) {
			this.model = model;
		}
	}
