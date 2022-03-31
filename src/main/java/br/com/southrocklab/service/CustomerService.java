package br.com.southrocklab.service;


import br.com.southrocklab.dto.CustomerDTO;
import br.com.southrocklab.dto.CustomerResponseDTO;
import br.com.southrocklab.mapper.CustomerMapper;
import br.com.southrocklab.model.Customer;
import br.com.southrocklab.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    public static final String CUSTOMER_NOT_FOUND = "Customer not found";

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CustomerResponseDTO> list() {
        List<Customer> all = repository.findAll();
        return mapper.map(all);
    }

    public CustomerResponseDTO create(CustomerDTO dto) {
        Customer customer = this.create(mapper.map(dto));
        return mapper.mapToResponse(customer);
    }

    public CustomerResponseDTO update(Integer customerId, CustomerDTO dto) {
        Customer updated = mapper.map(dto);
        return mapper.mapToResponse(update(customerId, updated));
    }

    public CustomerResponseDTO getByFullName(String name, String lastName) {
        Customer customer = getEntityByFullName(name, lastName);
        return mapper.mapToResponse(customer);
    }

    public CustomerResponseDTO getById(Integer id) {
        Customer customer = getEntityById(id);
        return mapper.mapToResponse(customer);
    }

    private Customer getEntityById(Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, CUSTOMER_NOT_FOUND));
    }

    private Customer getEntityByFullName(String name, String lastName) {
        return repository.findByNameAndLastName(name, lastName)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, CUSTOMER_NOT_FOUND));
    }

    private Customer create(Customer customer) {
        repository.findByNameAndLastName(customer.getName(), customer.getLastName())
            .ifPresent(result -> {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer already exists");
            });
        return repository.save(customer);
    }

    private Customer update(Integer customerId, Customer updated) {
        Customer old = getEntityById(customerId);
        updated.setId(old.getId());
        return repository.save(updated);
    }

    public void delete(Integer id) {
        Customer entity = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, CUSTOMER_NOT_FOUND));
        repository.delete(entity);
    }
}
