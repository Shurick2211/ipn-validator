package com.nimko.shppmentorpracktic6.controller;

import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.repo.PersonRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/persons", produces = "application/json")
public class PersonController {

    @Autowired
    PersonRepo personRepo;





    @GetMapping("/{ipn}")
    public Person getPerson(@PathVariable String ipn){
        return  personRepo.findPersonByIpn(ipn);
    }

    @GetMapping
    public List<Person> getPersons(){
        return  personRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@Valid @RequestBody Person person, BindingResult result){
        log.debug(result.toString());
        if(!result.hasErrors()){
            personRepo.save(person);
            log.info("{}",person);
        } else {
            log.error("{}",result);
            return ResponseEntity.badRequest().body(result.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Add: " + person);
    }

    @PutMapping
    public ResponseEntity<String> putPerson(@Valid @RequestBody Person person, BindingResult result){
        log.debug(result.toString());
        if(!result.hasErrors()){
            personRepo.save(person);
            log.info("{}",person);
        } else{
            return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(result.toString());
        }
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body("Put: " + person);
    }

    @DeleteMapping("/{ipn}")
    public ResponseEntity<String> deletePerson(@PathVariable String ipn){
        Person person;
        try{
            log.info("delete {}", ipn);
            person = personRepo.findPersonByIpn(ipn);
            personRepo.delete(person);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(),null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Delete: " + person, null,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

}
