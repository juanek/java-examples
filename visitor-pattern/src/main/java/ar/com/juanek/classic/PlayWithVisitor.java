package ar.com.juanek.classic;

import ar.com.juanek.classic.model.Body;
import ar.com.juanek.classic.model.Car;
import ar.com.juanek.classic.model.Engine;
import ar.com.juanek.classic.model.Wheel;

/**
 * @author juanekipes@gmail.com
 */
public class PlayWithVisitor {
    public static void main(String[] args) {
        Car renault = new Car();
        final StringBuilder visited = new StringBuilder();
        Visitor visitor = new Visitor() {


            @Override
            public void visit(Car car) {
                visited.append(" Visited car " + car);
            }

            @Override
            public void visit(Body body) {
                visited.append(" Visited body " + body);
            }

            @Override
            public void visit(Engine engine) {
                visited.append(" Visited engine " + engine);
            }

            @Override
            public void visit(Wheel wheel) {
                visited.append(" Visited wheel " + wheel);
            }
        };
        renault.accept(visitor);
        System.out.println(visited);
    }
}
