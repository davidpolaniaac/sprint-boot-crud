package co.com.crudtest.usecase.crudproduct;

import java.util.List;

import co.com.crudtest.model.product.Product;
import co.com.crudtest.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CrudProductUseCase implements ProductRepository {

    private ProductRepository productRepository;

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public Product read(String id) {
        return productRepository.read(id);
    }

    @Override
    public void update(String id, Product product) {
        productRepository.update(id, product);
        
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
