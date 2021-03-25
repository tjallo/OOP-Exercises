package polynomials;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 */
public class Polynomial {

    /**
     * A polynomial is a sequence of terms here kept in an List
     */
    private List<Term> terms;

    /**
     * A constructor for creating the zero Polynomial zero is presented as an empty
     * list of terms and not as a single term with 0 as a coefficient
     */
    public Polynomial() {

        terms = new ArrayList<>();

    }

    /**
     * A Constructor creating a polynomial from the argument string.
     *
     * @param s a String representing a list of terms which is converted to a
     *          scanner and passed to scanTerm for reading each individual term
     */
    public Polynomial(String s) {
        terms = new ArrayList<>();
        Scanner scan = new Scanner(s);

        for (Term t = Term.scanTerm(scan); t != null; t = Term.scanTerm(scan)) {
            terms.add(t);
        }
    }

    /**
     * The copy constructor for making a deep copy
     *
     * @param p the copied polynomial
     */
    public Polynomial(Polynomial p) {
        terms = new ArrayList<>();
        for (Term t : p.terms) {
            terms.add(new Term(t));
        }
    }

    /**
     * A straightforward conversion of a Polynomial into a string based on the
     * toString for terms
     *
     * @return a readable string representation of this
     */
    @Override
    public String toString() {
        removeZeroes();

        StringBuilder s = new StringBuilder();

        // First Coef is always independent to the rest (No plus needed at beginning)
        s.append(terms.get(0).toString() + ' ');

        // From index 1 onwards, because index 0 has already been added
        for (int i = 1; i < terms.size(); i++) {
            Term t = terms.get(i);
            s.append(singleTermToValidString(t) + ' ');
        }

        return s.toString();
    }

    public String singleTermToValidString(Term t) {
        double coef = t.getCoef();

        StringBuilder s = new StringBuilder();

        if (coef > -0.99999999) {
            s.append("+ ");
        }

        s.append(t.toString());

        return s.toString();
    }

    /**
     * @return Returns -1 if not found, otherwise returns Position in Term list
     */
    public int getIndexOfTermWithExponent(int exp) {
        for (int i = 0; i < terms.size(); i++) {
            Term t = terms.get(i);
            if (t.getExp() == exp) {
                return i;
            }
        }
        return -1;
    }

    public void plus(Polynomial b) {

        for (Term t : b.terms) {
            int indexExponent = getIndexOfTermWithExponent(t.getExp());

            // If index was found, add the two Terms together
            if (indexExponent >= 0) {
                terms.get(indexExponent).plus(t);
            } else {
                terms.add(t);
            }
        }

        removeZeroes();
    }

    public void minus(Polynomial b) {

        for (Term t : b.terms) {
            int indexExponent = getIndexOfTermWithExponent(t.getExp());
            Term inverted = new Term(t.getCoef() * -1, t.getExp());

            if (indexExponent >= 0) {
                terms.get(indexExponent).plus(inverted);

            } else {
                terms.add(inverted);
            }
        }
        removeZeroes();

    }

    public void times(Polynomial b) {

        List<Term> newTerms = new ArrayList<>();

        for (Term t1 : terms) {
            for (Term t2 : b.terms) {
                Term t = new Term(t1.getCoef() * t2.getCoef(), t1.getExp() + t2.getExp());
                newTerms.add(t);
            }
        }
        this.terms = newTerms;
        removeZeroes();
    }

    @Override
    public boolean equals(Object other_poly) {
        return false;
    }

    public double evaluate(int x) {
        int result = 0;

        for (Term t : terms) {
            result += t.getCoef() * Math.pow(x, t.getExp());
        }

        return result;
    }

    public void removeZeroes() {

        // I know this is completely unoptimized :) but I can not afford the spent any more time on this exercise...
        // There is also probably a more clever trick than adding removeZeroes add the end of every function, oh well
        int biggestExp = 0;

        for (Term t : this.terms) {
            if (t.getExp() > biggestExp)
                biggestExp = t.getExp();
        }

        // Array trick with exponents as index to add all coefs together without too much hassle
        double[] doubles = new double[biggestExp + 1];
        for (Term t : this.terms) {
            doubles[t.getExp()] = doubles[t.getExp()] + t.getCoef();
        }

        List<Term> newTerms = new ArrayList<>();

        for (int i = doubles.length - 1; i >= 0; i--) {
            double coef = doubles[i];
            if (coef <= -0.999 || coef >= 0.0001) {
                newTerms.add(new Term(coef, i));
            }
        }

        this.terms = newTerms;
    }


}
