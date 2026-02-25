package it.credem.macina_be.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorMessage {
    @Schema(description = "The error code", example = "TEC-PRC-RAC-GEN")
    private String code;

    @Schema(description = "The http status code", example = "500")
    private String status;

    @Schema(description = "The main title of error", example = "Resource not found")
    private String title;

    @Schema(description = "The detail of error", example = "The given resource 123 is not found")
    private String detail;

    @Schema(description = "The timestamp of error", example = "2022-10-10T13:01:40.068282Z")
    private String timestamp;

    @Schema(description = "The id of the operation", example = "0e82b4da0d7e5d3b")
    private String traceId;

}
