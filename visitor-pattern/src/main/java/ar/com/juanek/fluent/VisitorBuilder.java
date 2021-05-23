package ar.com.juanek.fluent;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author juanekipes@gmail.com
 */
public interface VisitorBuilder<R> extends BiConsumer<Class<?>, Function<Object,R>> {

    default void register(Class<?> type, Function<Object, R> function){
        this.accept(type,function);
    }
}
