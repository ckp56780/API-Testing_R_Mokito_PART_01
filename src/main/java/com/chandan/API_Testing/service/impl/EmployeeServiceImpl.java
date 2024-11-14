package com.chandan.API_Testing.service.impl;

import com.chandan.API_Testing.exception.ResourceNotFoundException;
import com.chandan.API_Testing.model.Employee;
import com.chandan.API_Testing.repository.EmployeeRepository;
import com.chandan.API_Testing.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.util.Optionals.ifPresentOrElse;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        Optional<Employee> employeeByEmail = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeByEmail.isPresent()){
            throw new ResourceNotFoundException("Email already taken"+employee.getEmail());
        }

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id"+id));

    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.findById(id).map(employee1 -> {
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setEmail(employee.getEmail());
            return employeeRepository.save(employee1);
        }).orElseThrow(()->new ResourceNotFoundException("Employee not found with id"+id));
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id"+id));
        employeeRepository.delete(employee);
    }
}
