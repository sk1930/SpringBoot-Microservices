package sk.microservices.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;

}