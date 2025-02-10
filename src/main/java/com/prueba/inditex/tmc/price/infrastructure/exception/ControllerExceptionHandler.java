package com.prueba.inditex.tmc.price.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {
        @SuppressWarnings("null")
        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public ResponseEntity<Map<String, String>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
            if (ex.getRequiredType().equals(LocalDateTime.class)) {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("Error", "Formato de fecha incorrecto. Usa una fecha válida con formato 'yyyy-MM-dd HH:mm:ss'.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Parámetro inválido."));
        }
}
