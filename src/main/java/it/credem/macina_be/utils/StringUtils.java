package it.credem.macina_be.utils;

public final class StringUtils {

    private StringUtils() {}

    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
