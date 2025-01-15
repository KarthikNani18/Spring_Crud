package com.user.userCrud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private int id;

    private String  name;

    private int age;

    @ElementCollection
    @CollectionTable(name = "hobbies-table" , joinColumns = @JoinColumn(name="emp_id"))

    private List<String> hobbies;

    private int ranking;

    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL)
    private List<Address> address;

}
