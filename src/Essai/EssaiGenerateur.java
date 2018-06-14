package Essai;

import javafx.scene.paint.Color;
import modele.GenerateurDeCouleurs;

public class EssaiGenerateur {

    public static void main(String[] args) {
        GenerateurDeCouleurs generateur =  new GenerateurDeCouleurs();

        generateur.genererEchantillon(5);

        for(Color color : generateur.getCouleurs()) {
            System.out.println(color.grayscale());
        }
    }
}
