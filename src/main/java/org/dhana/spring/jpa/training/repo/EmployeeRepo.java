package org.dhana.spring.jpa.training.repo;

import org.dhana.spring.jpa.training.dto.EmailPhoneResponseEntity;
import org.dhana.spring.jpa.training.entity.Employee;
import org.dhana.spring.jpa.training.utils.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByEmailIgnoreCaseOrPhoneNumber(String email, Long phoneNumber);

    Optional<List<Employee>> findByEmailContainingIgnoreCaseOrderByEmail(String email);

    Optional<List<Employee>> findByEmailContainingIgnoreCaseAndPhoneNumber(String email, Long phoneNumber);

    @Query("Select e from Employee e where e.gender=:gender and e.status=:status and e.email like %:email%")
    Optional<List<Employee>> findByGenderAndStatusAndMatchingEmail(@Param("gender") Character gender,
                                                                   @Param("status") Status status,
                                                                   @Param("email") String email);

    @Query(value = "Select * from employees e where e.gender=:gender",
            nativeQuery = true)
    Optional<List<Employee>> findAllByGender(@Param("gender") Character gender);

    @Modifying
    @Query("Update Employee e SET e.phoneNumber=:phoneNumber WHERE e.email=:email")
    int updatePhoneNumber(@Param("phoneNumber") long phoneNumber,
                           @Param("email") String email);

    @Query(value = "Select new org.dhana.spring.jpa.training.dto.EmailPhoneResponseEntity(e.email, e.phoneNumber)" +
            " from Employee e where e.id=:id")
    EmailPhoneResponseEntity findPhoneAndEmailById(@Param("id") String id);
}
