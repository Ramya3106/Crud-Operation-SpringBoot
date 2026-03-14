package rami.code.LearningSB.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rami.code.LearningSB.models.User;
import rami.code.LearningSB.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public User createUser(User user) {
        return UserRepository.save(user);
    }

    public User getTodoById(Long id) {
        return UserRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }
}