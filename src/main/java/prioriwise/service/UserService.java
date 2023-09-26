package prioriwise.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import prioriwise.model.User;
import prioriwise.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByEmail (String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById (Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser (User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
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
            if (!passwordEncoder.matches(user.getPassword(), oldUser.getPassword())) {
                String encodePassword = passwordEncoder.encode(user.getPassword());
                oldUser.setPassword(encodePassword);
            }
            oldUser.setName(user.getName());
            oldUser.setLastname(user.getLastname());
            oldUser.setEmail(user.getEmail());

        return userRepository.save(oldUser);
        }

        throw new EntityNotFoundException("El usuario con ID " + user.getUserId() + " no existe.");
    }

}
