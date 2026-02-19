package it.credem.macina_be.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Schema(description = "Simple person entity")
public class Person {
    @Schema(description = "First name of a person", example = "Mario")
    private String firstName;

    @Schema(description = "Last name (also called surname) of a person", example = "Rossi")
    private String lastName;

}
