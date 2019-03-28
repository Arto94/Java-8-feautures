package am.itspace.java8.service;

import am.itspace.java8.model.User;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;


/**
 * The type Java 8 service.
 */
@Service
@Slf4j
public class Java8Service {


    @Value("${file.upload.dir}")
    private String fileUploadDir;

    /**
     * Get new list of integers expect less than param number
     *
     * @param list   the ArrayList
     * @param number int number
     * @return the new List of Integers
     */
    public List<Integer> getNumbersLessThenNumber(List<Integer> list, int number) {
        return list.stream()
                .filter(x -> x < number)
                .collect(Collectors.toList());
    }


    /**
     * Gets numbers less then number.
     *
     * @param list   the list
     * @param number the number
     * @param limit  the limit
     * @return the numbers less then number
     */
    public List<Integer> getNumbersLessThenNumber(List<Integer> list, int number, int limit) {
        return list.stream()
                .filter(x -> x < number)
                .limit(limit)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    /**
     * Gets max number of list.
     *
     * @param list the list
     * @return the max number of list
     */
    public int getMaxNumberOfList(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    /**
     * Print list sorted by name.
     *
     * @param users the users
     */
    public void printListSortedByName(List<User> users) {
        log.info("Sort by Name");
        users.sort((Comparator.comparing(User::name)));
        users.forEach(System.out::println);
    }

    /**
     * Print list sorted by age.
     *
     * @param users the users
     */
    public void printListSortedByAge(List<User> users) {
        log.info("Sort by Age");
        users.sort((Comparator.comparing(User::age)));
        users.forEach(System.out::println);
    }

    /**
     * Print couple of list.
     *
     * @param numbers the numbers
     */
    public void printCoupleOfList(List<Integer> numbers) {
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .forEach(integer -> System.out.print(integer + ","));
    }

    /**
     * Print names.
     *
     * @param names the names
     */
    public void printNames(List<String> names) {
        names.stream()
                .map(StringUtils::capitalize)
                .forEach(System.out::println);
    }


    /**
     * Print txt file.
     */
    public void printTxtFile() {
        List<String> lines = new ArrayList<>();
        File file = new File(fileUploadDir);
        try (Stream<String> lineStream = Files.lines(file.toPath())) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ignored) {

        }
        System.out.println(lines);
    }

    /**
     * Print txt file with lombok.
     */
    @SneakyThrows(IOException.class)
    public void printTxtFileWithLombok() {
        List<String> lines;
        File file = new File(fileUploadDir);
        @Cleanup Stream<String> lineStream = Files.lines(file.toPath());
        lines = lineStream.collect(Collectors.toList());
        System.out.println(lines);
    }

    /**
     * Print int stream.
     */
    public void printIntStream() {
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        LongStream longStream = LongStream.of(5, 6, 7, 8);
        DoubleStream doubleStream = DoubleStream.of(9, 10, 11, 12);

        intStream.forEach(System.out::print);
        //rangeClosed print from 1 to 100
        IntStream range = IntStream.range(1, 100);
        System.out.println();
        range.forEach(System.out::println);

    }

    /**
     * Print optional.
     */
    public void printOptional() {
        Optional<String> name = Optional.of("Terminator");
        System.out.println(name);
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.orElse("Arnold"));
//        Object emptyValue = empty.orElseThrow(RuntimeException::new);

    }

    /**
     * String join example.
     */
    public void stringJoinExample() {
        List<String> databases = Arrays.asList("OracleDB", "Mongo", "PostgreSQL", "MySQL");
        String string = String.join(", ", databases);
        System.out.println(string);
    }

}



