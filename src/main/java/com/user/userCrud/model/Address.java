package com.user.userCrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private int id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private int  zipcode;

    @ManyToOne
   private  Employee employee;



}
