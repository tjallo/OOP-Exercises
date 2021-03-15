package polynomials;

public class Main {

	public static void main(String[] args) {
		Polynomial p1 = new Polynomial("3.0 1 2 3 6 7");
		Polynomial p2 = new Polynomial("4.0 1 3 3 5 4");
		Polynomial p1c2 = new Polynomial("3.0 1 2 3 6 7");
		Polynomial p2c2 = new Polynomial("4.0 1 3 3 5 4");
		Polynomial p3 = new Polynomial("0 1 4 0 -5 3");
		Polynomial p4 = new Polynomial("6 1");
		Polynomial p5 = new Polynomial("6 3 -5 0 12 1 -8 2");


		System.out.println(p3);
		System.out.println(p3.evaluate(3));

	}

}
