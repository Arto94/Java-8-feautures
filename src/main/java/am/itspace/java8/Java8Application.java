package am.itspace.java8;

import am.itspace.java8.model.User;
import am.itspace.java8.service.Java7Service;
import am.itspace.java8.service.Java8Service;
import am.itspace.java8.service.VehicleService;
import am.itspace.java8.userService.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;


@SpringBootApplication
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Slf4j
public class Java8Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }


    Java7Service java7Service;

    Java8Service java8Service;

    VehicleService vehicleService;

    UserService userService;


    @Override
    @SneakyThrows(Exception.class)
    @Transactional(readOnly = true)
    public void run(String... args) {

        printFromRepoWithoutStream();

        printFromRepoWithStream();
    }


    /**
     * Print from repo with stream.
     */
    @Transactional(readOnly = true)
    public void printFromRepoWithStream() {
        log.info("print with stream");
        long startTime = System.currentTimeMillis();
        @Cleanup Stream<User> stream = userService.getAllUsers();
        stream.forEach(System.out::println);
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("the program was running " + timeSpent + " milliseconds");
    }

    /**
     * Print from repo without stream.
     */
    @Transactional(readOnly = true)
    public void printFromRepoWithoutStream() {
        log.info("print without stream");
        long startTime = System.currentTimeMillis();
        for (User user : userService.findAllUsers()) {
            System.out.println(user);
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("the program was running  " + timeSpent + " milliseconds");
    }

}
