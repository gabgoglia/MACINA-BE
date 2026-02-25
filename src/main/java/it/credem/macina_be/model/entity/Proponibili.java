package it.credem.macina_be.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Proponibili {

    @Schema(description = "Value of proponibile BTS Secured")
    private Double proponibileBTSecured;

    @Schema(description = "Value of proponibile MT Secured")
    private Double proponibileMTSecured;

    @Schema(description = "Value of proponibile BTS Unsecured")
    private Double proponibileBTUnsecured;

    @Schema(description = "Value of proponibile MT Unseecured")
    private Double proponibileMTUnsecured;


}
