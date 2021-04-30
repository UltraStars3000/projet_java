package Modele;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import TAD.Recette;

public class Modele extends Observable {

	Recette r;
	Path original;
	private String[] typeUnite = {"g", "gramme", "litre", "c. à soupe", "cuillère à soupe", "c. à café", "cuillère à café", "pincée"};
	HashMap<String,Recette> listeRecettes = new HashMap<>();
	HashMap<String,ArrayList<Recette>> triParCategorie = new HashMap<>();
	File recetteXML = new File("recettes.xml");
	ArrayList<Recette> listeEntree=new ArrayList<>();
	ArrayList<Recette> listePlat=new ArrayList<>();
	ArrayList<Recette> listeDessert=new ArrayList<>();
	
	public Modele() {
		
	}
	public void remplirRecettes() {
		XMLDecoder decoder = null;
		try {
			FileInputStream fis= new FileInputStream(recetteXML);
			BufferedInputStream bis= new BufferedInputStream(fis);
			decoder = new XMLDecoder(bis);
			
			this.listeRecettes=(HashMap<String, Recette>) decoder.readObject();
			
			// On remplit les listes des différentes catégories
			for(String rec : this.listeRecettes.keySet()){
				Recette r = this.listeRecettes.get(rec);
				switch(r.getTypeRC()){
					case "Entrée":
						listeEntree.add(r);
						break;
					case "Plat":
						listePlat.add(r);
						break;
					case "Dessert":
						listeDessert.add(r);
						break;
					}
			}
			// On remplit la HashMap avec les listes de chaque catégories
			triParCategorie.put("Entrée", listeEntree);
			triParCategorie.put("Plat", listePlat);
			triParCategorie.put("Dessert", listeDessert);
			System.out.println(triParCategorie);
			
		}catch(Exception e) {
			System.out.println("Pas de recette disponible");
		}finally {
			if (decoder != null) decoder.close();
		}
	}

	public void ajouteRecette(String nomR, String tempsPrep, String ingre, String etapePrep, String pathImage, String typeR) throws IOException {
		//Recuperation des ingrédients
		ArrayList<String> listIngr = new ArrayList<String>();
		for (String s : ingre.split("\n")) {
				listIngr.add(s);
			}
		
		//Recuperation des etapes
		ArrayList<String> listEtape = new ArrayList<String>();
		for (String s : etapePrep.split(".\n")) {
			listEtape.add(s);
		}
		String newImagePathfinale;
		//Copy coller dans le rep ressource avec le nouveau path
		String newImagePath = "ressources\\imageRecette\\";
		InputStream in;
		OutputStream out;
		if (pathImage!="ressources/imageRecette/aucune.png") {
			in = new FileInputStream(pathImage);
			String[] tab=nomR.split(" ");
			String nomtest=tab[0];
			for (int i=1;i<tab.length;i++) {
				nomtest+="_"+tab[i];
			}
	
			out = new FileOutputStream(newImagePath+nomtest+".png");
			BufferedInputStream bin = new BufferedInputStream(in);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			int blc=0;
			while(blc!=-1){
				blc=bin.read();
				bout.write(blc);
			}
			bin.close();
			bout.close();
			newImagePathfinale= newImagePath+nomtest+".png";
			System.out.println(newImagePathfinale);
		}else {
			newImagePathfinale="ressources/imageRecette/aucune.png";
		}
		r = new Recette(nomR, tempsPrep, listIngr, listEtape, newImagePathfinale, typeR);
		
		this.listeRecettes.put(r.nomRecette,r);
		
		switch(r.getTypeRC()){
		case "Entrée":
			listeEntree.add(r);
			break;
		case "Plat":
			listePlat.add(r);
			break;
		case "Dessert":
			listeDessert.add(r);
			break;
		}
		triParCategorie.put("Entrée", listeEntree);
		triParCategorie.put("Plat", listePlat);
		triParCategorie.put("Dessert", listeDessert);
		
		saveRecettes();
		
	}
	
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
	
