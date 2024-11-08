package com.abc.loyaltypointsystem.handler;


import com.abc.loyaltypointsystem.exceptions.CustomerAlreadyExistsException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handelException(CustomerAlreadyExistsException exp){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .errorCode(HttpStatus.FORBIDDEN.value())
                .errorDescription(exp.getMessage())
                .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handelException(MethodArgumentNotValidException exp){

        Set<String> errorMessages = exp.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toSet());

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .errorMessages(errorMessages)
                .build();

        return new ResponseEntity<>(exceptionResponse, exp.getStatusCode());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handelException(HttpMessageNotReadableException exp){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .errorDescription(exp.getLocalizedMessage())
                .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }




//
//    @ExceptionHandler(UnexpectedTypeException.class)
//    public ResponseEntity<ExceptionResponse> handelException(UnexpectedTypeException exp){
//        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
//                .errorCode(HttpStatus.BAD_REQUEST.value())
//                .errorDescription(exp.getLocalizedMessage())
//                .build();
//
//        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }

}
