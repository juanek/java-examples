package ar.com.juanek.classic.model;

import ar.com.juanek.classic.Visitor;

/**
 * @author juanekipes@gmail.com
 */
public class Engine {

    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Engine{}";
    }
}
