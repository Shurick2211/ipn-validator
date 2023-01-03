package com.nimko.shppmentorpracktic6.controller;

import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.repo.PersonRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/persons", produces = "application/json")
public class PersonController {
    private final PersonRepo personRepo;
    @Autowired
    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("/{ipn}")
    public Person getPerson(@PathVariable String ipn){
        Person person = personRepo.findPersonByIpn(ipn);
        if(person == null) throw new NotFoundException("IPN not found");
        return  person;
    }

    @GetMapping
    public List<Person> getPersons(){
        return  personRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@Valid @RequestBody Person person){
        personRepo.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Add: " + person);
    }

    @PutMapping
    public ResponseEntity<String> putPerson(@Valid @RequestBody Person person){
        personRepo.findById(person.getId()).orElseThrow();
        personRepo.save(person);
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body("Put: " + person);
    }

    @DeleteMapping("/{ipn}")
    public ResponseEntity<String> deletePerson(@PathVariable String ipn){
        Person person = personRepo.findPersonByIpn(ipn);
        if(person == null) throw new NotFoundException("IPN not found");
        personRepo.delete(person);
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .body("Delete: " + person);
    }

}
