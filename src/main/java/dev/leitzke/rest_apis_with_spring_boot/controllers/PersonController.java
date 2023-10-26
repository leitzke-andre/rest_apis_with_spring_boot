package dev.leitzke.rest_apis_with_spring_boot.controllers;

import dev.leitzke.rest_apis_with_spring_boot.model.Person;
import dev.leitzke.rest_apis_with_spring_boot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(
            @PathVariable(value = "id") Long id
    ) {
        return service.findbyId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody(required = true) Person person) {
        return service.create(person);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody(required = true) Person person) {
        return service.update(person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value="/{id}")
    public void delete(
            @PathVariable(value = "id") Long id
    ) {
        service.delete(id);
    }

}
