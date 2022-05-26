package com.mysquare.restoms.controller;

import com.mysquare.restoms.model.Sample;
import com.mysquare.restoms.service.TestService;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String firstHello() {
        return "Hello There !";
    }

    @GetMapping("/helloName")
    public String firstHello(@RequestParam String name) {
        return "Hello " + name + " !";
    }

    @Before("/hello")
    @PostMapping(value = "/hello", consumes = "application/json")
    public Sample firstHello(@RequestBody Sample body){
        body.setName("Hello Bro "+body.getName()+" !");
        return body;
    }

    @Autowired
    TestService ts;

    @GetMapping("/news/topstories")
    public Map getNews() throws Exception{
        return ts.getTopStories();
    }
}