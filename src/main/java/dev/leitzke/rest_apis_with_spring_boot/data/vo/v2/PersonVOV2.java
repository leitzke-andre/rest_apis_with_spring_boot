package dev.leitzke.rest_apis_with_spring_boot.data.vo.v2;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@JsonPropertyOrder({"id", "firstName", "lastName", "gender", "birthDate", "address"})
public class PersonVOV2 implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    public PersonVOV2() {
    }

    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String address;
    private String gender;
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonVOV2 that = (PersonVOV2) o;

        if (!id.equals(that.id)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!address.equals(that.address)) return false;
        if (!gender.equals(that.gender)) return false;
        return birthDate.equals(that.birthDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }
}
