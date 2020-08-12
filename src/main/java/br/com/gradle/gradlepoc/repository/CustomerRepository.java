package br.com.gradle.gradlepoc.repository;

import br.com.gradle.gradlepoc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer save(Customer customer);

    void delete(Customer customer);

    Customer findById(UUID customerId);

}
