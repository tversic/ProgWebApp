package hr.tvz.versic.hardwareapp.security.repository;

import hr.tvz.versic.hardwareapp.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
