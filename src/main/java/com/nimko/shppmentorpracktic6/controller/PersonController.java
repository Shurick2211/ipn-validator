package com.nimko.shppmentorpracktic6.controller;

import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.repo.DataBase;
import com.nimko.shppmentorpracktic6.services.ValidateServices;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/persons", produces = "application/json")
public class PersonController {

    @Autowired
    DataBase dataBase;

    @Autowired
    ValidateServices validateServices;



    @GetMapping("/{ipn}")
    public Person getPerson(@PathVariable long ipn){
        return  dataBase.findPersonByIpn(ipn);
    }

    @GetMapping
    public List<Person> getPersons(){
        return  dataBase.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@RequestBody Person person){
        try{
            validateServices.validate(person);
            dataBase.save(person);
            log.info("{}",person);
        } catch (Exception e){
            log.error("",e);
            return new ResponseEntity<>(e + " " + person,null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Add: " + person,null, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> putPerson(@RequestBody Person person){
        try{
            validateServices.validate(person);
            dataBase.save(person);
            log.info("{}",person);
        } catch (Exception e){
            return new ResponseEntity<>(e + " " + person, null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Put: " + person, HttpStatus.UPGRADE_REQUIRED);
    }

    @DeleteMapping("/{ipn}")
    public ResponseEntity<String> deletePerson(@PathVariable long ipn){
        Person person;
        try{
            log.info("delete {}", ipn);
            person = dataBase.findPersonByIpn(ipn);
            dataBase.delete(person);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(),null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Delete: " + person, null,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

}
