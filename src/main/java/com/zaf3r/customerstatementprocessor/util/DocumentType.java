package com.zaf3r.customerstatementprocessor.util;

import java.util.Arrays;

public enum DocumentType {
    CSV("CSV"),
    XML("XML"),
    UNKNOWN("UNKNOWN");

    private DocumentType(String fileType) {
    }

    public static DocumentType findTypeByString(String type) {
        return Arrays.stream(DocumentType.values())
                .filter(type::equals)
                .findFirst()
                .orElse(DocumentType.UNKNOWN);
    }
}
