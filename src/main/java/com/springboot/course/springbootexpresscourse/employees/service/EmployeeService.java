package com.springboot.course.springbootexpresscourse.employees.service;

import com.springboot.course.springbootexpresscourse.employees.entity.Employee;
import com.springboot.course.springbootexpresscourse.employees.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    private final ValidateEmployeeService validationService;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Entity not found"));
    }

    public Employee getNewEmployee(final Employee employee) {
        validationService.validateEmployee(employee);
        return repository.save(employee);
    }

    public void removeEmployee(final Long id) {

        if(repository.findById(id).isPresent()){
            repository.delete(repository.findById(id).get());
        }else {
            throw new NoSuchElementException(format("There is no employee with id %s", id));
        }
    }

    @Transactional
    public Employee updateEmployee(Long id, String email, Integer salary){

        Employee employee = repository.findById(id).orElseThrow(() ->new NoSuchElementException(format("There is no employee with id %s", id)));

        if(email != null && !email.isEmpty() && !email.equals(employee.getEmail())){
            employee.setEmail(email);
        }

        if(salary != null && !salary.equals(employee.getSalary())){
            employee.setSalary(salary);
        }

        return repository.save(employee);
    }
}
