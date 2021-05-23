package ar.com.juanek.classic;

import ar.com.juanek.classic.model.Body;
import ar.com.juanek.classic.model.Car;
import ar.com.juanek.classic.model.Engine;
import ar.com.juanek.classic.model.Wheel;

/**
 * @author juanekipes@gmail.com
 */
public interface Visitor {
    void visit(Car car);
    void visit(Body body);
    void visit(Engine engine);
    void visit(Wheel wheel);
}
