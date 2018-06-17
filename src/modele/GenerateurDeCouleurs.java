package modele;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     *
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
     *
     * @param nbCouleurs
     */
    public void genererEchantillon(int nbCouleurs) {
        Color couleur;
        int borneA = 5;
        int borneB = 20;
        couleurs.clear();

        while (couleurs.size() < nbCouleurs) {
            couleur = this.genererCouleur();

            if (valeurNiveauGris(couleur) >= borneA && valeurNiveauGris(couleur) <= borneB) {
                couleurs.add(couleur);
                borneA += 25.00;
                borneB += 25.00;
            }
        }
    }

    public double valeurNiveauGris(Color couleur) {
        //System.out.println(Math.toIntExact(Math.round(couleur.grayscale().getRed() * 255)));
        return couleur.grayscale().getRed() * 255;
    }

    /**
     * Fonction de trie de l'arrayList de couleurs, elles sont triées selon leur valeur en niveau de gris
     */
    public void trier() {
        couleurs.sort((c1, c2) -> c1.grayscale().toString().compareTo(c2.grayscale().toString()));
    }

    /**
     * Méthode qui retourne l'ArrayList de couleurs
     *
     * @return ArrayList de Color
     */
    public ArrayList<Color> getCouleurs() {
        return couleurs;
    }
}