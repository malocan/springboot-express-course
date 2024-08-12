package com.springboot.course.springbootexpresscourse.employees.config;

import com.springboot.course.springbootexpresscourse.employees.entity.Employee;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
@Slf4j
public class EmployeeDataUtils {


    static List<Employee> retrieveEmployeeData(){
        final var employees = new ArrayList<Employee>();
        final var path = Path.of("./employee-data.txt");
        try(var scanner = new Scanner(path)){
            while (scanner.hasNext()) {
                try{
                    var e = new Employee(
                            scanner.next(),
                            scanner.next(),
                            scanner.next(),
                            scanner.nextInt(),
                            LocalDate.parse(scanner.next())
                    );
                    employees.add(e);
                }catch (Exception e){
                    log.error("Invalid input format");
                }
            }
        }catch (Exception e){
            log.error("File not found via path "+ path);
        }
        return employees;
    }
}
