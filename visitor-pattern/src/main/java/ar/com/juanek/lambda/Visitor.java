package ar.com.juanek.lambda;

/**
 * @author juanekipes@gmail.com
 */
public interface Visitor<R> {
    R visit(Object o);

}
