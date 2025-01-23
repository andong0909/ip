import java.util.*;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>(100);

    public static void addTask(String task) {
        list.add(new Task(task));
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
}
