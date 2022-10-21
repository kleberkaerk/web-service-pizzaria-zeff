package com.webservicepizzariazeff.www.exception_handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MethodArgumentNotValidExceptionHandlerTest {

    private MethodArgumentNotValidExceptionHandler methodArgumentNotValidExceptionHandler;

    @BeforeEach
    void setMethodArgumentNotValidExceptionHandler() {

        this.methodArgumentNotValidExceptionHandler = MethodArgumentNotValidExceptionHandler.MethodArgumentNotValidExceptionHandlerBuilder.builder()
                .message("message")
                .build();
    }

    @Test
    void getMessage() {

        Assertions.assertThat(this.methodArgumentNotValidExceptionHandler.getMessage())
                .isEqualTo("message");
    }
}