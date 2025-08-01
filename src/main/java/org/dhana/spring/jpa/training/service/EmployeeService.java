package org.dhana.spring.jpa.training.service;

import org.dhana.spring.jpa.training.entity.Employee;
import org.dhana.spring.jpa.training.utility.Status;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<List<Employee>> getEmployeeByEmailWithPrefix(String email);

    Optional<List<Employee>> getByGenderAndStatusAndMatchingEmail(Character gender, Status status, String email);


    int updateEmployeePhoneNumber(long phoneNumber, String email);
}
