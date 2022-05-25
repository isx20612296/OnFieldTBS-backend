package org.proyectofinal.OnFieldTBS.exceptions.advise;


import org.proyectofinal.OnFieldTBS.exceptions.BadRequestException;
import org.proyectofinal.OnFieldTBS.exceptions.ConflictException;
import org.proyectofinal.OnFieldTBS.exceptions.NotFoundException;
import org.proyectofinal.OnFieldTBS.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({
            org.springframework.security.access.AccessDeniedException.class,
            UnauthorizedException.class
    })
    @ResponseBody
    public ErrorMessage unauthorizedRequest(Exception exception){
        return new ErrorMessage(exception, HttpStatus.UNAUTHORIZED.value());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class })
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception exception){
        return new ErrorMessage(exception, HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.dao.DuplicateKeyException.class,
            org.springframework.web.bind.support.WebExchangeBindException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class
    })
    @ResponseBody
    public ErrorMessage badRequest(Exception exception) {
        return new ErrorMessage(exception, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ConflictException.class })
    @ResponseBody
    public ErrorMessage conflict(Exception exception) {
        return new ErrorMessage(exception, HttpStatus.CONFLICT.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public ErrorMessage exception(Exception exception) { // Any other request that is not contemplated, the error must be corrected
        return new ErrorMessage(exception, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
