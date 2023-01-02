package com.nimko.shppmentorpracktic6.services;

import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.model.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateServicesTest {
    IpnValidateImpl ipnValidateImpl = new IpnValidateImpl();
    Person person;

    @BeforeEach
    void setUp(){
        person = new Person(1, "2991108392", "Olexandr",
                "Nimko", Sex.MALE);
    }

    @Test
    void  checkValidPerson(){
        assertTrue(ipnValidateImpl.checkInPerson(person));
    }

    @Test
    void checkInNoValidPersonSex() {
        person.setSex(Sex.FEMALE);
        assertFalse(ipnValidateImpl.checkInPerson(person));
    }

    @Test
    void checkInNoValidPersonIpn() {
        person.setIpn("2991108391");
        assertFalse(ipnValidateImpl.checkInPerson(person));
    }

    @Test
    void valid(){
       LongStream.range(2_000_000_000, 9_999_999_999L).mapToObj(String::valueOf)
               .filter(ipnValidateImpl::checkInControlNumber)
               .limit(10).forEach(System.out::println);
    }
}