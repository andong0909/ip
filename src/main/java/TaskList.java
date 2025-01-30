import java.util.*;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>(100);

    public static void addTodo(String task) {
        list.add(new Todo(task));
    }

    public static void addDeadline(String task, String date) {
        list.add(new Deadline(task, date));
    }

    public static void addEvent(String task, String from, String to) {
        list.add(new Event(task, from, to));
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
