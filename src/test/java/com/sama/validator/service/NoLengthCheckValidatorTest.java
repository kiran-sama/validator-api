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
@ContextConfiguration(locations = {"classpath:nolength-check-validator.xml"})
public class NoLengthCheckValidatorTest extends TestCase{
    @Autowired
    @Qualifier(value = "passwordValidator")
    Validator<String> passwordValidator;

    @Test
    public void testPasswordValidation(){
        String password = "kirkin1ama";
        assertTrue(passwordValidator.validate(password).isSuccess());
    }

    @Test
    public void testPasswordValidationFailure(){
        String password = "kirkin1amagggjhhgjh";
        assertTrue(passwordValidator.validate(password).isSuccess());
    }

    @Test
    public void testPasswordValidationFailure2(){
        String password = "kirkir1n1a";
        assertFalse(passwordValidator.validate(password).isSuccess());
    }

    @Test
    public void testPasswordValidationFailure3(){
        String password = "kirkinla";
        assertFalse(passwordValidator.validate(password).isSuccess());
    }

    @Test
    public void testPasswordValidationFailure4(){
        String password = "Kirkinla";
        assertFalse(passwordValidator.validate(password).isSuccess());
    }

    @Test
    public void testPasswordValidationFailure5(){
        String password = "Kirk nla";
        assertFalse(passwordValidator.validate(password).isSuccess());
    }
}
