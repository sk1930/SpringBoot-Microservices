package sk.microservices.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.microservices.employeeservice.entity.Employee;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    //90. EmployeeService - Create Employee JPA Entity and Spring Data JPA Repository



}
