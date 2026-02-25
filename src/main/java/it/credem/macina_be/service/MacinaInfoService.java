package it.credem.macina_be.service;

import it.credem.macina_be.model.dto.MacinaInfoDtoResponse;

public interface MacinaInfoService {

    MacinaInfoDtoResponse getInfo(Integer intCd, Integer cdgCd);

}
