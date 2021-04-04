package polynomials;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {

    @Test
    public void toStringTest() {
        Polynomial p1 = new Polynomial("3.0 1 2 3 6 7");
        Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");

        assertEquals("6.000000x^7 + 2.000000x^3 + 3.000000x ", p1.toString());
        assertEquals("5.000000x^4 + 3.000000x^3 + 4.000000x ", p2.toString());
    }

    @Test
    public void plusTest() {
        Polynomial p1 = new Polynomial("3.0 1 2 3 6 7");
        Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");

        p1.plus(p2);

        assertEquals(p1.toString(), "6.000000x^7 + 5.000000x^4 + 5.000000x^3 + 7.000000x ");
    }

    @Test
    public void minusTest() {
        Polynomial p1 = new Polynomial("3.0 1 2 3 6 7");
        Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");

        p1.minus(p2);

        assertEquals(p1.toString(), "6.000000x^7 -5.000000x^4 -1.000000x^3 -1.000000x ");
    }

    @Test
    public void timesTest() {
        Polynomial p1 = new Polynomial("3.0 1 2 3 6 7");
        Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");

        p1.times(p2);

        assertEquals(p1.toString(), "30.000000x^11 + 18.000000x^10 + 24.000000x^8 + 10.000000x^7 + 6.000000x^6 + 15.000000x^5 + 17.000000x^4 + 12.000000x^2 ");
    }

    @Test
    public void evaluateTest() {
        Polynomial p1 = new Polynomial("3 4 -4 3 2 1 -8 0");
        Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");

        assertEquals(p1.evaluate(2), 12, 0.00001);
        assertEquals(p2.evaluate(-30), 3968880, 0.00001);
    }

    @Test
    public void edgeCaseTest() {
        // Test 1
        Polynomial p1 = new Polynomial("3 4 -4 3 2 1 -8 0");
        Polynomial p2 = new Polynomial("3 4 -6 3 4 1 -8 0");

        p1.minus(p2);

        assertEquals(p1.toString(), "2.000000x^3 -2.000000x ");

        // Test 2
        Polynomial p3 = new Polynomial("3 4 -4 3 2 1 -8 0");
        Polynomial p4 = new Polynomial("3 4 4 3 -2 1 -8 0");
        p3.plus(p4);

        assertEquals(p3.toString(), "6.000000x^4 -16.000000 ");
    }

    @Test
    public void negationAddTest() {
        Polynomial p1a = new Polynomial("3 1 4 2");
        Polynomial p2a = new Polynomial("6 1 6 2");
        p1a.plus(p2a);

        Polynomial p1b = new Polynomial("3 1 4 2");
        Polynomial p2b = new Polynomial("-6 1 -6 2");

        p1b.minus(p2b);

        assertEquals(p1a.toString(), p1b.toString());
    }

    @Test
    public void timesSelfTest() {
        Polynomial p1 = new Polynomial("3 4 -4 3 2 1 -8 0");
        p1.times(p1);

        assertEquals(p1.toString(), "9.000000x^8 -24.000000x^7 + 16.000000x^6 + 12.000000x^5 -64.000000x^4 + 64.000000x^3 + 4.000000x^2 -32.000000x + 64.000000 ");
    }

    @Test
    public void commutativityTest() {

        // a + b == b + a
        Polynomial a1 = new Polynomial("4 3 2 1");
        Polynomial b1 = new Polynomial("6 5 4 3 2 1");
        Polynomial a2 = new Polynomial("4 3 2 1");
        Polynomial b2 = new Polynomial("6 5 4 3 2 1");

        a1.plus(b1);
        b2.plus(a2);
        assertEquals(a1.toString(), b2.toString());

        // a + b == b + a
        a1 = new Polynomial("4 3 2 1");
        b1 = new Polynomial("6 5 4 3 2 1");
        a2 = new Polynomial("4 3 2 1");
        b2 = new Polynomial("6 5 4 3 2 1");

        a1.times(b1);
        b2.times(a2);
        assertEquals(a1.toString(), b2.toString());
    }

    @Test
    public void associativityTest() {
        // (a + b) + c == a + (b + c)
        Polynomial a1 = new Polynomial("4 3 2 1");
        Polynomial b1 = new Polynomial("6 5 4 3 2 1");
        Polynomial c1 = new Polynomial("4 3 2 1 2 3 4 5");
        Polynomial a2 = new Polynomial("4 3 2 1");
        Polynomial b2 = new Polynomial("6 5 4 3 2 1");
        Polynomial c2 = new Polynomial("4 3 2 1 2 3 4 5");

        a1.plus(b1);
        a1.plus(c1);

        b2.plus(c2);
        a2.plus(b2);

        assertEquals(a1.toString(), a2.toString()); 
        // (a * b) * c == a * (b * c)
        a1 = new Polynomial("4 3 2 1");
        b1 = new Polynomial("6 5 4 3 2 1");
        c1 = new Polynomial("4 3 2 1 2 3 4 5");
        a2 = new Polynomial("4 3 2 1");
        b2 = new Polynomial("6 5 4 3 2 1");
        c2 = new Polynomial("4 3 2 1 2 3 4 5");

        a1.times(b1);
        a1.times(c1);

        b2.times(c2);
        a2.times(b2);

        assertEquals(a1.toString(), a2.toString());


    }

    @Test
    public void distributivityTest() {
        // a * (b+ c) == (a * b) + (a * c)

        Polynomial a1 = new Polynomial("4 3 2 1");
        Polynomial b1 = new Polynomial("6 5 4 3 2 1");
        Polynomial c1 = new Polynomial("4 3 2 1 2 3 4 5");

        Polynomial a2a = new Polynomial("4 3 2 1");
        Polynomial a2b = new Polynomial("4 3 2 1");
        Polynomial b2 = new Polynomial("6 5 4 3 2 1");
        Polynomial c2 = new Polynomial("4 3 2 1 2 3 4 5");

        b1.plus(c1);
        a1.times(b1);

        a2a.times(b2);
        a2b.times(c2);
        a2a.plus(a2b);

        assertEquals(a1.toString(), a2a.toString());

    }

}
