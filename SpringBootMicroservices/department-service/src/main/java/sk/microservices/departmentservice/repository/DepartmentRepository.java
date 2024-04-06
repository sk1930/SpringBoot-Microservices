package sk.microservices.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.microservices.departmentservice.dto.DepartmentDto;
import sk.microservices.departmentservice.entity.Department;

import java.util.UUID;
/*86. DepartmentService - Create Department JPA Entity and Spring Data JPA Repository
 */
public interface DepartmentRepository extends JpaRepository<Department, UUID> {



    /*let's write one spring data JPA query method that will retrieve a department by department code.
	So let's go to DepartmentRepository and within a DepartmentRepository let's write a query method.
	let's give method name as findByDepartmentCode and return type of the method as Department.

	So this is the naming convention that typically we follow to create the query method using spring data JPA.
	pass a parameter as a departmentCode
     */
    //88. DepartmentService - Build Get Department REST API
    Department findByDepartmentCode(String departmentCode);
}
