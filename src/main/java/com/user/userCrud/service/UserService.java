package com.user.userCrud.service;

import com.user.userCrud.dto.RequestDto;
import com.user.userCrud.dto.ResponseDto;
import com.user.userCrud.model.Address;
import com.user.userCrud.model.Employee;
import com.user.userCrud.repository.AddressRepository;
import com.user.userCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;


    public ResponseDto addUsers(RequestDto requestDto) {
        Employee u = new Employee();
        u.setName(requestDto.getName());
        u.setAge(requestDto.getAge());
        u.setHobbies(requestDto.getHobbies());
        u.setRanking(requestDto.getRanking());
        u.setAddress(requestDto.getAddress());
       List<Address> addressList=new ArrayList() ;

       if(u.getAddress()!=null)
       {
           u.getAddress().forEach(add->
           {
               Address address=new Address();
               address.setAddressLine1(add.getAddressLine1());
               address.setAddressLine2(add.getAddressLine2());
               address.setState(add.getState());
               address.setCity(add.getCity());
               address.setCountry(add.getCountry());
               address.setZipcode(add.getZipcode());
               address.setEmployee(u);
               addressList.add(address);
           });
       }

//        List<Address> addressList=requestDto.getAddress().stream().map(e -> {
//            Address address=new Address();
//            address.setAddressLine1(e.getAddressLine1());
//            address.setAddressLine2(e.getAddressLine2());
//            address.setState(e.getState());
//            address.setCity(e.getCity());
//            address.setCountry(e.getCountry());
//            address.setZipcode(e.getZipcode());
//            address.setEmployee(u);
//            return address;
//        }).toList();

       u.setAddress(addressList);
       userRepository.save(u);
       addressRepository.saveAll(addressList);

        return mapToRes(u);
    }

    private ResponseDto mapToRes(Employee employee) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setName(employee.getName());
        responseDto.setHobbies(employee.getHobbies());
        responseDto.setRanking(employee.getRanking());
        return responseDto;
    }

    public List<ResponseDto> getEmployeeAll() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToRes)
                .toList();
    }

    public ResponseDto getEmployee( Integer num) {

        Employee employee = userRepository.findById(num)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
        return mapToRes(employee);
    }

    public ResponseDto putEmployees(RequestDto requestDto, Integer num) {
            Employee employee=userRepository.findById(num).orElseThrow(()->new IllegalArgumentException("not found"));
            employee.setName(requestDto.getName());
            employee.setAge(requestDto.getAge());
            employee.setHobbies(requestDto.getHobbies());
            employee.setRanking(requestDto.getRanking());
            return mapToRes(employee);
    }

    public String delEmployee(Integer num) {
        userRepository.findById(num).orElseThrow(()->new IllegalArgumentException("not found"));
        userRepository.deleteById(num);
        return "successfully removed";
    }
}
