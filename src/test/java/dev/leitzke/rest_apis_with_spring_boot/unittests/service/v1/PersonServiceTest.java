package dev.leitzke.rest_apis_with_spring_boot.unittests.service.v1;

import dev.leitzke.rest_apis_with_spring_boot.model.Person;
import dev.leitzke.rest_apis_with_spring_boot.repositories.PersonRepository;
import dev.leitzke.rest_apis_with_spring_boot.service.v1.PersonService;
import dev.leitzke.rest_apis_with_spring_boot.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    MockPerson input;

    @InjectMocks
    private PersonService service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUp() throws Exception {
        input = new MockPerson();
    }

    @Test
    void testFindAll(){
        Person person = input.mockEntity();
        person.setPersonId(1L);

        MockitoAnnotations.openMocks(this);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getPersonId());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/v1/person/1>;rel=\"self\""));

    }
}
