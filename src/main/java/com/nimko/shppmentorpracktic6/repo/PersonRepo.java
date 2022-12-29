package com.nimko.shppmentorpracktic6.repo;

import com.nimko.shppmentorpracktic6.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person,Long> {
    Person findPersonByIpn(String ipn);

    List<Person> findAll();


}
