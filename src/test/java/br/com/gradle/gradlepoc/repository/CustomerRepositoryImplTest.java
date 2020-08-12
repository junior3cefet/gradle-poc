package br.com.gradle.gradlepoc.repository;

import br.com.gradle.gradlepoc.configuration.TestType;
import br.com.gradle.gradlepoc.model.Customer;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag(TestType.UNIT_TEST)
class CustomerRepositoryImplTest {

    @Mock
    private CustomerJpaRepository customerJpaRepositoryMock;

    @Mock
    private Customer customerMock;

    @InjectMocks
    private CustomerRepositoryImpl customerRepository;

    @Test
    @DisplayName("when get all customers then return all customer")
    void findAll() {
        when(customerMock.getAge()).thenReturn(18L);
        when(customerMock.getId()).thenReturn(UUID.fromString("9850294e-dc04-4e8e-bbe6-6d686736cf23"));
        when(customerMock.getName()).thenReturn("JUNIOR");
        when(customerMock.getSurname()).thenReturn("NAKAMURA");

        when(customerJpaRepositoryMock.findAll()).thenReturn(List.of(customerMock));

        var result = customerRepository.findAll();

        assertThat(result)
                .extracting("id", "name", "surname", "age")
                .contains(new Tuple(UUID.fromString("9850294e-dc04-4e8e-bbe6-6d686736cf23"), "JUNIOR", "NAKAMURA", 18L));

    }

}