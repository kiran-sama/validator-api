package com.sama.validator.rule;

/**
 * Created by ksama on 4/9/16.
 */
public interface Rule<T> {

    RuleResult applyRule(T input);
}
