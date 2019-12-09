package com.zaf3r.customerstatementprocessor.exception;

public class XMLParseException extends RuntimeException {

    private String fileName;

    XMLParseException(String message, Throwable cause, String fileName) {
        super(message, cause);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
