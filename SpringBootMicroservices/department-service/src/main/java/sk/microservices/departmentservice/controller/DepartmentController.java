package sk.microservices.departmentservice.controller;


/*86. DepartmentService - Create Department JPA Entity and Spring Data JPA Repository
 */

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import sk.microservices.departmentservice.dto.DepartmentDto;
import sk.microservices.departmentservice.entity.Department;
import sk.microservices.departmentservice.exception.ErrorDetails;
import sk.microservices.departmentservice.exception.ResourceNotFoundException;
import sk.microservices.departmentservice.service.DepartmentService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    /*86. DepartmentService - Create Department JPA Entity and Spring Data JPA Repository
     */

    /*
Well, typically we need to use @Autowired annotation to inject the dependency
But spring 4.3 onwards, whenever there is a spring bean, it has a single parameterized constructor
then we can omit using @Autowired annotation.*/
    private DepartmentService departmentService;

    // http://localhost:8090/api/departments
    /*
    Request
    curl --location 'http://localhost:8090/api/departments/create' \
--header 'Content-Type: application/json' \
--data '{
    "departmentName" : "dep1",
    "departmentDescription" : "department description 1",
    "departmentCode" : "depCode1"
}'

Response:
{
    "uuid": "d1936d1b-adc9-4335-9859-78afe2efd69f",
    "departmentName": "dep1",
    "departmentDescription": "department description 1",
    "departmentCode": "depCode1"
}


     */
    @PostMapping("create")
    public ResponseEntity<DepartmentDto> saveDepartmennt(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return  new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }


    /*Request:
    curl --location 'http://localhost:8090/api/departments/depCode1'

    Response:
    {
    "uuid": "d1936d1b-adc9-4335-9859-78afe2efd69f",
    "departmentName": "dep1",
    "departmentDescription": "department description 1",
    "departmentCode": "depCode1"
}

     */
    //88. DepartmentService - Build Get Department REST API
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return  new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }


    /* commented this and used this code to handle exceptions globally

    //48. Handing Specific Custom Exception - ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "DEPARTMENT_NOT_FOUND"
        );

        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);



    }

     */






}