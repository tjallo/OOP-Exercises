package expressions;

public class Multiply extends TwoArgExpr {

    public Multiply(Expression x, Expression y) {
        super(x, y, (e1, e2) -> e1 * e2, (p1, p2) -> partialEvalMul(p1, p2));
    }

    private static Expression partialEvalMul(Expression x, Expression y) {
        return x;
    }

    @Override
    protected final String getOperator() {
        return "*";
    }

}
