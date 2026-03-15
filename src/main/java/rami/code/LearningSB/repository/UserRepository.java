package rami.code.LearningSB.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import rami.code.LearningSB.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    default Optional<User> findByEmail(String email) {
        return null;
    }
}
