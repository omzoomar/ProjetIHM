package essai;

import javafx.scene.paint.Color;
import modele.GenerateurDeCouleurs;

public class EssaiGenerateur {

    public static void main(String[] args) {
        GenerateurDeCouleurs generateur =  new GenerateurDeCouleurs();

        generateur.genererEchantillon(10);

        for(Color color : generateur.getCouleurs()) {
            System.out.println(color.grayscale());
        }
    }
}
