package it.credem.macina_be.service;

import it.credem.macina_be.model.dto.AdvancedRequest;
import it.credem.macina_be.model.dto.AdvancedResponse;

public interface AdvancedService {
    AdvancedResponse process(AdvancedRequest req);
}
