package Visualiseur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        root.setVgap(10);
        root.setHgap(10);  
        root.setPrefWrapLength(250);
        TextField texte = new TextField();
        FileInputStream input = new FileInputStream("ressources/images/home.png");  
        Image home = new Image(input);
        ImageView logo = new ImageView(home);
        logo.setFitHeight(30);
        logo.setFitWidth(30);
        Button accueil = new Button("",logo);
        Button recherche = new Button("Recherche");
        Button filtres = new Button("Filtres");
        Button ajouter = new Button("Ajouter une recette");
        
        filtres.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent arg0) {
            	Stage filtre = new Stage();
            	FlowPane box = new FlowPane(); 
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
                
                filtre.setScene(scene2);
            	filtre.show();
            }  
        });
        
        ajouter.setOnAction(new EventHandler<ActionEvent>()  {  
            @Override  
            public void handle(ActionEvent arg0) {
            	Stage ajout = new Stage();
            	FlowPane box2 = new FlowPane();
            	Scene scene2 = new Scene(box2);
            	ajout.setWidth(600);
            	ajout.setHeight(360);
            	box2.setVgap(6);
            	box2.setHgap(10);
            	ajout.setTitle("Ajouter une recette");
            	Label t = new Label("Nom de la recette : ");
            	TextField titre = new TextField();
            	Button img = new Button("Image");
            	Label r = new Label("Etape 1 : ");
            	TextField prep = new TextField();
            	Region p = new Region();
            	p.setPrefSize(Double.MAX_VALUE, 0.0);
            	FileInputStream input2=null;
				try {
					input2 = new FileInputStream("ressources/images/star.png");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
                Image star = new Image(input2);
                ImageView logo2 = new ImageView(star);
                logo2.setFitHeight(30);
                logo2.setFitWidth(30);
                 
                box2.getChildren().addAll(t,titre,img);
                box2.getChildren().add(p);
                box2.getChildren().addAll(r,prep,logo2);
                
                ajout.setScene(scene2);
                ajout.show();   
            }  
        });
        
        
        root.getChildren().addAll(accueil,texte,recherche,filtres,ajouter); 
        
        stage.setScene(scene);

        stage.show();
    }
}


