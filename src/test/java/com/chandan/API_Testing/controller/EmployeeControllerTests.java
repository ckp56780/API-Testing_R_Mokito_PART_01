package com.chandan.API_Testing.controller;

import com.chandan.API_Testing.exception.ResourceNotFoundException;
import com.chandan.API_Testing.model.Employee;
import com.chandan.API_Testing.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

     @MockBean
     private EmployeeService employeeService;

     @Autowired
    private ObjectMapper objectMapper;

      //Junit Test for
          @Test
          public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception {
              //given-pre-Condition
              Employee employee= Employee.builder()
                      .firstName("chandan")
                      .lastName("kumar")
                      .email("ckp56780@gmail.com").build();
              BDDMockito.given(employeeService.saveEmployee(ArgumentMatchers.any(Employee.class)))
                      .willAnswer((invocation)->invocation.getArgument(0));
              //when-action or behaviour that we want to test
              ResultActions respose = mockMvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON)
                      .content(objectMapper.writeValueAsString(employee)));

              //then-verifying the result
              respose.andDo(MockMvcResultHandlers.print())
              .andExpect(MockMvcResultMatchers.status().isCreated())
                      //.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(employee.getId())))
                      .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",CoreMatchers.is(employee.getFirstName())))
                      .andExpect(MockMvcResultMatchers.jsonPath("$.lastName",CoreMatchers.is(employee.getLastName())))
                      .andExpect(MockMvcResultMatchers.jsonPath("$.email",CoreMatchers.is(employee.getEmail())));

          }

          //Junit Test for get all employees
            @Test
            public void givenEmployeeObject_whenGetAllEmployees_thenReturnAllEmployees() throws Exception {
                //given-pre-Condition
                List<Employee> ListOfEmployee = new ArrayList<>();
                ListOfEmployee.add(Employee.builder()
                        .firstName("chandan")
                        .lastName("kumar")
                        .email("ckp56780@gmail.com").build());
                ListOfEmployee.add(Employee.builder().firstName("mohan")
                        .lastName("kumar")
                        .email("mohan@gmail.com").build());
                BDDMockito.given(employeeService.getAllEmployees()).willReturn(ListOfEmployee);

                //when-action or behaviour that we want to test
                ResultActions respose = mockMvc.perform(get("/api/employees"));

                //then-verifying the result
                respose.andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(ListOfEmployee.size())));
            }

            //Junit Test for get employee by id
    //This test case for positive scenario when get employee by id
            @Test
            public void givenEmployeeObject_whenGetEmployeeById_thenReturnEmployee() throws Exception {
                //given-pre-Condition
                Employee employee = Employee.builder()
                        .id(1L)
                        .firstName("chandan")
                        .lastName("kumar")
                        .email("ckp56780@gmail.com").build();
                BDDMockito.given(employeeService.getEmployeeById(employee.getId())).willReturn(employee);

                //when-action or behaviour that we want to test
                ResultActions respose = mockMvc.perform(get("/api/employees/{id}", +employee.getId() ));

                //then-verifying the result
                respose.andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(employee.getId().intValue())))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employee.getEmail())));
            }

            //This test case for negative scenario when get employee by id is not present
            @Test
            public void givenEmployeeObject_whenGetEmployeeById_thenReturnEmployee_whenEmployeeIsNotPresent() throws Exception {
                //given-pre-Condition
                Employee employee = Employee.builder()
                        .id(1L)
                        .firstName("chandan")
                        .lastName("kumar")
                        .email("ckp56780@gmail.com").build();
                BDDMockito.given(employeeService.getEmployeeById(employee.getId())).willThrow(new ResourceNotFoundException("Employee not found with id"+employee.getId()));


                //when-action or behaviour that we want to test
                ResultActions respose = mockMvc.perform(get("/api/employees/{id}", +employee.getId() ));

                //then-verifying the result
                respose.andExpect(MockMvcResultMatchers.status().isNotFound())
                        .andDo(MockMvcResultHandlers.print());
            }

            //Test case for update employee
            @Test
            public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() throws Exception {
                //given-pre-Condition
                Employee savedEmployee = Employee.builder()
                        .id(1L)
                        .firstName("chandan")
                        .lastName("kumar")
                        .email("ckp56780@gmail.com").build();

                Employee updatedEmployee = Employee.builder()
                        .id(1L)
                        .firstName("sita")
                        .lastName("kumari")
                        .email("sita@gmail.com").build();


                BDDMockito.given(employeeService.updateEmployee(savedEmployee.getId(),savedEmployee)).willReturn(savedEmployee);
                BDDMockito.given(employeeService.updateEmployee(updatedEmployee.getId(),updatedEmployee)).willAnswer((invocation)->invocation.getArgument(1));

                //when-action or behaviour that we want to test
                ResultActions respose = mockMvc.perform(put("/api/employees/{id}", +savedEmployee.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(savedEmployee)));

                //then-verifying the result
                respose.andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(updatedEmployee.getId().intValue())))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(updatedEmployee.getFirstName())))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(updatedEmployee.getLastName())))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(updatedEmployee.getEmail())));

            }

            //Test case for delete employee
            @Test
            public void givenEmployeeObject_whenDeleteEmployee_thenReturnSuccessMessage() throws Exception {
                //given-pre-Condition

                long employeeId = 1L;
                BDDMockito.doNothing().when(employeeService).deleteEmployee(employeeId);

                //when-action or behaviour that we want to test
                ResultActions respose = mockMvc.perform(delete("/api/employees/{id}", +employeeId));

                //then-verifying the result
                respose.andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.content().string("Employee deleted successfully"));
            }


}
