package expressions;

import static expressions.ExpressionFactory.*;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		ArrayList<Expression> e = new ArrayList<Expression>();

		e.add(add(mul(con(2.), con(3.)), var("x")));
		e.add(add(mul(con(2.), var("x")), mul(var("y"), mul(con(2.), con(6.)))));

		printerE(e);

	}

	public static void printerE(ArrayList<Expression> e) {
		for (Expression ex : e) {
			System.out.println(ex.toString());
			System.out.println(ex.partialEval().toString() + "\n");
		}
	}
}
