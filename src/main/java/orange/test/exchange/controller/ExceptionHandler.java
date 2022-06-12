package orange.test.exchange.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> handleIllegalArgumentException(RuntimeException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
