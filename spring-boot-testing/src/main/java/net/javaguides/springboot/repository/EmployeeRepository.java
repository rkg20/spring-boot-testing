package net.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 
    Optional<Employee> findByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1 AND e.lastName = ?2")
    Employee findByJPQL(String firstName, String lastName); 

    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName")
    Employee findByJPQLNamedParams(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query(
        value = "SELECT * FROM employees e WHERE e.first_name = ?1 AND e.last_name = ?2",
        nativeQuery = true
    )  
    Optional<Employee> findByNativeSQLUsingIndexParams(String firstName, String lastName);

    @Query(
        value = "SELECT * FROM employees e WHERE e.first_name = :firstName AND e.last_name = :lastName",
        nativeQuery = true
    )
    Optional<Employee> findByNativeSQLNamedParams(@Param("firstName") String firstName, @Param("lastName") String lastName);

    

}