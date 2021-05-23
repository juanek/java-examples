package ar.com.juanek.fluent.model;

import ar.com.juanek.fluent.Visitor;

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
