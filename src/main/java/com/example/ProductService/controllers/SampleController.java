package com.example.ProductService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String helloWithName(@PathVariable("name") String name){

        return "Hello " + name;
    }
}
