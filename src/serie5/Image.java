package serie5;

import java.awt.*;

import static java.lang.Math.*;

/**
 * Une image continue et infinie, représentée par une fonction associant une
 * valeur d'un type donné (p.ex. une couleur) à chaque point du plan.
 */

@FunctionalInterface
public interface Image<T> {

    public static final Image<ColorRGB> RED_DISK = (x,y) -> {
        double r = sqrt(x*x+y*y);
        return r <= 1d ? ColorRGB.RED : ColorRGB.WHITE;
    };

    public static final Image<Double> HORI_GRAD_MASK = (x, y) -> max(0, min((x + 1d) / 2d, 1d));

    T apply(double x, double y);

    public static Image<ColorRGB> chessBoard(ColorRGB c1, ColorRGB c2, double w) {
        if(!(w>0)) throw new IllegalArgumentException();
        return (x, y) -> {
            int sqX = (int)floor(x / w), sqY = (int)floor(y / w);
            return (sqX + sqY) % 2 == 0 ? c1 : c2;
        };
    }

    public static Image<ColorRGB> composed(Image<ColorRGB> bg, Image<ColorRGB> fg, Image<Double> mask) {
        return (x, y) -> bg.apply(x, y).mixWith(fg.apply(x, y), mask.apply(x, y));
    }

    public default Image<T> rotated(double angle) {
        double cosA = cos(-angle);
        double sinA = sin(-angle);
        return (x, y) -> {
            double x1 = x * cosA - y * sinA;
            double y1 = x * sinA + y * cosA;
            return this.apply(x1, y1);
        };
    }

    public static Image<Double> mandelbrot(int maxIt) {
        if(!(maxIt>0)) throw new IllegalArgumentException();
        return (x, y) -> {
            int ct = 0;
            Complex c = new Complex(x,y);
            Complex z = new Complex(0,0);
            while (z.moduleSquared() < 4d && ct < maxIt) {
                z = z.square().add(c);
                ct += 1;
            }
            //if(((double) ct)/((double) maxIt) > 1.0) System.out.println("here " +x+" "+ y + " "+ ct);
            return ((double) ct)/((double) maxIt);
        };
    }

    public static <T> Image<T> constant(T color) {
        return (x, y) -> color;
    }

}
