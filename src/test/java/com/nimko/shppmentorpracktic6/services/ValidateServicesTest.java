package com.nimko.shppmentorpracktic6.services;

import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.model.Sex;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateServicesTest {

    CheckIpnService checkIpnService = new CheckIpnService();

    Person person = new Person(1, "2991108392", "Olexandr",
            "Nimko", Sex.MALE);

    @Test
    void checkInPerson() {
        assertTrue(checkIpnService.checkInPerson(person));
    }



    @Test
    void validateException() {
        /*
        person.setSex(null);
        Exception e = assertThrows(MyValidatorException.class,()->{
            validateServices.validate(person);
        });

         */
    }

    @Test
    void valid(){
       LongStream.range(2_000_000_000, 9_999_999_999L).mapToObj(String::valueOf).filter(checkIpnService::checkInControlNumber)
               .limit(10).forEach(System.out::println);
    }
}