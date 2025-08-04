package org.dhana.spring.jpa.training.repo;

import org.dhana.spring.jpa.training.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, String> {
    Course findByCourseName(String courseName);
}
