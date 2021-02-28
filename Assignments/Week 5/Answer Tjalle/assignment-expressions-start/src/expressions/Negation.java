package expressions;

import java.util.Map;

public class Negation extends OneArgExpr {

    public Negation(Expression x) {
        super(x);
    }

    @Override
    public double eval(Map<String, Double> env) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Expression partialEval() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String getOperator() {
        return "-";
    }

    

    
    
}
