package org.dhana.spring.jpa.training.service;

import org.dhana.spring.jpa.training.utility.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    void testEmployeeFindByEmailContainingIgnoreCase() {
        String emailPrefix = "ja";
        var employees = employeeService.getEmployeeByEmailWithPrefix(emailPrefix);
        if (employees.isPresent()) {
            employees.get().forEach(e -> System.out.println(e.getEmail()));
        } else {
            System.out.println("No employees found with email containing: " + emailPrefix);
        }

        employeeService.getByGenderAndStatusAndMatchingEmail('F', Status.ACTIVE, "jo")
                .ifPresentOrElse(
                        employeesList -> employeesList.forEach(e -> System.out.println("Phone:" + e.getPhoneNumber())),
                        () -> System.out.println("No Phone: No employees found"));

        int count = employeeService.updateEmployeePhoneNumber(5555555554L, "jamal@accionlabs.com");
        System.out.println("Number of employees updated: " + count);

        var pageList = employeeService.findAll();
        assertEquals(2, pageList.get().count(), "There should be 5 employees in the list");

        for (var employee : pageList) {
            System.out.println("Employee: " + employee.getEmail() + ", Phone: " + employee.getPhoneNumber());
        }

    }
}
