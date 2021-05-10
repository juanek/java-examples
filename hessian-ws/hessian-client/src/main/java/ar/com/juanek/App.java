package ar.com.juanek;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

/**
 * Hello world!
 *  mvn exec:java -Dexec.mainClass="ar.com.juanek.App"
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException {
        String url = "http://localhost:8080/products";
        HessianProxyFactory factory = new HessianProxyFactory();
        ProductService productService = (ProductService)factory.create(ProductService.class,url);

        System.out.println(""+productService.product("345").getProductCode());
    }
}
