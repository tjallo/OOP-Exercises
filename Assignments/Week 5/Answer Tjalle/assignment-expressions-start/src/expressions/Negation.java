package expressions;

import java.util.Map;

public class Negation extends OneArgExpr {

    public Negation(Expression x) {
        super(x);
    }

    @Override
    public double eval(Map<String, Double> env) {
        return x.eval(env) * -1;
    }

    @Override
    public Expression partialEval() {
        return new Constant(Double.parseDouble(x.toString()) * -1);
    }

    @Override
    protected String getOperator() {
        return "-";
    }

}
