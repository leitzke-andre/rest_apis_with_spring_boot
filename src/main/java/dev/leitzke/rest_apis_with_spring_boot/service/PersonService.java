package dev.leitzke.rest_apis_with_spring_boot.service;

import dev.leitzke.rest_apis_with_spring_boot.exceptions.ResourceNotFoundException;
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

    public List<Person> findAll() {
        logger.info("Returning all Person entries");
        return repository.findAll();
    }

    public Person findbyId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with ID="+id+" not found."));
    }

    public Person create(Person person){
        return repository.save(person);
    }

    public void delete(Long id){
        var personToDelete = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delete failed. Person with ID="+id+" not found."));
        repository.delete(personToDelete);
        logger.info("Successfully deleted person ID="+id+".");
    }

    public Person update(Person person){
        // If we don't check for the existence before saving it acts as an upsert, which can also be pretty useful.
        var personToUpdate = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Update failed. Person with ID="+person.getId()+" not found."));
        return repository.save(person);
    }

}
