package org.dhana.spring.jpa.training.repo;

import jakarta.transaction.Transactional;
import org.dhana.spring.jpa.training.entity.Course;
import org.dhana.spring.jpa.training.entity.Employee;
import org.dhana.spring.jpa.training.utils.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;

@SpringBootTest
public class EmployeeRepoTest {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Test
    @Transactional
    void testAddEmployeeAndCourse() {
        var employee = new Employee("rushi@gmail.com", 'M',
                java.time.LocalDate.of(1990, 1, 1),
                1234567890L, 999999999L, Status.ACTIVE);
        var courses = new ArrayList<Course>(){{
            add(new Course("Java"));
            add(new Course("Spring Boot"));
            add(new Course("Hibernate"));
        }};
        employee.setCourses(courses);
        employeeRepo.save(employee);
        employeeRepo.flush();

        employeeRepo.findAll(PageRequest.of(0, 2)).forEach(e -> {
            System.out.println("Employee: " + e.getEmail());
            e.getCourses().forEach(c -> System.out.println("Course: " + c.getCourseName()));
        });
    }
}
