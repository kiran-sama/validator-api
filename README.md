# validator-api

A password validation service in Java, meant to be configurable via IoC using the Spring Framework. The service is meant to check a text string for compliance to any number of password validation rules.
The rules currently known are:

-Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
-Must be between 5 and 12 characters in length.
-Must not contain any sequence of characters immediately followed by the same sequence.

Instructions:
1) Checkout project from github
2) Go to validator-api folder and run mvn clean install 

Integration Instructions:
1)Add following maven dependency to the application pom
    <groupId>com.sama</groupId>
    <artifactId>validator-api</artifactId>
    <version>1.0-SNAPSHOT</version>
2) add this import statement in spring context file <import resource="classpath:validator-api-context.xml"/> or add ContextConfiguration annotation
3)Add following code in the classes where you want to access Validation Service
@Autowired
@Qualifier(value = "passwordValidator")
Validator<String> passwordValidator;
4)call validate method on the service passwordValidator.validate(password)
5) Check ValidationResult for success or failure. See ValidationResult.java format

Things that could be different:
Current approach applies all the rules and give the result for each of them. We could stop whenever we see a failure

Design Choices:
Implemented a very generic validation framework which could be applied to other usecases than password validation
Made current rules configurable through spring for different values
Implemented a generic regex rule which could be aplied to multiple rules

    
