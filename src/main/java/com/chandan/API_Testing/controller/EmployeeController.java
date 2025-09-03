package com.chandan.API_Testing.controller;

import com.chandan.API_Testing.model.Employee;
import com.chandan.API_Testing.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    //use dependency injection
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    //Create employee
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    //List of all employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    //Update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    //delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }

}
