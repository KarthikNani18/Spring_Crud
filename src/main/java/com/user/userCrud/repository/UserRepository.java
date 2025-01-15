package com.user.userCrud.repository;

import com.user.userCrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Integer> {
}
