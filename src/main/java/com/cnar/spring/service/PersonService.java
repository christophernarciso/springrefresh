package com.cnar.spring.service;

import com.cnar.spring.model.Person;
import com.cnar.spring.repository.PersonRepository;
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

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> listAllPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public void deletePerson(Person person) {
        Optional<Person> existing = personRepository.getPersonByName(person.getName());
        existing.ifPresent(p -> personRepository.deleteById(p.getId()));
    }

}
