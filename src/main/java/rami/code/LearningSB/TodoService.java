package rami.code.LearningSB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rami.code.LearningSB.models.Todo;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }
    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }
}