package org.dhana.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NonNull
    private String email;

    @NonNull
    private Character gender;

    @NonNull
    private Date birthDate;

    @Transient
    private String passCode;
}
