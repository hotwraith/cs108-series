package serie6;

public class Transpose implements TextImage {
    TextImage original;

    public Transpose(TextImage original) {
        this.original = original;
    }


    @Override
    public int width() {
        return this.original.height();
    }

    @Override
    public int height() {
        return this.original.width();
    }

    @Override
    public char charAt(int x, int y) {
        return this.original.charAt(y, x);
    }
}
