package it.credem.macina_be.model.dto;

public record AdvancedResponse(String status, String result) {
    public static AdvancedResponse ok(String result) { return new AdvancedResponse("OK", result); }
    public static AdvancedResponse rejected(String reason) { return new AdvancedResponse("REJECTED", reason); }
    public static AdvancedResponse failed(String reason) { return new AdvancedResponse("FAILED", reason); }
}