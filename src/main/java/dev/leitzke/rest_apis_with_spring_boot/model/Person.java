package dev.leitzke.rest_apis_with_spring_boot.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="person")
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    public Person() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    @Column(name="first_name", nullable = false, length = 80)
    private String firstName;
    @Column(name="last_name",  nullable = false, length = 80)
    private String lastName;
    @Column( nullable = false, length = 120)
    private String address;
    @Column(length = 25)
    private String gender;

    @Column
    private LocalDate birthDate;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
