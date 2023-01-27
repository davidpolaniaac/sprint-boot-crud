package co.com.crudtest.api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.crudtest.usecase.crudproduct.CrudProductUseCase;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final CrudProductUseCase crudProductUseCase;

    @GetMapping(path = "/hello")
    public String commandName() {
//      return useCase.doAction();
        return "Hello World";
    }
}
