package sk.microservices.departmentservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="departments")
public class Department {
    /*86. DepartmentService - Create Department JPA Entity and Spring Data JPA Repository
     */

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    //private Long id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String departmentName;
    private String departmentDescription;
    private String departmentCode;


}
