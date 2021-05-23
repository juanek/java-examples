package ar.com.juanek.classic.model;

import ar.com.juanek.classic.Visitor;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author juanekipes@gmail.com
 */
public class Car {

    private Body body = new Body();
    private Engine engine = new Engine();
    private Wheel[] wheels = {new Wheel(),new Wheel(),new Wheel(),new Wheel()};

    public void accept(Visitor visitor){
        this.body.accept(visitor);
        this.engine.accept(visitor);
        Arrays.asList(this.wheels).forEach(new Consumer<Wheel>() {
            @Override
            public void accept(Wheel wheel) {
                wheel.accept(visitor);
            }
        });
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body=" + body +
                ", engine=" + engine +
                ", wheels=" + Arrays.toString(wheels) +
                '}';
    }
}
