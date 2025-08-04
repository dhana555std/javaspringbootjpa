package org.dhana.spring.jpa.training.entity;

import jakarta.persistence.*;
import lombok.*;
import org.dhana.spring.jpa.training.utils.Status;

import java.time.LocalDate;
import java.util.List;

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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "passport_number", referencedColumnName = "passport_number",
            unique = true)
    private Passport passport;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_name", referencedColumnName = "department_name",
            foreignKey = @ForeignKey(name = "fk_employee_department"))
    private Department department;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_course",
               joinColumns = @JoinColumn(name = "employee_email", referencedColumnName = "email"),
               inverseJoinColumns = @JoinColumn(name = "course_name", referencedColumnName = "course_name"),
               foreignKey = @ForeignKey(name = "fk_employee_course_employee"),
               inverseForeignKey = @ForeignKey(name = "fk_employee_course_course"))
    private List<Course> courses;
}
