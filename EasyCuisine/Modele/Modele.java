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
import java.util.List;
import java.util.Observable;


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
	public void remplirRecettes() {
		XMLDecoder decoder = null;
		try {
			FileInputStream fis= new FileInputStream(recetteXML);
			BufferedInputStream bis= new BufferedInputStream(fis);
			decoder = new XMLDecoder(bis);
			ArrayList<Recette> listeEntree=new ArrayList<>();
			ArrayList<Recette> listePlat=new ArrayList<>();
			ArrayList<Recette> listeDessert=new ArrayList<>();
			this.listeRecettes=(HashMap<String, Recette>) decoder.readObject();
			
			
		}catch(Exception e) {
			System.out.println("Pas de recette disponible");
		}finally {
			if (decoder != null) decoder.close();
		}
	}

	public void ajouteRecette(String nomR, String tempsPrep, String ingre, String etapePrep, String pathImage, String typeR) throws IOException {
		//On sépare la quant, nomI, unit, pour la classe Ingredient
		ArrayList<Ingredient> listIngr = new ArrayList<Ingredient>();
		Ingredient ingr;
		String quant = "";
		String nomI = "";
		String unit = "";
		int cpt=0;
		for (String s : ingre.split("\n")) {
			for (String s2 : s.split(" ")) {

				if(cpt<2) {
					cpt+=1;
				}else {
					cpt=0;
				}
				switch(cpt){
				case 0:
					nomI=s2;
					break;
				case 1:
					quant=s2;
					break;
				case 2:
					unit=s2;
					break;
				}
			}
			ingr = new Ingredient(nomI, unit,quant );

			listIngr.add(ingr);
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
		System.out.println(listeRecettes);
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

}
