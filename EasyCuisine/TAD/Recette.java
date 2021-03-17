package TAD;

public class Recette {
	
	private String nomRecette;
	private String descriptionRecette;
	private String ingrediant;
	private String preparation;
	//private Image img;
	
	public Recette(String recette, String description, String ingrediant, String preparation) {
		this.nomRecette = recette;
		this.descriptionRecette = description;
		this.ingrediant = ingrediant;
		this.preparation = preparation;
	}
	
	public String getNomRecette() {
		return nomRecette;
	}

	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	public String getDescriptionRecette() {
		return descriptionRecette;
	}

	public void setDescriptionRecette(String descriptionRecette) {
		this.descriptionRecette = descriptionRecette;
	}

	public String getIngrediant() {
		return ingrediant;
	}

	public void setIngrediant(String ingrediant) {
		this.ingrediant = ingrediant;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}
	
}
