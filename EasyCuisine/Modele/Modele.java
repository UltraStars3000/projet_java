package Modele;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import TAD.Ingredient;
import TAD.Recette;

public class Modele extends Observable {

	Recette r;
	Path original;
	private String[] typeUnite = {"g", "gramme", "litre", "c. à soupe", "cuillère à soupe", "c. à café", "cuillère à café", "pincée"};
	HashMap<String,Recette> listeRecettes = new HashMap<>();
	File recetteXML = new File("recettes.xml");
	
	public Modele() {
		
	}
	
	@SuppressWarnings("resource")
	public void ajouteRecette(String nomR, String tempsPrep, String ingre, String etapePrep, String pathImage, String typeR) throws IOException {
		//On sépare la quant, nomI, unit, pour la classe Ingredient
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
			ingr = new Ingredient(nomI.substring(0, nomI.length()-1), quant, unit);
			listIngr.add(ingr);
		}
		
		//Recuperation des etapes
		List<String> listEtape = new ArrayList<String>();
		for (String s : etapePrep.split(".\n")) {
			listEtape.add(s);
		}
		
		//Copy coller dans le rep ressource avec le nouveau path
		String newImagePath = "ressources\\imageRecette\\";
		/*File f = new File(pathImage);
		String newImagePath = "ressources\\imageRecette\\" + f.getName();
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		//si l'utilisateur ne donne pas d'image
		if (pathImage.isBlank()) {
			newImagePath = "ressources\\imageRecette\\aucune.png";
		} else {
			//lit l'image
			Mat matrix = Imgcodecs.imread(pathImage);
			//copy the image
			Imgcodecs.imwrite(newImagePath, matrix);
		}
		*/
		System.out.println("here");
		r = new Recette(nomR, tempsPrep, listIngr, listEtape, newImagePath, typeR);
		
		this.listeRecettes.put(r.nomRecette,r);
		System.out.println(listeRecettes);
		saveRecettes();
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
	
	public void saveRecettes() throws java.io.InvalidObjectException, FileNotFoundException {
        XMLEncoder encoder=null;
        try {
            FileOutputStream fos = new FileOutputStream(recetteXML);
            BufferedOutputStream bos= new BufferedOutputStream(fos);
            encoder=new XMLEncoder(bos);
            encoder.writeObject(this.listeRecettes);
            encoder.flush();
        }finally {
            if (encoder != null) encoder.close();
        }
    }

}
