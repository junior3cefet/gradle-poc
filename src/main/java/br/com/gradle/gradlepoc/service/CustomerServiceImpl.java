package br.com.gradle.gradlepoc.service;

import br.com.gradle.gradlepoc.controller.request.CustomerInputDTO;
import br.com.gradle.gradlepoc.model.Customer;
import br.com.gradle.gradlepoc.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(CustomerInputDTO customerInputDTO) {
        return customerRepository.save(Customer.of(customerInputDTO));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(UUID customerId) {
        var customer = customerRepository.findById(customerId);
        customerRepository.delete(customer);
    }

}
