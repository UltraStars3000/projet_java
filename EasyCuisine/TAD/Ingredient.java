package TAD;

public class Ingredient {

	
	
	private String quantite;
	private String nomIngredient;
	private String unite;
	
	
	public Ingredient(String nomIngredient, String quantite, String unite) {
		this.quantite = quantite;
		this.nomIngredient = nomIngredient;
		this.unite = unite;
	}
	
	public String getNomIngredient() {
		return nomIngredient;
	}
	
	public String getQuantiteIngredient() {
		return quantite;
	}
	
	public String getUniteIngredient() {
		return unite;
	}
	
	public String toString() {
		return "Quantité de "+ getNomIngredient() + " :\n" + getQuantiteIngredient() + getUniteIngredient();
	}
	

}
