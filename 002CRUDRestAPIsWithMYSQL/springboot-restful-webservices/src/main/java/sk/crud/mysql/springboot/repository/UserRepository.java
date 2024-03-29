package sk.crud.mysql.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.crud.mysql.springboot.entity.User;

import java.util.UUID;

//24. Create Spring Data JPA Repository - UserRepository
public interface UserRepository extends JpaRepository<User, UUID> {
}
