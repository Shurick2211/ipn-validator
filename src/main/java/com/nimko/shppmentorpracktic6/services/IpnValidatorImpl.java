package com.nimko.shppmentorpracktic6.services;

import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.model.Sex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class IpnValidatorImpl implements ConstraintValidator<IpnValidator,Person> {

    private static final int SIZE = 10;

    public boolean checkInPerson(Person person) {
        return  checkSex(person.getIpn(), person.getSex())
                && checkInControlNumber(person.getIpn());
    }

    public boolean checkInControlNumber(String ipn) {
        return ipn.length() == SIZE
                && charToDigit(ipn.charAt(SIZE - 1)) == checkSum(ipn) % 11;
    }

    private boolean checkSex(String ipn, Sex sex) {
        return sex == Sex.MALE ? charToDigit(ipn.charAt(SIZE - 2)) % 2 == 1:
                charToDigit(ipn.charAt(SIZE - 2)) % 2 == 0;
    }

    private int checkSum(String ipn) {
        int result = 0;
        final int[] formula = {-1,5,7,9,4,6,10,5,7};
        for (int i = 0; i < formula.length; i++)
            result += charToDigit(ipn.charAt(i)) * formula[i];
        return result;
    }

    private int charToDigit(char c) {
        return c - '0';
    }

    @Override
    public boolean isValid(Person value, ConstraintValidatorContext context) {
        return checkInPerson(value);
    }
}
