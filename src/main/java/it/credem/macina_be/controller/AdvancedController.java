package it.credem.macina_be.controller;

import it.credem.macina_be.model.dto.AdvancedRequest;
import it.credem.macina_be.model.dto.AdvancedResponse;
import it.credem.macina_be.service.AdvancedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdvancedController {

    private final AdvancedService service;

    public AdvancedController(AdvancedService service) {
        this.service = service;
    }

    @PostMapping(value = "/advanced", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AdvancedResponse> process(@RequestBody AdvancedRequest req) {
        AdvancedResponse res = service.process(req);
        return ResponseEntity.ok(res);
    }
}
