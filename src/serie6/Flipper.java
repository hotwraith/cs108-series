package serie6;

public class Flipper implements TextImage {
    TextImage original;

    public Flipper(TextImage original) {
        this.original = original;
    }


    @Override
    public int width() {
        return this.original.width();
    }

    @Override
    public int height() {
        return this.original.height();
    }

    @Override
    public char charAt(int x, int y) {
        return this.original.charAt(width()-1-x, y);
    }
}
