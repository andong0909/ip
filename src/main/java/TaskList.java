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
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= list.size(); i++) {
            String curr = list.get(i-1).toString();
            sb.append(i).append(". ").append(curr).append("\n");
        }
        return sb.toString();
    }

    public static void mark(String index) throws MarkedErrorException {
        Integer.parseInt(index);
        list.get(Integer.parseInt(index) - 1).markAsDone();
    }

    public static void unmark(String index) throws UnmarkedErrorException {
        Integer.parseInt(index);
        list.get(Integer.parseInt(index) - 1).unmarkAsDone();
    }

    public static String get(String index) {
        Integer.parseInt(index);
        return list.get(Integer.parseInt(index) - 1).toString();
    }

    public static int size() {
        return list.size();
    }

    public static String getLast() {
        return list.get(list.size() - 1).toString();
    }
}
