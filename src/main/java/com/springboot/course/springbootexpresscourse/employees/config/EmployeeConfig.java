package com.springboot.course.springbootexpresscourse.employees.config;

import com.springboot.course.springbootexpresscourse.employees.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class EmployeeConfig {

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return (args) -> {
            final var employeeList = EmployeeDataUtils.retrieveEmployeeData();
            repository.saveAll(employeeList);
        };
    }
}
