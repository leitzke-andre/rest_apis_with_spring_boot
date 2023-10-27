package dev.leitzke.rest_apis_with_spring_boot.service;

import dev.leitzke.rest_apis_with_spring_boot.exceptions.ResourceNotFoundException;
import dev.leitzke.rest_apis_with_spring_boot.data.vo.v1.PersonVO;
import dev.leitzke.rest_apis_with_spring_boot.mapper.Mapper;
import dev.leitzke.rest_apis_with_spring_boot.model.Person;
import dev.leitzke.rest_apis_with_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

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
        // If we don't check for the existence before saving it acts as an upsert, which can also be pretty useful.
        Person personObject = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Update failed. PersonVO with ID="+person.getId()+" not found."));
        return Mapper.mapObject(repository.save(personObject), PersonVO.class);
    }

}
