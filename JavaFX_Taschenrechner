package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFX_Taschenrechner extends Application {

	@Override
	public void start(Stage meineBuehne) throws Exception {
		
		//eine Instanz von FXMLLoader erzeugen
		FXMLLoader taschenrechner = new FXMLLoader(getClass().getResource("fxml_Taschenrechner.fxml"));
		
		//die Datei laden
		Parent root = taschenrechner.load();
		
		//Kontroller beschaffen
		FXMLController trController = taschenrechner.getController();
		
		//und die Bühne übergeben
		trController.setMeineStage(meineBuehne);
		
		//Scene erstellen
		Scene meineScene = new Scene(root, 400, 400);
		
		//den Titel über stage setzen
		meineBuehne.setTitle("JavaFX Taschenrechner");
		//die Szene setzen
		meineBuehne.setScene(meineScene);
		//Fenstergröße fix setzen
		meineBuehne.setResizable(false);
		//anzeigen
		meineBuehne.show();
	}
	
	public static void main(String[] args) {
		//der Start
		launch(args);
	}

}
