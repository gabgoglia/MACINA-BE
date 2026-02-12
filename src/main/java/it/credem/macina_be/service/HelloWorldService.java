package it.credem.macina_be.service;

import it.credem.macina_be.model.dto.HelloResponseDto;

public interface HelloWorldService {

    HelloResponseDto sayHello();

    HelloResponseDto sayHelloTo(String name);
}
