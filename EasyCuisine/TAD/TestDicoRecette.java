package TAD;

import org.junit.Before;
import org.junit.Test;

public class TestDicoRecette {

	Recette r;
	Dico d;

	private String[] ingredient0 = { "1 sachet pépites de chocolas", "500g farine" };
	private String[] preparation0 = {
			"Etape 1: Délayez la levure dans deux cuillerées à soupe d'eau tiède puis ajoutez le restant d'eau.",
			"Etape 2: Versez la farine et le sel dans un saladier, ajoutez le lait puis la levure délayée dans l'eau. Pétrissez énergiquement la pâte pendant 5 minutes (utilisez un robot si vous en possédez un)." };

	@Before
	public void SetUp() {
		d = new Dico();
	}

	@Test
	public void AjouterRecette() {
		r = new Recette("Brioche moelleuse aux pépites de chocolat", "Brioche moelleuse aux pépites de chocolat", ingredient0, preparation0);
		System.out.println(r.toString());
	}
	/*
	 * @Test public void rechercherRecette() throws Exception {
	 * d.ajouteRecette("Patate", r); System.out.println(d.getRecette("Patate")); }
	 * 
	 * @Test(expected = NullPointerException.class) public void rechercherRecett()
	 * throws Exception { d.getRecette("Poisson"); }
	 */
}