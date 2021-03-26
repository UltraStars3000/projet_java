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
	 * Ajout recette via fichier/serialisation
	 * 
	 * @param recette
	 * @param description
	 * @param ingredient
	 * @param preparation
	 */
	public Recette(String recette, String description, String ingredient, String preparation) {
		// to change imput read
		this.nomRecette = recette;
		this.descriptionRecette = description;
		this.listIngredient.add(ingredient);
		this.etapePreparation.add(preparation);
	}

	/**
	 * Input utilisateur
	 */
	public Recette() {
		// todo
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