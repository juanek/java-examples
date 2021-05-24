package ar.com.juanek.fluent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author juanekipes@gmail.com
 */
public interface Visitor<R> {
    R visit(Object o);

    static <R> Visitor<R> of(VisitorInitializer<R> visitorInitializer) {
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
        VisitorBuilder<R> visitorBuilder = registry::put;
        visitorInitializer.init(visitorBuilder);
        Visitor<R> visitor = o -> registry.get(o.getClass()).apply(o);
        return visitor;
    }

    static <R> X<R> forType(Class<?> type){
        return () -> type;
    }

    interface X<R>{
        Class<?> type();
        default VisitorInitializer<R> execute(Function<Object,R> function){
            return builder -> builder.register(type(),function);
        }
    }

}
