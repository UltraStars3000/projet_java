package Visualiseur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Afficheur extends Application {
	
	Parent root;
		
	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("VueRecette.fxml"));
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("file:ressources/images/icon.png")); 
		primaryStage.setTitle("EasyCuisine");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
