package ar.com.juanek.fluent.model;

import ar.com.juanek.fluent.Visitor;

/**
 * @author juanekipes@gmail.com
 */
public class Body {

    public <R> R accept(Visitor<R> visitor){
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Body{}";
    }
}
