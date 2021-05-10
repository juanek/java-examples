package ar.com.juanek;

public class ProductServiceImpl implements ProductService{
    @Override
    public Product product(String productCode) {
        Product product = new Product();
        product.setProductCode("2345");
        return product;
    }
}
