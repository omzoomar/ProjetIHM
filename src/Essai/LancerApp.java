package Essai;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import modele.GenerateurDeCouleurs;

import java.util.ArrayList;
import java.util.List;

public class LancerApp extends Application {
	/**
	 * Méthode Start
	 */
	public void start(Stage stage)
	{
		Pane root = new Pane();
		BorderPane border = new BorderPane();

		/**
		 * Agencement de la barre horizontale en haut
		 */
		border.setTop(topToolbar());
		/**
		 * Agencement du menu vertical en-dessous
		 */
		border.setLeft(palettesDeCouleurs());

		/**
		 * Ajout des noeuds à la fenêtre
		 */
        root.getChildren().addAll(border);
		Scene scene = new Scene(root, 770, 550);
		stage.setTitle("Interface d’optimisation du choix de couleurs");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Barre horizontale affichant le nom de l'application ainsi qu'un bouton A propos
	 */
	public VBox topToolbar() {
		String nomApp = "Interface d’optimisation du choix de couleurs";
        Stage stage = new Stage();

		/**
		 * Création de la barre
		 */
        VBox box = new VBox();
        box.setPadding(new Insets(10, 770, 10, 210));
		box.setStyle("-fx-background-color: #ffffff;");
        box.setAlignment(Pos.CENTER);

		/**
		 * Déclaration d'un label contenant le nom de l'application
		 */
        Label labelNom = new Label(nomApp);
		labelNom.setFont(Font.font("Verdana", 16));
		labelNom.setTextAlignment(TextAlignment.CENTER);

		/**
		 * Retour chariot
		 */
		 Label labelRetour = new Label("\n");

		/**
		 * Déclaration d'un bouton pour afficher les informations A Propos
		 */
        Button btnAPropos = new Button();
        btnAPropos.setText("À propos");

		/**
		 * Action à l'appui sur le bouton
		 */
        btnAPropos.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
				showAPropos();
                stage.close();
            }
        });

		/**
		 * Ajout des labels au noeud
		 */
        box.getChildren().add(labelNom);
        box.getChildren().add(labelRetour);
        box.getChildren().add(btnAPropos);

	    return box;
	}

	/**
	 * Méthode retournant toutes les palettes de couleurs
	 */
	public VBox palettesDeCouleurs() {
		/**
		 * Création du contenu
		 */
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 0, 20, 10));
	    vbox.setSpacing(8);
        vbox.setAlignment(Pos.CENTER);

		/**
		 * Création d'une ArrayList contenant les palettes de couleurs
		 */
		List<HBox> box = new ArrayList<>();
	    for(int i=0;i<5;i++)
	       box.add(addCouleur());

		/**
		 * Ajout de chaque palette au contenu
		 */
	    for(int i=0;i<5;i++)
	        vbox.getChildren().addAll(box.get(i));

	    return vbox;
	}

	/**
	 * Affichage d'une palette, de la couleur, du niveau de gris et du RGB correspondant
	 */
	public HBox addCouleur() {
		ColorPicker colorPicker = new ColorPicker();
		Color couleur = colorPicker.getValue();

		/**
		 * Création d'une barre horizontale
		 */
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(5));
	    hbox.setSpacing(8);
	    hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setStyle("-fx-border-style: none none solid none; -fx-border-width: 1; -fx-border-color: #cfc6ca;");

		/**
		 * Création d'un rectangle affichant la couleur et d'un rectangle affichant le niveau de gris correspondant
		 */
		Rectangle recColor = new Rectangle(200, 25);
		Rectangle recGray = new Rectangle(200, 25);

		/**
		 * Création d'un texte affichant le RGB de la couleur correspondante
		 */
	    Text titleRGB = new Text("R : "+Math.round(couleur.getRed()*255)
	        +" G : "+Math.round(couleur.getGreen()*255)
	        +" B : "+Math.round(couleur.getBlue()*255));
	    titleRGB.setFont(Font.font("Verdana", 14));

		/**
		 * Création d'un texte affichant le RGB de la couleur correspondante
		 */
	    Text titleHSB = new Text("R : "+Math.round(couleur.getRed()*255)
	        +" G : "+Math.round(couleur.getGreen()*255)
	        +" B : "+Math.round(couleur.getBlue()*255));
	    titleHSB.setFont(Font.font("Verdana", 14));

        GenerateurDeCouleurs generateur =  new GenerateurDeCouleurs();

        generateur.genererEchantillon(5);

        for(Color color : generateur.getCouleurs()) {
//            System.out.println(color.grayscale());
			recColor.setFill(color);
			recGray.setFill(color.grayscale());
        }

		/**
		 * Attribution de la couleur
		 */
