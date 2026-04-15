package serie5;

import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexTest {

    @Test
    public void testComplexSquare() {
        Complex onlyReal = new Complex(1,0);
        Complex onlyImagine = new Complex(0,1);
        Complex both = new Complex(1,1);
        assertEquals(-1.0, onlyImagine.square().real());
        assertEquals(1.0, onlyReal.square().real());
        assertEquals(0.0, both.square().real());
        assertEquals(2, both.square().imagine());
    }

    @Test
    public void testComplexAddition() {
        Complex onlyReal = new Complex(1,0);
        Complex onlyImagine = new Complex(0,1);
        Complex both = new Complex(1,1);
        Complex bothOneNeg = new Complex(1, -1);
        assertEquals(1.0, onlyReal.add(onlyImagine).real());
        assertEquals(1.0, onlyReal.add(onlyImagine).imagine());
        assertEquals(2.0, onlyReal.add(onlyImagine).add(both).real());
        assertEquals(2.0, onlyReal.add(onlyImagine).add(both).imagine());
        assertEquals(2.0, both.add(bothOneNeg).real());
        assertEquals(0.0, both.add(bothOneNeg).imagine());
    }

    @Test
    public void testComplexModule() {
        Complex onlyReal = new Complex(1,0);
        Complex onlyImagine = new Complex(0,1);
        Complex both = new Complex(1,1);
        Complex bothOneNeg = new Complex(1, -1);
        assertEquals(1.0, onlyReal.module());
        assertEquals(1.0, onlyImagine.module());
        assertEquals(sqrt(2), both.module());
        assertEquals(sqrt(2), bothOneNeg.module());
    }

}
