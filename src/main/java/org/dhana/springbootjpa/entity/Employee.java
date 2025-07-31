package org.dhana.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.dhana.springbootjpa.utils.Status;

import java.time.LocalDate;

@Entity
@Table(name = "employees", schema = "training", indexes = {
        @Index(name = "idx_employee_email", columnList = "email"),
        @Index(name = "idx_employee_phone_number", columnList = "phone_number")},
        uniqueConstraints = {@UniqueConstraint(name = "uc_employee_email_phone_number",
                             columnNames = {"email", "phone_number"})})
@Getter
@Setter
@EqualsAndHashCode
@ToString(callSuper = true)
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity {
    @NonNull
    @Column(name = "email", nullable = false)
    private String email;

    @NonNull
    @Column(name = "gender", nullable = false, columnDefinition = "char(1)")
    private Character gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "varchar(40)")
    private Status status;

    @NonNull
    @Column(name = "salary", nullable = false, length = 50, scale = 2)
    private long salary;

    @NonNull
    @Column(name = "phone_number", nullable = false, unique = true, length = 10)
    private long phoneNumber;
}
