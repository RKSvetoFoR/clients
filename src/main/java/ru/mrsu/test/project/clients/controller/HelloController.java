package ru.mrsu.test.project.clients.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello(){
        return "Hello!";
    }

    @GetMapping("/helloClient")
    public String getHelloMessage(@RequestParam String name) {
       return "Hello, " + name;
    }
}
