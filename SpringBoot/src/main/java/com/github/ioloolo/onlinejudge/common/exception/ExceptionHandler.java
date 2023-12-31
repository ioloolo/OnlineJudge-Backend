package com.github.ioloolo.onlinejudge.common.exception;

import com.github.ioloolo.onlinejudge.common.payload.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;
import java.util.Optional;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        Optional<String> message = e.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .filter(Objects::nonNull)
                .sorted()
                .findFirst();

        return message.map(s -> ResponseEntity.badRequest().body(new ErrorResponse(s)))
                .orElseGet(() -> ResponseEntity.badRequest().body(new ErrorResponse(e)));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {

        return ResponseEntity.internalServerError().body(new ErrorResponse(e));
    }
}
