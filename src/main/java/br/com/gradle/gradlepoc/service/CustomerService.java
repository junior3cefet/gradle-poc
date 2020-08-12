package br.com.gradle.gradlepoc.service;

import br.com.gradle.gradlepoc.controller.request.CustomerInputDTO;
import br.com.gradle.gradlepoc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer create(CustomerInputDTO customerInputDTO);

    List<Customer> findAll();

    void delete(UUID customerId);

}
