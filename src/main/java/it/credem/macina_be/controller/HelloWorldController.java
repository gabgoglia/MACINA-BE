package it.credem.macina_be.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import io.temporal.client.WorkflowClient;
import it.credem.macina_be.model.dto.HelloResponseDto;
import it.credem.macina_be.service.HelloService;
import it.credem.macina_be.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@OpenAPIDefinition(info = @Info(title = "CR_ESTATE_BE_HELLO_WORLD_SERVICE_V1", description = "servizio be di esempio", version = "1.0.0"),
        servers = {
                @Server(url = "/api", description = "Default Server URL")
        }

)
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldService service;

    private final HelloService helloService;

    @Autowired
    WorkflowClient client;


    @Operation(summary = "Get Hello Message without name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Hello without name",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = HelloResponseDto.class))})})
    @GetMapping
    public HelloResponseDto hello() {
        return service.sayHello();
    }

    @Operation(summary = "Get Hello Message with name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Hello with name",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = HelloResponseDto.class))})})
    @GetMapping("/{name}")
    public HelloResponseDto helloWithName(@PathVariable String name) {
        return service.sayHelloTo(name);
    }

    @Operation(summary = "Print hello")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Print hello",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("sample", "Say Hello");
        return "hello";
    }

    @Operation(summary = "Start Hello Workflow")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Compose greeting",
                    content = {@Content(mediaType = "text/html",
                            schema = @Schema(implementation = ResponseEntity.class))})})
    @PostMapping(
            value = "/hello",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.TEXT_HTML_VALUE})
    ResponseEntity<String> helloSample(@RequestBody String firstName) {

        String result = helloService.startHello(firstName);
        return ResponseEntity.ok(result);
    }
}
