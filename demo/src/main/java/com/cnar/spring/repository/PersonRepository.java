package com.cnar.spring.repository;

import com.cnar.spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

    Optional<Person> getPersonByName(String name);

    @Query("SELECT p FROM Person p WHERE p.name = ?1")
    void deleteByName(String qname);

}
