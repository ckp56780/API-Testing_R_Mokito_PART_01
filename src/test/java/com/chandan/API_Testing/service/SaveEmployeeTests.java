package com.chandan.API_Testing.service;

import com.chandan.API_Testing.model.Employee;
import com.chandan.API_Testing.repository.EmployeeRepository;
import com.chandan.API_Testing.service.impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static java.util.Collection.*;

@ExtendWith(MockitoExtension.class)
public class SaveEmployeeTests {
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @Mock
    private EmployeeRepository employeeRepository;
    private Employee employee;


    @BeforeEach
    public void setUp() {
       // employeeRepository= Mockito.mock(EmployeeRepository.class);
      //  employeeService = new EmployeeServiceImpl(employeeRepository);

         employee = Employee.builder()
                .id(1L)
                .firstName("chandan")
                .lastName("kumar")
                .email("ckp56780@gmail.com").build();
    }

    //Junit test for save employee operation
    @DisplayName("Test save employee")
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() {
        //given-pre-Condition

        BDDMockito.given(employeeRepository.findEmployeeByEmail(employee.getEmail())).willReturn(Optional.empty());

        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        //print the saved employee
        System.out.println(employeeRepository);
        //print the employeeService
        System.out.println(employeeService);

        //when-action or behaviour that we want to test
        Employee savedEmployee = employeeService.saveEmployee(employee);

        //print the saved employee
        System.out.println(savedEmployee);

        //then-verifying the RESULT
        //Assertions-take from the assertJ library not from jupiter
        Assertions.assertThat(savedEmployee).isNotNull();
    }


    //Junit test case for save employee operation when employee already exists
    @DisplayName("Test save employee when employee already exists which throws exception")
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject_whenEmployeeAlreadyExists() {
        //given-pre-Condition

        BDDMockito.given(employeeRepository.findEmployeeByEmail(employee.getEmail())).willReturn(Optional.of(employee));

        //when-action or behaviour that we want to test
        Employee savedEmployee = employeeService.saveEmployee(employee);

        //then-verifying the RESULT
        //Assertions-take from the assertJ library not from jupiter
        Assertions.assertThat(savedEmployee).isNull();
    }

    //Junit test case for the get All employees operation
    @DisplayName("Test get all employees")
    @Test
    public void givenEmployeeObject_whenGetAllEmployees_thenReturnListOfEmployees() {
        //given-pre-Condition
        //let create another employee object
        Employee employee1 = Employee.builder()
                .id(2L)
                .firstName("mohan")
                .lastName("kumar")
                .email("mohan@gmail.com").build();

        java.util.List<Employee> value = new java.util.ArrayList<>();
        value.add(employee);
        value.add(employee1);
        BDDMockito.given(employeeRepository.findAll()).willReturn(value);

        //when-action or behavior that we want to test
        java.util.List<Employee> employees = employeeService.getAllEmployees();

        //then-verifying the RESULT
        //Assertions-take from the assertJ library not from jupiter
        Assertions.assertThat(employees).isNotNull();
        Assertions.assertThat(employees.size()).isEqualTo(2);
    }

    //write junit test case for get all employees when no employee is present which is negative test case
    @DisplayName("Test get all employees when no employee is present")
    @Test
    public void givenEmployeeObject_whenGetAllEmployees_thenReturnEmptyListOfEmployees() {
        //given-pre-Condition
        BDDMockito.given(employeeRepository.findAll()).willReturn(Collections.EMPTY_LIST);

        //when-action or behaviour that we want to test
        java.util.List<Employee> employees = employeeService.getAllEmployees();

        //then-verifying the RESULT
        //Assertions-take from the assertJ library not from jupiter
        Assertions.assertThat(employees).isEmpty();
        Assertions.assertThat(employees.size()).isEqualTo(0);
    }

    //write junit test case for get employee by id
    @DisplayName("Test get employee by id")
    @Test
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject() {
        //given-pre-Condition
        BDDMockito.given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

        //when-action or behaviour that we want to test
        Employee employeeById = employeeService.getEmployeeById(1L);

        //then-verifying the RESULT
        //Assertions-take from the assertJ library not from jupiter
        Assertions.assertThat(employeeById).isNotNull();
    }

    //write junit test case for get employee by id when employee is not present
    @DisplayName("Test get employee by id when employee is not present")
    @Test
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject_whenEmployeeIsNotPresent() {
        //given-pre-Condition
        BDDMockito.given(employeeRepository.findById(1L)).willReturn(Optional.empty());

        //when-action or behaviour that we want to test
        Employee employeeById = employeeService.getEmployeeById(1L);

        //then-verifying the RESULT
        //Assertions-take from the assertJ library not from jupiter
        Assertions.assertThat(employeeById).isNull();
    }

    //write junit test case for update employee
    @DisplayName("Test update employee")
    @Test
    public void givenEmployeeIdAndEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployeeObject() {
        //given-pre-Condition
        Employee updatedEmployee = Employee.builder()
                .id(1L)
                .firstName("sita")
                .lastName("kumari")
                .email("sit@gmail.com").build();

        BDDMockito.given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));
        BDDMockito.given(employeeRepository.save(employee)).willReturn(updatedEmployee);

        //when-action or behaviour that we want to test
        Employee employeeById = employeeService.updateEmployee(1L, updatedEmployee);

        //then-verifying the RESULT
        //Assertions-take from the assertJ library not from jupiter
        Assertions.assertThat(employeeById).isNotNull();
        Assertions.assertThat(employeeById.getFirstName()).isEqualTo("sita");
        Assertions.assertThat(employeeById.getLastName()).isEqualTo("kumari");
        Assertions.assertThat(employeeById.getEmail()).isEqualTo("sit@gmail.com");
    }

    //WRITE TEST CASE FOR DELETE EMPLOYEE
    @DisplayName("Test delete employee")
    @Test
    public void givenEmployeeId_whenDeleteEmployee_thenEmployeeShouldBeDeleted() {
        //given-pre-Condition
        BDDMockito.given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

        //when-action or behaviour that we want to test
        employeeService.deleteEmployee(1L);

        //then-verifying the RESULT
        //Assertions-take from the assertJ library not from jupiter
        Mockito.verify(employeeRepository, Mockito.times(1)).delete(employee);
    }


}
