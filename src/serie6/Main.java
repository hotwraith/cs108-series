package serie6;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Thread.sleep;
import static javax.swing.SwingUtilities.invokeLater;

public final class Main {
    public static void main(String[] args) {
        // Permet d'obtenir l'image 20x1 :
        // La malade pédala mal
        TextImage.fromString("La malade pédala mal").printOn(System.out);
        // Inverse
        TextImage.fromString("La malade pédala mal").flippedHorizontally().printOn(System.out);
        // Transpose
        TextImage.fromString("La malade pédala mal").transpose().printOn(System.out);

        // Permet d'obtenir l'image 3x2 :
        // ***
        // ***
        TextImage.filled(3, 2, '*').printOn(System.out);
        TextImage.filled(3, 2, '*').flippedHorizontally().printOn(System.out);
        TextImage.filled(3, 2, '*').transpose().printOn(System.out);

        TextImage.fromString("Un rectangle : ")
                .leftOf(TextImage.filled(3, 2, '#')).printOn(System.out);

        TextImage.filled(3, 2, '#')
                .leftOf(TextImage.fromString("Un rectangle : ")).printOn(System.out);

        TextImage.filled(3, 1, 'X')
                .above(TextImage.filled(4, 2, 'O')).printOn(System.out);

        TextImage.filled(4, 2, 'O')
                .above(TextImage.filled(3, 1, 'X')).printOn(System.out);
    }
}
