package com.zaf3r.customerstatementprocessor.exception;

public class FileTypeNotSupportedException extends RuntimeException {

    private String unSupportedType;

    public FileTypeNotSupportedException(String message, String unSupportedType) {
        super(message);
        this.unSupportedType = unSupportedType;
    }

    public String getUnSupportedType() {
        return unSupportedType;
    }
}
