package org.proyectofinal.OnFieldTBS.exceptions.advise;


import org.proyectofinal.OnFieldTBS.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ApiExceptionHandler {


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthorizedException.class })
    public ErrorMessage unauthorizedRequest(Exception exception){
        return new ErrorMessage(exception, HttpStatus.UNAUTHORIZED.value());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class })
    public ErrorMessage notFoundRequest(Exception exception){
        return new ErrorMessage(exception, HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            MethodArgumentTypeMismatchException.class,
            org.springframework.dao.DuplicateKeyException.class,
    })
    public ErrorMessage badRequest(Exception exception) {
        return new ErrorMessage(exception, HttpStatus.BAD_REQUEST.value());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ HttpMessageNotReadableException.class })
    public ErrorMessage notBody(Exception exception) {
       Integer code = HttpStatus.BAD_REQUEST.value();
       String error = exception.getClass().getSimpleName();
       String message = "The request body are missing or something is wrong there, it necessary to process this request.";
       return new ErrorMessage(code, error, message);
    }


    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ConflictException.class })
    public ErrorMessage conflict(Exception exception) {
        return new ErrorMessage(exception, HttpStatus.CONFLICT.value());
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler({ErrorSaveDataException.class})
    public ErrorMessage errorSaveData(Exception exception){
        return new ErrorMessage( exception, HttpStatus.NOT_IMPLEMENTED.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    public ErrorMessage exception(Exception exception) { // Any other request that is not contemplated, the error must be corrected
        return new ErrorMessage(exception, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
