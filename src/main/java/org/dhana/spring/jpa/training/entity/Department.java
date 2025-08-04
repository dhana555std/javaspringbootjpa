package org.dhana.spring.jpa.training.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode()
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Department extends BaseEntity{
    @NonNull
    @Column(name = "department_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employee;
}
