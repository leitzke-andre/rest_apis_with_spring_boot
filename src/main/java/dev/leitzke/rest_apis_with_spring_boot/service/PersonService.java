package dev.leitzke.rest_apis_with_spring_boot.service;

import dev.leitzke.rest_apis_with_spring_boot.exceptions.ResourceNotFoundException;
import dev.leitzke.rest_apis_with_spring_boot.data.vo.v1.PersonVO;
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
        return repository.findAll();
    }

    public PersonVO findbyId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PersonVO with ID="+id+" not found."));
    }

    public PersonVO create(PersonVO person){
        return repository.save(person);
    }

    public void delete(Long id){
        var personToDelete = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delete failed. PersonVO with ID="+id+" not found."));
        repository.delete(personToDelete);
        logger.info("Successfully deleted person ID="+id+".");
    }

    public PersonVO update(PersonVO person){
        // If we don't check for the existence before saving it acts as an upsert, which can also be pretty useful.
        var personToUpdate = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Update failed. PersonVO with ID="+person.getId()+" not found."));
        return repository.save(person);
    }

}
