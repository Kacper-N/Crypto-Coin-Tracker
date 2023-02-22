package pl.coderslab.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUser(Long userId);
    void addUser(User user);
    void editUser(User user);
    void deleteUser(Long userId);

    Object[] getUsersLogins();
}
