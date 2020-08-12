package com.teamjw.template.mq.app;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  전역 예외처리 핸들러
 *  모든 예외 처리를 캡쳐하여 핸들링 한다.
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        log.error("handleException", e);
        log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return new ResponseEntity<>(new ErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Getter
    private class ErrorResponse {

        private String name = "";
    }
}
