package com.nimko.shppmentorpracktic6.services;

import com.nimko.shppmentorpracktic6.Excepion.MyValidatorException;
import com.nimko.shppmentorpracktic6.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
@Service
public class ValidateServices {
    @Autowired
    private CheckIpnService checkIpnService;


    public boolean isValid(Person dto) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Person>> errors = validator.validate(dto);
        return errors.isEmpty() && checkIpnService.checkInPerson(dto);
    }

    public void validate(Person person) throws Exception {
        if (!isValid(person)) throw new MyValidatorException();
    }

}
