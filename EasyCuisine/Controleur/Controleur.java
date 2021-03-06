package Controleur;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;


import Modele.Modele;
import TAD.Recette;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Controleur implements Initializable,Observer {
	
	Modele modl = new Modele();
	boolean boolRecherche = false;

	// Button de la VueRecette
	@FXML private Button rechercheRecette;
	@FXML private Button buttonAjouteRecette;
	@FXML private TextField barreDeRecherche = new TextField();
	@FXML private ComboBox<String> selectionCategorie;
	@FXML private GridPane grilleRecherche;
	@FXML private AnchorPane paneRecherche;
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
	@FXML private Label afficherPathImage;
	@FXML private ComboBox<String> categorieRecette;
	@FXML private GridPane grilleRecette;
	@FXML private AnchorPane allRecettes;
	@FXML private AnchorPane pageRecette;
	@FXML private AnchorPane PageAjouterRecette;
	@FXML private AnchorPane menu;
	
	//Recette
	@FXML private Text titreRecette;
	@FXML private ImageView imageRecette;
	@FXML private AnchorPane ingredientsRecette;
	@FXML private GridPane gridIngredient;
	@FXML private AnchorPane etapesRecette;
	@FXML private GridPane gridEtapes;
	@FXML private TextArea noteRecette;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		modl.addObserver(this);
		modl.remplirRecettes();
		modl.lireRecettes();



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

	public void sceneAjouterRecette(ActionEvent e28) throws IOException {
		PageAjouterRecette.setVisible(true);
		menu.setVisible(false);
		
		//Reset des zones d'entr??es lors de l'affichage de la sc??ne
		textAreaEtape.clear();
		textAreaIngre.clear();
		textFieldNomRecette.clear();
		textFieldPrep.clear();
		afficherPathImage.setText("");
		categorieRecette.valueProperty().set(null);
	}

	
	/////////////////. Vue Ajouter Recette controler .////////////////
	
	/**
	 * idem que sceneAjouterRecette, sauf sens inverse
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void backToVueRecette() throws IOException {
		pageRecette.setVisible(false);
		PageAjouterRecette.setVisible(false);
		menu.setVisible(true);
		modl.lireRecettes();
		
	}

	/**
	 * Ajoute la recette dans le dico
	 * 
	 * @param e
	 * @throws Exception 
	 */
	public void AjouterRecette(ActionEvent e) throws Exception {
		if (afficherPathImage.getText().length()<=0) {
			afficherPathImage.setText("ressources/imageRecette/aucune.png");
		}
		String nomRecette = textFieldNomRecette.getText();
		String preparation = textFieldPrep.getText();
		String ingredient = textAreaIngre.getText();
		String etape = textAreaEtape.getText();
		String pathImage = afficherPathImage.getText();
		String typeR = categorieRecette.getValue();
		
		//controle si le champ et vide ou non: sinon --> erreur
		if(nomRecette.length()<=0) 
		{
			throw new Exception("Nom de la recette non donn??");
		}
		if (preparation.length()<=0) {
			throw new Exception("Temps de preparation de la recette non donn??");
		} 
		if (ingredient.length()<=0) {
			throw new Exception("Ingredients de la recette non donn??s");
		} 
		if (etape.length()<=0) {
			throw new Exception("Etapes de preparation de la recette non donn??es");
		} 
		if (typeR==null) {
			throw new Exception("Cat??gorie manquante");
		}
		
		//Reset de la grille pour ??viter un doublon des boutons
		grilleRecette.getChildren().clear();
		//System.out.println(nomRecette + preparation + ingredient + etape);
		//ajout dans le dico
		this.modl.ajouteRecette(nomRecette, preparation, ingredient, etape, pathImage, typeR);
		//copy and paste pathImage in ressource and add it
		
		
		
		// revois sur la fen??te principale sinon sur un autre scene avec un validation
		// puis retour sur la scene pricipale
		 
		 
	}
	public void selecteImage(ActionEvent e) {

		String testpath = "";
		Stage stage=new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("PNG Images", "*.png"));
		File listes =fileChooser.showOpenDialog(stage);
		testpath+=listes;
		afficherPathImage.setText(testpath);

	}

	@Override
	public void update(Observable arg0, Object arg1) {	
		if(boolRecherche == false) {
			try {
				int line = 0; 
				for (int i=0;i<((ArrayList<Recette>) arg1).size();i++) {
					Button in = new Button((((ArrayList<Recette>) arg1).get(i)).getNomRecette());
					
					in.setOnMouseClicked(event->{
						
						try {
							Affichelarecette(((Button) in).getText());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
					});
					grilleRecette.add(in, 0, line++);
					grilleRecette.setMargin(in, new Insets(10));
					grilleRecette.setVisible(true);
					allRecettes.setPrefHeight((i+1)*80);
				}
			}catch(ClassCastException e){
			}
		}else {
			grilleRecherche.getChildren().clear();
			try {
				int line = 0; 
				for (int i=0;i<((ArrayList<Recette>) arg1).size();i++) {
					Button in = new Button((((ArrayList<Recette>) arg1).get(i)).getNomRecette());
					
					in.setOnMouseClicked(event->{
						
						try {
							Affichelarecette(((Button) in).getText());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
					});
					grilleRecherche.add(in, 0, line++);
					grilleRecherche.setMargin(in, new Insets(10));
					grilleRecherche.setVisible(true);
					paneRecherche.setPrefHeight((i+1)*80);
					boolRecherche = false;
				}
			}catch(ClassCastException e){
			}
		}
		try {
			gridIngredient.getChildren().clear();
			gridEtapes.getChildren().clear();
			int lineIngre=0;
			int lineEtape=0;
			Image imageDelarecette;
			imageDelarecette = (new Image("file:"+((Recette) arg1).getImagePath())); 
			imageRecette.setImage(imageDelarecette);
			for (int i=0;i<((Recette)arg1).getListIngredient().size();i++) {
				String Labelname="";
				Labelname+=((Recette)arg1).getListIngredient().get(i);
				Label lb = new Label(Labelname);
				gridIngredient.add(lb, 0, lineIngre++);
				gridIngredient.setMargin(lb, new Insets(10));
				gridIngredient.setVisible(true);
				gridIngredient.setPrefHeight((i+1)*50);
				gridIngredient.setPrefWidth(gridIngredient.getPrefWidth()+50);
				ingredientsRecette.setPrefWidth(ingredientsRecette.getPrefWidth()+50);
			}
			for (int i=0;i<((Recette)arg1).getEtapePreparation().size();i++) {
				String Labelname="";
				Labelname+=((Recette)arg1).getEtapePreparation().get(i);
				Label lb = new Label(Labelname);
				gridEtapes.add(lb, 0, lineEtape++);
				gridEtapes.setMargin(lb, new Insets(10));
				gridEtapes.setVisible(true);
				gridEtapes.setPrefWidth(gridEtapes.getPrefWidth()+100);
				etapesRecette.setPrefHeight((i+1)*50);
				etapesRecette.setPrefWidth(etapesRecette.getPrefWidth()+100);
				
			}
			noteRecette.setText(((Recette)arg1).getNoteR());
		}catch(ClassCastException e){
		}
	}
	public void saveNote(ActionEvent e2) throws IOException {
		modl.saveNote(noteRecette.getText(), titreRecette.getText());
	}
	public void Affichelarecette(String string) throws IOException {

		pageRecette.setVisible(true);
		titreRecette.setText(string);
		modl.donnelarecette(string);

	}
	
	public void rechercheAction() throws IOException {
		backToVueRecette();
		boolRecherche = true;
		if(barreDeRecherche.getText().length() > 0) {
			modl.searchCategorie(barreDeRecherche.getText(), selectionCategorie.getValue());
		}else if(selectionCategorie.getValue() != "Ingr??dient"){
			modl.searchCategorie(selectionCategorie.getValue());
		}else {
			System.out.println("VEUILLEZ PRECISER UN INGR????DIENT A RECHERCHER");
		}
	}

}
