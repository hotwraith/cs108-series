package serie6;

public class Above implements TextImage {
    TextImage above, under;

    public Above(TextImage above, TextImage under) {
        this.above = above;
        this.under = under;
    }

    @Override
    public int width() {
        return Math.max(above.width(), under.width());
    }

    @Override
    public int height() {
        return above.height() + under.height();
    }

    @Override
    public char charAt(int x, int y) {
        if (x < 0 | x > width() || y < 0 | y > height()) throw new IllegalArgumentException();
        if(y < above.height()) {
            if(x < above.width()) {
                return above.charAt(x, y);
            } else return ' ';
        } else {
            if(x < under.width()) {
                return under.charAt(x, y);
            } else return ' ';
        }
    }
}
