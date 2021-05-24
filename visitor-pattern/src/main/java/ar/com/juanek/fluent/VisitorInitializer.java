package ar.com.juanek.fluent;

import java.util.function.Consumer;

/**
 * @author juanekipes@gmail.com
 */
public interface VisitorInitializer<R> extends Consumer<VisitorBuilder<R>> {

    default void init(VisitorBuilder<R> builder){
        this.accept(builder);
    }
}
