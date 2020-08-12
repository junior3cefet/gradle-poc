package br.com.gradle.gradlepoc.controller;

import br.com.gradle.gradlepoc.controller.request.CustomerInputDTO;
import br.com.gradle.gradlepoc.controller.response.CustomerOutputDTO;
import br.com.gradle.gradlepoc.model.Customer;
import br.com.gradle.gradlepoc.service.CustomerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/v1/customer")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerOutputDTO> getAllCustomers() {
        return customerService
                .findAll()
                .stream()
                .map(CustomerOutputDTO::of)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createCustomer(@RequestBody CustomerInputDTO customerInputDTO) {
        return Stream.of(customerService.create(customerInputDTO))
                .map(Customer::getId)
                .findFirst()
                .orElseThrow();
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.delete(customerId);
    }

}
