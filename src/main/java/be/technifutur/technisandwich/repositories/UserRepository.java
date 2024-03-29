package be.technifutur.technisandwich.repositories;

import be.technifutur.technisandwich.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<Object> findByUsername(String username);
    boolean existsByUsername(String username);
}
