package com.app.medicine_finder.util;

public class MedicineNameNormalizer {

    private MedicineNameNormalizer() {
        // prevent instantiation
    }

    public static String normalize(String name) {
        if (name == null) return "";
        return name
                .toLowerCase()
                .trim()
                .replaceAll("\\s+", " ");
    }
}

