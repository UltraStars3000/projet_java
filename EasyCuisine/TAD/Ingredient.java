package TAD;

public class Ingredient {

	private int quantite;
	private String nomIngredient;
	private String unite;
	
	public Ingredient(String nomIngredient, int quantite, String unite) {
		this.quantite = quantite;
		this.nomIngredient = nomIngredient;
		this.unite = unite;
	}
	
	public String getNomIngredient() {
		return nomIngredient;
	}
	
	public int getQuantiteIngredient() {
		return quantite;
	}
	
	public String getUniteIngredient() {
		return unite;
	}
	
	public String toString() {
		return getNomIngredient() + "Quantité:\n" + getQuantiteIngredient() + getUniteIngredient();
	}
}
