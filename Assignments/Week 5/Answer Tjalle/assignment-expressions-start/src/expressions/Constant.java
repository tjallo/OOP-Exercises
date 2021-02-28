package expressions;

import java.util.Map;

public class Constant extends NoArgExpr {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public double eval(Map<String, Double> env) {
        return value;
    }
}
