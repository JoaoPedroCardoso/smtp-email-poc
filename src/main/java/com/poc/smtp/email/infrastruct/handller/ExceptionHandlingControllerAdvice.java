package com.poc.smtp.email.infrastruct.handller;

import com.poc.smtp.email.infrastruct.exceptions.ObjectNotFoundException;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(ObjectNotFoundException.class)
    private ResponseEntity<ErrorMessageResponse> handleObjectNotFoundException(ObjectNotFoundException exception) {

        ErrorMessageResponse errorMessageResponse = ErrorMessageResponse.of(
                HttpStatus.BAD_REQUEST,
                exception.getMessage());

        log.warning("ObjectNotFound exception: " + errorMessageResponse.getMessage());

        return ResponseEntity.badRequest().body(errorMessageResponse);
    }

}