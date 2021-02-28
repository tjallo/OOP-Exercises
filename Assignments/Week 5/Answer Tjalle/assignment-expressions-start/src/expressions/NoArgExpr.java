package expressions;

public abstract class NoArgExpr implements Expression {
    @Override
    public Expression partialEval() {
        return this;
    }
}
