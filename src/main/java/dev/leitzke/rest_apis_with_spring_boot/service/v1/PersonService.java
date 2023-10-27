package dev.leitzke.rest_apis_with_spring_boot.service.v1;

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

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        logger.info("Returning all PersonVO entries");
        return Mapper.mapListObjects(repository.findAll(), PersonVO.class);

    }

    public PersonVO findById(Long id) {
        return Mapper.mapObject(
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("PersonVO with ID="+id+" not found.")),
                PersonVO.class
        ) ;
    }

    public PersonVO create(PersonVO person){
        if(checkPersonExists(person.getId())) {
            throw new DuplicatedEntryException("Insert failed. An entry with ID="+person.getId()+" already exists.");
        }
        Person personObject = Mapper.mapObject(person, Person.class);
        return Mapper.mapObject(repository.save(personObject), PersonVO.class);
    }

    public void delete(Long id){
        var personToDelete = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delete failed. PersonVO with ID="+id+" not found."));
        repository.delete(personToDelete);
        logger.info("Successfully deleted person ID="+id+".");
    }

    public PersonVO update(PersonVO person){
        if (checkPersonExists(person.getId())) {
            var entity = Mapper.mapObject(person, Person.class);
            return Mapper.mapObject(repository.save(entity), PersonVO.class);
        }
        throw new ResourceNotFoundException("Update failed. PersonVOV2 with ID="+person.getId()+" not found.");
    }

    private boolean checkPersonExists(Long id) {
        Optional<Person> person = repository.findById(id);
        return person.isPresent();
    }

}
