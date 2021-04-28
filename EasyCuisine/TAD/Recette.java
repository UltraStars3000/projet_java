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
	List<Ingredient> listIngredient = new ArrayList<>();
	List<String> etapePreparation = new ArrayList<>();
	private File imagePath;
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
	public Recette(String recette, String tempsPrep, List<?> ingredient, List<?> preparation, String pathImage, String typeR) {
		this.nomRecette = recette;
		this.tempsPreparation = tempsPrep;
		this.typeRC = typeR;
		this.imagePath = new File(pathImage);
		
		for (int i = 0; i < ingredient.size(); i++) {
			this.listIngredient.add((Ingredient) ingredient.get(i));
		}
		for (int i = 0; i < preparation.size(); i++) {
			this.etapePreparation.add((String) preparation.get(i));
		}
	}
	
	/**
	 * 
	 * @return nomRecette: nom de la recette
	 */
	public String getNomRecette() {
		return nomRecette + "\n";
	}
	
	/**
	 * 
	 * @return tempsPreparation: Description de la recette
	 */
	public String getTempsPreparation() {
		return tempsPreparation +"\n";
	}
	
	/**
	 * 
	 * @return s: Liste des ingredients
	 */
	public String getIngredient() {
		String s = "";
		for (int i = 0; i < listIngredient.size(); i++) {
			Ingredient c = listIngredient.get(i);
			s += c.getNomIngredient() + ": " + c.getQuantiteIngredient() + c.getUniteIngredient() + "\n ";
		}

		return s;
	}
	
	public String getTypeRC() {
		return typeRC;
	}
	
	
	/**
	 * 
	 * @return s: Liste des étapes de la recette
	 */
	public String getPreparation() {
		String s = "";
		for (int i = 0; i < etapePreparation.size(); i++) {
			s += etapePreparation.get(i) + "\n ";
		}
		return s;
	}
	
	public String getPathImage() {
		return imagePath.getAbsolutePath();
	}
	
	


	public void setListIngredient(List<Ingredient> listIngredient) {
		this.listIngredient = listIngredient;
	}


	public void setEtapePreparation(List<String> etapePreparation) {
		this.etapePreparation = etapePreparation;
	}

	public void setImagePath(File imagePath) {
		this.imagePath = imagePath;
	}

	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	public void setTempsPreparation(String tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}

	public void setTypeRC(String typeRC){
		this.typeRC = typeRC;
	}
	
	/**
	 * 
	 */
	public String toString() {
		String s = "";
		s += getNomRecette() + "\nTemps de préparation:\n " + getTempsPreparation() + "\nIngrediant requis:\n "
				+ getIngredient() + "\nPreparation:\n " + getPreparation();

		return s;
	}
}