package com.anr.demo;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", "welcome page message");

        return "welcome";
    }

    @RequestMapping("/jsp-check")
    public String serveJsp(Map<String, Object> model) {
        model.put("message", "JSP page message");
        // use this servlet mapping to show a JSP page

        return "welcome";
    }

}