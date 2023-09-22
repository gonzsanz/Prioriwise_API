package prioriwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prioriwise.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(final String email);
}
