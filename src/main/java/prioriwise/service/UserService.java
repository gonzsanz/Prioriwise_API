package prioriwise.service;

import org.springframework.stereotype.Service;
import prioriwise.model.User;
import prioriwise.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail (String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById (Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser (User user) {
        return userRepository.save(user);
    }

    public void deleteUser (User user) {
        userRepository.delete(user);
    }

    public void deleteUserById (Long id) {
        userRepository.deleteById(id);
    }

    public void deleteUserByEmail (String email) {
        userRepository.deleteByEmail(email);
    }

    public User updateUser (User user) {
        User oldUser = userRepository.findById(user.getUserId()).orElse(null);
        if (oldUser != null) {
            oldUser.setName(user.getName());
            oldUser.setLastname(user.getLastname());
            oldUser.setPassword(user.getPassword());
            oldUser.setEmail(user.getEmail());
        }
        assert oldUser != null;
        return userRepository.save(oldUser);
    }

}
