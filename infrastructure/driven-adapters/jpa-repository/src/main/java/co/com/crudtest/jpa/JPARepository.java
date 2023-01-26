package co.com.crudtest.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import co.com.crudtest.jpa.entities.ProductEntity;

public interface JPARepository extends CrudRepository<ProductEntity, String>, QueryByExampleExecutor<ProductEntity> {
}
