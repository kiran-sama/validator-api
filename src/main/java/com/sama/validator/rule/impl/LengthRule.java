package com.sama.validator.rule.impl;

import com.sama.validator.rule.AbstractRule;
import com.sama.validator.rule.Rule;
import com.sama.validator.rule.RuleResult;

/**
 * Validates the length of the input for given range
 * Created by ksama on 4/9/16.
 */
public class LengthRule extends AbstractRule<String> {
    private static String DESCRIPTION= "Length must be between %1 and %2 characters";

    private int min;
    private int max;


    public LengthRule(int min, int max){
        super(DESCRIPTION.replaceAll("%1",
                String.valueOf(min)).replaceAll("%2", String.valueOf(max)));
      this.min = min;
      this.max = max;
    }

    public RuleResult applyRule(String input) {
        if(min<=input.length() && input.length()<=max){
            return new RuleResult(true,getDescription());
        } else {
            return new RuleResult(false,getDescription());
        }
    }
}
