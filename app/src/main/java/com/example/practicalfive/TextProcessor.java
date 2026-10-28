package com.example.practicalfive;

public class TextProcessor {

    public static final String[] VALID_MUNICIPALITIES = {"Beijing", "Shanghai", "Tianjin", "Chongqing"};

    public String processMunicipality(String municipality) {
        if (municipality == null || municipality.trim().isEmpty()) {
            return null;
        }

        String trimmed = municipality.trim();

        for (String valid : VALID_MUNICIPALITIES) {
            if (valid.equalsIgnoreCase(trimmed)) {
                return valid;
            }
        }

        return null;
    }
}
