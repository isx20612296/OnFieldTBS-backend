package org.proyectofinal.OnFieldTBS.exceptions.advise;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorMessage {
    private final Integer code;
    private final String error;
    private final String message;


    ErrorMessage(Exception exception, Integer code) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.code = code;
    }

    public ErrorMessage(Integer code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }
}
