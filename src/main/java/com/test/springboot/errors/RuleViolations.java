package com.test.springboot.errors;

import java.util.ArrayList;
import java.util.List;

public class RuleViolations {
    private List<RuleViolation> violationList = new ArrayList<RuleViolation>();

    public void addViolation (RuleViolation violation) {
        violationList.add(violation);
    }

    public boolean hasErrors() {
        return violationList.size() >0;
    }

    public List<RuleViolation> getViolationList() {
        return violationList;
    }

    public void setViolationList(List<RuleViolation> violationList) {
        this.violationList = violationList;
    }

    @Override
    public String toString() {
        return "RuleViolations{" +
                "violationList=" + violationList +
                '}';
    }
}
