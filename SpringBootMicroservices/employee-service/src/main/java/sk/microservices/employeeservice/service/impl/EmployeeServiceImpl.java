package sk.microservices.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.microservices.employeeservice.EmployeeServiceApplication;
import sk.microservices.employeeservice.dto.EmployeeDto;
import sk.microservices.employeeservice.entity.Employee;
import sk.microservices.employeeservice.repository.EmployeeRepository;
import sk.microservices.employeeservice.service.EmployeeService;

import java.util.UUID;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
//91. EmployeeService - Build Save Employee REST API
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {


        Employee employee = new Employee(employeeDto.getUuid(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()

        );
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getUuid(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );

        return savedEmployeeDto;
    }


    @Override
    public EmployeeDto getEmployeeById(UUID uuid) {
        Employee employee = employeeRepository.findById(uuid).get();
        //So findById method basically returns an optional of type Employee.
        //		So let's use the get() method to get an employee object from the optional.

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getUuid(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );

        return employeeDto;
    }
}