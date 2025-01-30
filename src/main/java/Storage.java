import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    public List<Task> loadTasks(String filePath) {
        List<Task> tasks = new ArrayList<>(100);
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                return tasks;
            }

            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                tasks.add(Storage.parseTask(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("WERWER! It seems that you don't have the required file!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tasks;
    }

    private static Task parseTask(String line) throws Exception {
        String[] split = line.split(" \\| ");
        String command = split[0];
        Task newTask = null;
        boolean isCompleted = split[1].equals("1");
        switch (command) {
            case "T":
                newTask = new Todo(split[2]);
                if (isCompleted) {
                    newTask.markAsDone();
                }
                break;
            case "D":
                newTask = new Deadline(split[2], split[3]);
                if (isCompleted) {
                    newTask.markAsDone();
                }
                break;
            case "E":
                newTask = new Event(split[2], split[3], split[4]);
                if (isCompleted) {
                    newTask.markAsDone();
                }
                break;
            default:
                System.out.println("WERWER! I don't recognise this task: " + command);
        }
        return newTask;
    }

    public static void saveTasks(String filePath) {
        try (FileWriter fw = new FileWriter(filePath)) {
            for (int i = 1; i <= TaskList.size(); i++) {
                fw.write(TaskList.getTask(i).print() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("WERWER! Failed to save: " + e.getMessage());
        }
    }
}
