package com.user.userCrud.repository;

import com.user.userCrud.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address,Integer> {

}