//		recColor.setFill(couleur);
//		recGray.setFill(couleur.grayscale());

		/**
		 * Action au changement de couleur
		 */
		changerCouleur(colorPicker, titleRGB, titleHSB, recColor, recGray);

		/**
		 * Ajout des éléments au noeud
		 */
//	    hbox.getChildren().addAll(colorPicker, recColor, recGray, titleRGB, titleHSB);
	    hbox.getChildren().addAll(recColor, recGray);

		return hbox;
	}

	/**
	 * Méthode permettant d'actualiser l'affichage en fonction du changement de couleur
	 */
	public void changerCouleur(ColorPicker color, Text titleRGB, Text titleHSB, Rectangle recColor, Rectangle recGray) {
		color.setOnAction(new EventHandler() {
            public void handle(Event t) {
				titleRGB.setText("R : "+Math.round(color.getValue().getRed()*255)
			        +" G : "+Math.round(color.getValue().getGreen()*255)
	                +" B : "+Math.round(color.getValue().getBlue()*255));
           		recColor.setFill(color.getValue());
           		recGray.setFill(color.getValue().grayscale());
            }
        });
	}

	/**
	 * Création d'une fenêtre affichant les auteurs
	 */
    public void showAPropos() {
		String projet = "Projet de S2 : IHM\n\n";
		String auteurs = "\nBilal RABBOUJ\nMickaël SPILMONT\nOmar DIALLO\nMohammed Amine BENNACER";
        Stage stage = new Stage();

		/**
		 * Création du contenu
		 */
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);

        Label labelProjet = new Label(projet);
        Label labelA = new Label("Auteurs");
        Label labelAuteurs = new Label(auteurs);

		/**
		 * Ajout des labels au noeud
		 */
        box.getChildren().add(labelProjet);
        box.getChildren().add(labelA);
        box.getChildren().add(labelAuteurs);
        Scene scene = new Scene(box, 250, 150);
		stage.setTitle("À propos");
        stage.setScene(scene);
        stage.show();
    }

//	/**
//	 * Création d'une fenêtre affichant les auteurs
//	 */
//    public void showTuto() {
//		String titre = "Fonctionnement de l'application\n\n";
//		String tuto = "\nChoisir plusieurs couleurs\nComparer leurs niveaux de gris\nRécupérer leur valeur RGB";
//        Stage stage = new Stage();
//
//		/**
//		 * Création du contenu
//		 */
//        VBox box = new VBox();
//        box.setPadding(new Insets(10));
//        box.setAlignment(Pos.CENTER);
//
//        Label labelTitre = new Label(titre);
////        Label label1 = new Label("Auteurs");
//        Label labelTuto = new Label(tuto);
//
//		/**
//		 * Ajout des labels au noeud
//		 */
//        box.getChildren().add(labelTitre);
////        box.getChildren().add(label1);
//        box.getChildren().add(labelTuto);
//        Scene scene = new Scene(box, 250, 150);
//		stage.setTitle("Fonctionnement de l'application");
//        stage.setScene(scene);
//        stage.show();
//    }

    /**
     * Méthode Main
     */
    public static void main(String[] args) {
        launch(args);
    }
}