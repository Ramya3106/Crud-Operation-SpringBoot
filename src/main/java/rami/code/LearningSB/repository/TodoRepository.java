package rami.code.LearningSB.repository;
import rami.code.LearningSB.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import rami.code.LearningSB.models.User;
import java.util.Optional;

//CRUD - Create Read Update Delete
public interface TodoRepository extends JpaRepository<Todo, Long> {
    default Optional<User> findByEmail(String email) {
        return null;
    }
}