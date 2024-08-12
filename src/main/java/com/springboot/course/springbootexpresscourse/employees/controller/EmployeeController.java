package com.springboot.course.springbootexpresscourse.employees.controller;

import com.springboot.course.springbootexpresscourse.employees.service.EmployeeService;
import com.springboot.course.springbootexpresscourse.employees.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/all")
    public List<Employee> getEmployees(){
        return service.getAllEmployees();
    }
    @GetMapping("/employee")
    public Employee getEmployee(@RequestBody Employee employee){
        return service.getEmployeeById(employee.getId());
    }

    @PostMapping("/new")
    public  Employee createNewEmployee(@RequestBody Employee employee){
        return service.getNewEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestParam(required = false) String email,
                                   @RequestParam(required = false)  Integer salary){
        return service.updateEmployee(id, email, salary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        service.removeEmployee(id);
        return ResponseEntity.ok("Employee successfully removed");
    }
}
