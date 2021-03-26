package TAD;

import java.util.List;
import java.util.ArrayList;

public class Recette {

	private String nomRecette;
	private String descriptionRecette;
	List<String> listIngredient = new ArrayList<>();
	List<String> etapePreparation = new ArrayList<>();
	// private Image img;

	/**
	 * Constructeur d'une recette
	 * 
	 * @param recette
	 * @param description
	 * @param ingredient:  tableau (string) d'ingredient requis pour la recette
	 * @param preparation: tableau (string) d'ingredient requis pour les étapes de
	 *                     préparation de la recette
	 */
	public Recette(String recette, String description, String[] ingredient, String[] preparation) {
		this.nomRecette = recette;
		this.descriptionRecette = description;
		
		for (int i = 0; i < ingredient.length; i++) {
			this.listIngredient.add(ingredient[i]);
		}
		for (int i = 0; i < preparation.length; i++) {
			this.etapePreparation.add(preparation[i]);
		}
	}

	public String getNomRecette() {
		return nomRecette;
	}

	public String getDescriptionRecette() {
		return descriptionRecette;
	}

	public String getIngredient() {
		String s = "";
		for (int i = 0; i < listIngredient.size(); i++) {
			s += listIngredient.get(i) + " ";
		}

		return s;
	}

	/**
	 * 
	 * @return
	 */
	public String getPreparation() {
		String s = "";
		for (int i = 0; i < etapePreparation.size(); i++) {
			s += etapePreparation.get(i) + " ";
		}
		return s;
	}

	/**
	 * 
	 */
	public String toString() {
		String s = "";
		s += getNomRecette() + "\nDescription:\n -" + getDescriptionRecette() + "\nIngrediant requis:\n -"
				+ getIngredient() + "\nPreparation:\n -" + getPreparation();

		return s;
	}
}