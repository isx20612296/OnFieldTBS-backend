package org.proyectofinal.OnFieldTBS.exceptions;

public class UnauthorizedException extends RuntimeException{
    private static final String DESCRIPTION = "You are Unauthorized";

    public UnauthorizedException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
