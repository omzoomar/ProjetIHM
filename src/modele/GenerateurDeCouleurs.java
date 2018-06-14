package modele;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Class qui génére des couleurs au hazard et les classe selon leur niveau de gris
 */
public class GenerateurDeCouleurs {
    ArrayList<Color> couleurs;
    Random random;

    /**
     * Constructeur
     */
    public GenerateurDeCouleurs() {
        couleurs = new ArrayList<>();
        random = new Random();
    }

    /**
     * Génére une couleur au hazard
     * @return Color
     */
    public Color genererCouleur() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return Color.rgb(r, g, b);
    }

    /**
     * Genere un nombre de couleur égale à l'entier passé en paramètre, ces couleurs sont contenues dans une ArrayList
     * et selons leur rendu en niveau de gris
     * @param nbCouleurs
     */
    public void genererEchantillon(int nbCouleurs) {
        couleurs.clear();
        int j;
        Color couleur = genererCouleur();

		for (int i = 0; i < nbCouleurs; i++) {
			couleurs.add(genererCouleur());
	        do {
	            j = 0;
		        for (int k=0;k<nbCouleurs;k++) {
		            if(couleurs.get(i) == couleur)
						j++;
		        }
	        } while(j != 0);
        }
        this.trier();
    }

    /**
     * Fonction de trie de l'arrayList de couleurs, elles sont triées selon leur valeur en niveau de gris
     */
    public void trier() {
        Collections.sort(couleurs, (c1, c2) -> Math.round((float) c1.grayscale().getRed() * 255) - Math.round((float) c2.grayscale().getRed() * 255));
    }

    /**
     * Méthode qui retourne l'ArrayList de couleurs
     * @return ArrayList de Color
     */
    public ArrayList<Color> getCouleurs() {
        return couleurs;
    }
}
