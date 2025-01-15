package com.user.userCrud.dto;


import com.user.userCrud.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String name;

    private List<String> hobbies;

    private int ranking;

    private List<Address> address;
}
