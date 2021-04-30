package TAD;

import java.io.Serializable;

public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String quantite;
	private String nomIngredient;
	private String unite;
	
	public Ingredient() {}
	public Ingredient(String nomIngredient, String quantite,  String unite) {
		this.quantite = quantite;
		this.nomIngredient = nomIngredient;
		this.unite = unite;
	}
	

	
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public String getNomIngredient() {
		return nomIngredient;
	}
	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	public String toString() {
		return "Quantité de "+ getNomIngredient() + " :" + getQuantite() +" "+ getUnite();
	}
	

}
