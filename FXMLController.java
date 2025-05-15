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
		String number = clickedButton.getText();
		
		eingabeAusgabe.setText(number);
	}
	
	
	//Methode um ausgewählte Rechenoperation zu erkennen per "get-Text"
	
	@FXML protected void operantErkennen(ActionEvent event) {
		Button clickedButton = (Button) event.getSource();
		String operant = clickedButton.getText();
		
		eingabeAusgabe.setText(operant);
	}
	
	/*berechnenMethod für den Button
	private String calculate() {
		
		double zahl1, zahl2, ergebnis = 0;
		
		try {	
			zahl1 = Double.parseDouble(eingabe1.getText());
			zahl2 = Double.parseDouble(eingabe2.getText());
			
			boolean fehlerFlag = false;

				if (addition.isSelected()) {
					ergebnis = zahl1 + zahl2;
				}
				
				if (subtraktion.isSelected()) {
					ergebnis = zahl1 - zahl2;
				}
				
				if (division.isSelected()) {
					if (zahl2 != 0) {
						ergebnis = zahl1 / zahl2;
					}
					else {
						fehlerFlag = true;
					}
				}
				
				if (multi.isSelected()) {
					ergebnis = zahl1 * zahl2;
				}
				
				//wenn es keine Probleme gegeben hat, liefern wir das Ergebnis zurück
				if (fehlerFlag == false)
					return Double.toString(ergebnis);
				else
					return ("Nicht definiert");
			
		} 
		catch (NumberFormatException e) {
			ausgabe.setText("Nicht definiert!");
		}
		return ("Nicht definiert :)");
	}*/
}
