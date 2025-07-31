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
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    private Character gender;

    @NonNull
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ToString.Exclude
    @Transient
    private String passCode;
}
