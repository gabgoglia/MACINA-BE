package it.credem.macina_be.controller;

import it.credem.macina_be.model.dto.HelloResponseDto;
import it.credem.macina_be.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldService service;

    @GetMapping
    public HelloResponseDto hello() {
        return service.sayHello();
    }

    @GetMapping("/{name}")
    public HelloResponseDto helloWithName(@PathVariable String name) {
        return service.sayHelloTo(name);
    }
}
