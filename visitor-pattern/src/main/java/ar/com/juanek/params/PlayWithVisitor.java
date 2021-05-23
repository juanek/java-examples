package ar.com.juanek.params;

import ar.com.juanek.params.model.Body;
import ar.com.juanek.params.model.Car;
import ar.com.juanek.params.model.Engine;
import ar.com.juanek.params.model.Wheel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author juanekipes@gmail.com
 */
public class PlayWithVisitor {
    public static void main(String[] args) {
        Car renault = new Car();
        Visitor visitor = new Visitor<String>() {


            @Override
            public String visit(Car car) {

                return " Visited car " + car;
            }

            @Override
            public String visit(Body body) {
                return " Visited body " + body;
            }

            @Override
            public String visit(Engine engine) {
                return " Visited engine " + engine;
            }

            @Override
            public String visit(Wheel wheel) {
                return " Visited wheel " + wheel;
            }
        };
        String accept = renault.accept(visitor, Collectors.joining(" -- "));
        System.out.println(accept);


        List<String> accepts = renault.accept(visitor, Collectors.toList());
        accepts.forEach(System.out::println);
    }
}
