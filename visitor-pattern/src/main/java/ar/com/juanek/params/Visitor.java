package ar.com.juanek.params;

import ar.com.juanek.params.model.Body;
import ar.com.juanek.params.model.Car;
import ar.com.juanek.params.model.Engine;
import ar.com.juanek.params.model.Wheel;

/**
 * @author juanekipes@gmail.com
 */
public interface Visitor<R> {
    R visit(Car car);
    R visit(Body body);
    R visit(Engine engine);
    R visit(Wheel wheel);
}
