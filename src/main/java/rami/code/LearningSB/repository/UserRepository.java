package rami.code.LearningSB.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import rami.code.LearningSB.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
