package ar.com.juanek.lambda;

import ar.com.juanek.lambda.model.Body;
import ar.com.juanek.lambda.model.Car;
import ar.com.juanek.lambda.model.Engine;
import ar.com.juanek.lambda.model.Wheel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author juanekipes@gmail.com
 */
public class PlayWithVisitor {
    public static void main(String[] args) {
        Car renault = new Car();

        //Los comportamientos los guardo en mapa
        //  Objects Car,Wheel etc , String lo que produce el Visitor
        Map<Class<?>, Function<Object, String>> registry = new HashMap<>();
        registry.put(Car.class, car -> "Visited car " + car);
        registry.put(Body.class, body -> "Visited body " + body);
        registry.put(Engine.class, engine -> "Visited engine " + engine);
        registry.put(Wheel.class, whell -> "Visited whell " + whell);

        Visitor<String> visitor = o -> registry.get(o.getClass()).apply(o);

        String visit = visitor.visit(renault);
        System.out.println(visit);

        String visit1 = visitor.visit(renault.getBody());
        System.out.println(visit1);

//        String accept = renault.accept(visitor, Collectors.joining(" -- "));
//        System.out.println(accept);
//
//
//        List<String> accepts = renault.accept(visitor, Collectors.toList());
//        accepts.forEach(System.out::println);
    }
}
