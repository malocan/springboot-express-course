package com.springboot.course.springbootexpresscourse.employees.controller;

import com.springboot.course.springbootexpresscourse.employees.exception.ApplicationException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(final @NotNull Exception ex, final Object body,
                                                             final @NotNull HttpHeaders headers, final @NotNull HttpStatusCode statusCode, final @NotNull WebRequest request) {
        if (statusCode.is4xxClientError()) {
            log.warn("Handling 4xx error: {}", ex.getMessage(), ex);
        } else {
            log.error(ex.getMessage(), ex);
        }
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    @SneakyThrows
    @ExceptionHandler({ApplicationException.class, HttpClientErrorException.BadRequest.class, ConstraintViolationException.class})
    public ResponseEntity<Object> handleApplicationExceptions(final Exception ex, final WebRequest request) {
        final var httpStatus = HttpStatus.BAD_REQUEST;
        final var problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, ex.getMessage());
        return this.handleExceptionInternal(ex, problemDetail, new HttpHeaders(), httpStatus, request);
    }

    @SneakyThrows
    @ExceptionHandler({HttpClientErrorException.NotFound.class})
    public ResponseEntity<Object> handleNotFoundException(final Exception ex, final WebRequest request) {
        final var httpStatus = HttpStatus.NOT_FOUND;
        final var problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, ex.getMessage());
        return this.handleExceptionInternal(ex, problemDetail, new HttpHeaders(), httpStatus, request);
    }
}
