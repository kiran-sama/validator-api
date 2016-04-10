package com.sama.validator.service;

import com.sama.validator.ValidationResult;
import com.sama.validator.Validator;
import com.sama.validator.rule.Rule;
import com.sama.validator.rule.RuleResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksama on 4/9/16.
 */
public class ValidatorService<T> implements Validator<T>{

    public void setRules(List<Rule<T>> rules) {
        this.rules = new ArrayList<Rule<T>>();
        this.rules.addAll(rules);
    }

    List<Rule<T>> rules = null;

    public ValidationResult validate(T input) {
        boolean result = true;
        List<RuleResult> ruleResults = new ArrayList<RuleResult>();
        for(Rule r:rules){
            RuleResult temp = r.applyRule(input);
            ruleResults.add(temp);
            result = result && temp.isValid();
        }
        return new ValidationResult(result,ruleResults);
    }
}
