package com.sama.validator.rule;

/**
 * Created by ksama on 4/9/16.
 */
public abstract class AbstractRule<T> implements Rule<T>{
    String description;
    public AbstractRule(String description){
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AbstractRule() {

    }

    public String getDescription(){
        return description;
    }
}
