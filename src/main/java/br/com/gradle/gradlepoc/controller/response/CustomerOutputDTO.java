package br.com.gradle.gradlepoc.controller.response;

import br.com.gradle.gradlepoc.model.Customer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CustomerOutputDTO {

    private UUID id;

    private String name;

    private String surname;

    private long age;

    public static CustomerOutputDTO of(Customer customer) {
        return CustomerOutputDTO
                .builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .age(customer.getAge())
                .build();
    }

}
