package br.com.gradle.gradlepoc.model;

import br.com.gradle.gradlepoc.controller.request.CustomerInputDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {

    @Id
    private UUID id;

    private String name;

    private String surname;

    private long age;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getAge() {
        return age;
    }

    public static Customer of(CustomerInputDTO customerInputDTO) {
        return new CustomerBuilder()
                .id(UUID.randomUUID())
                .name(customerInputDTO.getName())
                .surname(customerInputDTO.getSurname())
                .age(customerInputDTO.getAge())
                .build();
    }

}
