package com.zaf3r.customerstatementprocessor.util;

import java.util.Optional;

public class DocumentHelper {

    public static Optional<String> getFileExtensionFromFileName(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(name -> name.contains("."))
                .map(name -> name.substring(fileName.lastIndexOf(".") + 1));
    }
}
