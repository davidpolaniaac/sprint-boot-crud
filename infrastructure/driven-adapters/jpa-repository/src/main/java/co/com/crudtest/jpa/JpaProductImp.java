package co.com.crudtest.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import co.com.crudtest.model.product.Product;
import co.com.crudtest.model.product.gateways.ProductRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JpaProductImp implements ProductRepository {

    private JPARepositoryAdapter jpaRepositoryAdapter;

    @Override
    public void create(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        jpaRepositoryAdapter.save(product);
    }

    @Override
    public Product read(String id) {
        return jpaRepositoryAdapter.findById(id);
    }

    @Override
    public void update(String id, Product product) {
        Product productDb = jpaRepositoryAdapter.findById(id);

        if (productDb != null) {
            product.setId(id);
            jpaRepositoryAdapter.save(product);
        }
    }

    @Override
    public void delete(String id) {
        jpaRepositoryAdapter.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return jpaRepositoryAdapter.findAll();
    }

}
