package ar.com.juanek.fluent;

import ar.com.juanek.fluent.model.Body;
import ar.com.juanek.fluent.model.Car;
import ar.com.juanek.fluent.model.Engine;
import ar.com.juanek.fluent.model.Wheel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author juanekipes@gmail.com
 */
public class PlayWithVisitor {
    public static void main(String[] args) {
        Car renault = new Car();

//        VisitorInitializer<String> visitorInitializer = builder -> {
//            builder.register(Car.class, car -> "Visited car " + car);
//            builder.register(Body.class, body -> "Visited body " + body);
//            builder.register(Engine.class, engine -> "Visited engine " + engine);
//            builder.register(Wheel.class, whell -> "Visited whell " + whell);
//        };

        VisitorInitializer<String> visitorInitializer =
                Visitor.<String>forType(Car.class).execute(car -> "Visited car " + car);
//                        .forType(Body.class).execute(body -> "Visited body " + body)
//                        .forType(Engine.class).execute(engine -> "Visited engine " + engine)
//                        .forType(Wheel.class).execute(whell -> "Visited whell " + whell);

        Visitor<String> visitor = Visitor.of(visitorInitializer);

        String visit = visitor.visit(renault);
        System.out.println(visit);

        String visit1 = visitor.visit(renault.getBody());
        System.out.println(visit1);
    }
}
