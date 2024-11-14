package com.chandan.API_Testing.service;

import com.chandan.API_Testing.model.Employee;

import java.util.List;

public interface EmployeeService {
    //save employee
    Employee saveEmployee(Employee employee);

    //List of all employees
    List<Employee> getAllEmployees();

    //get employee by id
    Employee getEmployeeById(Long id);

    //Update employee
    Employee updateEmployee(Long id, Employee employee);

    //delete employee
    void deleteEmployee(Long id);

}
