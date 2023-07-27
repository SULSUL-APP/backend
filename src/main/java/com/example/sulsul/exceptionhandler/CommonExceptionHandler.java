package com.example.sulsul.exceptionhandler;

import com.example.sulsul.exception.AccessNotAllowedException;
import com.example.sulsul.exception.BadInputException;
import com.example.sulsul.exception.ResourceNotFoundException;
import com.example.sulsul.exception.S3FileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(BadInputException.class)
    public ResponseEntity<ErrorResponse> badInputExceptionHandler(BadInputException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(e.getCode())
                .messages(e.getMessage())
                .errors(e.getErrors())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(e.getCode())
                .messages(e.getMessage())
                .errors(e.getErrors())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccessNotAllowedException.class)
    public ResponseEntity<ErrorResponse> accessNotAllowedExceptionHandler(AccessNotAllowedException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(e.getCode())
                .messages(e.getMessage())
                .errors(e.getErrors())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(S3FileException.class)
    public ResponseEntity<ErrorResponse> s3ExceptionHandler(S3FileException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(e.getCode())
                .messages(e.getMessage())
                .errors(e.getErrors())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }
}