package com.chandan.API_Testing.repository;

import com.chandan.API_Testing.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    //Create Custom Query method to find employee by email
    Optional<Employee> findEmployeeByEmail(String email);

    //find the custom query for JPQL WITH INDEX PARAM
    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1 AND e.lastName = ?2")
    Employee findByJPQL(String firstName,String lastName);


    //find the custom query for JPQL WITH NAMED PARAM
    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName")
    Employee findByJPQLNamedParam(@Param("firstName") String firstName,@Param("lastName") String lastName);

    //find the custom query for Native Query
    @Query(value = "SELECT * FROM employees e WHERE e.first_name = ?1 AND e.last_name = ?2",nativeQuery = true)
    Employee findByNativeQuery(String firstName,String lastName);

    //find the custom query for Native Query with Named Param
    @Query(value = "SELECT * FROM employees e WHERE e.first_name = :firstName AND e.last_name = :lastName",nativeQuery = true)
    Employee findByNativeQueryNamedParam(@Param("firstName") String firstName,@Param("lastName") String lastName);

}
