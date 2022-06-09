package com.cnar.spring.service;

import com.cnar.spring.model.Person;
import com.cnar.spring.repository.PersonRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("personService")
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void test() {
        //Save a new Person
        Person person1 = new Person("John");
        personRepository.save(person1);

        Person person2 = new Person("Smith");
        personRepository.save(person2);

        // Find person by ID
        Optional<Person> res = personRepository.findById(1L);
        res.ifPresent(System.out::println);

        // Find person by name
        Optional<Person> res2 = personRepository.getPersonByName("Smith");
        res2.ifPresent(System.out::println);

        // List all person
        Iterable<Person> res3 = personRepository.findAll();
        res3.forEach(System.out::println);

        // count the person
        long headCount = personRepository.count();
        System.out.println("Person count: " + headCount);
    }

    public List<Person> listAllPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person editPerson(Person person) {
        Person existing = personRepository.getById(person.getId());
        existing.setName(person.getName());
        return personRepository.save(existing);
    }

    public Person editPerson(Long id, Person person) {
        Person existing = personRepository.getById(id);
        existing.setName(person.getName());
        return personRepository.save(existing);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}
