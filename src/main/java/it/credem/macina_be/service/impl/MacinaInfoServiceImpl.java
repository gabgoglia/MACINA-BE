package it.credem.macina_be.service.impl;

import it.credem.macina_be.model.dto.ErrorMessage;
import it.credem.macina_be.model.dto.MacinaInfoDtoResponse;
import it.credem.macina_be.model.dto.ProponibiliDTO;
import it.credem.macina_be.service.MacinaInfoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MacinaInfoServiceImpl implements MacinaInfoService {

    @Override
    public MacinaInfoDtoResponse getInfo(Integer intCd, Integer cdgCd) {
        return MacinaInfoDtoResponse.builder()
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
                .build();
    }
}
