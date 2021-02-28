package expressions;

public class Constant extends NoArgExpr {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
