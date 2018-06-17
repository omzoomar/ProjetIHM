package couleur;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.List;

public class CouleurPalettes {
	public VBox palettesDeCouleursChoisies() {
		/**
		 * Création du contenu
		 */
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 800, 20, 10));
	    vbox.setSpacing(8);
        vbox.setAlignment(Pos.CENTER);

		/**
		 * Création d'une ArrayList contenant les palettes de couleurs
		 */
		List<HBox> box = new ArrayList<>();
	    for(int i=0;i<10;i++)
	       box.add(addCouleur());

		/**
		 * Ajout de chaque palette au contenu
		 */
	    for(int i=0;i<10;i++)
	        vbox.getChildren().addAll(box.get(i));

	    return vbox;
	}

	/**
	 * Affichage d'une palette, de la couleur, du niveau de gris et du RGB correspondant
	 */
	public HBox addCouleur() {
		ColorPicker colorPicker = new ColorPicker();
		Color color = colorPicker.getValue();
		Rectangle recColor;
		Rectangle recGray;
		Text titleRGB = new Text();
		Text titleHSB = new Text();
		Text titleRGBHexa = new Text();
		Text titleHSBHexa = new Text();
		Clipboard clipboard = Clipboard.getSystemClipboard();
		ClipboardContent content = new ClipboardContent();
		Tooltip tooltip = new Tooltip();

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
		recColor = new Rectangle(230, 25);
		recGray = new Rectangle(230, 25);
		StackPane stackColor = new StackPane();
		StackPane stackGray = new StackPane();

		tooltip.setText("Code couleur copié !");

		recColor.setFill(color);
		recGray.setFill(color.grayscale());

	    titleRGB.setText("RGB : "+Math.round(color.getRed()*255)
	        +", "+Math.round(color.getGreen()*255)
	        +", "+Math.round(color.getBlue()*255));
	    titleRGBHexa.setText(color.toString().replace("0x","#").substring(0,7).toUpperCase());
        titleRGBHexa.setOnMouseClicked(e -> {
            content.putString(color.toString().replace("0x","#").substring(0,7).toUpperCase());
			clipboard.setContent(content);
			Tooltip.install(titleRGBHexa, tooltip);
        });

	    titleHSB.setText("HSB : "+Math.round(color.getHue())
	        +", "+Math.round(color.getSaturation()*255)
	        +", "+Math.round(color.getBrightness()*255));
	    titleHSBHexa.setText(color.grayscale().toString().replace("0x","#").substring(0,7).toUpperCase());
        titleHSBHexa.setOnMouseClicked(e -> {
            content.putString(color.grayscale().toString().replace("0x","#").substring(0,7).toUpperCase());
			clipboard.setContent(content);
			Tooltip.install(titleHSBHexa, tooltip);
        });

		VBox vboxTitle = new VBox();

	    titleRGB.setFont(Font.font("Verdana", 12));
	    titleRGB.setFill(Color.GREEN);

		titleHSB.setFont(Font.font("Verdana", 12));
		titleHSB.setFill(Color.RED);
		vboxTitle.getChildren().addAll(titleRGB, titleHSB);

		stackColor.getChildren().addAll(recColor, titleRGBHexa);
		stackGray.getChildren().addAll(recGray, titleHSBHexa);

		/**
		 * Action au changement de couleur
		 */
		changerCouleur(colorPicker, titleRGB, titleHSB, titleRGBHexa, titleHSBHexa, recColor, recGray, content,
		clipboard, tooltip);

		/**
		 * Ajout des éléments au noeud
		 */
	    hbox.getChildren().addAll(colorPicker, stackColor, stackGray, vboxTitle);

		return hbox;
	}

	/**
	 * Méthode permettant d'actualiser l'affichage en fonction du changement de couleur
	 */
	public void changerCouleur(ColorPicker color, Text titleRGB, Text titleHSB, Text titleRGBHexa, Text titleHSBHexa,
	Rectangle recColor, Rectangle recGray, ClipboardContent content, Clipboard clipboard, Tooltip tooltip) {
		color.setOnAction(e -> {
			recColor.setFill(color.getValue());
			recGray.setFill(color.getValue().grayscale());

		    titleRGB.setText("RGB : "+Math.round(color.getValue().getRed()*255)
		        +", "+Math.round(color.getValue().getGreen()*255)
		        +", "+Math.round(color.getValue().getBlue()*255));
		    titleRGBHexa.setText(color.getValue().toString().replace("0x","#").substring(0,7).toUpperCase());
	        titleRGBHexa.setOnMouseClicked(e1 -> {
	            content.putString(color.getValue().toString().replace("0x","#").substring(0,7).toUpperCase());
				clipboard.setContent(content);
				Tooltip.install(titleRGBHexa, tooltip);
	        });

		    titleHSB.setText("HSB : "+Math.round(color.getValue().getHue())
		        +", "+Math.round(color.getValue().getSaturation()*255)
		        +", "+Math.round(color.getValue().getBrightness()*255));
		    titleHSBHexa.setText(color.getValue().grayscale().toString().replace("0x","#").substring(0,7).toUpperCase());
	        titleHSBHexa.setOnMouseClicked(e2 -> {
	            content.putString(color.getValue().grayscale().toString().replace("0x","#").substring(0,7).toUpperCase());
				clipboard.setContent(content);
				Tooltip.install(titleHSBHexa, tooltip);
	        });
        });
	}
}