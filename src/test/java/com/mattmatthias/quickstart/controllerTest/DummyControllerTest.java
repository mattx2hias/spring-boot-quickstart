package com.mattmatthias.quickstart.controllerTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mattmatthias.quickstart.controller.DummyController;
import com.mattmatthias.quickstart.entity.Dummy;
import com.mattmatthias.quickstart.repository.DummyRepository;
import com.mattmatthias.quickstart.service.DummyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DummyController.class)
public class DummyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DummyService dummyService;

    Dummy dummy = new Dummy(0, "Bob");

    @DisplayName("Injected Mock Mvc is not null")
    @Test
    void shouldCreateMockMvc() {
        assertThat(mockMvc).isNotNull();
    }

    @DisplayName("2xx when visiting landing page")
    @Test
    void landingPageIs2xx() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @DisplayName("2xx when creating Dummy and input is valid")
    @Test
    void createDummyWithValidInputIs2xx() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/dummy/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dummy))
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @DisplayName("4xx when creating Dummy and input is invalid")
    @Test
    void createDummyWithInvalidInputIs4xx() throws Exception {

        mockMvc.perform(post("/dummy/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(dummy))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
