package com.chandan.API_Testing.repository;

import com.chandan.API_Testing.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
    public void setUp() {
         employee = Employee.builder()
                .firstName("chandan")
                .lastName("kumar")
                .email("ckp56780@gmail.com").build();
    }

    //Junit test for save employee operation
    @Test
    @DisplayName("Test save employee")
    //@DisplayName is used to give the name of the test
    public void given_when_then() {

        //given-pre-Condition
//        Employee employee = Employee.builder()
//                .firstName("Chandan")
//                .lastName("Kumar")
//                .email("ckp56780@gmail.com").build();

        //when-action or behaviour that we want to test
        Employee savedEmployee = employeeRepository.save(employee);

        //then-verifying the
        //Assertions-take from the assertJ library nt from jupiter
        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);

    }

    //Junit Test for findAll employee operation
    @DisplayName("Test findAll employee")
    @Test
    public void givenEmployeeList_whenFindAll_thenListOfEmployee() {
        //given-pre-Condition
//        Employee employee = Employee.builder()
//                .firstName("chandan")
//                .lastName("kumar")
//                .email("ckp56780@gmail.com").build();
        Employee employee1=Employee.builder().firstName("chandan").lastName("kumar").email("ckp56780@gmail.com").build();
        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        //when-action or behaviour that we want to test
        List<Employee> ListOfEmployee = employeeRepository.findAll();

        //then-verifying the result
        assertThat(ListOfEmployee).isNotNull();
        assertThat(ListOfEmployee.size()).isEqualTo(2);

    }

    //Junit Test case for get employee by id

    @DisplayName("Test get employee by id")
    @Test
    public void givenEmployeeId_whenFindById_thenEmployee() {
        //given-pre-Condition
//        Employee employee = Employee
//                .builder()
//                .firstName("chandan")
//                .lastName("kumar")
//                .email("ckp56780@gmail.com").build();
        Employee savedEmployee = employeeRepository.save(employee);

        //when-action or behaviour that we want to test
        Employee getEmployee = employeeRepository.findById(savedEmployee.getId()).get();

        //then-verifying the result
        assertThat(getEmployee).isNotNull();
    }

    //Junit Test Case for get Employee by email
    @DisplayName("Test get employee by email")
    @Test
    public void givenEmployeeEmail_whenFindByEmail_thenEmployeeObject() {
        //given-pre-Condition
//        Employee employee = Employee
//                .builder()
//                .firstName("chandan")
//                .lastName("kumar")
//                .email("ckp56780@gmail.com").build();
                Employee savedEmployee = employeeRepository.save(employee);

        //when-action or behaviour that we want to test
        Employee getEmployee = employeeRepository.findEmployeeByEmail(savedEmployee.getEmail()).get();

        //then-verifying the result
        assertThat(getEmployee).isNotNull();
    }

    //Junit test case for update employee
    @DisplayName("Test update employee")
    @Test
    public void givenEmployee_whenUpdate_thenEmployeeUpdated() {
        //given-pre-Condition
//        Employee employee = Employee
//                .builder()
//                .firstName("chandan")
//                .lastName("kumar")
//                .email("ckp56780@gmail.com").build();
        Employee savedEmployee = employeeRepository.save(employee);

        //when-action or behaviour that we want to test
        savedEmployee.setFirstName("mohan");
        Employee updatedEmployee = employeeRepository.save(savedEmployee);

        //then-verifying the result
        assertThat(updatedEmployee.getFirstName()).isEqualTo("mohan");
    }

    //Junit test case for delete employee
    @DisplayName("Test delete employee")
    @Test
    public void givenEmployeeId_whenDelete_thenEmployeeDeleted() {
        //given-pre-Condition
//        Employee employee = Employee
//                .builder()
//                .firstName("chandan")
//                .lastName("kumar")
//                .email("ckp56780@gmail.com").build();
        Employee savedEmployee = employeeRepository.save(employee);

        //when-action or behaviour that we want to test
        employeeRepository.findById(savedEmployee.getId());
        employeeRepository.deleteById(savedEmployee.getId());

        //then-verifying the result
        assertThat(employeeRepository.findById(savedEmployee.getId())).isEmpty();
    }

    //Junit test case for JPQL query
    @DisplayName("Test JPQL query")
    @Test
    public void givenEmployeeName_whenFindByJPQL_thenEmployeeObject() {
        //given-pre-Condition
//        Employee employee = Employee
//                .builder()
//                .firstName("chandan")
//                .lastName("Kumar")
//                .email("ckp56780@gmail.com").build();
        Employee savedEmployee = employeeRepository.save(employee);
        String firstName = "chandan";
        String lastName = "kumar";

        //when-action or behaviour that we want to test
        Employee getEmployee = employeeRepository.findByJPQL(firstName, lastName);

        //then-verifying the result
        assertThat(getEmployee).isNotNull();
    }

    //Junit test case for JPQL query with named parameter
    @DisplayName("Test JPQL query with named parameter")
    @Test
    public void givenEmployeeName_whenFindByJPQLNamedParam_thenEmployeeObject() {
        //given-pre-Condition
//        Employee employee = Employee
//                .builder()
//                .firstName("chandan")
//                .lastName("Kumar")
//                .email("ckp56780@gmail.com").build();
        Employee savedEmployee = employeeRepository.save(employee);
        String firstName = "chandan";
        String lastName = "kumar";

        //when-action or behaviour that we want to test
        Employee getEmployee = employeeRepository.findByJPQLNamedParam(firstName, lastName);

        //then-verifying the result
        assertThat(getEmployee).isNotNull();
    }

    //Junit test case for Native query
    @DisplayName("Test Native query")
    @Test
    public void givenEmployeeName_whenFindByNativeQuery_thenEmployeeObject() {
        //given-pre-Condition
//        Employee employee = Employee
//                .builder()
//                .firstName("chandan")
//                .lastName("Kumar")
//                .email("ckp56780@gmail.com").build();
        Employee savedEmployee = employeeRepository.save(employee);

        //when-action or behaviour that we want to test
        Employee getEmployee = employeeRepository.findByNativeQuery(employee.getFirstName(), employee.getLastName());

        //then-verifying the result
        assertThat(getEmployee).isNotNull();
    }

    //Junit test case for Native query with named parameter
    @DisplayName("Test Native query with named parameter")
    @Test
    public void givenEmployeeName_whenFindByNativeQueryNamedParam_thenEmployeeObject() {
        //given-pre-Condition
//        Employee employee = Employee
//                .builder()
//                .firstName("chandan")
//                .lastName("kumar")
//                .email("ckp56780@gmail.com").build();
        Employee savedEmployee = employeeRepository.save(employee);
//        String firstName = "Rahul";
//        String lastName = "Kumar";

        //when-action or behaviour that we want to test
        Employee getEmployee = employeeRepository.findByNativeQueryNamedParam(employee.getFirstName(), employee.getLastName());

        //then-verifying the result
        assertThat(getEmployee).isNotNull();
    }

}
