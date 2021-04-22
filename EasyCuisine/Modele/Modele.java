package Modele;

import java.util.ArrayList;
import java.util.List;

import TAD.Ingredient;
import TAD.Recette;

public class Modele {

	Recette r;
	
	private String[] typeUnite = {"g", "gramme", "litre", "c. à soupe", "cuillère à soupe", "c. à café", "cuillère à café", "pincée"};
	
	
	public Modele() {
		
	}
	
	public void ajouteRecette(String nomR, String tempsPrep, String ingre, String etapePrep) {
		System.out.println("haaaaa");
		//On sépare la quant, nomI, unit, pour la class Ingrediant
		List<Ingredient> listIngr = new ArrayList<Ingredient>();
		Ingredient ingr;
		String quant = "";
		String nomI = "";
		String unit = "";
		
		for (String s : ingre.split("\n")) {
			for (String s2 : s.split(" ")) {
				nomI = ""; 
				unit = "";
				//test quantité
				if(isNumeric(s2)) {
					quant = s2;
				} else if (s2.contains("\\")) {
					quant = s2;
				} else if (isUnite(s2)) {
					unit = s2;
				} else if(!(isNumeric(s2) && s2.contains("\\") && isUnite(s2))){
					nomI += s2 + " ";
				} else {
					unit = ""; // 10 tomate bah y'a pas d'unite
				}
			}
			System.out.println("here :"+ nomI + quant + unit);
			ingr = new Ingredient(nomI.substring(0, nomI.length()-1), quant, unit);
			listIngr.add(ingr);
		}
		
		//Recuperation des etapes
		List<String> listEtape = new ArrayList<String>();
		for (String s : etapePrep.split(".\n")) {
			listEtape.add(s);
		}
		
		System.out.println("Lalallalala");
		r = new Recette(nomR, tempsPrep, listIngr, listEtape);
		r.put(nomR, r);
		System.out.println("Succes");
		System.out.println(r.get(nomR).toString());
	}
	
	////////////Les trucs utile///////////////
	/**
	 * A mettre dans un autre class
	 * @param string
	 * @return
	 */
	public static boolean isNumeric(String string) {
	    @SuppressWarnings("unused")
		int intValue;
	    
	    if(string == null || string.equals("")) {
	        return false;
	    }
	    
	    try {
	        intValue = Integer.parseInt(string);
	        return true;
	    } catch (NumberFormatException e) {}
	    return false;
	}
	
	/**
	 * idem
	 * @param s
	 * @return
	 */
	public boolean isUnite(String s) {
		for (int i = 0; i < typeUnite.length; i++) {
			if(s.equals(typeUnite[i])) {
				return true;
			}
		}	
		return false;
	}
}
