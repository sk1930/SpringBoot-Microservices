package sk.microservices.departmentservice.service;

import sk.microservices.departmentservice.dto.DepartmentDto;


/*86. DepartmentService - Create Department JPA Entity and Spring Data JPA Repository
 */
public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    //88. DepartmentService - Build Get Department REST API
    DepartmentDto getDepartmentByCode(String code);
}
