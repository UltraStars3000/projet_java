package Visualiseur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Afficheur extends Application {
	
	Parent root;
		
	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/Visualiseur/VueRecette.fxml"));

		primaryStage.setTitle("EasyCuisine");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

		// Test de base
		/*
		 * try { BorderPane root = new BorderPane(); Scene scene = new Scene(root, 400,
		 * 400); scene.getStylesheets().add(getClass().getResource("application.css").
		 * toExternalForm()); primaryStage.setScene(scene); primaryStage.show(); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
	}

	public static void main(String[] args) {
		// System.out.println("Main method inside Thread : " +
		// Thread.currentThread().getName());
		launch(args);
	}

	/*
	 * @Override public void start(Stage stage) throws Exception {
	 * 
	 * stage.setWidth(1280); stage.setHeight(720); stage.setTitle("Easy Cuisine");
	 * 
	 * FlowPane root = new FlowPane(); Scene scene = new Scene(root);
	 * root.setVgap(10); root.setHgap(10); root.setPrefWrapLength(250); TextField
	 * texte = new TextField(); FileInputStream input = new
	 * FileInputStream("ressources/images/home.png"); Image home = new Image(input);
	 * ImageView logo = new ImageView(home); logo.setFitHeight(30);
	 * logo.setFitWidth(30); Button accueil = new Button("",logo); Button recherche
	 * = new Button("Recherche"); Button filtres = new Button("Filtres"); Button
	 * ajouter = new Button("Ajouter une recette");
	 * 
	 * Group acc = new Group();
	 * acc.getChildren().addAll(accueil,texte,recherche,filtres);
	 * 
	 * filtres.setOnAction(new EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent arg0) { root.getChildren().clear();
	 * stage.setWidth(600); stage.setHeight(360); stage.setTitle("Filtres"); Region
	 * p = new Region(); p.setPrefSize(Double.MAX_VALUE, 0.0); Label categories =
	 * new Label("Catégories :"); CheckBox c1 = new CheckBox("Entrées"); CheckBox c2
	 * = new CheckBox("Plats"); CheckBox c3 = new CheckBox("Desserts"); CheckBox c4
	 * = new CheckBox("Appéritifs");
	 * 
	 * root.getChildren().add(acc); root.getChildren().add(p);
	 * root.getChildren().addAll(categories,c1,c2,c3,c4); stage.show(); } });
	 * 
	 * ajouter.setOnAction(new EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent arg0) { root.getChildren().clear();
	 * stage.setWidth(600); stage.setHeight(360); Label t = new
	 * Label("Nom de la recette : "); TextField titre = new TextField(); Button img
	 * = new Button("Image"); Button ajouter = new Button("Ajouter recette"); Button
	 * plus = new Button("+"); Label r = new Label("Etape 1 : "); TextField prep =
	 * new TextField(); Region p = new Region(); p.setPrefSize(Double.MAX_VALUE,
	 * 0.0); FileInputStream input2=null; try { input2 = new
	 * FileInputStream("ressources/images/star.png"); } catch (FileNotFoundException
	 * e) { e.printStackTrace(); } Image star = new Image(input2); ImageView logo2 =
	 * new ImageView(star); logo2.setFitHeight(30); logo2.setFitWidth(30);
	 * 
	 * root.getChildren().add(acc); root.getChildren().addAll(t,titre,img);
	 * root.getChildren().add(p); root.getChildren().addAll(r,prep,logo2);
	 * root.getChildren().add(p); root.getChildren().add(ajouter); stage.show();
	 * 
	 * ajouter.setOnAction(new EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent arg0) { try { restart(stage); }
	 * catch (Exception e) { e.printStackTrace(); } } });
	 * 
	 * plus.setOnAction(new EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent arg0) { try { restart(stage); }
	 * catch (Exception e) { e.printStackTrace(); } } }); } });
	 * 
	 * accueil.setOnAction(new EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent arg0) { try { restart(stage); }
	 * catch (Exception e) { e.printStackTrace(); } } });
	 * 
	 * root.getChildren().addAll(acc,ajouter); stage.setScene(scene); stage.show();
	 * }
	 * 
	 * 
	 * 
	 * void restart(Stage stage) throws Exception { start(stage); }
	 */
}
