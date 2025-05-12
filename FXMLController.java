package src;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


public class FXMLController {

/*
 * Deklarationen
 */
	
	@FXML private Stage meineBuehne;
	@FXML private TextField eingabe1;
	@FXML private TextField eingabe2;
	@FXML private Label ausgabe;
	
	//einzelne Deklarationen, sonst erkennt es der SceneBuilder nicht	
	@FXML private RadioButton addition;
	@FXML private RadioButton subtraktion;
	@FXML private RadioButton multi;
	@FXML private RadioButton division;
	
	
	//die Methode setzt die Bühne auf den übergebenen Wert
	public void setMeineStage(Stage meineStage) {
		this.meineBuehne = meineStage;
	}	

	
/*
 * Die Methoden	
 */
		
	//die Methode Reset, um die Felder zurückzusetzen 
	@FXML protected void resetKlick(ActionEvent event) {
			eingabe1.clear();
			eingabe2.clear();
			ausgabe.setText(null);
	}
	
	//Methode zum Beenden
	@FXML protected void beendenKlick(ActionEvent event) {
		Platform.exit();
	}
	
	//Methode zum Berechnen
	@FXML protected void berechnenKlick(ActionEvent event) {
		ausgabe.setText(calculate());
	}
		
	//Methode für die Software-Info
	@FXML protected void infoKlick(ActionEvent event) {
		Alert info = new Alert(AlertType.INFORMATION, "Von Martin Tastler");
		info.setHeaderText("Taschenrechner Version 1.0");
		info.show();
	}
	
	
	//berechnenMethod für den Button
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
	}
}
