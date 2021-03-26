package TAD;

import org.junit.Before;
import org.junit.Test;

public class TestDicoRecette {

	Recette r;
	Dico d;

	@Before
	public void SetUp() {
		r = new Recette("Patate", "Patate cuite à l'eau", "Patate, Eau", "plop");
		r = new Recette("Patate", "Patate cuite à l'eau", "Patate, Eau", "plop");
		d = new Dico();
	}

	@Test
	public void AjouterRecette() {
		// d.ajouteRecette("Patate", r);
	}
	/*
	 * @Test public void rechercherRecette() throws Exception {
	 * d.ajouteRecette("Patate", r); System.out.println(d.getRecette("Patate")); }
	 * 
	 * @Test(expected = NullPointerException.class) public void rechercherRecett()
	 * throws Exception { d.getRecette("Poisson"); }
	 */
}