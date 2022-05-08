package com.cnar.spring.dao;

import com.cnar.spring.model.Person;

import java.util.UUID;

public interface PersonDao {

    void insertPerson(UUID id, Person person);

    default void addPerson(Person person) {
        UUID id = UUID.randomUUID();
        insertPerson(id, person);
    }
}
