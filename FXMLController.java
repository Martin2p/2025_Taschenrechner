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
//Hilfsvariable um eine Trennung bei der Erkennung der eingegeben Zahl zu ermöglichen
	//sobald kein Operator ausgewählt wurde bleibt der Ausdruck "false"
	boolean operatorGedrueckt = false;
	
/*
 * Die Methoden	
 */
	//die Methode setzt die Bühne auf den übergebenen Wert
	public void setMeineStage(Stage meineStage) {
		this.meineBuehne = meineStage;
	}	
		
	//die Methode zum Zurücksetzen der Felder
	@FXML protected void resetKlick(ActionEvent event) {
			eingabeAusgabe.clear();
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
		
		//hier wird der geklickte Button erkannt und einer Variable zugewießen
		Button clickedButton = (Button) event.getSource();
		
		//die Zahl des geklickten Buttons wird eingelesen und als String-Variable gespeichert
		String number = clickedButton.getText();
	
		//die String-Variable wird im Eingabe-Ausgabe-Feld eingefügt
		eingabeAusgabe.appendText(number);
	}
	
	
	//Methode um ausgewählte Rechenoperation zu erkennen per "get-Text"
	@FXML protected void operantErkennen(ActionEvent event) {
		
		//geklickten Button erkennen
		Button clickedButton = (Button) event.getSource();
		
		//Die oben initialisierte Hilfsvariable wird nun auf "true" gesetzt. 
		//Dies ist notwendig, um die erste Zahl die vor dem Operator steht zu erkennen und abzuspeichern.
		operatorGedrueckt = true;
		
		//erkennen der ersten Zahl und umwandeln in einen Double-Wert
		this.zahl1 = Double.parseDouble(eingabeAusgabe.getText());
		
		//jetzt wird der Operator von dem geklickten Button eingelesen und übergeben an die Operator-Variable
		this.operator = clickedButton.getText();
		
		//Eingabe-Ausgabefeld leeren
		eingabeAusgabe.clear();
	}
	
		
	//die Methode für die Berechnung
	@FXML private void berechnen(ActionEvent event) {
		
		//Initialsieren vom Ergebnis
		double ergebnis = 0;
		
		//Try-Catch-Block um Falscheingaben wie Buchstaben abzufangen 
		try {
			
			//da nach der Auswahl des Operator das Eingabe-Ausgabefeld geleert wurde
			//kann nun eine neue Zahl eingelesen und abgespeichert werden
			this.zahl2 = Double.parseDouble(eingabeAusgabe.getText());
			
			//Switch-Case Anweisung für die 4 Grundrechenarten
			switch (operator) {
				case "+":
					ergebnis = zahl1 + zahl2;
					break;
				case "-":
					ergebnis = zahl1 - zahl2;
					break;
				case "*":
					ergebnis = zahl1*zahl2;
					break;
				case "/":
					
					if (zahl2 != 0) {
						ergebnis = zahl1/zahl2;
						
						//Abfangen der Division durch 0
					} else {
						eingabeAusgabe.setText("Nicht definiert");
					return;
					}
			break;
			}
			
			//wenn das Ergebnis eine "glatte" Zahl ist, erfolgt die Anzeige als int-Wert / ohne Kommastelle
			if (ergebnis % 1 == 0) {
				//das Ergebnis in einen String umwandeln und in das Eingabe-Ausgabefeld setzen
				eingabeAusgabe.setText(String.valueOf((int)ergebnis));
			} else {
				eingabeAusgabe.setText(String.valueOf(ergebnis));
			}
			
			//Hilfsvariable wieder auf "false" setzen um ein erneutes Einlesen der Zahl im Feld zu ermöglichen
			operatorGedrueckt = false;
		}
		
		//Fehlerhafte Eingaben wie Buchstaben abfangen
		catch (NumberFormatException e) {
			eingabeAusgabe.setText("Bitte nur Zahlen eingeben!");
		}
		//sonstige Fehler abfangen
		catch (Exception e) {
		    eingabeAusgabe.setText("Unbekannter Fehler!");
		}
	}
}
