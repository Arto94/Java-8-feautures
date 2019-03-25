package am.itspace.java8.repository;

import am.itspace.java8.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    @Query(value = "SELECT * from user", nativeQuery = true)
    Stream<User> findAllWithQuery();


    Stream<User> findAllByNameContaining(String name);
}
