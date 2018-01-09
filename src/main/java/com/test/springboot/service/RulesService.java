package com.test.springboot.service;

import com.test.springboot.errors.RuleViolations;
import com.test.springboot.domain.Fact;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RulesService {

    @Autowired
    private KieContainer kContainer;

    public boolean executeRules(Fact fact, RuleViolations violations) {
        KieSession kieSession = kContainer.newKieSession();
        kieSession.setGlobal("violations", violations);
        kieSession.insert(fact);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("!! Errors !! " + violations.getViolationList().toString());
        return !violations.hasErrors();
    }
}