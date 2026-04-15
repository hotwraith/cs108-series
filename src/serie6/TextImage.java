package serie6;

import java.io.PrintStream;

public interface TextImage {
    int width();
    int height();
    char charAt(int x, int y);

    default void printOn(PrintStream stream) {
        for (var y = 0; y < height(); y += 1) {
            for (var x = 0; x < width(); x += 1)
                stream.print(charAt(x, y));
            stream.println();
        }
    }

    static FromString fromString(String s) {
        return new FromString(s);
    }

    static Filler filled(int width, int height, char c) {
        return new Filler(width, height, c);
    }

    default TextImage flippedHorizontally() {
        return new Flipper(this);
    }

    default TextImage transpose() {
        return new Transpose(this);
    }

    default TextImage leftOf(TextImage other) {
        return new LeftOf(this, other);
    }

    default TextImage above(TextImage other) {
        return new Above(this, other);
    }

}
