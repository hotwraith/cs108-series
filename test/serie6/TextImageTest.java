package serie6;

import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TextImageTest {

    @Test
    public void textImageTestCharAt() {
        TextImage test = new FromString("les sanglots longs");
        assertEquals('s', test.charAt(4,0));
        assertThrows(IllegalArgumentException.class, () -> test.charAt(0,1));
    }
}
