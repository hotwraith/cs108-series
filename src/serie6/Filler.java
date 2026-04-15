package serie6;

public class Filler implements TextImage {
    private int width, height;
    private char cFill;

    public Filler(int width, int height, char c) {
        this.width = width;
        this.height = height;
        this.cFill = c;
    }

    @Override
    public int width() {
        return this.width;
    }

    @Override
    public int height() {
        return this.height;
    }

    @Override
    public char charAt(int x, int y) {
        return cFill;
    }
}
