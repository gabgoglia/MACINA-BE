package it.credem.macina_be.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HelloResponseDto {
    @Schema(description = "Message inside the response")
    private String message;
}
