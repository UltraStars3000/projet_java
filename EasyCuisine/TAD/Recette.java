package TAD;

import java.util.ArrayList;
import java.util.List;

public class Recette {
	
	private String nomRecette;
	private String tempsPreparation;
	List<Ingredient> listIngredient = new ArrayList<>();
	List<String> etapePreparation = new ArrayList<>();
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
	public Recette(String recette, String tempsPrep, List<?> ingredient, List<?> preparation) {
		this.nomRecette = recette;
		this.tempsPreparation = tempsPrep;
		
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