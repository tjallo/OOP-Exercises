package expressions;

public class Add extends TwoArgExpr {

    public Add(Expression x, Expression y) {
        super(x, y, (a1, a2) -> a1 + a2, (p1, p2) -> partialEvalAdd(p1, p2));
    }

    private static Expression partialEvalAdd(Expression x, Expression y) {
        return x;
    }

    @Override
    protected final String getOperator() {
        return "+";
    }

}
