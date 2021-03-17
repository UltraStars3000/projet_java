package TAD;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Dico {
	//to change Map<class<nom, filtre, ... >, String>
	//Recette extends Map<String, >
	/*
	 * Recette : NomRecette, ingrediant, 
	 * 			 description de recette, 
	 * 			 protocol de preparation (tuto),
	 * 			 image
	 * 
	 */
	
	
	private Map<String, String> map;
	
	public Dico() {
		map = new HashMap<String, String>();	
	}
	
	
	public void ajouteRecette(String cle, String recette) {
		this.map.put(cle, recette);
	}

	public void supprimmerRecette(String cle) {
		this.map.remove(cle);
	}
	
	public void modifierRecette(String cle, String recette) {
		
		//to change
		this.map.replace(cle, recette);
	}
	
	
	public Set<String> getCle() {
		return this.map.keySet();
	}
}