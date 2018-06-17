package essai;
import couleur.CouleurAleatoire;
import couleur.CouleurPalettes;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import menu.MenuAPropos;
import menu.MenuAide;
import modele.GenerateurDeCouleurs;

public class LancerAppFX extends Application {
	private BorderPane border;
	private CouleurPalettes cp = new CouleurPalettes();
	private CouleurAleatoire ca = new CouleurAleatoire();
	private GenerateurDeCouleurs generateur =  new GenerateurDeCouleurs();

	/**
	 * Méthode Start
	 */
	public void start(Stage stage)
	{
		Pane root = new Pane();
		border = new BorderPane();

		/*
		  Agencement de la barre horizontale en haut
		 */
		border.setTop(getMenu());
		/*
		  Agencement du menu vertical en-dessous
		 */
		border.setLeft(topToolbar(new Label("Bienvenue et merci d'utiliser notre logiciel")));

		/*
		  Ajout des noeuds à la fenêtre
		 */
        root.getChildren().addAll(border);
		Scene scene = new Scene(root, 780, 610);
		stage.setTitle("Interface d’optimisation du choix de couleurs");
		stage.getIcons().add(new Image("file:AppIcon.png"));
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Barre horizontale affichant le nom de l'application ainsi qu'un bouton A propos
	 */
	private VBox topToolbar(Label labelOption) {
		String nomApp = "Interface d’optimisation du choix de couleurs";

		/*
		  Création de la barre
		 */
        VBox box = new VBox();
        box.setPadding(new Insets(10, 770, 10, 210));
		box.setStyle("-fx-background-color: #ffffff;");
        box.setAlignment(Pos.CENTER);

		/*
		  Déclaration d'un label contenant le nom de l'application
		 */
        Label labelNom = new Label(nomApp);
		labelNom.setFont(Font.font("Verdana", 16));
		labelNom.setTextAlignment(TextAlignment.CENTER);

		/*
		  Retour chariot
		 */
		 Label labelRetour = new Label("\n");

		/*
		  Ajout des labels au noeud
		 */
        box.getChildren().add(labelNom);
        box.getChildren().add(labelRetour);
        box.getChildren().add(labelOption);

	    return box;
	}

	private MenuBar getMenu() {
		MenuBar menuBar = new MenuBar();
		MenuAide ma = new MenuAide();
		MenuAPropos map = new MenuAPropos();

		Menu menuFile = new Menu("Fichier");
		MenuItem generer = new MenuItem("Générer des couleurs");
        generer.setOnAction(e -> {
			border.setLeft(topToolbar(new Label("Couleurs aléatoires : cliquez pour copier !")));
			border.setBottom(ca.palettesDeCouleursAleatoires(generateur));
        });
		MenuItem choisir = new MenuItem("Choisir des couleurs");
        choisir.setOnAction(e -> {
			border.setLeft(topToolbar(new Label("Couleurs à définir : cliquez pour copier !")));
			border.setBottom(cp.palettesDeCouleursChoisies());
        });
		MenuItem accueil = new MenuItem("Retour à l'accueil");
        accueil.setOnAction(e -> {
			border.setLeft(topToolbar(new Label("Bienvenue et merci d'utiliser notre logiciel")));
			border.setBottom(null);
        });
		MenuItem quitter = new MenuItem("Quitter");
        quitter.setOnAction(e -> System.exit(0));

        menuFile.getItems().add(generer);
        menuFile.getItems().add(choisir);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(accueil);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(quitter);

		Menu menuEdit = new Menu("Aide");
		MenuItem aideGenerer = new MenuItem("Générer des couleurs");
        aideGenerer.setOnAction(e -> {
			border.setLeft(topToolbar(new Label("Utiliser les couleurs générées")));
			border.setBottom(ma.getGenerer());
        });
		MenuItem aideChoisir = new MenuItem("Choisir des couleurs");
        aideChoisir.setOnAction(e -> {
			border.setLeft(topToolbar(new Label("Utiliser les couleurs avec la palette")));
			border.setBottom(ma.getChoisir());
        });
		MenuItem aideAPropos = new MenuItem("À propos");
        aideAPropos.setOnAction(e -> {
			border.setLeft(topToolbar(new Label("Version stable - 1.0")));
			border.setBottom(map.showAPropos());
        });

        menuEdit.getItems().add(aideGenerer);
        menuEdit.getItems().add(aideChoisir);
        menuEdit.getItems().add(new SeparatorMenuItem());
        menuEdit.getItems().add(aideAPropos);

		menuBar.getMenus().addAll(menuFile, menuEdit);

		return menuBar;
	}

    /**
     * Méthode Main
     */
    public static void main(String[] args) {
        launch(args);
    }
}