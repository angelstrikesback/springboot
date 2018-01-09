package com.test.springboot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import com.test.springboot.config.DroolsConfiguration;
import com.test.springboot.errors.RuleViolations;
import com.test.springboot.domain.Fact;
import com.test.springboot.service.RulesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DroolsConfiguration.class)
public class RuleServiceTests {
    @Autowired
    private RulesService rulesService;

    @Test
    public void whenAgeIsLessThan18_thenErrorSayingEmployeeIsMinor() {
        Fact factObject = new Fact();
        factObject.setAge(10);
        factObject.setEmployeeNumber(100);
        factObject.setName("TestEmployee");

        RuleViolations violations = new RuleViolations();
        boolean isValidEmployee = rulesService.executeRules(factObject, violations);

        assertNotNull(violations);
        assertFalse("Employee should be declared invalid", isValidEmployee);
    }

}
