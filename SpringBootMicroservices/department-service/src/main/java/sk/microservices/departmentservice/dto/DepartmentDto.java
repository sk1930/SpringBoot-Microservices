package sk.microservices.departmentservice.dto;

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

public class DepartmentDto {
    /*86. DepartmentService - Create Department JPA Entity and Spring Data JPA Repository
*/
    private UUID uuid;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}