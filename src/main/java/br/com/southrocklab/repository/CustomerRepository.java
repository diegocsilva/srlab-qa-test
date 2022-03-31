package br.com.southrocklab.repository;

import br.com.southrocklab.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByNameAndLastName(String name, String lastName);
}