	public void saveRecettes() {
        XMLEncoder encoder=null;
        try {
            FileOutputStream fos = new FileOutputStream(recetteXML);
            BufferedOutputStream bos= new BufferedOutputStream(fos);
            encoder=new XMLEncoder(bos);
            encoder.writeObject(this.listeRecettes);
            encoder.flush();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            if (encoder != null) encoder.close();
        }
    }
	public void lireRecettes() {
		ArrayList<Recette> listeR = new ArrayList<>();
		for(String rec : this.listeRecettes.keySet()){
			listeR.add(this.listeRecettes.get(rec));
		}
		envoiInformation(listeR);
	}
	public void donnelarecette(String Str) {
		Recette r=listeRecettes.get(Str);
		envoiInformationdelarecette(r);
	}
	
	public void envoiInformation(ArrayList<Recette> l) {
		this.setChanged();
		this.notifyObservers(l);
	}
	public void envoiInformationdelarecette(Recette l) {
		this.setChanged();
		this.notifyObservers(l);
	}
	public void saveNote(String text,String name) {
		// TODO Auto-generated method stub
		this.listeRecettes.get(name).ajouterNotes(text);
		saveRecettes();
		
	}
	public void searchCategorie(String nameR, String catR) {
		ArrayList<Recette> arrayRec = new ArrayList<>();
		ArrayList<Recette> temp = new ArrayList<>();
		switch(catR) {
		case "Toutes":
			for(String rec : this.listeRecettes.keySet()){
				if((rec.toLowerCase()).contains(nameR.toLowerCase())) {
					arrayRec.add(this.listeRecettes.get(rec));
				}
			}
			break;
		case "Entrées":
			for(String rec : this.triParCategorie.keySet()){
				if(rec == "Entrée") {
					temp = this.triParCategorie.get(rec);
				}
			}
			for(int i=0;i<temp.size();i++) {
				if(((temp.get(i).getNomRecette()).toLowerCase()).contains(nameR.toLowerCase())) {
					arrayRec.add(temp.get(i));
				}
			}
			break;
		case "Plats":
			for(String rec : this.triParCategorie.keySet()){
				if(rec == "Plat") {
					temp = this.triParCategorie.get(rec);
				}
			}
			for(int i=0;i<temp.size();i++) {
				if(((temp.get(i).getNomRecette()).toLowerCase()).contains(nameR.toLowerCase())) {
					arrayRec.add(temp.get(i));
				}
			}
			break;
		case "Desserts":
			for(String rec : this.triParCategorie.keySet()){
				if(rec == "Dessert") {
					temp = this.triParCategorie.get(rec);
				}
			}
			for(int i=0;i<temp.size();i++) {
				if(((temp.get(i).getNomRecette()).toLowerCase()).contains(nameR.toLowerCase())) {
					arrayRec.add(temp.get(i));
				}
			}
			break;
		case "Ingrédient":
			for(String rec : this.listeRecettes.keySet()){
				Recette recSel = this.listeRecettes.get(rec);
				for(int j=0;j<recSel.getListIngredient().size();j++) {
					if(((recSel.getListIngredient().get(j)).toLowerCase()).contains(nameR.toLowerCase())) {
						arrayRec.add(this.listeRecettes.get(rec));
					}
				}
			}
			break;
		}
		envoiInformation(arrayRec);
	}
	public void searchCategorie(String catR) {
		ArrayList<Recette> arrayRec = new ArrayList<>();
		switch(catR.toString()) {
		case "Toutes":
			for(String rec : this.listeRecettes.keySet()){
				arrayRec.add(this.listeRecettes.get(rec));
			}
			break;
		case "Entrées":
			for(String rec : this.triParCategorie.keySet()){
				if(rec == "Entrée") {
					arrayRec = this.triParCategorie.get(rec);
				}
			}
			break;
		case "Plats":
			for(String rec : this.triParCategorie.keySet()){
				if(rec == "Plat") {
					arrayRec = this.triParCategorie.get(rec);
				}
			}
			break;
		case "Desserts":
			for(String rec : this.triParCategorie.keySet()){
				if(rec == "Dessert") {
					arrayRec = this.triParCategorie.get(rec);
				}
			}
			break;
		}
		envoiInformation(arrayRec);
	}

}
