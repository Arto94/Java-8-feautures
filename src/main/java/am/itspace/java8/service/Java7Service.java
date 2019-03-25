package am.itspace.java8.service;

import am.itspace.java8.model.User;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
@Slf4j
public class Java7Service {

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
        List<Integer> integerList = new ArrayList<>();
        for (int x : list) {
            if (x >= number) {
                continue;
            }
            integerList.add(x);
        }
        return integerList;
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
        List<Integer> integerList = new ArrayList<>();
        int count = 0;
        for (int x : list) {
            if (x >= number) continue;
            count++;
            if (count > limit) break;
            integerList.add(x);
        }
        return integerList;
    }

    /**
     * Gets max number of list.
     *
     * @param list the list
     * @return the max number of list
     */
    public int getMaxNumberOfList(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer lists : list) {
            if (lists > max) {
                max = lists;
            }
        }
        return max;
    }


    /**
     * Print list sorted by name.
     *
     * @param users the users
     */
    public void printListSortedByName(List<User> users) {
        log.info("Sort by Name");
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name().compareTo(o2.name());
            }
        });
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * Print list sorted by age.
     *
     * @param users the users
     */
    public void printListSortedByAge(List<User> users) {
        log.info("Sort by age");
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.age() - o2.age();
            }
        });
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * Print couple of list.
     *
     * @param numbers the numbers
     */
    public void printCoupleOfList(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i % 2 == 0) {
                System.out.print(i + ",");
            }
        }
    }

    /**
     * Print names.
     *
     * @param names the names
     */
    public void printNames(List<String> names) {
        for (String s : names) {
            char[] chars = s.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            System.out.println(new String(chars));
        }
    }

    /**
     * Print txt file.
     */
    public void printTxtFile() {
        List<String> lines = new ArrayList<>();
        File file = new File(fileUploadDir);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);
        } catch (IOException ignored) {

        }
        System.out.println(lines);
    }

    /**
     * Print txt file with lombok.
     */
    @SneakyThrows(IOException.class)
    public void printTxtFileWithLombok() {
        List<String> lines = new ArrayList<>();
        File file = new File(fileUploadDir);
        @Cleanup BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null)
            lines.add(line);
        System.out.println(lines);
    }

}
