package co.com.crudtest.api;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.com.crudtest.model.product.Product;
import co.com.crudtest.usecase.crudproduct.CrudProductUseCase;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final CrudProductUseCase crudProductUseCase;

    @GetMapping(path = "/hello")
    public String commandName() {
        return "Hello World";
    }

    @PostMapping(path = "/product")
    public void create(@RequestBody Product product) {
        crudProductUseCase.create(product);
    }

    @GetMapping(path = "/product")
    public List<Product> getAll() {
        return crudProductUseCase.getAll();
    }

    @GetMapping(path = "/product/{id}")
    public Product get(@PathVariable String id) {
        return crudProductUseCase.read(id);
    }

    @DeleteMapping(path = "/product/{id}")
    public void delete(@PathVariable String id) {
      crudProductUseCase.delete(id);
    }

    @PutMapping(path = "/product/{id}")
    public void update(@PathVariable String id, @RequestBody Product product) {
      try {
        crudProductUseCase.update(id, product);
      } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
      }
    }
}
