package TAD;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recette implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String nomRecette;
	private String tempsPreparation;
	private String typeRC;
	List<String> listIngredient = new ArrayList<>();
	List<String> etapePreparation = new ArrayList<>();
	private String imagePath;
	public String noteR;
	// private Image img;

	/**
	 * Constructeur d'une recette
	 * 
	 * @param recette
	 * @param description
	 * @param ingredient:  tableau (ingredient) d'ingredient requis pour la recette
	 * @param preparation: tableau (string) d'ingredient requis pour les étapes de
	 *                     préparation de la recette
	 */
	public Recette() {
		
	}
	public Recette(String recette, String tempsPrep, ArrayList<String> ingredient, ArrayList<String> preparation, String pathImage, String typeR) {
		this.nomRecette = recette;
		this.tempsPreparation = tempsPrep;
		this.typeRC = typeR;
		this.imagePath = pathImage;

		for (int i = 0; i < ingredient.size(); i++) {
			this.listIngredient.add((String) ingredient.get(i));
		}
		for (int i = 0; i < preparation.size(); i++) {
			this.etapePreparation.add((String) preparation.get(i));
		}
	}
	
	/**
	 * 
	 * @return nomRecette: nom de la recette
	 */
	
	
	/**
	 * 
	 */
	public String toString() {
		String s = "";
		s += getNomRecette() + "\nTemps de préparation:\n " + getTempsPreparation() + "\nIngrédients requis:\n "
				+ getListIngredient() + "\nPreparation:\n " + getEtapePreparation() + "\nCatégorie:\n " + getTypeRC()+"\n\n";

		return s;
	}
	public String getNomRecette() {
		return nomRecette;
	}
	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}
	public String getTempsPreparation() {
		return tempsPreparation;
	}
	public void setTempsPreparation(String tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}
	public String getTypeRC() {
		return typeRC;
	}
	public void setTypeRC(String typeRC) {
		this.typeRC = typeRC;
	}
	public List<String> getListIngredient() {
		return listIngredient;
	}
	public void setListIngredient(List<String> listIngredient) {
		this.listIngredient = listIngredient;
	}
	public List<String> getEtapePreparation() {
		return etapePreparation;
	}
	public void setEtapePreparation(List<String> etapePreparation) {
		this.etapePreparation = etapePreparation;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getNoteR() {
		return noteR;
	}
	public void setNoteR(String noteR) {
		this.noteR = noteR;
	}

	public void ajouterNotes(String text) {
		// TODO Auto-generated method stub
		this.noteR=text;
	}
	
}