package com.nimko.shppmentorpracktic6.services;

import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.model.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateServicesTest {
    IpnValidatorImpl ipnValidatorImpl = new IpnValidatorImpl();
    Person person;

    @BeforeEach
    void setUp(){
        person = new Person(1, "2991108392", "Olexandr",
                "Nimko", Sex.MALE);
    }

    @Test
    void  checkValidPerson(){
        assertTrue(ipnValidatorImpl.checkInPerson(person));
    }

    @Test
    void checkInNoValidPersonSex() {
        person.setSex(Sex.FEMALE);
        assertFalse(ipnValidatorImpl.checkInPerson(person));
    }

    @Test
    void checkInNoValidPersonIpn() {
        person.setIpn("2991108391");
        assertFalse(ipnValidatorImpl.checkInPerson(person));
    }

    @Test
    void valid(){
       LongStream.range(2_000_000_000, 9_999_999_999L).mapToObj(String::valueOf)
               .filter(ipnValidatorImpl::checkInControlNumber)
               .limit(10).forEach(System.out::println);
    }
}