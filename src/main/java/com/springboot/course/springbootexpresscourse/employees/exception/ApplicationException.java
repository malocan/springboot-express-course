package com.springboot.course.springbootexpresscourse.employees.exception;

import java.io.Serial;

public class ApplicationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3234397309786360176L;

    public ApplicationException(final String message) {
        super(message);
    }
}
