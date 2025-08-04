package org.dhana.spring.jpa.training.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class Courses extends BaseEntity {
    @NonNull
    @Column(name = "course_name", nullable = false, unique = true)
    private String courseName;
}
