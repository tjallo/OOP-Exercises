package expressions;

import java.util.Map;

public class Variable extends NoArgExpr{
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
   
}