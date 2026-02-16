package it.credem.macina_be.controller;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import it.credem.macina_be.model.dto.HelloResponseDto;
import it.credem.macina_be.model.entity.Person;
import it.credem.macina_be.service.HelloWorldService;
import it.credem.macina_be.temporal.workflow.HelloWorkflow;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldService service;

    @Autowired
    WorkflowClient client;

    @GetMapping
    public HelloResponseDto hello() {
        return service.sayHello();
    }

    @GetMapping("/{name}")
    public HelloResponseDto helloWithName(@PathVariable String name) {
        return service.sayHelloTo(name);
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("sample", "Say Hello");
        return "hello";
    }

    @PostMapping(
            value = "/hello",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.TEXT_HTML_VALUE})
    ResponseEntity helloSample(@RequestBody String firstName) {
        HelloWorkflow workflow =
                client.newWorkflowStub(
                        HelloWorkflow.class,
                        WorkflowOptions.newBuilder()
                                .setTaskQueue("HELLO_TQ")
                                .setWorkflowId("HelloSample-" + UUID.randomUUID())
                                .build());

        // bypass thymeleaf, don't return template name just result
        return new ResponseEntity<>("\"" + workflow.sayHello(firstName) + "\"", HttpStatus.OK);
    }
}
