package Controleur;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import Modele.Modele;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Controleur implements Initializable {
	

	Modele mold = new Modele();
	Scene scene;

	// Button de la VueRecette
	@FXML private Button rechercheRecette;
	@FXML private Button buttonAjouteRecette;
	@FXML private TextField barreDeRecherche = new TextField();

	// Button de la VueAjouterRecette (on pourait ajoutais un autre controlleur pour
	// VueAjoutRecette)
	// Si on rejoute un controlleur faut le specifier dans le fxml ->
	// fx:controler=""
	@FXML private Button buttonAnnulerRecette;
	@FXML private Button buttonAjouterRecette;
	//ajout recette
	@FXML private TextField textFieldNomRecette;
	@FXML private TextField textFieldPrep;
	@FXML private TextArea textAreaIngre;
	@FXML private TextArea textAreaEtape;
	@FXML private Button btnAjouterImage;
	@FXML private TextField afficherPathImage;
	@FXML private TextField categorieRecette;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Quand cette method est appeler, la scene changeras pour la scene ajouter une
	 * Recette
	 * 
	 * https://www.youtube.com/watch?v=XCgcQTQCfJQ
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void sceneAjouterRecette(ActionEvent e) throws IOException {
		Parent VueAjouterRecetteParent = FXMLLoader.load(getClass().getResource("/Visualiseur/VueAjouterRecette.fxml"));
		Scene VueAjouterRecetteScene = new Scene(VueAjouterRecetteParent);

		// On recupere les informations du stage (primaryStage) de la class Afficheur
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(VueAjouterRecetteScene);
		window.show();
	}

	
	/////////////////. Vue Ajouter Recette controler .////////////////
	
	/**
	 * idem que sceneAjouterRecette, sauf sens inverse
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void backToVueRecette(ActionEvent e) throws IOException {
		Parent VueRecetteParent = FXMLLoader.load(getClass().getResource("/Visualiseur/VueRecette.fxml"));
		Scene VueRecetteScene = new Scene(VueRecetteParent);

		// On recupere les informations du stage (window) de la class Afficheur (scene
		// charger actuellement)
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(VueRecetteScene);
		window.show();
	}

	/**
	 * Ajoute la recette dans le dico
	 * 
	 * @param e
	 * @throws Exception 
	 */
	public void AjouterRecette(ActionEvent e) throws Exception {
				
		String nomRecette = textFieldNomRecette.getText();
		String preparation = textFieldPrep.getText();
		String ingrediant = textAreaIngre.getText();
		String etape = textAreaEtape.getText();
		String pathImage = afficherPathImage.getText();
		String typeR = categorieRecette.getText();
		
		
		//controle si le champ et vide ou non: sinon --> erreur
		if(nomRecette.isBlank()) 
		{
			throw new Exception("Nom de la recette non donnée");
		}
		if (preparation.isBlank()) {
			throw new Exception("Temps de preparation de la recette non donnée");
		} 
		if (ingrediant.isBlank()) {
			throw new Exception("Ingrediant de la recette non donnée");
		} 
		if (etape.isBlank()) {
			throw new Exception("Etape de preparation de la recette non donnée");
		} 
		if (pathImage.isBlank()) {
			//alerte box ou a suppr
			//to do add : black image "Aucune image"
		}
		if (typeR.isBlank()) {
			throw new Exception("Catégorie manquante");
		}
		//System.out.println(nomRecette + preparation + ingrediant + etape);
		//ajout dans le dico
		this.mold.ajouteRecette(nomRecette, preparation, ingrediant, etape, pathImage, typeR);
		//copy and paste pathImage in ressource and add it
		
		
		
		// revois sur la fenête principale sinon sur un autre scene avec un validation
		// puis retour sur la scene pricipale
		 
		 
	}
	public void selecteImage(ActionEvent e) {
		//Get Image
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("PNG image", "*.png"));
		File f = fc.showOpenDialog(null);
		
		if (f != null) {
			afficherPathImage.setText(f.getAbsolutePath());
		}	
		
	}
}
