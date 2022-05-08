package com.cnar.spring.api;

import com.cnar.spring.model.Person;
import com.cnar.spring.repository.PersonRepository;
import com.cnar.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping("/new")
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.createPerson(person);
    }

    @DeleteMapping
    public void purge(@Valid @NonNull @RequestBody Person person) {
        personService.deletePerson(person);
    }

    @GetMapping("/all")
    public List<Person> getAll() {
        return personService.listAllPersons();
    }
}
