package it.credem.macina_be.controller;

import it.credem.macina_be.model.constant.MessageConstants;
import it.credem.macina_be.model.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;


@AutoConfigureRestTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest {

    @Autowired
    private RestTestClient restClient;

    @Test
    public void whenHelloRequestThenReturnsCorrectPayloadGreetings1() throws Exception {
        restClient
                .get()
                .uri("/api/hello")
                .exchange()
                .expectBody(String.class)
                .value(greeting -> assertEquals("hello", greeting));
    }

    @Test
    public void whenHelloRequestThenReturnsCorrectPayloadGreetings2() throws Exception {
        restClient
                .get()
                .uri("/api")
                .exchange()
                .expectBody(HelloResponseDto.class)
                .value(greeting -> assertEquals( new HelloResponseDto(MessageConstants.DEFAULT_HELLO_MESSAGE), greeting));
    }


    @Test
    public void whenHelloRequestThenReturnsCorrectPayloadGreetingsAndName() throws Exception {
        restClient
                .get()
                .uri("/api/Mario")
                .exchange()
                .expectBody(HelloResponseDto.class)
                .value(greeting -> assertEquals(new HelloResponseDto("Hello Mario!"), greeting));
    }

    @Test
    public void whenHelloRequestPostThenReturns200() throws Exception {
        restClient
                .post()
                .uri("/api/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .body("Mario")
                .exchange()
                .expectStatus().isOk();
    }

}