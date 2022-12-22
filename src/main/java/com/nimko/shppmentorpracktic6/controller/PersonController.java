package com.nimko.shppmentorpracktic6.controller;

import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.repo.DataBase;
import com.nimko.shppmentorpracktic6.services.ValidateServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> addPerson(@RequestBody Person person){
        try{
            validateServices.validate(person);
            dataBase.save(person);
            log.info("{}",person);
        } catch (Exception e){
            log.error("",e);
            return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> putPerson(@RequestBody Person person){
        try{
            validateServices.validate(person);
            dataBase.save(person);
            log.info("{}",person);
        } catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.UPGRADE_REQUIRED);
    }

    @DeleteMapping("/{ipn}")
    public ResponseEntity<?> deletePerson(@PathVariable long ipn){
        try{
            log.info("delete {}", ipn);
            dataBase.delete(dataBase.findPersonByIpn(ipn));
        } catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

}
