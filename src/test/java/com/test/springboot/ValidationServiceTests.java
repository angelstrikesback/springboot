package com.test.springboot;

import com.test.springboot.config.DroolsConfiguration;
import com.test.springboot.domain.Fact;
import com.test.springboot.errors.RuleViolations;
import com.test.springboot.service.ValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
//@SpringBootTest
@ContextConfiguration(classes = DroolsConfiguration.class)
public class ValidationServiceTests {

    @Autowired
    private ValidationService validationService;

    @Test
    public void shouldError_WhenAgeIsLessthan18AndEmployeeNumberIsPositive() {
        Fact factObject = new Fact();
        factObject.setAge(10);
        factObject.setEmployeeNumber(100);
        factObject.setName("TestEmployee");

        RuleViolations violations = validationService.validate(factObject);

        System.out.println("The list of Violations:"+violations.toString());
    }
}
