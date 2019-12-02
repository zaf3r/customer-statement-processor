package com.zaf3r.customerstatementprocessor.util;

import java.util.Optional;

public class DocumentTypeFinder {


    public static Optional<String> findFileTypeFromFileName(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(name -> name.contains("."))
                .map(name -> name.substring(fileName.lastIndexOf(".")+1));
    }
}