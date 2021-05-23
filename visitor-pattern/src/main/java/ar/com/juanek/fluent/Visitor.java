package ar.com.juanek.fluent;

/**
 * @author juanekipes@gmail.com
 */
public interface Visitor<R> {
    R visit(Object o);

}
