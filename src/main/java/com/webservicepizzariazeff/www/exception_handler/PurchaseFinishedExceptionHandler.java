package com.webservicepizzariazeff.www.exception_handler;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

public class PurchaseFinishedExceptionHandler {


    @Schema(example = "Your order is already ready, so it cannot be cancelled. In a few minutes it will be delivered in your house.")
    private final String message;

    @JsonCreator()
    private PurchaseFinishedExceptionHandler(@JsonProperty("message") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseFinishedExceptionHandler that = (PurchaseFinishedExceptionHandler) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    public static final class PurchaseFinishedExceptionHandlerBuilder {
        private String message;

        private PurchaseFinishedExceptionHandlerBuilder() {
        }

        public static PurchaseFinishedExceptionHandlerBuilder builder() {
            return new PurchaseFinishedExceptionHandlerBuilder();
        }

        public PurchaseFinishedExceptionHandlerBuilder message(String message) {
            this.message = message;
            return this;
        }

        public PurchaseFinishedExceptionHandler build() {
            return new PurchaseFinishedExceptionHandler(message);
        }
    }
}
