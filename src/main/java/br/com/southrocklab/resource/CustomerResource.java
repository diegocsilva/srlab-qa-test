package br.com.southrocklab.resource;

import br.com.southrocklab.dto.CustomerDTO;
import br.com.southrocklab.dto.CustomerResponseDTO;
import br.com.southrocklab.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

    private final CustomerService service;

    public CustomerResource(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> list() {
        List<CustomerResponseDTO> customers = service.list();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> create(@Valid @RequestBody CustomerDTO dto) {
        CustomerResponseDTO customer = service.create(dto);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> update(@Valid @RequestBody CustomerDTO dto,
                                                      @PathVariable("id") Integer id) {
        CustomerResponseDTO customer = service.update(id, dto);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{name}/{lastName}")
    public ResponseEntity<CustomerResponseDTO> getByName(@PathVariable("name") String name,
                                                         @PathVariable("lastName") String lastName) {
        CustomerResponseDTO customer = service.getByFullName(name, lastName);
        return ResponseEntity.ok(customer);
    }
}
