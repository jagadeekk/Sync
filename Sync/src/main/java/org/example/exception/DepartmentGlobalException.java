package org.example.exception;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentGlobalException extends RuntimeException {
    private String code;
    private String message;
}
