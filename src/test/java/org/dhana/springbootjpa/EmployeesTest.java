package org.dhana.springbootjpa;

import org.dhana.springbootjpa.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.dhana.springbootjpa.repo.EmployeeRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.dhana.springbootjpa.utils.Status;

@SpringBootTest
public class EmployeesTest {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    public void testEmployeeRepo() {
        Employee employee = new Employee("dhana@gmail.com", 'M',
                LocalDate.of(1985, 6, 23),
                Status.ACTIVE, 99999999L, 3545433532L);
        employeeRepo.save(employee);
        employeeRepo.flush();
        List<Employee> employeeList = employeeRepo.findAll();
        assertTrue(employeeList.size() > 0, "Employee list should not be empty");
        assertTrue(employeeList.stream().map(x -> x.getEmail()).collect(Collectors.toSet()).contains("dhana@gmail.com"),
                "Employee should be in the list");
        System.out.println(employeeList);
    }
}
