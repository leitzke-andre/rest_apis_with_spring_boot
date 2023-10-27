package dev.leitzke.rest_apis_with_spring_boot.unittests.mapper.mocks;

import dev.leitzke.rest_apis_with_spring_boot.data.vo.v1.PersonVO;
import dev.leitzke.rest_apis_with_spring_boot.data.vo.v2.PersonVOV2;
import dev.leitzke.rest_apis_with_spring_boot.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonVO mockVO() {
        return mockVO(0);
    }

    public PersonVOV2 mockVOV2() {
        return mockVOV2(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }

    public List<PersonVOV2> mockVOV2List() {
        List<PersonVOV2> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVOV2(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        person.setBirthDate(LocalDate.of(2023, 1, 1));
        return person;
    }

    public PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonVOV2 mockVOV2(Integer number) {
        PersonVOV2 person = new PersonVOV2();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        person.setBirthDate(LocalDate.of(2023, 1, 1));
        return person;
    }

}
