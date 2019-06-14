package project.spring_boot_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring_boot_api.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByLoginAndPassword(String login, String password);
    User getUserByLogin(String login);
}
