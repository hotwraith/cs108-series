package serie6;

public class FromString implements TextImage {
    private String internalStr;

    public FromString(String internalStr) {
        this.internalStr = internalStr;
    }


    @Override
    public int width() {
        return internalStr.length();
    }

    @Override
    public int height() {
        return 1;
    }

    @Override
    public char charAt(int x, int y) {
        if(x < 0 || y < 0 || x >= width() || y >= height()) throw new IllegalArgumentException();
        return internalStr.charAt(x+y*width());
    }
}
