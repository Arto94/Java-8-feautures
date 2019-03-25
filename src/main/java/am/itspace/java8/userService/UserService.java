package am.itspace.java8.userService;

import am.itspace.java8.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface UserService {

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    User findByName(String name);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<User> findById(int id);

    /**
     * Save user.
     *
     * @param user the user
     */
    void saveUser(User user);

    /**
     * Gets all users.
     *
     * @return the all users
     */
    Stream<User> getAllUsers();

    /**
     * Find all users list.
     *
     * @return the list
     */
    List<User> findAllUsers();

}
