package com.github.goodfatcat.computershop.util;

import lombok.Data;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ErrorsUtil {
    public static List<String> showErrors(Errors errors) {
        return errors.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
    }

    public static ResponseEntity<ResponseError> getResponseEntity(HttpStatus status, String path, List<String> messages) {
        ResponseError responseError = new ResponseError();
        responseError.setStatus(status.value());
        responseError.setError(status.getReasonPhrase());
        responseError.setPath(path);
        responseError.setMessages(messages);
        return new ResponseEntity<>(responseError, status);
    }

    @Data
    private static class ResponseError {
        private LocalDateTime timeStamp = LocalDateTime.now();
        private int status;
        private String error;
        private String path;
        private List<String> messages;

    }
}
