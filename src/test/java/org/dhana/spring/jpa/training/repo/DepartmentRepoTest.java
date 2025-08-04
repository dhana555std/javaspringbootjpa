package org.dhana.spring.jpa.training.repo;

import jakarta.transaction.Transactional;
import org.dhana.spring.jpa.training.entity.Department;
import org.dhana.spring.jpa.training.entity.Employee;
import org.dhana.spring.jpa.training.entity.Passport;
import org.dhana.spring.jpa.training.utils.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;


    @Test()
    void test() {
        var department = new Department("HR");
        departmentRepo.save(department);

        var employee = employeeRepo.findByEmail("Dhana@gmail.com").get();
        employee.setDepartment(department);
        employeeRepo.save(employee);
    }

}
