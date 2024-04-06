package sk.microservices.employeeservice.service;

import sk.microservices.employeeservice.EmployeeServiceApplication;
import sk.microservices.employeeservice.dto.EmployeeDto;

import java.util.UUID;

public interface EmployeeService {
    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public EmployeeDto getEmployeeById(UUID uuid);
}
