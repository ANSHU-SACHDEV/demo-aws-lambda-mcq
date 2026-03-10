package awslambda.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "Server working";
    }

}