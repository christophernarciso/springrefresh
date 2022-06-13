package com.cnar.spring.api;

import com.cnar.spring.model.Person;
import com.cnar.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping("/new")
    public Person addPerson(@Valid @NonNull @RequestBody Person person) {
        return personService.createPerson(person);
    }

    @DeleteMapping("/{id}")
    public void purge(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @PatchMapping("/edit")
    public Person editPerson(@Valid @NonNull @RequestBody Person person) {
        return personService.editPerson(person);
    }

    @PatchMapping("/edit/{id}")
    public Person editPerson(@PathVariable Long id, @Valid @NonNull @RequestBody Person person) {
        return personService.editPerson(id, person);
    }

    @GetMapping("/all")
    public List<Person> getAll() {
        return personService.listAllPersons();
    }
}
