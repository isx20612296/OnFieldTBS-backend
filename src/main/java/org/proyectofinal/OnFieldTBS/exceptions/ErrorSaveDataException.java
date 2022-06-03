package org.proyectofinal.OnFieldTBS.exceptions;

public class ErrorSaveDataException extends RuntimeException{

    private static final String DESCRIPTION = "Error Save Data Exception";

    public ErrorSaveDataException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
