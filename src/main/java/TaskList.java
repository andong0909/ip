import java.util.*;

public class TaskList {
    private static ArrayList<String> list = new ArrayList<>(100);

    public static void addTask(String task) {
        list.add(task);
    }

    public static String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= list.size(); i++) {
            String curr = list.get(i-1);
            sb.append(i).append(". ").append(curr).append("\n");
        }
        return sb.toString();
    }
}
