package dev.leitzke.rest_apis_with_spring_boot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOperandException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidOperandException(String s) {
        super(s);
    }
}
