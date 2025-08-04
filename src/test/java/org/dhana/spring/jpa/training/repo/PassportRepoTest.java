package org.dhana.spring.jpa.training.repo;

import org.dhana.spring.jpa.training.entity.Employee;
import org.dhana.spring.jpa.training.entity.Passport;
import org.dhana.spring.jpa.training.utils.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class PassportRepoTest {

    @Autowired
    private PassportRepo passportRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    void test() {
        var employee = new Employee("Dhana@gmail.com", 'M', LocalDate.of(1990, 1, 1),
                1234567890L, 999999999L, Status.ACTIVE);
        employeeRepo.save(employee);

        var passport = passportRepo.save(
                new Passport("P123456789", LocalDate.of(2023, 1, 1),
                        LocalDate.of(2033, 1, 1), employee));

        employee.setPassport(passport);
        employeeRepo.save(employee);
    }
}
