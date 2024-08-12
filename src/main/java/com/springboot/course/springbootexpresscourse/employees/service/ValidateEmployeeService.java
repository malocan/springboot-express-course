package com.springboot.course.springbootexpresscourse.employees.service;

import com.springboot.course.springbootexpresscourse.employees.entity.Employee;
import com.springboot.course.springbootexpresscourse.employees.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.springboot.course.springbootexpresscourse.employees.utils.DomainPreconditions.checkDomainState;
import static java.lang.String.format;


@Service
@Slf4j
@RequiredArgsConstructor
public class ValidateEmployeeService {

    private final EmployeeRepository repository;

    public void validateEmployee(final Employee employee){
        validateId(employee);
        validateSalary(employee);
        validateAge(employee);
        validateEmail(employee);
    }

    public void validateForUpdate(final Employee employee){
        validateSalary(employee);
        validateEmail(employee);
    }

    private void validateId(final Employee employee){
        checkDomainState(employee.getId() == null, "ID must be empty");
    }

    private void validateEmail(final Employee employee){
        String newEmailToRegister = employee.getEmail();
        checkDomainState(newEmailToRegister.contains("@"), "Incorrect email format");

        Optional<Employee> existingEmployee = repository.findByEmail(newEmailToRegister);
        checkDomainState(existingEmployee.isEmpty(), "This email already exist");
    }

    private void validateAge(final Employee employee){
        LocalDate dateOfBirth = employee.getDateOfBirth();
        checkDomainState(isEligibleToWork(dateOfBirth), "Not allowed to work if person under 18");
    }

    private void validateSalary(final Employee employee){
        checkDomainState(employee.getSalary()>5000, "Salary must be greater than 5000");
    }

    private static boolean isEligibleToWork(LocalDate date){
        return Period.between(date, LocalDate.now()).getYears() >= 18;
    }
}
