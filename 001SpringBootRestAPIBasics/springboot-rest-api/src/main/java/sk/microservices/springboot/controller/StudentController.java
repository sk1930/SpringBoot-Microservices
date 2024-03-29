package sk.microservices.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.microservices.springboot.beans.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
// 18. Define Base URL for REST API’s in Spring MVC Controller - @RequestMapping
// After adding RequestMapping students , students can be removed from each of the below GetMapping URLs
public class StudentController {
    // 10. SpringBoot REST API returns Java Bean


    /* changing the return type below to ResponseEntity
    //http:localhost:8090/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1,"sai","krishna");

        return student;
    }
     */

    //17. Using Spring ResponseEntity class to Manipulate the HTTP Response
    //http:localhost:8090/student
    // after adding students in RequestMapping at class definition
    // url is now     //http:localhost:8090/students/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"sai","krishna");

        /* one way
        return new ResponseEntity<Student>(student,HttpStatus.OK);
         */
        /* 2nd way
        return ResponseEntity.ok(student);
         */

        return ResponseEntity.ok().header("custom-headerAbcd","value1234")
                .body(student);

    }



    //http:localhost:8090/students
    //@GetMapping("students")
    @GetMapping
    //public List<Student> getStudents(){
    public ResponseEntity<List<Student>> getStudents(){

            List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"Sai","krishna"));
        students.add(new Student(2,"Saikris","krishna12"));
        students.add(new Student(3,"Saikrishna","krishna34"));

        //return students;
        return ResponseEntity.ok(students);

    }

    //12. Create Spring Boot REST API with Path variable
    //{id} - is called URI template variable
    // @PathVariable annotation is used on method argument to bind it to
    // the value of the URI template variable
    //http://localhost:8090/students/1
    /*@GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable int id){
            return new Student(id,"Sai","krishna");
        }

    both variables names are same or
     */

    //@GetMapping("students/{id}")
    @GetMapping("{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId,"Sai","krishna");

    }




    //http://localhost:8090/students/1/sai/krishna12
    //@GetMapping("students/{id}/{firstname}/{lastname}")
    @GetMapping("{id}/{firstname}/{lastname}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("firstname") String firstname,
                                       @PathVariable("lastname") String lastname){
        return new Student(studentId,firstname,lastname);

    }


    //13. Spring Boot REST API with Request Param - @RequestParam
    //Spring Boot REST API with request param
    // here id is the query param
    //http://localhost:8090/students/query?id=1
    //@GetMapping("students/query")
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id,"sai","krishna");

    }



    //13. Spring Boot REST API with Request Param - @RequestParam
    //http://localhost:8090/students/query2?id=1&firstName=sai
    //@GetMapping("students/query2")
    @GetMapping("query2")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam  String firstName){
        return new Student(id,firstName,"krishna");

    }

    // creating new resource
    //14. Spring Boot POST REST API -  @PostMapping and @RequestBody
    // @PostMapping and @RequestBody

    /* one way without ResponseEntity Class
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;

    }*/
    // with ResponseEntity Class
    //@PostMapping("students/create")
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }




    // updating existing resource
    // 15. Spring Boot PUT REST API - @PutMapping and @RequestBody
    //http://localhost:8090/students/1/update
    //@PutMapping("students/{id}/update")
    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;

    }

    // deleting existing resource
    // 16. Spring Boot DELETE REST API - @DeleteMapping
    //http://localhost:8090/students/1/delete
    //@DeleteMapping("students/{id}/delete")
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "deleted successfully";

    }


}
