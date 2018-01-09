package com.test.springboot.service;

import com.test.springboot.domain.Fact;
import com.test.springboot.errors.RuleViolations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    @Autowired
    private RulesService rulesService;

    public RuleViolations validate(Fact fact) {
        RuleViolations violations = new RuleViolations();
        if(rulesService.executeRules(fact, violations)) {
            System.out.println("No violations found");
        } else {
            System.out.println("Violations found:"+violations.toString());
        }
        return violations;
    }
}
