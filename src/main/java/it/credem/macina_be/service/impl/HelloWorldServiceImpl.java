package it.credem.macina_be.service.impl;

import it.credem.macina_be.model.constant.MessageConstants;
import it.credem.macina_be.model.dto.HelloResponseDto;
import it.credem.macina_be.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public HelloResponseDto sayHello() {
        return new HelloResponseDto(MessageConstants.DEFAULT_HELLO_MESSAGE);
    }

    @Override
    public HelloResponseDto sayHelloTo(String name) {
        return new HelloResponseDto("Hello " + name + "!");
    }
}
