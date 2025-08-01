package org.dhana.spring.jpa.training.entity;

import jakarta.persistence.*;
import lombok.*;
import org.dhana.spring.jpa.training.utility.Status;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=false)
@Table(name = "employees", schema = "training",
       indexes = {
           @Index(name = "idx_employee_email", columnList = "email"),
           @Index(name = "idx_employee_phone_number", columnList = "phone_number")
       },
       uniqueConstraints = {
           @UniqueConstraint(name = "uc_employee_email_phone_number",
               columnNames = {"email", "phone_number"})
       })
public class Employee extends BaseEntity{
    @Id
    @GeneratedValue(strategy = UUID)
    private String id;

    @NonNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NonNull
    @Column(name = "gender", nullable = false, columnDefinition = "char(1)")
    private Character gender;

    @NonNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @NonNull
    @Column(name="phone_number", nullable = false, length = 10)
    private long phoneNumber;

    @NonNull
    @Column(nullable = false)
    private long salary;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}
