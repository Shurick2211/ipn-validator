package com.nimko.shppmentorpracktic6.services;

import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.model.Sex;
import org.springframework.stereotype.Service;

@Service
public class CheckIpnService {

    private final int SIZE = 10;

    public boolean checkInPerson(Person person) {
        return checkSex(person.getIpn()+"", person.getSex())
                && checkInControlNumber(person.getIpn()+"");
    }

    public boolean checkInControlNumber(String ipnStr){
        return ipnStr.length() == SIZE
                && charToDigit(ipnStr.charAt(SIZE - 1)) == checkSum(ipnStr) % 11;
    }

    private boolean checkSex(String ipnStr, Sex sex){
        return charToDigit(ipnStr.charAt(SIZE - 2)) % 2 == 1
                && sex == Sex.MALE;
    }

    private int checkSum(String ipnStr) {
        int[] ipn = new int[SIZE];
        for (int i = 0; i < SIZE; i++) ipn[i] = charToDigit(ipnStr.toCharArray()[i]);
        return ipn[0]*(-1) + ipn[1]*5
                + ipn[2]*7 + ipn[3]*9
                + ipn[4]*4 + ipn[5]*6
                + ipn[6]*10 +ipn[7]*5 + ipn[8]*7;
    }

    private int charToDigit(char c){
        return c - '0';
    }
}
