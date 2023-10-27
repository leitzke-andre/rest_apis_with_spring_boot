package dev.leitzke.rest_apis_with_spring_boot.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import dev.leitzke.rest_apis_with_spring_boot.data.vo.v1.PersonVO;
import dev.leitzke.rest_apis_with_spring_boot.data.vo.v2.PersonVOV2;
import dev.leitzke.rest_apis_with_spring_boot.mapper.Mapper;
import dev.leitzke.rest_apis_with_spring_boot.model.Person;
import dev.leitzke.rest_apis_with_spring_boot.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class MapperTest {
    
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = Mapper.mapObject(inputObject.mockEntity(), PersonVO.class);
        assertEquals(Long.valueOf(0L), output.getPersonId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityToVOV2Test() {
        PersonVOV2 output = Mapper.mapObject(inputObject.mockEntity(), PersonVOV2.class);
        assertEquals(Long.valueOf(0L), output.getPersonId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
        assertEquals(LocalDate.of(2023, 1, 1), output.getBirthDate());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = Mapper.mapListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getPersonId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        
        PersonVO outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getPersonId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        
        PersonVO outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getPersonId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseEntityListToVOV2ListTest() {
        List<PersonVOV2> outputList = Mapper.mapListObjects(inputObject.mockEntityList(), PersonVOV2.class);
        PersonVOV2 outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getPersonId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        assertEquals(LocalDate.of(2023, 1, 1), outputZero.getBirthDate());

        PersonVOV2 outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getPersonId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        assertEquals(LocalDate.of(2023, 1, 1), outputSeven.getBirthDate());

        PersonVOV2 outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getPersonId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
        assertEquals(LocalDate.of(2023, 1, 1), outputTwelve.getBirthDate());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = Mapper.mapObject(inputObject.mockVO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getPersonId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }
    @Test
    public void parseVOV2ToEntityTest() {
        Person output = Mapper.mapObject(inputObject.mockVOV2(), Person.class);
        assertEquals(Long.valueOf(0L), output.getPersonId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
        assertEquals(LocalDate.of(2023, 1, 1), output.getBirthDate());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = Mapper.mapListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getPersonId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getPersonId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getPersonId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parserVOV2ListToEntityListTest() {
        List<Person> outputList = Mapper.mapListObjects(inputObject.mockVOV2List(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getPersonId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        assertEquals(LocalDate.of(2023, 1, 1), outputZero.getBirthDate());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getPersonId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        assertEquals(LocalDate.of(2023, 1, 1), outputSeven.getBirthDate());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getPersonId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
        assertEquals(LocalDate.of(2023, 1, 1), outputTwelve.getBirthDate());
    }
}
