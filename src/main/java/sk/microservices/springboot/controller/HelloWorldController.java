package sk.microservices.springboot.controller;
/*

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
We use @Controller annotation to make this controller class as Spring MVC controller
@ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into HttpResponse Object.
*

Instead of using 2 we have one single annotation
@RestController
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //9. we'll create a simple Spring Boot Hello World Rest API.

    //http://localhost:8090/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello world";
    }
}
