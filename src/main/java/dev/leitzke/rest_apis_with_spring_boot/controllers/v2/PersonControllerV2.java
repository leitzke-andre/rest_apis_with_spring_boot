package dev.leitzke.rest_apis_with_spring_boot.controllers.v2;

import dev.leitzke.rest_apis_with_spring_boot.data.vo.v2.PersonVOV2;
import dev.leitzke.rest_apis_with_spring_boot.service.v2.PersonServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v2/person")
public class PersonControllerV2 {

    @Autowired
    private PersonServiceV2 service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 findById(
            @PathVariable(value = "id") Long id
    ) {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVOV2> findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 create(@RequestBody PersonVOV2 person) {
        return service.create(person);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 update(@RequestBody PersonVOV2 person) {
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
