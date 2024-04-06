package sk.microservices.employeeservice.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.microservices.employeeservice.dto.EmployeeDto;
import sk.microservices.employeeservice.service.EmployeeService;

import java.util.UUID;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //91. EmployeeService - Build Save Employee REST API
    /*
    Request
    curl --location 'http://localhost:8091/api/employees/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName" : "firstName1",
    "lastName" : "lastName 1",
    "email" : "firstName1@gmail.com"
}'
Response:
{
    "uuid": "7148b671-f1d2-4341-aa94-178ae3845860",
    "firstName": "firstName1",
    "lastName": "lastName 1",
    "email": "firstName1@gmail.com"
}

     */
    @PostMapping("create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    /*Request:
    curl --location 'http://localhost:8091/api/employees/7148b671-f1d2-4341-aa94-178ae3845860'

    Response:
    {
    "uuid": "7148b671-f1d2-4341-aa94-178ae3845860",
    "firstName": "firstName1",
    "lastName": "lastName 1",
    "email": "firstName1@gmail.com"
}
     */
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") UUID uuid){
        EmployeeDto employeeDto = employeeService.getEmployeeById(uuid);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }



}
