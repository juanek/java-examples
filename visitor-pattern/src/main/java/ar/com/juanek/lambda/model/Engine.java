package ar.com.juanek.lambda.model;

import ar.com.juanek.lambda.Visitor;

/**
 * @author juanekipes@gmail.com
 */
public class Engine {

    public <R> R accept(Visitor<R> visitor){
        return visitor.visit(this);
    }
    @Override
    public String toString() {
        return "Engine{}";
    }
}
