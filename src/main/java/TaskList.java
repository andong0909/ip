import java.time.LocalDate;
import java.util.*;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>(100);

    public static void addTodo(String task) {
        list.add(new Todo(task.trim()));
    }

    public static void addDeadline(String task, String date) throws IllegalDateException {
        list.add(new Deadline(task.trim(), date.trim()));
    }

    public static void addEvent(String task, String from, String to) throws IllegalDateTimeException {
        list.add(new Event(task.trim(), from.trim(), to.trim()));
    }

    public static String print() {
        if (list.isEmpty()) {
            return "You have no tasks!";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= list.size(); i++) {
            String curr = list.get(i - 1).toString();
            sb.append(i).append(". ").append(curr).append("\n");
        }
        return sb.toString();
    }

    public static void mark(int index) throws MarkedErrorException {
        list.get(index - 1).markAsDone();
    }

    public static void unmark(int index) throws UnmarkedErrorException {
        list.get(index - 1).unmarkAsDone();
    }

    public static void delete(int index) {
        list.remove(index - 1);
    }

    public static String get(int index) {
        return list.get(index - 1).toString();
    }

    public static int size() {
        return list.size();
    }

    public static String getLast() {
        return list.get(list.size() - 1).toString();
    }

    public static Task getTask(int index) {
        return list.get(index - 1);
    }
}
