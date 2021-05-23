package ar.com.juanek.params.model;

import ar.com.juanek.params.Visitor;

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
