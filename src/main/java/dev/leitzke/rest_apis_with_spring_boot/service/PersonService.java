package dev.leitzke.rest_apis_with_spring_boot.service;

import dev.leitzke.rest_apis_with_spring_boot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Returning all Person entries");
        List<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
           personList.add(mockPerson(i));
        }
        return personList;
    }

    public Person findbyId(String id) {

        logger.info("Finding person with ID="+id+".");
        Person person = new Person();
        person.setFirstName("Andre");
        person.setLastName("Leitzke");
        person.setGender("male");
        person.setAddress("Rua 123");
        person.setId(counter.incrementAndGet());
        logger.info("Returning person object: "+person.toString());

        return person;
    }

    public Person create(Person person){
        logger.info("Creating one person");
        Person newPerson = new Person();
        newPerson.setAddress("New "+person.getAddress());
        newPerson.setFirstName("New "+person.getFirstName());
        newPerson.setGender("New "+person.getGender());
        newPerson.setId(person.getId());
        newPerson.setLastName("New "+person.getLastName());
        return newPerson;
    }

    public void delete(Person person){
        logger.info("Deleted person ID="+person.getId());
    }

    public Person update(Person person){
        logger.info("Updating one person");
        Person newPerson = new Person();
        newPerson.setAddress("New "+person.getAddress());
        newPerson.setFirstName("New "+person.getFirstName());
        newPerson.setGender("New "+person.getGender());
        newPerson.setId(person.getId());
        newPerson.setLastName("New "+person.getLastName());
        return newPerson;
    }

    public Person mockPerson(int id) {
        Person person = new Person();
        person.setFirstName("Andre"+id);
        person.setLastName("Leitzke");
        person.setGender("male");
        person.setAddress("Rua 123");
        person.setId(counter.incrementAndGet());
        return person;
    }
}
