package br.com.gradle.gradlepoc.repository;

import br.com.gradle.gradlepoc.exception.NotEntityFoundException;
import br.com.gradle.gradlepoc.model.Customer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor(access = AccessLevel.PUBLIC)
class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    @Override
    public List<Customer> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return jpaRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        jpaRepository.delete(customer);
    }

    @Override
    public Customer findById(UUID customerId) {
        return jpaRepository.findById(customerId)
                .orElseThrow(() -> new NotEntityFoundException(Customer.class, customerId.toString()));
    }
}
