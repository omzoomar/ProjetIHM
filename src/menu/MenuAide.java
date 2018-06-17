package menu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuAide {
	public VBox getGenerer() {
		String aide1 = "Les couleurs sont générées aléatoirement en utilisant un algorithme de tri.\n\n";
		String aide2 = "Vous pouvez générer une gamme de couleurs à l'infini en utilisant le menu :";
		String aide3 = "Fichier > Générer des couleurs\n\n\n";
		String aide4 = "Pour copier le code d'une couleur, cliquez dessus !";

		/*
		  Création du contenu
		 */
        VBox box = new VBox();
        box.setPadding(new Insets(10, 0, 0, 10));
        box.setAlignment(Pos.CENTER_LEFT);

        Label labelaide1 = new Label(aide1);
        Label labelaide2 = new Label(aide2);
        Label labelaide3 = new Label(aide3);
		labelaide3.setPadding(new Insets(0, 0, 0, 20));
		labelaide3.setStyle("-fx-font-weight:bold");
        Label labelaide4 = new Label(aide4);
        labelaide4.setTextFill(Color.BLUE);
        labelaide4.setFont(Font.font(13));
		labelaide4.setStyle("-fx-font-weight:bold");

		/*
		  Ajout des labels au noeud
		 */
        box.getChildren().add(labelaide1);
        box.getChildren().add(labelaide2);
        box.getChildren().add(labelaide3);
        box.getChildren().add(labelaide4);

		return box;
	}

	public VBox getChoisir() {
		String aide1 = "Les palettes de couleurs sont affichées en utilisant l'outil ColorPicker, qui fournit une " +
		 "gestion complète du choix de couleur.\n";
		String aide2 = "Vous pouvez combiner une infinité de couleurs qui ne vous sont pas imposées !\n\n";
		String aide3 = "Vous pouvez choisir des couleurs à l'infini en utilisant le menu :";
		String aide4 = "Fichier > Choisir des couleurs\n\n\n";
		String aide5 = "Pour copier le code d'une couleur, cliquez dessus !";

		/*
		  Création du contenu
		 */
        VBox box = new VBox();
        box.setPadding(new Insets(10, 0, 0, 10));
        box.setAlignment(Pos.CENTER_LEFT);

        Label labelaide1 = new Label(aide1);
        Label labelaide2 = new Label(aide2);
        Label labelaide3 = new Label(aide3);
        Label labelaide4 = new Label(aide4);
		labelaide4.setPadding(new Insets(0, 0, 0, 20));
		labelaide4.setStyle("-fx-font-weight:bold");
        Label labelaide5 = new Label(aide5);
        labelaide5.setTextFill(Color.BLUE);
        labelaide5.setFont(Font.font(13));
		labelaide5.setStyle("-fx-font-weight:bold");

		/*
		  Ajout des labels au noeud
		 */
        box.getChildren().add(labelaide1);
        box.getChildren().add(labelaide2);
        box.getChildren().add(labelaide3);
        box.getChildren().add(labelaide4);
        box.getChildren().add(labelaide5);

		return box;
	}
}