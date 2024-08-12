package com.springboot.course.springbootexpresscourse.employees.utils;

import com.springboot.course.springbootexpresscourse.employees.exception.ApplicationException;
import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class DomainPreconditions {

    public static void checkDomainState(final boolean expression, final String errorMessage) {
        if (!expression) {
            throw new ApplicationException(errorMessage);
        }
    }

    public static void checkDomainState(final boolean expression, final Supplier<String> errorMessageSupplier) {
        if (!expression) {
            final var errorMessage = errorMessageSupplier.get();
            throw new ApplicationException(errorMessage);
        }
    }
}
