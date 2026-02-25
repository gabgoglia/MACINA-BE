package it.credem.macina_be.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import it.credem.macina_be.model.dto.ErrorMessage;
import it.credem.macina_be.model.dto.MacinaInfoDtoResponse;
import it.credem.macina_be.service.MacinaInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/macina/info")
@OpenAPIDefinition(info = @Info(title = "MACINA_INFO_SERVICE_V1", description = "macina info service", version = "1.0.0"),
        servers = {
                @Server(url = "/macina-be", description = "Default Server URL")
        }

)
@RequiredArgsConstructor
public class MacinaInfoController {

    private final MacinaInfoService service;

//    @Operation(summary = "get Info")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "OK",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = MacinaInfoDtoResponse.class))}),
//            @ApiResponse(responseCode = "500", description = "KO",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = ErrorMessage.class))})})
//    @GetMapping(path = "/{istCd}/{cdgCd}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<MacinaInfoDtoResponse> getInfo(@PathVariable @Parameter(description = "IstCd") Integer istCd,
//                                                         @PathVariable @Parameter(description = "CdgCd") Integer cdgCd) {
//        MacinaInfoDtoResponse result = service.getInfo(istCd, cdgCd);
//        return ResponseEntity.ok(result);
//    }

    @Operation(summary = "get Info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MacinaInfoDtoResponse.class))}),
            @ApiResponse(responseCode = "500", description = "KO",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorMessage.class))})})
    @GetMapping(path = "/{istCd}/{cdgCd}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MacinaInfoDtoResponse getInfo(@PathVariable @Parameter(description = "IstCd") Integer istCd,
                                                         @PathVariable @Parameter(description = "CdgCd") Integer cdgCd) {
        return service.getInfo(istCd, cdgCd);
    }


}
