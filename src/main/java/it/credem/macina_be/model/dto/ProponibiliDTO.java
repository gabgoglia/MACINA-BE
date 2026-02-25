package it.credem.macina_be.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProponibiliDTO {
    @Schema(description = "Value of proponibile BTS Secured")
    private Double proponibileBTSecured;

    @Schema(description = "Value of proponibile MT Secured")
    private Double proponibileMTSecured;

    @Schema(description = "Value of proponibile BTS Unsecured")
    private Double proponibileBTUnsecured;

    @Schema(description = "Value of proponibile MT Unseecured")
    private Double proponibileMTUnsecured;

}
