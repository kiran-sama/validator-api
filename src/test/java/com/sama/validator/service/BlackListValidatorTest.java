package com.sama.validator.service;

import com.sama.validator.Validator;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ksama on 4/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:blacklist-check-validator.xml"})
public class BlackListValidatorTest extends TestCase {
    @Autowired
    @Qualifier(value = "passwordValidator")
    Validator<String> passwordValidator;

    @Test
    public void testPasswordValidation(){
        String password = "KIRAN_SAMA";
        assertTrue(passwordValidator.validate(password).isSuccess());
    }

    @Test
    public void testPasswordValidationFailure(){
        String password = "kiransama";
        assertFalse(passwordValidator.validate(password).isSuccess());
    }

    @Test
    public void testPasswordValidationFailure2(){
        String password = "KIRKIR";
        assertFalse(passwordValidator.validate(password).isSuccess());
    }

    @Test
    public void testPasswordValidationFailure3(){
        String password = "KIRKISAMAGHUTHJHKHJK";
        assertFalse(passwordValidator.validate(password).isSuccess());
    }
}
