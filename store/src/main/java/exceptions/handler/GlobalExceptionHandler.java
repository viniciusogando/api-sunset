package exceptions.handler;

import exceptions.details.ExceptionsDetailsNotFound;
import exceptions.notFound.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionsDetailsNotFound handlerNotFoundException(NotFoundException e) {
        return ExceptionsDetailsNotFound.builder()
                .status(NOT_FOUND.value())
                .title("Not Found")
                .timestamp(Instant.now())
                .details(e.getMessage())
                .developerMessage("Include a valid ID. Make sure it exists.")
                .build();
    }

}


   /*ExceptionsDetailsNotFound handlerNotFoundException(NotFoundException e) {
        ExceptionsDetailsNotFound   exceptionsDetailsNotFound = ExceptionsDetailsNotFound.builder()
                .status(NOT_FOUND.value())
                .title("Not Found")
                .timestamp(Instant.now())
                .details(e.getMessage())
                .developerMessage("Include a valid ID. Make sure it exists.")
                .build();
        return exceptionsDetailsNotFound;*/