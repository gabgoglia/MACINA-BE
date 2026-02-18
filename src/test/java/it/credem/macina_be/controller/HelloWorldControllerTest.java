package it.credem.macina_be.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenHelloRequestThenReturns200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/hello")).andExpect(content().string("hello"));
    }


    @Test
    public void whenHelloRequestThenReturnsCorrectPayload() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/Mario" )).andExpect(content().string("Hello Mario!"));
    }
}