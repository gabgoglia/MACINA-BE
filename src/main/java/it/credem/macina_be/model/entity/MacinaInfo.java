package it.credem.macina_be.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MacinaInfo {

    private String ima;

    private String funzioneRegolamentare;

    private String icm;

    @Pattern(regexp = "dd-MM-yyyy")
    @Schema(pattern = "dd-MM-yyyy")
    private LocalDate dataDeliberaIcm;

    private String rating;

    @Pattern(regexp = "dd-MM-yyyy")
    @Schema(pattern = "dd-MM-yyyy")
    private LocalDate scadenzaRating;

    private String classeMetodo;

    private String revisioneSpeciale;

    private Boolean proponiliVisibili;

    private Proponibili proponibili;

    private Boolean offerteVisibili;

    private String nOfferte;

    private String messaggioErrore;




}
