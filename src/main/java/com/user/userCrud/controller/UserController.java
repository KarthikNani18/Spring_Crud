package com.user.userCrud.controller;

import com.user.userCrud.dto.RequestDto;
import com.user.userCrud.dto.ResponseDto;

import com.user.userCrud.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseDto addUser(@Valid @RequestBody RequestDto requestDto) {
        log.info("adding a data");
        return userService.addUsers(requestDto);
    }

    @GetMapping
    public List<ResponseDto> getEmployeeAll()
    {
        return userService.getEmployeeAll();
    }

    @GetMapping("/{num}")
    public ResponseDto getEmployee(@PathVariable Integer num)
    {
        return userService.getEmployee(num);
    }

    @PutMapping("/update")
    public ResponseDto  putEmployee(@RequestBody RequestDto requestDto, @RequestParam Integer num)
    {
        return userService.putEmployees(requestDto,num);
    }
    @DeleteMapping("/{num}")
    public String delEmployee(@PathVariable int num)
    {
        return userService.delEmployee(num);
    }


}
