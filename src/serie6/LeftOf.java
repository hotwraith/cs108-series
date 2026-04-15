package serie6;

public class LeftOf implements TextImage {
    TextImage left, right;

    public LeftOf(TextImage left, TextImage right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int width() {
        return left.width() + right.width();
    }

    @Override
    public int height() {
        return Math.max(left.height(), right.height());
    }

    @Override
    public char charAt(int x, int y) {
        if (x < 0 | x > width() || y < 0 | y > height()) throw new IllegalArgumentException();
        if(x < left.width()) {
            if(y < left.height()) {
                return left.charAt(x, y);
            } else {
                return ' ';
            }
        } else {
            if(y < right.height()) {
                return right.charAt(x-left.width(), y);
            } else {
                return ' ';
            }
        }
    }
}
