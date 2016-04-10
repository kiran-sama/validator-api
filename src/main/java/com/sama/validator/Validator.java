package com.sama.validator;

/**
 * Created by ksama on 4/9/16.
 */
public interface Validator<T> {
    ValidationResult validate(T input);
}
