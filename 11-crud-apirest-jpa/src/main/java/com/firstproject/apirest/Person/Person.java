package com.firstproject.apirest.Person;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // generates getters and setters for all fields
@AllArgsConstructor // generates a constructor with all fields
@NoArgsConstructor // generates a constructor with no fields
@Entity // indicates that this class is an entity
public class Person {
    @Id // indicates that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indicates that the primary key is automatically generated
    private long id;

    @Basic // indicates that this field is a column in the database
    private String name;
    private String lastName;
    private int age;
    private String email;
}
