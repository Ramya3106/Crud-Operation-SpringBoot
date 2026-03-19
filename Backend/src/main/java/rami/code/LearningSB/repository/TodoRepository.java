package rami.code.LearningSB.repository;
import rami.code.LearningSB.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


//CRUD - Create Read Update Delete
public interface TodoRepository extends JpaRepository<Todo, Long> {

}