package br.com.gradle.gradlepoc.controller;

import br.com.gradle.gradlepoc.configuration.TestType;
import br.com.gradle.gradlepoc.controller.request.CustomerInputDTO;
import br.com.gradle.gradlepoc.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Tag(TestType.INTEGRATION_TEST)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void createNewCustomer() throws Exception {
        var customerInputDTO = new CustomerInputDTO("Maria", "Paiva", 18);

        var result = mockMvc.perform(post("/v1/customer")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(customerInputDTO)))
                .andExpect(status().isCreated())
                .andReturn();

        var customerIdResponse = objectMapper.readValue(result.getResponse().getContentAsByteArray(), UUID.class);

        var customerEntity = customerRepository.findById(customerIdResponse);
        assertThat(customerEntity)
                .extracting("name", "surname", "age")
                .contains("Maria", "Paiva", 18L);
    }

}