package com.pragma.powerup.retoextra.configuration;

import com.pragma.powerup.retoextra.adapters.driven.jpa.mysql.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

import static com.pragma.powerup.retoextra.configuration.Constants.RESPONSE_ERROR_MESSAGE_KEY;
import static com.pragma.powerup.retoextra.configuration.Constants.USER_NOT_FOUND_MESSAGE;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(
            UserNotFoundException userNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, USER_NOT_FOUND_MESSAGE));
    }

}
