package dev.leitzke.rest_apis_with_spring_boot.service;

import dev.leitzke.rest_apis_with_spring_boot.model.Person;
import dev.leitzke.rest_apis_with_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
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

    public Optional<Person> findbyId(String id) {
        return repository.findById(Long.valueOf(id));
    }

    public Person create(Person person){
        return repository.save(person);
    }

    public void delete(Person person){
        repository.delete(person);
        logger.info("Deleted person ID="+person.getId());
    }

    public Person update(Person person){
        return repository.save(person);
    }

}
