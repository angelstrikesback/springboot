package com.test.springboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.test.springboot.domain.Fact;
import com.test.springboot.dto.Greeting;
import com.test.springboot.errors.RuleViolations;
import com.test.springboot.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ValidationService validationService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("I am here");
        Fact factObject = new Fact();
        factObject.setAge(10);
        factObject.setEmployeeNumber(100);
        factObject.setName(name);

        RuleViolations violations = validationService.validate(factObject);

        System.out.println("In Controller- Violations :"+violations.toString());
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
