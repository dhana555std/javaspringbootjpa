package org.dhana.spring.jpa.training;

import org.dhana.spring.jpa.training.entity.Employee;
import org.dhana.spring.jpa.training.repo.EmployeeRepo;
import org.dhana.spring.jpa.training.utility.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TrainingApplicationTests {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Test
	void testEmployeeRepo() {
		String email = "lalitha@accionlabs.com";
		long phone = 9191919178L;
		var employee = new Employee(email, 'F',
				LocalDate.of(1986, 3, 23),
				phone, 9999, Status.ACTIVE);
		employeeRepo.save(employee);
		employeeRepo.flush();
		var count = employeeRepo.findAll().size();
		assertTrue(count > 0, "Employee list should not be empty");

		var employees = employeeRepo.findAllByGender('F');
		if (employees.isEmpty()) {
			System.out.println("No female employees");
		} else {
			System.out.println("There are " + employees.get().size() + " female employees.");
		}

		Optional<Employee> matchingEmployee = employeeRepo.findByEmail(email);
		System.out.println(matchingEmployee.get());
		assertTrue(matchingEmployee.isPresent(), "Employee should be in the list");

		var matchList = employeeRepo.findByEmailContainingIgnoreCaseOrderByEmail("ja");
		assertTrue(matchList.isPresent(), "There are matching employees whose email contains 'ja'");


	}
}
