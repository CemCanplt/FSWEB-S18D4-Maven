package com.workintech.s18d1.exceptions;

/*
Interceptor - Hatalarda Araya Girer
*/

import com.workintech.s18d1.exceptions.BurgerErrorException;
import com.workintech.s18d1.exceptions.BurgerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler // Otomatik algılamazsa bunu ekle (BurgerErrorException.class)
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerErrorException theException) {
        BurgerErrorResponse errorResponse = new BurgerErrorResponse();
        errorResponse.setStatusCode(theException.getHttpStatus().value());
        errorResponse.setMessage(theException.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, theException.getHttpStatus());
    }

    @ExceptionHandler // Otomatik algılamazsa bunu ekle (Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleException(Exception theException) {
        BurgerErrorResponse errorResponse = new BurgerErrorResponse();
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage(theException.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
