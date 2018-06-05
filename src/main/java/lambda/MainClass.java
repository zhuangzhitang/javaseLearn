package lambda;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        Task task1 = new Task("1","Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");

        Task task2 = new Task("2","Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");

        Task task3 = new Task("3","Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");

        Task task4 = new Task("4 ","Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");

        Task task5 = new Task("5","Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");

        List<Task> tasks = Arrays.asList(task1, task2, task3, task4, task5);
        List<String> readingTaskTitles = allReadingTasks(tasks);
        readingTaskTitles.forEach(System.out::println);

        List<String> ReadingTasksSortedByCreatedOnDesc = allReadingTasksSortedByCreatedOnDesc(tasks);
        ReadingTasksSortedByCreatedOnDesc.forEach(System.out::println);

        Map<TaskType, List<Task>> result = groupTasksByType(tasks);
        System.out.println(result.toString());
    }

    private static List<String> allReadingTasks(List<Task> tasks) {
        List<String> readingTaskTitles = tasks.stream().
                filter(task -> task.getType() == TaskType.READING).
                sorted(Comparator.comparing(Task::getCreatedOn)).
                map(task -> task.getTitle()).
                collect(Collectors.toList());
        return readingTaskTitles;
    }
    public static List<String> allReadingTasksSortedByCreatedOnDesc(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.READING).
                sorted(Comparator.comparing(Task::getCreatedOn).reversed()).
                map(Task::getTitle).
                collect(Collectors.toList());
    }
    private static Map<TaskType, List<Task>> groupTasksByType(List<Task> tasks) {
        return tasks.stream().collect(Collectors.groupingBy(task -> task.getType()));
    }
    public List<String> allTitles(List<Task> tasks) {
        return tasks.stream().map(Task::getTitle).collect(Collectors.toList());
    }
    private static Map<TaskType, Task> taskMap(List<Task> tasks) {
        Map<TaskType, Task> mapp = tasks.stream().collect(Collectors.toMap(Task::getType,Function.identity()));
        return mapp;
      //  return tasks.stream().collect(Collectors.toMap(Task::getType,Function.identity()));
    }


}
