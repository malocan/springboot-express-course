package com.springboot.course.springbootexpresscourse.employees.repository;

import com.springboot.course.springbootexpresscourse.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);
}
