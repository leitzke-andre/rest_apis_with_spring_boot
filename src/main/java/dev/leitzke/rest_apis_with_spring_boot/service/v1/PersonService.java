package dev.leitzke.rest_apis_with_spring_boot.service.v1;

import dev.leitzke.rest_apis_with_spring_boot.controllers.v1.PersonController;
import dev.leitzke.rest_apis_with_spring_boot.exceptions.DuplicatedEntryException;
import dev.leitzke.rest_apis_with_spring_boot.exceptions.ResourceNotFoundException;
import dev.leitzke.rest_apis_with_spring_boot.data.vo.v1.PersonVO;
import dev.leitzke.rest_apis_with_spring_boot.mapper.Mapper;
import dev.leitzke.rest_apis_with_spring_boot.model.Person;
import dev.leitzke.rest_apis_with_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        logger.info("Returning all Person entries");
        var voList = Mapper.mapListObjects(repository.findAll(), PersonVO.class);
        voList.stream().forEach(
                p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getPersonId())).withSelfRel())
        );
        return voList;
    }

    public PersonVO findById(Long id) {
         var vo = Mapper.mapObject(
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Person with ID="+id+" not found.")),
                PersonVO.class
        );
         vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
         vo.add(linkTo(methodOn(PersonController.class).findAll()).withRel("all"));
         return vo;
    }

    public PersonVO create(PersonVO person){

        if(person.getPersonId() != null && checkPersonExists(person.getPersonId())) {
            throw new DuplicatedEntryException("Insert failed. An entry with ID="+person.getPersonId()+" already exists.");
        }
        Person personObject = Mapper.mapObject(person, Person.class);
        var vo = Mapper.mapObject(repository.save(personObject), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getPersonId())).withSelfRel());
        return vo;
    }

    public void delete(Long id){
        var personToDelete = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delete failed. Person with ID="+id+" not found."));
        repository.delete(personToDelete);
        logger.info("Successfully deleted person ID="+id+".");
    }

    public PersonVO update(PersonVO person){
        if (checkPersonExists(person.getPersonId())) {
            Person personObject = Mapper.mapObject(person, Person.class);
            var vo = Mapper.mapObject(repository.save(personObject), PersonVO.class);
            vo.add(linkTo(methodOn(PersonController.class).findById(vo.getPersonId())).withSelfRel());
            return vo;
        }
        throw new ResourceNotFoundException("Update failed. Person with ID="+person.getPersonId()+" not found.");
    }

    private boolean checkPersonExists(Long id) {
        Optional<Person> person = repository.findById(id);
        return person.isPresent();
    }

}
