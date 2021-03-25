package polynomials;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {

    @Test
    public void toStringTest() {
        Polynomial p1 = new Polynomial("3.0 1 2 3 6 7");
        Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");

        assertEquals("3.000000x + 2.000000x^3 + 6.000000x^7 ", p1.toString());
        assertEquals("4.000000x + 3.000000x^3 + 5.000000x^4 ", p2.toString());
    }

    @Test
    public void plusTest() {
        Polynomial p1 = new Polynomial("3.0 1 2 3 6 7");
        Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");

        p1.plus(p2);

        assertEquals(p1.toString(), "7.000000x + 5.000000x^3 + 6.000000x^7 + 5.000000x^4 ");
    }

    @Test
    public void minusTest() {
        Polynomial p1 = new Polynomial("3.0 1 2 3 6 7");
        Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");

        p1.minus(p2);

        assertEquals(p1.toString(), "-1.000000x -1.000000x^3 + 6.000000x^7 -5.000000x^4 ");
    }

    @Test
    public void timesTest() {
        Polynomial p1 = new Polynomial("3.0 1 2 3 6 7");
        Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");

        p1.times(p2);

        assertEquals(p1.toString(), "-1.000000x -1.000000x^3 + 6.000000x^7 -5.000000x^4 ");

    }

    @Test
    public void evaluateTest() {
        // TODO: add Test methods

    }

    @Test
    public void edgecaseTest() {
        // TODO: add Test methods
    }

    @Test
    public void timesSelfTest() {
        // TODO: add Test methods
    }

    @Test
    public void communativityTest() {
        // TODO: add Test methods
    }

    @Test
    public void associativityTest() {
        // TODO: add Test methods
    }

    @Test
    public void distributivityTest() {
        // TODO: add Test methods
    }

}
