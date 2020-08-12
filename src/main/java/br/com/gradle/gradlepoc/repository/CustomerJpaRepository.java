package br.com.gradle.gradlepoc.repository;

import br.com.gradle.gradlepoc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface CustomerJpaRepository extends JpaRepository<Customer, UUID> {

}
