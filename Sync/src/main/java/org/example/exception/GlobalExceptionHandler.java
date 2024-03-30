package org.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentGlobalException.class)
    protected ResponseEntity handleGlobalException(DepartmentGlobalException departmentGlobalException, Locale locale) {
        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .code(departmentGlobalException.getCode())
                .message(departmentGlobalException.getMessage())
                .build());
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleException(Exception e, Locale locale) {
        return ResponseEntity
                .badRequest()
                .body("Exception occurs inside API "+e);
    }
}
