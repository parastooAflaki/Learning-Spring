package ind.learningSpring.controllers;

import ind.learningSpring.exceptions.PersonNotFoundException;
import ind.learningSpring.exceptions.UserAlreadyExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.jws.WebResult;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { PersonNotFoundException.class } )
    public ResponseEntity<Object> personNotFound(RuntimeException ex , WebRequest request){

        return handleExceptionInternal(
                ex,
                ex.getMessage(),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request

        );


    }

    @ExceptionHandler(value = {UserAlreadyExistsException.class })
    public ResponseEntity <Object> userAlreadyExist(RuntimeException ex , WebRequest request){


        return handleExceptionInternal(
                ex ,
                ex.getMessage(),
                new HttpHeaders(),
                HttpStatus.CONFLICT,
                request
        );

    }



}
