package com.sama.validator;

import com.sama.validator.rule.RuleResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksama on 4/9/16.
 */
public class ValidationResult {
    public ValidationResult(boolean isSuccess, List<RuleResult> ruleResults) {
        this.isSuccess = isSuccess;
        ruleResultList = new ArrayList<RuleResult>();
        ruleResultList.addAll(ruleResults);
    }

    public boolean isSuccess() {
        return isSuccess;
    }


    public List<RuleResult> getRuleResultList() {
        return ruleResultList;
    }

    boolean isSuccess;
    List<RuleResult> ruleResultList;
}
