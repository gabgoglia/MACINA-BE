package it.credem.macina_be.controller;

import it.credem.macina_be.model.constant.MessageConstants;
import it.credem.macina_be.model.dto.HelloResponseDto;
import it.credem.macina_be.model.dto.MacinaInfoDtoResponse;
import it.credem.macina_be.model.dto.ProponibiliDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureRestTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MacinaInfoControllerTest {

    @Autowired
    private RestTestClient restClient;

    @Test
    public void whenHelloRequestThenReturnsCorrectPayloadGreetings2() throws Exception {
        restClient
                .get()
                .uri("/macina/info/1/1")
                .exchange()
                .expectBody(MacinaInfoDtoResponse.class)
                .value(greeting -> assertEquals(MacinaInfoDtoResponse.builder()
                        .ima("TEST")
                        .funzioneRegolamentare("TEST")
                        .icm("TEST")
                        .dataDeliberaIcm(LocalDate.now())
                        .rating("1")
                        .scadenzaRating(LocalDate.now())
                        .classeMetodo("TEST")
                        .revisioneSpeciale("TEST")
                        .proponiliVisibili(true)
                        .proponibili(ProponibiliDTO.builder()
                                .proponibileBTSecured(1.0)
                                .proponibileMTSecured(1.0)
                                .proponibileBTUnsecured(1.0)
                                .proponibileMTUnsecured(1.0)
                                .build())
                        .offerteVisibili(true)
                        .nOfferte("1")
                        .messaggioErrore("200")
                        .build(), greeting));
    }

}
