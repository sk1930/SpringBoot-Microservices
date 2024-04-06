package sk.microservices.employeeservice.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="employees")
public class Employee {
    //90. EmployeeService - Create Employee JPA Entity and Spring Data JPA Repository

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String firstName;
    private String lastName;
    @Column(nullable=false,unique = true)
    private String email;






}
