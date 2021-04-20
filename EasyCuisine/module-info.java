module CuisineApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires junit;
	requires org.junit.jupiter.api;

	//dévlarer tous les packages ici
	opens Controleur to javafx.graphics, javafx.fxml;
	opens TAD to javafx.graphics, javafx.fxml;
	opens Visualiseur to javafx.graphics, javafx.fxml;
}
