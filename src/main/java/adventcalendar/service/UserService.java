package adventcalendar.service;

import adventcalendar.model.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by haljik on 15/06/04.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> findById(UserId id) {
        return userRepository.findBy(id);
    }

    public UserSummaries list() {
        return userRepository.list();
    }

    public void register(User user) {
        userRepository.register(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
