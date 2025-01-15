package com.user.userCrud.dto;

import com.user.userCrud.model.Address;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

   // @NotEmpty(message = "name should not be empty")
   // @Pattern(regexp = "^[A-Za-z]+" , message = "invalid Name")
    private String  name;

   // @Max(value = 30, message = "age should be less than 30")
   // @Min(value = 18, message = "age should be greater than 18")
    private int age;

    private List<String> hobbies;

    private int ranking;

    private List<Address> address;

}
