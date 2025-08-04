package org.dhana.spring.jpa.training.repo;

import org.dhana.spring.jpa.training.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepo extends JpaRepository<Passport, String> {
}
