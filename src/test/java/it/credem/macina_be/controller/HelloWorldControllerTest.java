package it.credem.macina_be.controller;

import it.credem.macina_be.model.constant.MessageConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenHelloRequestThenReturnsCorrectPayloadGreetings1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/hello")).andExpect(content().string("hello"));
    }

    @Test
    public void whenHelloRequestThenReturnsCorrectPayloadGreetings2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api")).andExpect(content().string(MessageConstants.DEFAULT_HELLO_MESSAGE));
    }


    @Test
    public void whenHelloRequestThenReturnsCorrectPayloadGreetingsAndName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/Mario" )).andExpect(content().string("Hello Mario!"));
    }

    @Test
    public void whenHelloRequestPostThenReturns200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("api/hello").contentType(MediaType.APPLICATION_JSON_VALUE).content("Mario")).andExpect(status().isOk());
    }
}