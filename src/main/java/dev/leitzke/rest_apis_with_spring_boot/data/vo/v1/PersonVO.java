package dev.leitzke.rest_apis_with_spring_boot.data.vo.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;


@JsonPropertyOrder({"id", "firstName", "lastName", "gender", "address"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    public PersonVO() {
    }

    @JsonProperty("id")
    private Long personId;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public Long getPersonId() {
        return personId;
    }
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
