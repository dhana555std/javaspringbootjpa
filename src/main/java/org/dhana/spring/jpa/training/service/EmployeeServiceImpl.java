package org.dhana.spring.jpa.training.service;

import jakarta.transaction.Transactional;
import org.dhana.spring.jpa.training.entity.Employee;
import org.dhana.spring.jpa.training.repo.EmployeeRepo;
import org.dhana.spring.jpa.training.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Optional<List<Employee>> getEmployeeByEmailWithPrefix(String email) {
        return employeeRepo.findByEmailContainingIgnoreCaseOrderByEmail(email);
    }

    @Override
    public Optional<List<Employee>> getByGenderAndStatusAndMatchingEmail(Character gender, Status status, String email) {
        return employeeRepo.findByGenderAndStatusAndMatchingEmail(gender, status,email);
    }

    @Override
    @Transactional
    public int updateEmployeePhoneNumber(long phoneNumber, String email) {
        return employeeRepo.updatePhoneNumber(phoneNumber,email);
    }


}
