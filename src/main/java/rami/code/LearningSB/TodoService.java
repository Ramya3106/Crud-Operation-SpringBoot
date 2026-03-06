package rami.code.LearningSB;

public class TodoService {
    private TodoRepository todoRepository;
    public TodoService() {
        todoRepository= new TodoRepository();
    }
    public void printTodos(){
        System.out.println(todoRepository.getAllTodos());
    }

}
