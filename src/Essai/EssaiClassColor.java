package Essai;

import javafx.scene.paint.Color;

public class EssaiClassColor {

    public static void main(String[] args) {
        Color couleur1 = Color.rgb(10, 230, 128);
        Color couleur2 = couleur1.grayscale();

        Integer grayValue = Math.round((float)(couleur1.grayscale().getRed()));

        for (int i = 25 ; i <= 255; i += 25) {
            System.out.println(i);
        }

        System.out.println(Integer.toHexString(255));
    }
}
