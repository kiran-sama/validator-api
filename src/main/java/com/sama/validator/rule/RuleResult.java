package com.sama.validator.rule;

/**
 * Created by ksama on 4/9/16.
 */
public class RuleResult {
    boolean isValid;
    String ruleDescription;

    public RuleResult(boolean isValid, String ruleDescription) {
        this.isValid = isValid;
        this.ruleDescription = ruleDescription;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public boolean isValid() {
        return isValid;
    }
}
