package TAD;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Dico {
	//to change Map<class<nom, filtre, ... >, String>
	//Recette extends Map<String, >
	/*
	 * Recette : NomRecette, ingredient, 
	 * 			 description de recette, 
	 * 			 protocol de preparation (tuto),
	 * 			 image
	 * 
	 * 
	 * 
	 * DicoRecette   --> Ensemble --> Recette
	 * DicoIngredient -->
	 * 
	 * patate, recette1, recette2
	 * 
	 * 
	 */
	
	
	private Map<String, Set<Recette>> mapRecette; // NomRecette
	private Map<String, Set<Recette>> mapIgredient; //Ingredient
	
	public Dico() {
		mapRecette = new HashMap<>();
		mapIgredient = new HashMap<>();
	}
	
	public static void main(String[] args) {
		
	}
	
}