package expressions;

public class Add extends TwoArgExpr {

    public Add(Expression x, Expression y) {
        super(x, y, (a1, a2) -> a1 + a2, (p1, p2) -> partialEvalAdd(p1, p2));
    }

    private static Expression partialEvalAdd(Expression x, Expression y) {
        if (x.getClass().equals(Constant.class) && y.getClass().equals(Constant.class)) {
            Expression c = new Constant(Double.parseDouble(x.toString()) + Double.parseDouble(y.toString()));
            return c;
        }

        if (x.getClass().equals(Constant.class) && Double.parseDouble(x.toString()) == 0){
            return y;
        }
        if (y.getClass().equals(Constant.class) && Double.parseDouble(y.toString()) == 0){
            return x;
        }

        return new Add(x, y);
    }

    @Override
    protected final String getOperator() {
        return "+";
    }

}
