package Visualiseur;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Afficheur extends Application{
	public static void main(String[] args) {
        System.out.println( "Main method inside Thread : " +  Thread.currentThread().getName());
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.setTitle("Easy Cuisine");
        
        FlowPane root = new FlowPane();  
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css"); 
        root.setVgap(10);
        root.setHgap(10);  
        root.setPrefWrapLength(250);
        TextField texte = new TextField();
        FileInputStream input = new FileInputStream("/home/natmani/Téléchargements/home2.png");  
        Image home = new Image(input);
        ImageView logo = new ImageView(home);
        logo.setFitHeight(30);
        logo.setFitWidth(30);
        Button accueil = new Button("",logo);
        Button recherche = new Button("Recherche");
        Button filtres = new Button("Filtres");
        filtres.setOnAction(new EventHandler<ActionEvent>() {  
            
            @Override  
            public void handle(ActionEvent arg0) {
            	Stage filtre = new Stage();
            	HBox box = new HBox(); 
            	Scene scene2 = new Scene(box);
            	filtre.setWidth(600);
            	filtre.setHeight(360);
            	filtre.setTitle("Filtres");
            	Label categories = new Label("Catégories :");  
                CheckBox c1 = new CheckBox("Entrées");  
                CheckBox c2 = new CheckBox("Plats");  
                CheckBox c3 = new CheckBox("Desserts");  
                CheckBox c4 = new CheckBox("Appéritifs");  
                 
                box.getChildren().addAll(categories,c1,c2,c3,c4);  
                box.setSpacing(5);
                
                filtre.setScene(scene2);
            	filtre.show();
                System.out.println("Button clicked");  
                  
            }  
        } );  
        root.getChildren().add(accueil);  
        root.getChildren().add(texte); 
        root.getChildren().add(recherche); 
        root.getChildren().add(filtres);  
        
        stage.setScene(scene);

        stage.show();
    }
}


