package org.dhana.spring.jpa.training.repo;

import org.dhana.spring.jpa.training.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {
    Optional<Department> findByName(String hr);

    @Modifying
    void deleteByName(String name);

}
