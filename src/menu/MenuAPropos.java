package menu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuAPropos {
	/**
	 * Création d'une fenêtre affichant les auteurs
	 */
    public VBox showAPropos() {
		String projet = "Projet de S2 : IHM\n\n";
		String auteurs = "\nBilal RABBOUJ\nMickaël SPILMONT\nOmar DIALLO\nMohammed Amine BENNACER";

		/*
		  Création du contenu
		 */
        VBox box = new VBox();
        box.setPadding(new Insets(10, 0, 0, 10));
        box.setAlignment(Pos.CENTER_LEFT);

        Label labelProjet = new Label(projet);
        Label labelA = new Label("Auteurs");
        Label labelAuteurs = new Label(auteurs);

		/*
		  Ajout des labels au noeud
		 */
        box.getChildren().add(labelProjet);
        box.getChildren().add(labelA);
        box.getChildren().add(labelAuteurs);

		return box;
    }
}