package dev.leitzke.rest_apis_with_spring_boot.service.v2;

import dev.leitzke.rest_apis_with_spring_boot.data.vo.v2.PersonVOV2;
import dev.leitzke.rest_apis_with_spring_boot.exceptions.DuplicatedEntryException;
import dev.leitzke.rest_apis_with_spring_boot.exceptions.ResourceNotFoundException;
import dev.leitzke.rest_apis_with_spring_boot.mapper.Mapper;
import dev.leitzke.rest_apis_with_spring_boot.model.Person;
import dev.leitzke.rest_apis_with_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonServiceV2 {

    private final Logger logger = Logger.getLogger(PersonServiceV2.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVOV2> findAll() {
        logger.info("Returning all PersonVOV2 entries");
        return Mapper.mapListObjects(repository.findAll(), PersonVOV2.class);

    }

    public PersonVOV2 findById(Long id) {
        return Mapper.mapObject(
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("PersonVOV2 with ID="+id+" not found.")),
                PersonVOV2.class
        ) ;
    }

    public PersonVOV2 create(PersonVOV2 person){
        if(person.getPersonId() != null && checkPersonExists(person.getPersonId())) {
            throw new DuplicatedEntryException("Insert failed. An entry with ID="+person.getPersonId()+" already exists.");
        }
        Person personObject = Mapper.mapObject(person, Person.class);
        return Mapper.mapObject(repository.save(personObject), PersonVOV2.class);
    }

    public void delete(Long id){
        var personToDelete = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delete failed. PersonVOV2 with ID="+id+" not found."));
        repository.delete(personToDelete);
        logger.info("Successfully deleted person ID="+id+".");
    }

    public PersonVOV2 update(PersonVOV2 person){
        if (checkPersonExists(person.getPersonId())) {
            var entity = Mapper.mapObject(person, Person.class);
            return Mapper.mapObject(repository.save(entity), PersonVOV2.class);
        }
        throw new ResourceNotFoundException("Update failed. PersonVOV2 with ID="+person.getPersonId()+" not found.");
    }

    private boolean checkPersonExists(Long id) {
        Optional<Person> person = repository.findById(id);
        return person.isPresent();
    }

}
