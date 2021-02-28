package expressions;

import java.util.Map;
import java.util.function.BinaryOperator;

public abstract class TwoArgExpr implements Expression {

    private final Expression x, y;
    private final BinaryOperator<Double> evalOp;
    private final BinaryOperator<Expression> partEvalOp;

    public TwoArgExpr(Expression x, Expression y, BinaryOperator<Double> evalOp, BinaryOperator<Expression> partEvalOp) {

        this.x = x;
        this.y = y;
        this.evalOp = evalOp;
        this.partEvalOp = partEvalOp;

    }

    @Override
    public double eval(Map<String, Double> env) {
        return evalOp.apply(x.eval(env), y.eval(env));
    }

    @Override
    public Expression partialEval() {
        return partEvalOp.apply(x.partialEval(), y.partialEval());
    }

    @Override
    public String toString() {
        return "(" + x.toString() + getOperator() + y.toString() + ")";
    }

    protected abstract String getOperator();
}
