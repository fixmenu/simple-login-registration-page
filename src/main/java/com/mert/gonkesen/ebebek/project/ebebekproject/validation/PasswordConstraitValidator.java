package com.mert.gonkesen.ebebek.project.ebebekproject.validation;

import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordConstraitValidator implements ConstraintValidator<ValidPassword,String> {
    private DictionaryRule dictionaryRule;
    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        PasswordValidator passwordValidator = new PasswordValidator(Arrays.asList(
                new LengthRule(7,30),
                new CharacterRule(EnglishCharacterData.UpperCase,1),
                new CharacterRule(EnglishCharacterData.Digit,1),
                new WhitespaceRule()
        ));

        RuleResult result = passwordValidator.validate(new PasswordData(password));

        if(result.isValid()){
            return true;
        }

        List<String> messages = passwordValidator.getMessages(result);
        String messageTemplate = messages.stream().collect(Collectors.joining(","));
        constraintValidatorContext.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        System.out.println(messages.toString());

        return false;
    }
}
