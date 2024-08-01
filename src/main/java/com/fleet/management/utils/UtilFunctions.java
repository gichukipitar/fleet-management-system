package com.fleet.management.utils;
import jakarta.validation.Validation;
import jakarta.validation.Validator;;
public class UtilFunctions {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
}
