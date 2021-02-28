package expressions;

public class Multiply extends TwoArgExpr {

    public Multiply(Expression x, Expression y) {
        super(x, y, (e1, e2) -> e1 * e2, (p1, p2) -> partialEvalMul(p1, p2));
    }

    private static Expression partialEvalMul(Expression x, Expression y) {
        if (x.getClass().equals(Constant.class) && y.getClass().equals(Constant.class)) {
            Expression c = new Constant(Double.parseDouble(x.toString()) * Double.parseDouble(y.toString()));
            return c;
        }

        if (x.getClass().equals(Constant.class) && Double.parseDouble(x.toString()) == 0) {
            return new Constant(0.0);
        }
        if (y.getClass().equals(Constant.class) && Double.parseDouble(y.toString()) == 0) {
            return new Constant(0.0);
        }

        return new Multiply(x, y);
    }

    @Override
    protected final String getOperator() {
        return "*";
    }

}
