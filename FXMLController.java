package src;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class FXMLController {

/*
 * Deklarationen
 */
	
	@FXML private Stage meineBuehne;
	@FXML private TextField eingabeAusgabe;
	
	
	//Variblen
	double zahl1;
	double zahl2;
	String operator;
	
	boolean operatorGedrueckt = false;
	
	
/*
 * Die Methoden	
 */
	//die Methode setzt die Bühne auf den übergebenen Wert
	public void setMeineStage(Stage meineStage) {
		this.meineBuehne = meineStage;
	}	
		
	//die Methode Reset, um die Felder zurückzusetzen 
	@FXML protected void resetKlick(ActionEvent event) {
			eingabeAusgabe.clear();
			eingabeAusgabe.setText(null);
	}
	
	//Methode zum Beenden
	@FXML protected void beendenKlick(ActionEvent event) {
		Platform.exit();
	}

		
	//Methode für die Software-Info
	@FXML protected void infoKlick(ActionEvent event) {
		Alert info = new Alert(AlertType.INFORMATION, "Von Martin Tastler");
		info.setHeaderText("Taschenrechner Version 1.0");
		info.show();
	}
	
	
	//Methode um ausgewählte Zahl zu erkennen per "get-Text"
	@FXML protected void nummerErkennen(ActionEvent event) {
	
		Button clickedButton = (Button) event.getSource();
		
		if (!operatorGedrueckt) {
			String number = clickedButton.getText();
			this.zahl1 = Double.parseDouble(number);
			
			eingabeAusgabe.appendText(number);
		}
		else {
			
		}
	}
	
	//Methode um ausgewählte Rechenoperation zu erkennen per "get-Text"
	
	@FXML protected void operantErkennen(ActionEvent event) {
		Button clickedButton = (Button) event.getSource();
		operatorGedrueckt = true;
		
		this.zahl1 = Double.parseDouble(eingabeAusgabe.getText());
		
		this.operator = clickedButton.getText();

	
		eingabeAusgabe.clear();
	}
	
	
	
	
	
	//die Methode für die Berechnung
	private String calculate() {
		
		try {	
			
			
		} 
		catch (NumberFormatException e) {
			eingabeAusgabe.setText("Nicht definiert!");
		}
		return ("Nicht definiert :)");
	}
}
